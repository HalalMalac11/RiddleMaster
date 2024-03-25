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
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;

public class AsztalFoglaloMainFrame extends javax.swing.JFrame {
    //private final String dbURL="jdbc:mysql://nebet.hu/c31kissM_db",dbUser="c31kissM",dbPass="ogqgtWAALB8!b";
    private final String dbURL="jdbc:mysql://localhost:3306/asztalfoglalo",dbUser="foglalas_kezelo",dbPass="4N6jqhr7dnwCACRI";
    protected ArrayList<Foglalas> foglalasokLista;
    protected DefaultTreeModel foglalasFa;
    private JFrame errorFrame= new JFrame();
    private Etterem etterem;
    public static Connection con;
    
    public AsztalFoglaloMainFrame() {
        foglalasokLista= new ArrayList<Foglalas>();
        initComponents();
        try {
            con = DriverManager.getConnection(dbURL,dbUser,dbPass);
            EtteremValasztDialog evd = new EtteremValasztDialog(this,true);
            evd.setVisible(true);
            loadListFromDB();
            loadTreeFromDB();
            
        } catch (SQLException sqle) {
            JOptionPane.showMessageDialog(errorFrame,"Sikertelen adatbázis kapcsolódás!\n"+sqle.getMessage(),"Hiba!",JOptionPane.ERROR_MESSAGE);
            System.exit(0);
        } catch (ClassNotFoundException cnfe) {
            JOptionPane.showMessageDialog(errorFrame,"Sikertelen driver betöltés!\n"+cnfe,"Hiba!",JOptionPane.ERROR_MESSAGE);
            System.exit(0);
        }
        
        this.kivalasztottEtteremLabel.setText(etterem.getNev());
        setLocationRelativeTo(null);
        createShortcuts();
    }

    public void setEtterem(Etterem etterem) {
        this.etterem = etterem;
    }

    public Etterem getEtterem() {
        return etterem;
    }
    
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        kivalasztottEtteremLabel = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTree1 = new javax.swing.JTree();
        menuSor = new javax.swing.JMenuBar();
        fileMenu = new javax.swing.JMenu();
        kilepes = new javax.swing.JMenuItem();
        editMenu = new javax.swing.JMenu();
        hozzaAd = new javax.swing.JMenuItem();
        edit = new javax.swing.JMenuItem();
        torol = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Asztal foglalas");
        setResizable(false);

        kivalasztottEtteremLabel.setFont(new java.awt.Font("Calibri", 1, 24)); // NOI18N
        kivalasztottEtteremLabel.setText("jLabel1");

        jScrollPane2.setViewportView(jTree1);

        fileMenu.setText("Fájl");

        kilepes.setText("Kilépés");
        kilepes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kilepesActionPerformed(evt);
            }
        });
        fileMenu.add(kilepes);

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
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(kivalasztottEtteremLabel)
                        .addGap(0, 257, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(kivalasztottEtteremLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void hozzaAdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_hozzaAdActionPerformed
        AddFoglalasDialog afd = new AddFoglalasDialog(this,true);
        afd.setVisible(true);
    }//GEN-LAST:event_hozzaAdActionPerformed

    private void editActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editActionPerformed
        AddFoglalasDialog afd = new AddFoglalasDialog(this,true, (DefaultMutableTreeNode) jTree1.getLastSelectedPathComponent());
        afd.setVisible(true);
    }//GEN-LAST:event_editActionPerformed

    private void torolActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_torolActionPerformed
        DefaultMutableTreeNode selectedNode = (DefaultMutableTreeNode) jTree1.getLastSelectedPathComponent();
        Foglalas f = (Foglalas) selectedNode.getUserObject();
        int valasz=JOptionPane.showConfirmDialog(errorFrame,"Biztosan törölni szeretné?\n"+f,"Törlés",JOptionPane.YES_NO_OPTION,JOptionPane.WARNING_MESSAGE);
        if(valasz==JOptionPane.YES_OPTION){
            String sql="DELETE FROM `foglalas`  WHERE `foglalas_id`='"+f.getFoglalas_id()+"'";
            try{
                Statement stmt= con.createStatement();
                stmt.execute(sql);
                boolean success=stmt.getUpdateCount()==1;
                if(success){
                    jTree1.removeSelectionPath(jTree1.getSelectionPath());
                }
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(errorFrame,"Sikertelen törlés!\n"+ex,"Hiba!",JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_torolActionPerformed

    private void kilepesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kilepesActionPerformed
        System.exit(0);
    }//GEN-LAST:event_kilepesActionPerformed

    protected void loadListFromDB() throws SQLException, ClassNotFoundException{
        foglalasokLista.clear();
        String todaysDateTime=dtf.format(LocalDateTime.now());
        String sql="SELECT `asztal_szam`,`asztal`.`etterem_id`,`foglalas`.`asztal_id`,`tipus_id`, `foglalas_id`, `foglalas_nev`,`foglalas_telszam`,`foglalas_csoport_meret`,`foglalas_idopont_kezd`,`foglalas_idopont_veg` "
                + "FROM `foglalas` "
                + "INNER JOIN `asztal` ON `asztal`.`asztal_id`=`foglalas`.`asztal_id` "
                + "INNER JOIN `etterem` ON `etterem`.`etterem_id`=`asztal`.`etterem_id` "
                + "WHERE `foglalas_idopont_kezd`>'"+todaysDateTime+"' AND `asztal`.`etterem_id`="+etterem.getId()+" ORDER BY `foglalas_idopont_kezd`";
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery(sql);
        Foglalas f;
        Asztal a;
        while(rs.next()){
            try {
                a= new Asztal(rs.getInt("asztal_szam"),etterem.getNev(),rs.getInt("asztal_id"),getTipus_ferohely(rs.getInt("tipus_id")));
                f= new Foglalas(rs.getInt("foglalas_id"),rs.getString("foglalas_nev"),rs.getString("foglalas_telszam"),rs.getInt("foglalas_csoport_meret"),a,rs.getString("foglalas_idopont_kezd"),rs.getString("foglalas_idopont_veg"));
                foglalasokLista.add(f);
            } catch (OldDateException | IllegalArgumentException | InvalidTimeException ex) {
                JOptionPane.showMessageDialog(errorFrame,"Ennek nem kéne megtörténni!\n"+ex.getMessage(),"Hiba!",JOptionPane.ERROR_MESSAGE);
            System.exit(0);
            }
        }
        rs.close();
    }
    
    protected void loadTreeFromDB() throws SQLException {
        DefaultMutableTreeNode rootNode = new DefaultMutableTreeNode("root");
        foglalasFa = new DefaultTreeModel(rootNode);
        
        String todaysDateTime=dtf.format(LocalDateTime.now());
        String sql = "SELECT * FROM `asztal` WHERE `etterem_id`='"+etterem.getId()+"'";
        Statement etteremStmt = con.createStatement();
        ResultSet etteremRs = etteremStmt.executeQuery(sql);
        Asztal a;
        
        Foglalas f;
        while(etteremRs.next()){
            try {
                a= new Asztal(etteremRs.getInt(3),etterem.getNev(),etteremRs.getInt(1),getTipus_ferohely(etteremRs.getInt(2)));
                DefaultMutableTreeNode asztalNode = new DefaultMutableTreeNode(a);
                sql="SELECT `asztal`.`etterem_id`,`foglalas`.`asztal_id`, `foglalas_id`, `foglalas_nev`,`foglalas_telszam`,`foglalas_csoport_meret`,`foglalas_idopont_kezd`,`foglalas_idopont_veg` "
                + "FROM `foglalas` "
                + "INNER JOIN `asztal` ON `asztal`.`asztal_id`=`foglalas`.`asztal_id` "
                + "WHERE `foglalas_idopont_kezd`>'"+todaysDateTime+"' AND `foglalas`.`asztal_id`="+etteremRs.getInt(1)+" ORDER BY `foglalas_idopont_kezd`";
                Statement foglalasStmt = con.createStatement();
                ResultSet foglalasRs =foglalasStmt.executeQuery(sql);
                while(foglalasRs.next()){
                    f= new Foglalas(foglalasRs.getInt("foglalas_id"),foglalasRs.getString("foglalas_nev"),foglalasRs.getString("foglalas_telszam"),foglalasRs.getInt("foglalas_csoport_meret"),a,foglalasRs.getString("foglalas_idopont_kezd"),foglalasRs.getString("foglalas_idopont_veg"));
                    DefaultMutableTreeNode foglalasNode = new DefaultMutableTreeNode(f);
                    asztalNode.add(foglalasNode);
                }
                rootNode.add(asztalNode);
            } catch (IllegalArgumentException|OldDateException|InvalidTimeException ex) {
                JOptionPane.showMessageDialog(errorFrame,"Ennek nem kéne megtörténni!\n"+ex.getMessage(),"Hiba!",JOptionPane.ERROR_MESSAGE);
            System.exit(0);
            }
        }
        etteremRs.close();
        jTree1.setModel(foglalasFa);
        jTree1.expandRow(0);
        jTree1.setRootVisible(false);
        /*while(rs.next()){
            try {
                a= new Asztal(rs.getInt(1),etterem.getNev(),rs.getInt(3),getTipus_ferohely(rs.getInt(4)));
                f= new Foglalas(rs.getString(5),rs.getString(6),a,rs.getInt(7),rs.getString(8),rs.getString(9));
                foglalasokLista.addElement(f);
            } catch (OldDateException | IllegalArgumentException | InvalidTimeException ex) {
                JOptionPane.showMessageDialog(errorFrame,"Ennek nem kéne megtörténni!\n"+ex.getMessage(),"Hiba!",JOptionPane.ERROR_MESSAGE);
            System.exit(0);
            }
        }*/
    }
    
    protected int getTipus_ferohely(int tipusId) throws SQLException{
        String sql="SELECT `tipus_ferohely` FROM `tipus` WHERE `tipus_id`='"+tipusId+"'";
        Statement stmt = con.createStatement();
        if(stmt.execute(sql)){
            ResultSet rs = stmt.executeQuery(sql);
            rs.next();
            int ferohely= rs.getInt("tipus_ferohely");
            rs.close();
            return ferohely;
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
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTree jTree1;
    private javax.swing.JMenuItem kilepes;
    private javax.swing.JLabel kivalasztottEtteremLabel;
    private javax.swing.JMenuBar menuSor;
    private javax.swing.JMenuItem torol;
    // End of variables declaration//GEN-END:variables

    
}
