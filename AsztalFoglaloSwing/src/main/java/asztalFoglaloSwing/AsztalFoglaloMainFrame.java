package asztalFoglaloSwing;

import java.awt.Color;
import java.time.DateTimeException;
import java.time.LocalDateTime;
import javax.swing.JPanel;
import asztalFoglaloSwing.InvalidTimeException;
import asztalFoglaloSwing.OldDateException;
import static asztalFoglaloSwing.iDateFormatting.dtf;
import java.awt.event.KeyEvent;
import javax.swing.DefaultListModel;
import java.sql.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.StringTokenizer;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.KeyStroke;

public class AsztalFoglaloMainFrame extends javax.swing.JFrame {
    //private final String dbURL="jdbc:mysql://nebet.hu/c31kissM_db",dbUser="c31kissM",dbPass="ogqgtWAALB8!b";
    private final String dbURL="jdbc:mysql://localhost:3306/foglalas",dbUser="foglalas_kezelo",dbPass="4N6jqhr7dnwCACRI";
    protected DefaultListModel<Foglalas> foglalasokLista;
    private DefaultComboBoxModel<Asztal> asztalokDCBM;
    private JFrame errorFrame= new JFrame();
    protected Etterem etterem;
    protected boolean etteremIsSet;
    public Connection con;
    
    public AsztalFoglaloMainFrame() {
        foglalasokLista= new DefaultListModel<Foglalas>();
        etteremIsSet = false;
        try {
            con = DriverManager.getConnection(dbURL,dbUser,dbPass);
            EtteremValasztDialog evd = new EtteremValasztDialog(this,true);
            evd.setVisible(true);
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
        createShortcuts();
    }
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        lista = new javax.swing.JList<Foglalas>();
        menuSor = new javax.swing.JMenuBar();
        fileMenu = new javax.swing.JMenu();
        editMenu = new javax.swing.JMenu();
        hozzaAd = new javax.swing.JMenuItem();
        edit = new javax.swing.JMenuItem();
        torol = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Asztal foglalas");
        setResizable(false);

        lista.setModel(foglalasokLista);
        lista.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        lista.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                listaMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(lista);

        fileMenu.setText("File");
        menuSor.add(fileMenu);

        editMenu.setText("Edit");

        hozzaAd.setText("Foglalas felvétele");
        hozzaAd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                hozzaAdActionPerformed(evt);
            }
        });
        editMenu.add(hozzaAd);

        edit.setText("Szerkesztés");
        edit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editActionPerformed(evt);
            }
        });
        editMenu.add(edit);

        torol.setText("Törlés");
        torol.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                torolActionPerformed(evt);
            }
        });
        editMenu.add(torol);

        menuSor.add(editMenu);

        setJMenuBar(menuSor);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 277, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 217, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void hozzaAdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_hozzaAdActionPerformed
        AddFoglalasDialog afd = new AddFoglalasDialog(this,true);
        afd.setVisible(true);
    }//GEN-LAST:event_hozzaAdActionPerformed

    private void listaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_listaMouseClicked
        if(evt.getClickCount()==2){
            ReszletekFrame rf = new ReszletekFrame(lista.getSelectedValue());
            rf.setEtteremNev(etterem.getNev());
            rf.setVisible(true);
        }
    }//GEN-LAST:event_listaMouseClicked

    private void editActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editActionPerformed
        AddFoglalasDialog afd = new AddFoglalasDialog(this,true,lista.getSelectedValue());
        afd.setVisible(true);
    }//GEN-LAST:event_editActionPerformed

    private void torolActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_torolActionPerformed
        Foglalas f = lista.getSelectedValue();
        int valasz=JOptionPane.showConfirmDialog(errorFrame,"Biztosan törölni szeretné?\n"+f,"Törlés",JOptionPane.YES_NO_OPTION,JOptionPane.WARNING_MESSAGE);
        if(valasz==JOptionPane.YES_OPTION){
            String sql="DELETE FROM `foglalasok`  WHERE `foglalo_nev` LIKE '"+f.getFoglaloNev()+"' AND `foglalo_telszam` LIKE '"+f.getFoglaloTSzam()+"' AND `csoport_meret`='"+f.getEmberSzam()+"' AND `asztal_id`='"+f.getAsztal().getAsztalId()+"' AND `idopont_kezd`='"+f.getIdopontKezdString(true)+"' AND `idopont_veg`='"+f.getIdopontVegString(true)+"'";
            try{
                Statement stmt= con.createStatement();
                stmt.execute(sql);
                boolean success=stmt.getUpdateCount()==1;
                if(success){
                    loadListFromDB();
                }
            } catch (SQLException|ClassNotFoundException ex) {
                JOptionPane.showMessageDialog(errorFrame,"Sikertelen törlés!\n"+ex,"Hiba!",JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_torolActionPerformed

    protected void loadListFromDB() throws SQLException, ClassNotFoundException{
        foglalasokLista.clear();
        String todaysDateTime=dtf.format(LocalDateTime.now());
        String sql="SELECT `szam`,`etterem_id`,`asztal_id`,`tipus`,`foglalo_nev`,`foglalo_telszam`,`csoport_meret`,`idopont_kezd`,`idopont_veg` "
                + "FROM `foglalasok` "
                + "INNER JOIN `asztalok` ON `asztalok`.`id`=`asztal_id` "
                + "INNER JOIN `ettermek` ON `ettermek`.`id`=`etterem_id` "
                + "WHERE `idopont_kezd`>'"+todaysDateTime+"' AND `etterem_id`="+etterem.getId()+" ORDER BY `idopont_kezd`";
        Statement stmt= con.createStatement();
        if(stmt.execute(sql)){
            ResultSet rs = stmt.getResultSet();
            Foglalas f;
            Asztal a;
            while(rs.next()){
                try {
                    a= new Asztal(rs.getInt(1),etterem.getNev(),rs.getInt(3),getAsztalKapacitas(rs.getInt(4)));
                    f= new Foglalas(rs.getString(5),rs.getString(6),a,rs.getInt(7),rs.getString(8),rs.getString(9));
                    foglalasokLista.addElement(f);
                } catch (OldDateException | IllegalArgumentException | InvalidTimeException ex) {
                    JOptionPane.showMessageDialog(errorFrame,"Ennek nem kéne megtörténni!\n"+ex.getMessage(),"Hiba!",JOptionPane.ERROR_MESSAGE);
                System.exit(0);
                }
            }
        }
    }
    
    protected int getAsztalKapacitas(int tipusId) throws SQLException{
        String sql="SELECT `ferohely` FROM `asztal_tipusok` WHERE `id`='"+tipusId+"'";
        Statement stmt= con.createStatement();
        if(stmt.execute(sql)){
            ResultSet rs = stmt.getResultSet();
            rs.next();
            return rs.getInt(1);
        }
        return 0;
    }
    
    private void createShortcuts(){
        KeyStroke keyStrokeHozzaAd= KeyStroke.getKeyStroke(KeyEvent.VK_F, KeyEvent.CTRL_DOWN_MASK);
        hozzaAd.setAccelerator(keyStrokeHozzaAd);
        KeyStroke keyStrokeSzerkesztes= KeyStroke.getKeyStroke(KeyEvent.VK_E, KeyEvent.CTRL_DOWN_MASK);
        edit.setAccelerator(keyStrokeSzerkesztes);
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
    private javax.swing.JMenuItem edit;
    private javax.swing.JMenu editMenu;
    private javax.swing.JMenu fileMenu;
    private javax.swing.JMenuItem hozzaAd;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JList<Foglalas> lista;
    private javax.swing.JMenuBar menuSor;
    private javax.swing.JMenuItem torol;
    // End of variables declaration//GEN-END:variables
}
