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
import javax.swing.DefaultComboBoxModel;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
/**
 *
 * @author Kiss Márton
 */
public class AsztalFoglaloMainFrame extends javax.swing.JFrame {
    private final FoglalasPanelGenerator fpg = new FoglalasPanelGenerator();
    /*private final String dbURL="jdbc:mysql://nebet.hu/c31kissM_db",dbUser="c31kissM",dbPass="ogqgtWAALB8!b";*/
    private final String dbURL="jdbc:mysql://localhost:3306/foglalas",dbUser="foglalas_kezelo",dbPass="4N6jqhr7dnwCACRI";
    private DefaultListModel<Foglalas> foglalasokLista;
    private DefaultComboBoxModel<Asztal> asztalokDCBM;
    private JFrame errorFrame= new JFrame();
    private String etteremNev;
    private int etteremId=1;
    public Connection con;
    /**
     * Creates new form AsztalFoglaloMainFrame
     */
    public AsztalFoglaloMainFrame() {
        foglalasokLista= new DefaultListModel<Foglalas>();
        asztalokDCBM = new DefaultComboBoxModel<Asztal>();
        try {
            con = DriverManager.getConnection(dbURL,dbUser,dbPass);
            loadAsztalokModel();
            loadListFromDB();
        } catch (SQLException sqle) {
            JOptionPane.showMessageDialog(errorFrame,"Sikertelen adatbázis kapcsolódás!\n"+sqle.getMessage(),"Hiba!",JOptionPane.ERROR_MESSAGE);
            System.exit(0);
        } catch (ClassNotFoundException cnfe) {
            JOptionPane.showMessageDialog(errorFrame,"Sikertelen driver betöltés!\n"+cnfe,"Hiba!",JOptionPane.ERROR_MESSAGE);
            System.exit(0);
        }
        initComponents();
        setLocationRelativeTo(null);
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
        foglaloNevLabel = new javax.swing.JLabel();
        tSzamLabel = new javax.swing.JLabel();
        emberSzamLabel = new javax.swing.JLabel();
        asztalIdLabel = new javax.swing.JLabel();
        datumLabel = new javax.swing.JLabel();
        idopontLabel = new javax.swing.JLabel();
        datum = new javax.swing.JTextField();
        idopontKezd = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jList3 = new javax.swing.JList<Foglalas>();
        jLabel7 = new javax.swing.JLabel();
        idopontVeg = new javax.swing.JTextField();
        asztalokComboBox = new javax.swing.JComboBox<Asztal>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Asztal foglalas");
        setResizable(false);

        submitButton.setText("Létrhoz");
        submitButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                submitButtonActionPerformed(evt);
            }
        });

        foglaloNevLabel.setText("Foglaló neve:");

        tSzamLabel.setText("Telefonszám:");

        emberSzamLabel.setText("Csoport mérete:");

        asztalIdLabel.setText("Asztal ID:");

        datumLabel.setText("Dátum (yyyy-MM-dd):");

        idopontLabel.setText("Időpont (HH:mm):");

        idopontKezd.setToolTipText("");

        jList3.setModel(foglalasokLista);
        jList3.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane1.setViewportView(jList3);

        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("-");

        asztalokComboBox.setModel(asztalokDCBM);

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
                            .addComponent(foglaloNevLabel)
                            .addComponent(tSzamLabel)
                            .addComponent(emberSzamLabel)
                            .addComponent(datumLabel)
                            .addComponent(idopontLabel)
                            .addComponent(asztalIdLabel))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(idopontKezd, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(idopontVeg, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(tSzam, javax.swing.GroupLayout.DEFAULT_SIZE, 121, Short.MAX_VALUE)
                            .addComponent(foglaloNev, javax.swing.GroupLayout.DEFAULT_SIZE, 121, Short.MAX_VALUE)
                            .addComponent(emberSzam, javax.swing.GroupLayout.DEFAULT_SIZE, 121, Short.MAX_VALUE)
                            .addComponent(datum, javax.swing.GroupLayout.DEFAULT_SIZE, 121, Short.MAX_VALUE)
                            .addComponent(asztalokComboBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 27, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
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
                            .addComponent(foglaloNevLabel))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(tSzam, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tSzamLabel))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(asztalIdLabel)
                            .addComponent(asztalokComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(emberSzam, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(emberSzamLabel))
                        .addGap(12, 12, 12)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(datumLabel)
                            .addComponent(datum, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(idopontLabel)
                            .addComponent(idopontKezd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7)
                            .addComponent(idopontVeg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
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
            String[] idopontSplit= idopontKezd.getText().split(":");
            if (Integer.parseInt(idopontSplit[0])>23||Integer.parseInt(idopontSplit[0])<0||Integer.parseInt(idopontSplit[1])>59||Integer.parseInt(idopontSplit[1])<0){
                throw new InvalidTimeException("Inavlid időpont");
            }
            for (int i = 0; i < asztalokDCBM.getSize(); i++) {
                
            }
            Asztal a = (Asztal) asztalokComboBox.getSelectedItem();
            f = new Foglalas(foglaloNev.getText(),tSzam.getText(),a,Integer.parseInt(emberSzam.getText()),new String(datum.getText()+" "+idopontKezd.getText()+":00"),new String(datum.getText()+" "+idopontVeg.getText()+":00"));
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
        } catch (ClassNotFoundException cnfe) {
            JOptionPane.showMessageDialog(errorFrame,"Sikertelen driver betöltés!\n"+cnfe,"Hiba!",JOptionPane.ERROR_MESSAGE);
            System.exit(0);
        }
        
    }//GEN-LAST:event_submitButtonActionPerformed

    private void loadListFromDB() throws SQLException, ClassNotFoundException{
        foglalasokLista.clear();
        String todaysDateTime=dtf.format(LocalDateTime.now());
        String sql="SELECT `szam`,`ettermek`.`nev`,`etterem_id`,`asztal_id`,`tipus`,`foglalo_nev`,`foglalo_telszam`,`csoport_meret`,`idopont_kezd`,`idopont_veg` "
                + "FROM `foglalasok` "
                + "INNER JOIN `asztalok` ON `asztalok`.`id`=`asztal_id` "
                + "INNER JOIN `ettermek` ON `ettermek`.`id`=`etterem_id` "
                + "WHERE `idopont_kezd`>'"+todaysDateTime+"' ORDER BY `idopont_kezd`";
        Statement stmt= con.createStatement();
        if(stmt.execute(sql)){
            ResultSet rs = stmt.getResultSet();
            Foglalas f;
            Asztal a;
            while(rs.next()){
                try {
                    a= new Asztal(rs.getInt(1),rs.getString(2),rs.getInt(3),rs.getInt(4),rs.getInt(5));
                    f= new Foglalas(rs.getString(6),rs.getString(7),a,rs.getInt(8),rs.getString(9),rs.getString(10));
                    foglalasokLista.addElement(f);
                } catch (OldDateException | IllegalArgumentException | InvalidTimeException ex) {
                    JOptionPane.showMessageDialog(errorFrame,"Ennek nem kéne megtörténni!\n"+ex.getMessage(),"Hiba!",JOptionPane.ERROR_MESSAGE);
                System.exit(0);
                }
            }
        }
    }
    
    public boolean addFoglalas(Foglalas f) throws SQLException, ClassNotFoundException{
        if (canBeReserved(f)) {
            
            String sql="INSERT INTO "+
                    "`foglalasok` (`id`, `foglalo_nev`, `foglalo_telszam`, `csoport_meret`, `asztal_id`, `idopont_kezd`, `idopont_veg`) "+
                    "VALUES "+
                    "(NULL, '"+f.getFoglaloNev()+"', '"+f.getFoglaloTSzam()+"', '"+f.getEmberSzam()+"', '"+f.getAsztal().getAsztalId()+"', '"+f.getIdopontKezdString()+"', '"+f.getIdopontVegString()+"');";
            Statement stmt= con.createStatement();
            stmt.execute(sql);
            boolean success=stmt.getUpdateCount()==1;
            
            if(success){
                loadListFromDB();
            }
            return success;
        }
        return false;
    }
    
    public boolean canBeReserved(Foglalas ujFoglalas)
    {
        for (int i = 0; i < foglalasokLista.getSize(); i++) {
            Foglalas f = foglalasokLista.get(i);
            if(f.getAsztal().getAsztalId()==ujFoglalas.getAsztal().getAsztalId()){
                LocalDateTime 
                            marFoglaltIdoKezd = foglalasokLista.get(i).getIdopontKezd(),
                            marFoglaltIdoVeg = foglalasokLista.get(i).getIdopontVeg();
                
                if(ujFoglalas.getIdopontKezd().isBefore(marFoglaltIdoVeg)&&ujFoglalas.getIdopontKezd().isAfter(marFoglaltIdoKezd)){
                    return false;
                }
            }
        }
        for (int i = foglalasokLista.getSize()-1; i > 0; i--) {
            Foglalas f = foglalasokLista.get(i);
            if(f.getAsztal().getAsztalId()==ujFoglalas.getAsztal().getAsztalId()){
                LocalDateTime 
                            marFoglaltIdoKezd = foglalasokLista.get(i).getIdopontKezd(),
                            marFoglaltIdoVeg = foglalasokLista.get(i).getIdopontVeg();
                
                if(ujFoglalas.getIdopontVeg().isBefore(marFoglaltIdoKezd)){
                    return false;
                }
            }
        }
        return true;
    }
    
    private void loadAsztalokModel() throws SQLException{
        String todaysDateTime=dtf.format(LocalDateTime.now());
        String sql="SELECT `nev`,`etterem_id`,`asztalok`.`id`,`tipus`,`szam` FROM `asztalok` "
                + "INNER JOIN `ettermek` ON `ettermek`.`id`=`etterem_id` "
                + "WHERE `etterem_id`='"+etteremId+"'";
        Statement stmt= con.createStatement();
        if(stmt.execute(sql)){
            ResultSet rs = stmt.getResultSet();
            Asztal a;
            while(rs.next()){
                a= new Asztal(rs.getInt(5),rs.getString(1),rs.getInt(2),rs.getInt(3),rs.getInt(4));
                asztalokDCBM.addElement(a);
            }
        }
    }
    
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
    private javax.swing.JLabel asztalIdLabel;
    private javax.swing.JComboBox<Asztal> asztalokComboBox;
    private javax.swing.JTextField datum;
    private javax.swing.JLabel datumLabel;
    private javax.swing.JTextField emberSzam;
    private javax.swing.JLabel emberSzamLabel;
    private javax.swing.JLabel feedBackLabel;
    private javax.swing.JTextField foglaloNev;
    private javax.swing.JLabel foglaloNevLabel;
    private javax.swing.JTextField idopontKezd;
    private javax.swing.JLabel idopontLabel;
    private javax.swing.JTextField idopontVeg;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JList<Foglalas> jList3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton submitButton;
    private javax.swing.JTextField tSzam;
    private javax.swing.JLabel tSzamLabel;
    // End of variables declaration//GEN-END:variables
}
