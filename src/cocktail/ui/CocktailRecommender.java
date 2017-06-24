/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cocktail.ui;

import cocktail.cbr.CBRApplication;
import java.awt.BorderLayout;
import javax.swing.JPanel;
import jcolibri.cbrcore.CBRCase;
import jcolibri.cbrcore.CBRCaseBase;
import jcolibri.exception.ExecutionException;

/**
 *
 * @author visaac
 */
public class CocktailRecommender extends javax.swing.JFrame {

    private AdaptationSettingsDialog settingsDialog = new AdaptationSettingsDialog(this);
    // Keep the following three attributes in synch
    private JPanel[] panels = {new SearchPanel(), new ImportanceConfigPanel(), new OutcomePanel()};
    private static final String[] actionButtonLables = {"Search", "Apply", "Retain"};
    private static final String[] resetButtonLables = {"Reset", "Default", "Refresh"};
    private static final String[] actionCommand= {"Query", "Importance", "Refresh"};
    private static final String[] stageTitles = {"Search Cocktails", "Importance/Weightage Selection", "Search and Adaptation Results"};
    private int currentPanelIdx = 0;
    private CBRApplication cbrApp = new CBRApplication();
    /**
     * Creates new form CocktailRecommender
     */
    public CocktailRecommender() {
        initCbr();
        initComponents();
        initPanels();
        activatePanel(0);

    }
    
    private void initCbr() {
        try {
            cbrApp.configure();
            CBRCaseBase caseBase = cbrApp.preCycle();

            for (CBRCase c : caseBase.getCases()) {
                System.out.println(c);
            }

        } catch (ExecutionException e) {
            e.printStackTrace();
        }

    }

    private void initPanels() {
        for (int i = 0; i < panels.length; i++) {
            panels[i].setVisible(false);
            mainTabPane.add(actionCommand[i], panels[i]);
        }
    }
    private void activatePanel(int panelIdx) {
        panels[currentPanelIdx].setVisible(false);
        if (panelIdx >= 0 && panelIdx < panels.length) {
            this.butCurrentAction.setText(actionButtonLables[panelIdx]);
            this.butCurrentAction.setActionCommand(actionCommand[panelIdx]);
            this.butCurrentReset.setText(resetButtonLables[panelIdx]);
            this.butCurrentReset.setActionCommand(actionCommand[panelIdx]);
            this.lblStageTitle.setText(stageTitles[panelIdx]);
            panels[currentPanelIdx].setVisible(true);
            mainTabPane.setSelectedIndex(panelIdx);
            currentPanelIdx = panelIdx;
        }
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        butCurrentAction = new javax.swing.JButton();
        butCurrentReset = new javax.swing.JButton();
        mainTabPane = new javax.swing.JTabbedPane();
        lblStageTitle = new javax.swing.JLabel();
        butSettings = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Cocktail Recommender");
        setBounds(new java.awt.Rectangle(50, 50, 675, 600));
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        butCurrentAction.setText("Action");
        butCurrentAction.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                butCurrentActionActionPerformed(evt);
            }
        });

        butCurrentReset.setText("Reset");
        butCurrentReset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                butCurrentResetActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(butCurrentAction, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(butCurrentReset, javax.swing.GroupLayout.DEFAULT_SIZE, 123, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(butCurrentAction)
                    .addComponent(butCurrentReset))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 510, -1, 40));
        getContentPane().add(mainTabPane, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 60, 570, 430));

        lblStageTitle.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lblStageTitle.setText("Title");
        getContentPane().add(lblStageTitle, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 20, 480, 31));

        butSettings.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/gear.png"))); // NOI18N
        butSettings.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                butSettingsActionPerformed(evt);
            }
        });
        getContentPane().add(butSettings, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 30, 30, -1));
    }// </editor-fold>//GEN-END:initComponents

    private void butCurrentActionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_butCurrentActionActionPerformed
        switch(evt.getActionCommand()) {
            case "Query" : activatePanel(1); break;
            case "Importance" : activatePanel(2); break;
            case "Retain" : break;
            default:
        }
    }//GEN-LAST:event_butCurrentActionActionPerformed

    private void butCurrentResetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_butCurrentResetActionPerformed
        switch(evt.getActionCommand()) {
            case "Query" : panels[0] = new SearchPanel(); break;
            case "Importance" : break;
            case "Retain" :  break;
            default:
        }
    }//GEN-LAST:event_butCurrentResetActionPerformed

    private void butSettingsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_butSettingsActionPerformed
        settingsDialog.setVisible(true);
    }//GEN-LAST:event_butSettingsActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(CocktailRecommender.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CocktailRecommender.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CocktailRecommender.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CocktailRecommender.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CocktailRecommender().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton butCurrentAction;
    private javax.swing.JButton butCurrentReset;
    private javax.swing.JButton butSettings;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblStageTitle;
    private javax.swing.JTabbedPane mainTabPane;
    // End of variables declaration//GEN-END:variables
}
