package org.cytoscape.mclique.internal;

import java.util.Properties;
import org.cytoscape.application.CyApplicationManager;
import org.cytoscape.application.swing.CySwingApplication;
import org.cytoscape.application.swing.CytoPanel;
import org.cytoscape.application.swing.CytoPanelComponent;
import org.cytoscape.application.swing.CytoPanelName;
import org.cytoscape.model.CyNetwork;
import org.cytoscape.service.util.CyServiceRegistrar;
import org.cytoscape.view.model.CyNetworkView;

/**
 * @author SrikanthB
 *
 */

public class CliqueCore {
    public CyNetwork network;
    public CyNetworkView view;
    public CyApplicationManager cyApplicationManager;
    public CySwingApplication cyDesktopService;
    public CyServiceRegistrar cyServiceRegistrar;
    public CyActivator cyactivator;
    private static CliqueUI startmenu;
    public CliqueCore(CyActivator cyactivator){
        this.cyactivator = cyactivator;
        this.cyApplicationManager = cyactivator.cyApplicationManager;
        this.cyDesktopService = cyactivator.cyDesktopService;
        this.cyServiceRegistrar = cyactivator.cyServiceRegistrar;
        startmenu = createCliqueStartMenu();
        updatecurrentnetwork();
    }
    public void updatecurrentnetwork() {
            //get the network view object
        if (view == null) {
            view = null;
            network = null;
        }
        else {
            view = cyApplicationManager.getCurrentNetworkView();
            //get the network object; this contains the graph  
            network = view.getModel();
        }
    }

    public void closecore() {
        network = null;
        view = null;
    }

    public CliqueUI createCliqueStartMenu() {
        startmenu = new CliqueUI(cyactivator, this);
        cyServiceRegistrar.registerService(startmenu, CytoPanelComponent.class, new Properties());
        CytoPanel cytopanelwest = cyDesktopService.getCytoPanel(CytoPanelName.WEST);
        int index = cytopanelwest.indexOfComponent(startmenu);
        cytopanelwest.setSelectedIndex(index);
        return startmenu;
    }

    public void closeCliqueStartMenu(CliqueUI menu) {
        cyServiceRegistrar.unregisterService(menu, CytoPanelComponent.class);
    }

   
    public CyApplicationManager getCyApplicationManager() {
        return this.cyApplicationManager;
    }

    public CySwingApplication getCyDesktopService() {
        return this.cyDesktopService;
    }
    
    public static CliqueUI getTiDieStartMenu(){
        return startmenu;
    }
    
}
