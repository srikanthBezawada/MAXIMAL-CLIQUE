
package org.cytoscape.mclique.internal;

import java.awt.Component;
import java.awt.event.ItemListener;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;
import javax.swing.DefaultComboBoxModel;
import javax.swing.Icon;
import org.cytoscape.application.CyApplicationManager;
import org.cytoscape.application.swing.CySwingApplication;
import org.cytoscape.application.swing.CytoPanelComponent;
import org.cytoscape.application.swing.CytoPanelName;
import org.cytoscape.mclique.internal.logic.CliqueThread;
import org.cytoscape.model.CyNetwork;
import org.cytoscape.model.events.NetworkAddedEvent;
import org.cytoscape.model.events.NetworkDestroyedEvent;
import org.cytoscape.view.model.CyNetworkView;

/**
 * @author SrikanthB
 *
 */

public class CliqueGUI extends javax.swing.JPanel implements CytoPanelComponent{
    private CliqueCore cliquecore;
    public CliqueThread logicThread;
    CyApplicationManager cyApplicationManager;
    CySwingApplication cyDesktopService;
    public CyActivator cyactivator;
    /**
     * Creates new form CliqueGUI
     */
    public CliqueGUI(CyActivator cyactivator, CliqueCore cliquecore) {
        initComponents();
        this.cyactivator = cyactivator;
        this.cliquecore = cliquecore;
        cyApplicationManager = cliquecore.getCyApplicationManager();
        cyDesktopService = cliquecore.getCyDesktopService();
        updateNetworkList();
    }
    @Override
    public Icon getIcon() {
        return null;
    }
    
    @Override
    public String getTitle() {
        return "MClique";
    }
    
    @Override
    public CytoPanelName getCytoPanelName() {
        return CytoPanelName.WEST;
    }
    
    public Component getComponent() {
        return this;
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup3 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup4 = new javax.swing.ButtonGroup();
        jScrollPane1 = new javax.swing.JScrollPane();
        parentPanel = new javax.swing.JPanel();
        startB = new javax.swing.JButton();
        headingLabel1 = new javax.swing.JLabel();
        networkPanel = new javax.swing.JPanel();
        netVariable1 = new javax.swing.JLabel();
        networkComboBox = new javax.swing.JComboBox();
        helpExitPanel = new javax.swing.JPanel();
        helpB = new javax.swing.JButton();
        exitB = new javax.swing.JButton();
        statusPanel = new javax.swing.JPanel();
        statusBar = new javax.swing.JProgressBar();
        statusLabel = new javax.swing.JLabel();
        yesNoPanel = new javax.swing.JPanel();
        YESbutton = new javax.swing.JRadioButton();
        NObutton = new javax.swing.JRadioButton();

        setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        parentPanel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        startB.setText("Find BiggestMaximalClique on selected network");
        startB.setToolTipText("");
        startB.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        startB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                startBActionPerformed(evt);
            }
        });

        headingLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        headingLabel1.setForeground(new java.awt.Color(255, 0, 51));
        headingLabel1.setText("     BMClique");

        networkPanel.setBorder(javax.swing.BorderFactory.createTitledBorder("Select the network"));

        netVariable1.setText("Network");

        javax.swing.GroupLayout networkPanelLayout = new javax.swing.GroupLayout(networkPanel);
        networkPanel.setLayout(networkPanelLayout);
        networkPanelLayout.setHorizontalGroup(
            networkPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(networkPanelLayout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(netVariable1, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 72, Short.MAX_VALUE)
                .addComponent(networkComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28))
        );
        networkPanelLayout.setVerticalGroup(
            networkPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(networkPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(networkPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(netVariable1)
                    .addComponent(networkComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(44, Short.MAX_VALUE))
        );

        helpExitPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        helpB.setForeground(new java.awt.Color(0, 200, 0));
        helpB.setText("Help");
        helpB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                helpBActionPerformed(evt);
            }
        });

        exitB.setForeground(new java.awt.Color(200, 0, 0));
        exitB.setText("Exit");
        exitB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitBActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout helpExitPanelLayout = new javax.swing.GroupLayout(helpExitPanel);
        helpExitPanel.setLayout(helpExitPanelLayout);
        helpExitPanelLayout.setHorizontalGroup(
            helpExitPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(helpExitPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(helpB, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(exitB, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        helpExitPanelLayout.setVerticalGroup(
            helpExitPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, helpExitPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(helpExitPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(exitB, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(helpB, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        statusPanel.setBorder(javax.swing.BorderFactory.createTitledBorder("Status bar"));

        statusLabel.setFont(new java.awt.Font("Tahoma", 2, 10)); // NOI18N
        statusLabel.setText("status");

        javax.swing.GroupLayout statusPanelLayout = new javax.swing.GroupLayout(statusPanel);
        statusPanel.setLayout(statusPanelLayout);
        statusPanelLayout.setHorizontalGroup(
            statusPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(statusPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(statusPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(statusBar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(statusLabel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        statusPanelLayout.setVerticalGroup(
            statusPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(statusPanelLayout.createSequentialGroup()
                .addComponent(statusBar, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(statusLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        yesNoPanel.setBorder(javax.swing.BorderFactory.createTitledBorder("Extract BMClique as subnetwork"));

        buttonGroup1.add(YESbutton);
        YESbutton.setText("YES");

        buttonGroup1.add(NObutton);
        NObutton.setText("NO");

        javax.swing.GroupLayout yesNoPanelLayout = new javax.swing.GroupLayout(yesNoPanel);
        yesNoPanel.setLayout(yesNoPanelLayout);
        yesNoPanelLayout.setHorizontalGroup(
            yesNoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(yesNoPanelLayout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(YESbutton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(NObutton)
                .addGap(19, 19, 19))
        );
        yesNoPanelLayout.setVerticalGroup(
            yesNoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(yesNoPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(yesNoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(YESbutton)
                    .addComponent(NObutton))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout parentPanelLayout = new javax.swing.GroupLayout(parentPanel);
        parentPanel.setLayout(parentPanelLayout);
        parentPanelLayout.setHorizontalGroup(
            parentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(parentPanelLayout.createSequentialGroup()
                .addGroup(parentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(parentPanelLayout.createSequentialGroup()
                        .addGap(52, 52, 52)
                        .addGroup(parentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(yesNoPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(networkPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(startB, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(helpExitPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(statusPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(parentPanelLayout.createSequentialGroup()
                        .addGap(121, 121, 121)
                        .addComponent(headingLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(200, Short.MAX_VALUE))
        );
        parentPanelLayout.setVerticalGroup(
            parentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, parentPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(headingLabel1)
                .addGap(8, 8, 8)
                .addComponent(networkPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(yesNoPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addComponent(startB, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addComponent(statusPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(helpExitPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(307, Short.MAX_VALUE))
        );

        jScrollPane1.setViewportView(parentPanel);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 482, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 526, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(280, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void startBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_startBActionPerformed
        CyNetwork currentnetwork = getSelectedNetwork();
        CyNetworkView currentnetworkview;
        if(currentnetwork != null){
            currentnetworkview = cyApplicationManager.getCurrentNetworkView();
            logicThread = new CliqueThread(this, currentnetwork, currentnetworkview, YESbutton.isSelected());
            logicThread.start();
        }   
    }//GEN-LAST:event_startBActionPerformed

    private void helpBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_helpBActionPerformed
        CliqueHelper help = new CliqueHelper();
        help.setText(1);
        help.setVisible(true);
        // TODO add your handling code here:
    }//GEN-LAST:event_helpBActionPerformed

    private void exitBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitBActionPerformed
        // TODO add your handling code here:
        cliquecore.closecore();
        cliquecore.closeCliqueStartMenu();
    }//GEN-LAST:event_exitBActionPerformed
    
    
    public void startComputation(){
        startB.setEnabled(false);
        statusBar.setIndeterminate(true);
        statusBar.setVisible(true);
        statusLabel.setText("bron-kerbosch algorithm is running ......");
    }
    
    public void endComputation(){
        statusBar.setIndeterminate(false);
        statusLabel.setText("<html> Have fun with Cliques ! <br> You might want to recompute with different inputs <html>");
        startB.setEnabled(true);
    }
    
    public void calculatingresult(String msg){
        statusLabel.setText(msg);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JRadioButton NObutton;
    private javax.swing.JRadioButton YESbutton;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.ButtonGroup buttonGroup3;
    private javax.swing.ButtonGroup buttonGroup4;
    private javax.swing.JButton exitB;
    private javax.swing.JLabel headingLabel1;
    private javax.swing.JButton helpB;
    private javax.swing.JPanel helpExitPanel;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel netVariable1;
    private javax.swing.JComboBox networkComboBox;
    private javax.swing.JPanel networkPanel;
    private javax.swing.JPanel parentPanel;
    private javax.swing.JButton startB;
    private javax.swing.JProgressBar statusBar;
    private javax.swing.JLabel statusLabel;
    private javax.swing.JPanel statusPanel;
    private javax.swing.JPanel yesNoPanel;
    // End of variables declaration//GEN-END:variables
    private void updateNetworkList() {
        final Set<CyNetwork> networks = CyActivator.getcyNetworkManager().getNetworkSet();
        final SortedSet<String> networkNames = new TreeSet<String>();

        for (CyNetwork net : networks)
                networkNames.add(net.getRow(net).get("name", String.class));

        // Clear the comboBox
        networkComboBox.setModel(new DefaultComboBoxModel());

        for (String name : networkNames)
                networkComboBox.addItem(name);

        CyNetwork currNetwork = this.cyApplicationManager.getCurrentNetwork();
        if (currNetwork != null) {
                String networkTitle = currNetwork.getRow(currNetwork).get("name", String.class);
                networkComboBox.setSelectedItem(networkTitle);			
        }
    }
    
    
    public void addItemListener(final ItemListener newListener) {
        networkComboBox.addItemListener(newListener);
    }
    
    public void handleEvent(NetworkDestroyedEvent e){
        updateNetworkList();
    }
    
    public void handleEvent(NetworkAddedEvent e){
        CyNetwork net = e.getNetwork();
        String title = net.getRow(net).get("name", String.class);
        ((DefaultComboBoxModel)networkComboBox.getModel()).addElement(title); 	
    }
    
    public CyNetwork getSelectedNetwork() {
        for (CyNetwork net : CyActivator.getcyNetworkManager().getNetworkSet()) {
                String networkTitle = net.getRow(net).get("name", String.class);
                if (networkTitle.equals(networkComboBox.getSelectedItem()))
                        return net;
        }

        return null;
    }
    
    
    
    
    
    

}
