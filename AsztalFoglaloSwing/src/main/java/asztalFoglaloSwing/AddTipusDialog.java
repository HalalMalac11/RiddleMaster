package asztalFoglaloSwing;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class AddTipusDialog extends javax.swing.JDialog {

    public AddTipusDialog(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        setLocationRelativeTo(null);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        cimLabel = new javax.swing.JLabel();
        ferohelySzamLabel = new javax.swing.JLabel();
        ferohelySzam = new javax.swing.JTextField();
        submit = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Új Asztal típus hozzáadása");

        cimLabel.setFont(new java.awt.Font("Calibri", 1, 24)); // NOI18N
        cimLabel.setText("Új típus");

        ferohelySzamLabel.setText("Férőhelyek száma:");

        submit.setText("Hozzáadás");
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
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cimLabel)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(ferohelySzamLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(ferohelySzam, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(submit))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(cimLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ferohelySzamLabel)
                    .addComponent(ferohelySzam, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(submit)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void submitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_submitActionPerformed
        String tipus_ferohely = ferohelySzam.getText().trim();
        Pattern pattern = Pattern.compile("(?:^\\d+$)");
        Matcher matcher = pattern.matcher(tipus_ferohely);
        if (matcher.find()) {
            try {
                String sql = "INSERT INTO `tipus`(`tipus_ferohely`) VALUES ('" + tipus_ferohely + "')";
                Statement stmt = AsztalFoglaloMainFrame.getStmt();
                stmt.execute(sql);
                dispose();
            } catch (SQLException sqle) {
                JOptionPane.showMessageDialog(new JFrame(), "Ilyen típus már létezik!", "Hiba!", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(new JFrame(), "A megadott férőhely szám nem megfelelő", "Hiba!", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_submitActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel cimLabel;
    private javax.swing.JTextField ferohelySzam;
    private javax.swing.JLabel ferohelySzamLabel;
    private javax.swing.JButton submit;
    // End of variables declaration//GEN-END:variables
}
