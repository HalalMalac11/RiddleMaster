package asztalFoglaloSwing;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class EtteremValasztDialog extends javax.swing.JDialog {
    private DefaultComboBoxModel<Etterem> dcbm;
    private AsztalFoglaloMainFrame parent;

    public EtteremValasztDialog(AsztalFoglaloMainFrame parent, boolean modal) {
        super(parent, modal);
        this.parent=parent;
        initComponents();
        setLocationRelativeTo(null);
        dcbm= new DefaultComboBoxModel<Etterem>();
        try {
            String sql = "SELECT `nev`, `id` FROM `ettermek`;";
            Statement stmt = parent.con.createStatement();
            if (stmt.execute(sql)) {
                ResultSet rs = stmt.getResultSet();
                Etterem etterem;
                while (rs.next()) {
                    etterem = new Etterem(rs.getString(1), rs.getInt(2));
                    dcbm.addElement(etterem);
                }
            }
            this.ettermekComboBox.setModel(dcbm);
            this.ettermekComboBox.setSelectedIndex(0);
        } catch (SQLException sqle) {
            JOptionPane.showMessageDialog(new JFrame(), "Adatbázis csatlakozás hiba!","HIBA!",JOptionPane.ERROR_MESSAGE);
            System.exit(0);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        valasszLabel = new javax.swing.JLabel();
        ettermekComboBox = new javax.swing.JComboBox<>();
        submit = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);

        valasszLabel.setFont(new java.awt.Font("Calibri", 1, 24)); // NOI18N
        valasszLabel.setText("Válasszon egy éttermet!");

        submit.setText("Ok");
        submit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                submitActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(ettermekComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 241, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(valasszLabel))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(submit)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(valasszLabel)
                .addGap(18, 18, 18)
                .addComponent(ettermekComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 48, Short.MAX_VALUE)
                .addComponent(submit)
                .addGap(20, 20, 20))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void submitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_submitActionPerformed
        parent.setEtterem((Etterem) this.ettermekComboBox.getSelectedItem());
        this.dispose();
    }//GEN-LAST:event_submitActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<Etterem> ettermekComboBox;
    private javax.swing.JButton submit;
    private javax.swing.JLabel valasszLabel;
    // End of variables declaration//GEN-END:variables
}