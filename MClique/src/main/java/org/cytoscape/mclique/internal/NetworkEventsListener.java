package org.cytoscape.mclique.internal;

import javax.swing.DefaultComboBoxModel;
import org.cytoscape.model.CyNetwork;
import org.cytoscape.model.events.NetworkAddedEvent;
import org.cytoscape.model.events.NetworkAddedListener;
import org.cytoscape.model.events.NetworkDestroyedEvent;
import org.cytoscape.model.events.NetworkDestroyedListener;

public class NetworkEventsListener implements NetworkAddedListener, NetworkDestroyedListener{
    public void handleEvent(NetworkAddedEvent e){
        CyNetwork net = e.getNetwork();
        String title = net.getRow(net).get("name", String.class);
        CliqueUI menu = CliqueCore.getTiDieStartMenu();
        ((DefaultComboBoxModel)menu.networkComboBox.getModel()).addElement(title); 	
    }
    
    public void handleEvent(NetworkDestroyedEvent e){
        CliqueUI menu = CliqueCore.getTiDieStartMenu();
        menu.updateNetworkList();
    }
}
