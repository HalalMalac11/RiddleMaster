package asztalFoglaloSwing;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class AddAsztalDialog extends javax.swing.JDialog {
    AsztalFoglaloMainFrame mf;

    public AddAsztalDialog(AsztalFoglaloMainFrame parent, boolean modal) {
        super(parent, modal);
        mf=parent;
        DefaultComboBoxModel<Tipus> ferohelyModel= new DefaultComboBoxModel<Tipus>();
        try{
            String sql = "SELECT * FROM `tipus` ORDER BY `tipus_ferohely` ASC";
            Statement stmt=AsztalFoglaloMainFrame.getStmt();
            ResultSet rs=stmt.executeQuery(sql);
            while(rs.next()){
                Tipus t = new Tipus(rs.getInt("tipus_id"),rs.getInt("tipus_ferohely"));
                ferohelyModel.addElement(t);
            }
        } catch (SQLException sqle) {
            JOptionPane.showMessageDialog(new JFrame(),"Sikertelen adatbázis lekérdezés!\n"+sqle.getMessage(),"Hiba!",JOptionPane.ERROR_MESSAGE);
            this.dispose();
        }
        initComponents();
        setLocationRelativeTo(null);
        ferohelyCB.setModel(ferohelyModel);
        etteremNev.setText(mf.getEtterem().getNev());
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        ujAsztalLabel = new javax.swing.JLabel();
        etteremNevLabel = new javax.swing.JLabel();
        asztalSzamLabel = new javax.swing.JLabel();
        ferohelyLabel = new javax.swing.JLabel();
        ferohelyCB = new javax.swing.JComboBox<>();
        asztalSzam = new javax.swing.JTextField();
        submit = new javax.swing.JButton();
        etteremNev = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Új asztal");

        ujAsztalLabel.setFont(new java.awt.Font("Calibri", 1, 24)); // NOI18N
        ujAsztalLabel.setText("Új asztal");

        etteremNevLabel.setText("Étterem:");

        asztalSzamLabel.setText("Száma:");

        ferohelyLabel.setText("Férőhelyek:");

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
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(ferohelyLabel)
                            .addComponent(asztalSzamLabel)
                            .addComponent(etteremNevLabel))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(etteremNev, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(ferohelyCB, javax.swing.GroupLayout.Alignment.LEADING, 0, 50, Short.MAX_VALUE)
                                .addComponent(asztalSzam, javax.swing.GroupLayout.Alignment.LEADING))))
                    .addComponent(ujAsztalLabel)
                    .addComponent(submit))
                .addContainerGap(43, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(ujAsztalLabel)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(etteremNevLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(etteremNev, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(asztalSzamLabel)
                    .addComponent(asztalSzam, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ferohelyLabel)
                    .addComponent(ferohelyCB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(submit)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void submitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_submitActionPerformed
        String szam=asztalSzam.getText();
        boolean ok = true;
        if(!szam.trim().isEmpty()){
            for (int i = 0; i < szam.length(); i++) {
                if (!Character.isDigit(szam.charAt(i))) {
                    JOptionPane.showMessageDialog(new JFrame(),"Az asztal száma csak szám lehet!","Hiba!",JOptionPane.ERROR_MESSAGE);
                    ok=false;
                }
            }
            if(ok){
                try{
                    Tipus selected = (Tipus) ferohelyCB.getSelectedItem();
                    String sql = "INSERT INTO `asztal`(`tipus_id`, `asztal_szam`, `etterem_id`) VALUES ('"+selected.getTipus_id()+"','"+asztalSzam.getText()+"','"+mf.getEtterem().getId()+"')";
                    Statement stmt=AsztalFoglaloMainFrame.getStmt();
                    stmt.execute(sql);
                    this.dispose();
                    mf.loadTreeFromDB();
                } catch (SQLException sqle) {
                    JOptionPane.showMessageDialog(new JFrame(),"Ennél az éttermenél ilyen számú asztal már létezik!\n"+sqle.getMessage(),"Hiba!",JOptionPane.ERROR_MESSAGE);
                }
            }
        }else{
            JOptionPane.showMessageDialog(new JFrame(),"Az asztal száma mező nem lehet üres!","Hiba!",JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_submitActionPerformed

    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField asztalSzam;
    private javax.swing.JLabel asztalSzamLabel;
    private javax.swing.JLabel etteremNev;
    private javax.swing.JLabel etteremNevLabel;
    private javax.swing.JComboBox<Tipus> ferohelyCB;
    private javax.swing.JLabel ferohelyLabel;
    private javax.swing.JButton submit;
    private javax.swing.JLabel ujAsztalLabel;
    // End of variables declaration//GEN-END:variables
}
