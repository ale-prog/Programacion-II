
package uni.ViewPanels;

import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JTextField;


public class IntFrmVehicle extends javax.swing.JInternalFrame {

    /**
     * Creates new form IntFrmVehicle
     */
    public IntFrmVehicle() {
        initComponents();
    }

    public JTable getTblViewVehicle() {
        return TblViewVehicle;
    }

    public JButton getBtnDelete() {
        return BtnDelete;
    }

    public void setBtnDelete(JButton BtnDelete) {
        this.BtnDelete = BtnDelete;
    }

    public JButton getBtnNew() {
        return BtnNew;
    }

    public void setBtnNew(JButton BtnNew) {
        this.BtnNew = BtnNew;
    }

    public JButton getBtnUpdate() {
        return BtnUpdate;
    }

    public void setBtnUpdate(JButton BtnUpdate) {
        this.BtnUpdate = BtnUpdate;
    }

    public JTextField getTxtFind() {
        return TxtFind;
    }

    public void setTxtFind(JTextField TxtFind) {
        this.TxtFind = TxtFind;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        jPanel3 = new javax.swing.JPanel();
        BtnNew = new javax.swing.JButton();
        BtnUpdate = new javax.swing.JButton();
        BtnDelete = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        TblViewVehicle = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        TxtFind = new javax.swing.JTextField();

        jPanel3.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.RIGHT));

        BtnNew.setText("New");
        jPanel3.add(BtnNew);

        BtnUpdate.setText("Update");
        jPanel3.add(BtnUpdate);

        BtnDelete.setText("Delete");
        jPanel3.add(BtnDelete);

        getContentPane().add(jPanel3, java.awt.BorderLayout.PAGE_END);

        jPanel4.setLayout(new java.awt.GridBagLayout());

        TblViewVehicle.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        TblViewVehicle.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        jScrollPane2.setViewportView(TblViewVehicle);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.weighty = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        jPanel4.add(jScrollPane2, gridBagConstraints);

        getContentPane().add(jPanel4, java.awt.BorderLayout.CENTER);

        jPanel1.setLayout(new java.awt.GridBagLayout());

        jLabel1.setText("Find:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(2, 3, 2, 3);
        jPanel1.add(jLabel1, gridBagConstraints);

        TxtFind.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TxtFindActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(2, 3, 2, 3);
        jPanel1.add(TxtFind, gridBagConstraints);

        getContentPane().add(jPanel1, java.awt.BorderLayout.PAGE_START);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void TxtFindActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TxtFindActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TxtFindActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtnDelete;
    private javax.swing.JButton BtnNew;
    private javax.swing.JButton BtnUpdate;
    private javax.swing.JTable TblViewVehicle;
    private javax.swing.JTextField TxtFind;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane2;
    // End of variables declaration//GEN-END:variables
}
