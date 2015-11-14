package org.cytoscape.mclique.internal.logic;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.ListIterator;
import java.util.Set;
import org.cytoscape.model.CyEdge;
import org.cytoscape.model.CyNetwork;
import org.cytoscape.model.CyNode;
import org.cytoscape.view.model.CyNetworkView;

public class CliqueThread extends Thread{
    
    public CyNetwork currentnetwork;
    public CyNetworkView currentnetworkview;
    public CliqueThread(CyNetwork currentnetwork, CyNetworkView currentnetworkview){
        this.currentnetwork = currentnetwork;
        this.currentnetworkview = currentnetworkview;
    }
    
    @Override
    public void run(){
        List<CyNode> X = new ArrayList<CyNode>();
        List<CyNode> R = new ArrayList<CyNode>();
        List<CyNode> P = currentnetwork.getNodeList();
        Bron_KerboschWithPivot(X, R, P);
         
        
    }
    
    public void Bron_KerboschWithPivot(List<CyNode> R, List<CyNode> P, List<CyNode> X){
        if(P.size() == 0 && X.size()==0){
            captureClique(R);
            return;
        }
        List<CyNode> P1 = new ArrayList<CyNode>(P);
        CyNode u = getMaxDegreeVertex(union(P,X));
        P = removeNbrs(P, u); 
        for(CyNode v : P){
            R.add(v);
            Bron_KerboschWithPivot(R, intersect(P1, currentnetwork.getNeighborList(v, CyEdge.Type.ANY)), intersect(X, currentnetwork.getNeighborList(v, CyEdge.Type.ANY)));
            R.remove(v); 
            P1.remove(v); 
            X.add(v); 
        }
 
    }
    
    public void captureClique(List<CyNode> R){
        System.out.println("Start");
        for(CyNode cur : R){
            System.out.println(currentnetwork.getRow(cur).get(CyNetwork.NAME, String.class));
            System.out.println("\n");
        }
        System.out.println("End");
    
    }
    
    public static <T> List<T> union(List<T> listA, List<T> listB) {
            List<T> output = new ArrayList<T>();
            Set<T> tmp = new HashSet<T>(listA);
            tmp.addAll(listB);
            output.addAll(tmp);
            return output;
    }
    
    public static <T> List<T> intersect(List<T> listA, List<T> listB) {
            List<T> output = new ArrayList<T>();
            Set<T> tmp = new HashSet<T>(listA);
            for (T x : listA)
            if (listB.contains(x))
                tmp.add(x);
            output.addAll(tmp);
            return output; 
    }
    
    CyNode getMaxDegreeVertex(List<CyNode> g){
        CyNode output=null;
        ListIterator<CyNode> itr; 
        itr = g.listIterator();
        CyNode curr;
        int maxDegree = Integer.MIN_VALUE;
        while(itr.hasNext()){
            curr = itr.next();
            int currDegree = currentnetwork.getNeighborList(curr, CyEdge.Type.ANY).size();
            if(currDegree > maxDegree){
                maxDegree = currDegree;
                output = curr;
            }
        }
        
        return output;
    }
    
    List<CyNode> removeNbrs(List<CyNode> arlFirst, CyNode v){
        List<CyNode> arlHold = new ArrayList<CyNode>(arlFirst); 
        arlHold.removeAll(currentnetwork.getNeighborList(v, CyEdge.Type.ANY)); 
        return arlHold; 
    }
    
}
