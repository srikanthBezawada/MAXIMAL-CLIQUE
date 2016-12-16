package org.cytoscape.mclique.internal.logic;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.cytoscape.mclique.internal.view.MCliqueUI;
import org.cytoscape.model.CyEdge;
import org.cytoscape.model.CyNetwork;
import org.cytoscape.model.CyNode;
import org.cytoscape.model.subnetwork.CyRootNetwork;
import org.cytoscape.model.subnetwork.CySubNetwork;
import org.cytoscape.view.model.CyNetworkView;
import org.jgrapht.UndirectedGraph;
import org.jgrapht.alg.BronKerboschCliqueFinder;
import org.jgrapht.graph.SimpleGraph;

public class MCliqueLogic extends Thread{
    private boolean stop;
    private MCliqueUI panel;
    private CyNetwork network;
    private CyNetworkView networkView;
    
    public MCliqueLogic(MCliqueUI panel, CyNetwork network, CyNetworkView networkview) {
        this.panel = panel;
        this.network = network;
        this.networkView = networkview;
    }
    
    public void run() {
        stop = false;
        panel.startComputation();
        long startTime = System.currentTimeMillis();
    
        if(stop) {
            return;
        }
        
        Set<MClique> cmcComplexes = new HashSet<MClique>();
        CyRootNetwork root = ((CySubNetwork)network).getRootNetwork();
        
        UndirectedGraph<CyNode, CyEdge> g = new SimpleGraph<CyNode, CyEdge>(CyEdge.class);
        List<CyNode> nodeList = network.getNodeList();
        List<CyEdge> edgeList = network.getEdgeList();
        
        
        for(CyNode n : nodeList){
            g.addVertex(n);
        }
        for(CyEdge e : edgeList){
            if(e.getSource().equals(e.getTarget())){
                continue; // removing self-loops
            }
            g.addEdge(e.getSource(), e.getTarget(),e);
        }
        
        BronKerboschCliqueFinder bcfinder = new BronKerboschCliqueFinder(g);
        
        if(stop) {
            return;
        }
        
        List<Set<CyNode>> requiredNodeSetsList = (List<Set<CyNode>>) bcfinder.getAllMaximalCliques();
        
        if(stop) {
            return;
        }
        
        for(Set<CyNode> requiredNodes : requiredNodeSetsList) {
            List<CyEdge> requiredEdges = new ArrayList<CyEdge>();
            for(CyEdge e : edgeList){
                if(requiredNodes.contains(e.getSource()) && requiredNodes.contains(e.getTarget())){
                    requiredEdges.add(e);
                }
            }
            
            if(stop) {
                return;
            }
            
            // Removing very small cliques < 3
            if(requiredEdges.size() >= 3) {
                CyNetwork subNet = root.addSubNetwork(requiredNodes, requiredEdges);
                cmcComplexes.add(new MClique(subNet));
            }
        }
        
 
        
        panel.resultsCalculated(cmcComplexes, network);
        
        if(stop) {
            return;
        }
        
        
        long endTime = System.currentTimeMillis();
        long difference = endTime - startTime;
        System.out.println("Execution time for MClique " + difference +" milli seconds");
        panel.endComputation();
        
    }
    
    
    public void end() {
        stop = true;
    }
    
}
