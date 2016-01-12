package org.cytoscape.mclique.internal.logic;

import org.jgrapht.*;
import org.jgrapht.graph.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.cytoscape.mclique.internal.CliqueUI;
import org.cytoscape.mclique.internal.CyActivator;
import org.cytoscape.model.CyEdge;
import org.cytoscape.model.CyNetwork;
import org.cytoscape.model.CyNode;
import org.cytoscape.model.CyRow;
import org.cytoscape.model.CyTable;
import org.cytoscape.task.create.NewNetworkSelectedNodesAndEdgesTaskFactory;
import org.cytoscape.view.model.CyNetworkView;
import org.cytoscape.work.TaskIterator;
import org.jgrapht.alg.BronKerboschCliqueFinder;

/**
 * @author SrikanthB
 *
 */

public class CliqueThread extends Thread{
    
    public CyNetwork currentnetwork;
    public CyNetworkView currentnetworkview;
    boolean YESb;
    CliqueUI menu;
    public CyNetwork subNetwork = null;
    
    public CliqueThread(CliqueUI menu, CyNetwork currentnetwork, CyNetworkView currentnetworkview, boolean YESb){
        this.menu = menu;
        this.currentnetwork = currentnetwork;
        this.currentnetworkview = currentnetworkview;
        this.YESb = YESb;
    }
    
    @Override
    public void run(){
        menu.startComputation();
        UndirectedGraph<CyNode, CyEdge> g = new SimpleGraph<CyNode, CyEdge>(CyEdge.class);
        List<CyNode> nodeList = currentnetwork.getNodeList();
        List<CyEdge> edgeList = currentnetwork.getEdgeList();
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
        List<Set<CyNode>> requiredNodeSets = (List<Set<CyNode>>) bcfinder.getBiggestMaximalCliques();
        // TODO : Iterate through all sets
        Set<CyNode> requiredNodeSet = requiredNodeSets.get(0);
        List<CyNode> requiredNodes = new ArrayList<CyNode>();
        requiredNodes.addAll(requiredNodeSet);
        List<CyEdge> requiredEdges = new ArrayList<CyEdge>();
        for(CyEdge e : edgeList){
            if(requiredNodes.contains(e.getSource()) && requiredNodes.contains(e.getTarget())){
                requiredEdges.add(e);
            }
        }

        createNetwork(currentnetwork, requiredNodes, requiredEdges, YESb);
        menu.endComputation();
    }
    
    
    public void createNetwork(CyNetwork network, List<CyNode> subnodeList, List<CyEdge> subedgeList, boolean YESb){
        // select the nodes and edges
        CyTable nTable = network.getDefaultNodeTable();
        CyTable eTable = network.getDefaultEdgeTable();
        List<CyEdge> elist = network.getEdgeList();
        for(CyEdge e : elist){
            if(subedgeList.contains(e)){
                CyRow row = eTable.getRow(e.getSUID());
                row.set("selected", true);
            }
            else{
                CyRow row = eTable.getRow(e.getSUID());
                row.set("selected", false);
            }
        }
        
        for(CyNode n : network.getNodeList()){
            CyRow row = nTable.getRow(n.getSUID());
            if(subnodeList.contains(n)){
                row.set("selected", true);
            } else{
                row.set("selected", false);
            }
            
        }
        
        // create the network
        if(YESb == true){
            NewNetworkSelectedNodesAndEdgesTaskFactory f = CyActivator.adapter.
                get_NewNetworkSelectedNodesAndEdgesTaskFactory();
            TaskIterator itr = f.createTaskIterator(network);
            CyActivator.adapter.getTaskManager().execute(itr);
            
            try {
                Thread.sleep(4000);
            } catch (InterruptedException ex) {
                Logger.getLogger(CliqueThread.class.getName()).log(Level.SEVERE, null, ex);
            }
            // set the name of the network
            this.menu.calculatingresult("Created! Renaming the network...");
            String currentNetworkName = network.getRow(network).get(CyNetwork.NAME, String.class);
            Set<CyNetwork> allnetworks = CyActivator.networkManager.getNetworkSet();
            long maxSUID = Integer.MIN_VALUE;
            for(CyNetwork net : allnetworks){
                if(net.getSUID() > maxSUID)
                    maxSUID = net.getSUID();
            }
            this.subNetwork = CyActivator.networkManager.getNetwork(maxSUID);
            subNetwork.getRow(subNetwork).set(CyNetwork.NAME, currentNetworkName + "_BiggestMaximalClique");         
        
        }
        
        
    }
    
   
    
    
    
}
