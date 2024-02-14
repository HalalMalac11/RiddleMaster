/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package asztalFoglaloSwing;

import java.awt.Color;
import java.time.DateTimeException;
import java.time.LocalDateTime;
import javax.swing.JPanel;
import asztalFoglaloSwing.InvalidTimeException;
import asztalFoglaloSwing.OldDateException;
import static asztalFoglaloSwing.iDateFormatting.dtf;
import javax.swing.DefaultListModel;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
/**
 *
 * @author Kiss Márton
 */
public class AsztalFoglaloMainFrame extends javax.swing.JFrame {
    private final FoglalasPanelGenerator fpg = new FoglalasPanelGenerator();
    private DefaultListModel<Foglalas> foglalasokLista;
    private Connection con;
    private JFrame errorFrame= new JFrame();
    /**
     * Creates new form AsztalFoglaloMainFrame
     */
    public AsztalFoglaloMainFrame() {
        foglalasokLista= new DefaultListModel<Foglalas>();
        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/foglalas","foglalas_kezelo","4N6jqhr7dnwCACRI");
            loadListFromDB();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(errorFrame,"Sikertelen adatbázis kapcsolódás!\n"+ex.getMessage(),"Hiba!",JOptionPane.ERROR_MESSAGE);
            System.exit(0);
        }
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        submitButton = new javax.swing.JButton();
        feedBackLabel = new javax.swing.JLabel();
        foglaloNev = new javax.swing.JTextField();
        tSzam = new javax.swing.JTextField();
        emberSzam = new javax.swing.JTextField();
        asztalId = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        datum = new javax.swing.JTextField();
        idopont = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jList3 = new javax.swing.JList<Foglalas>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        submitButton.setText("Létrhoz");
        submitButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                submitButtonActionPerformed(evt);
            }
        });

        jLabel1.setText("Foglaló neve:");

        jLabel2.setText("Telefonszám:");

        jLabel3.setText("Csoport mérete:");

        jLabel4.setText("Asztal ID:");

        jLabel5.setText("Dátum (yyyy-MM-dd):");

        jLabel6.setText("Időpont (HH:mm):");

        idopont.setToolTipText("");

        jList3.setModel(foglalasokLista);
        jList3.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane1.setViewportView(jList3);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(submitButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(feedBackLabel))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(datum, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(idopont, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(asztalId, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(emberSzam, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tSzam, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(foglaloNev, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 156, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(foglaloNev, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(tSzam, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(emberSzam, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(asztalId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4))
                        .addGap(12, 12, 12)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(datum, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(idopont, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(submitButton)
                            .addComponent(feedBackLabel)))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 257, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(20, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void submitButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_submitButtonActionPerformed
                                                    
        Foglalas f;

        try {
            String[] idopontSplit= idopont.getText().split(":");
            if (Integer.parseInt(idopontSplit[0])>23||Integer.parseInt(idopontSplit[0])<0||Integer.parseInt(idopontSplit[1])>59||Integer.parseInt(idopontSplit[1])<0){
                throw new InvalidTimeException("Inavlid időpont");
            }
            f = new Foglalas(foglaloNev.getText(),tSzam.getText(),Integer.parseInt(emberSzam.getText()),Integer.parseInt(asztalId.getText()),new String(datum.getText()+" "+idopont.getText()+":00"));
            if(addFoglalas(f)){
                feedBackLabel.setText("Sikeres hozzáadás!");
                feedBackLabel.setForeground(Color.green);
            }else{
                feedBackLabel.setText("A hozzáadás sikertelen!");
                feedBackLabel.setForeground(Color.red);
            }
        }catch (OldDateException ode){
            feedBackLabel.setText(ode.toString());
            feedBackLabel.setForeground(Color.red);
        }catch (InvalidTimeException ite){
            feedBackLabel.setText(ite.toString());
            feedBackLabel.setForeground(Color.red);
        }catch (IllegalArgumentException iae){
            feedBackLabel.setText(iae.toString());
            feedBackLabel.setForeground(Color.red);
        } catch (SQLException sqle) {
            JOptionPane.showMessageDialog(errorFrame,sqle.getMessage(),"Hiba!",JOptionPane.ERROR_MESSAGE);
            System.exit(0);
        }
        
    }//GEN-LAST:event_submitButtonActionPerformed

    private void loadListFromDB() throws SQLException{
        foglalasokLista.clear();
        String todaysDateTime=dtf.format(LocalDateTime.now());
        String sql="SELECT * FROM `foglalasok` WHERE `idopont`>'"+todaysDateTime+"' ORDER BY `idopont`;";
        Statement stmt= con.createStatement();
        if(stmt.execute(sql)){
            ResultSet rs = stmt.getResultSet();
            Foglalas f;
            while(rs.next()){
                try {
                    f= new Foglalas(rs.getString(2),rs.getString(3),rs.getInt(4),rs.getInt(5),rs.getString(6));
                    foglalasokLista.addElement(f);
                } catch (OldDateException ode) {
                    JOptionPane.showMessageDialog(errorFrame,"Ennek nem kéne megtörténni!\n"+ode.getMessage(),"Hiba!",JOptionPane.ERROR_MESSAGE);
                System.exit(0);
                } catch (IllegalArgumentException iae) {
                    JOptionPane.showMessageDialog(errorFrame,"Ennek nem kéne megtörténni!\n"+iae.getMessage(),"Hiba!",JOptionPane.ERROR_MESSAGE);
                System.exit(0);
                } catch (InvalidTimeException ite) {
                    JOptionPane.showMessageDialog(errorFrame,"Ennek nem kéne megtörténni!\n"+ite.getMessage(),"Hiba!",JOptionPane.ERROR_MESSAGE);
                System.exit(0);
                }
            }
        }
    }
    
    public boolean addFoglalas(Foglalas f) throws SQLException{
        String sql="INSERT INTO "+
                "`foglalasok` (`id`, `foglalo_nev`, `foglalo_telszam`, `csoport_meret`, `asztal_id`, `idopont`) "+
                "VALUES "+
                "(NULL, '"+f.getFoglaloNev()+"', '"+f.getFoglaloTSzam()+"', '"+f.getEmberSzam()+"', '"+f.getAsztalId()+"', '"+f.getIdopont()+"');";
        Statement stmt= con.createStatement();
        stmt.execute(sql);
        boolean success=stmt.getUpdateCount()==1;
        if(success){
            loadListFromDB();
        }
        return success;
    }
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
            java.util.logging.Logger.getLogger(AsztalFoglaloMainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AsztalFoglaloMainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AsztalFoglaloMainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AsztalFoglaloMainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AsztalFoglaloMainFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField asztalId;
    private javax.swing.JTextField datum;
    private javax.swing.JTextField emberSzam;
    private javax.swing.JLabel feedBackLabel;
    private javax.swing.JTextField foglaloNev;
    private javax.swing.JTextField idopont;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JList<Foglalas> jList3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton submitButton;
    private javax.swing.JTextField tSzam;
    // End of variables declaration//GEN-END:variables
}
