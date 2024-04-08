package asztalFoglaloSwing;

import java.time.LocalDateTime;
import static asztalFoglaloSwing.iDateFormatting.dtf;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import java.awt.event.KeyEvent;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;

public class AsztalFoglaloMainFrame extends javax.swing.JFrame {
    //private final String dbURL="jdbc:mysql://nebet.hu/c31kissM_db",dbUser="c31kissM",dbPass="ogqgtWAALB8!b";
    private final String dbURL="jdbc:mysql://localhost:3306/asztalfoglalo",dbUser="foglalas_kezelo",dbPass="4N6jqhr7dnwCACRI";
    protected DefaultTreeModel foglalasFaModel;
    private JFrame errorFrame= new JFrame();
    private Etterem etterem;
    public static Connection con;
    
    public AsztalFoglaloMainFrame() {
        initComponents();
        try {
            con = DriverManager.getConnection(dbURL,dbUser,dbPass);
            EtteremValasztDialog evd = new EtteremValasztDialog(this,true);
            evd.setVisible(true);
            loadTreeFromDB();
            
        } catch (SQLException sqle) {
            JOptionPane.showMessageDialog(errorFrame,"Sikertelen adatbázis kapcsolódás!\n"+sqle.getMessage(),"Hiba!",JOptionPane.ERROR_MESSAGE);
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
        foglalasFa = new javax.swing.JTree();
        menuSor = new javax.swing.JMenuBar();
        fajlMenu = new javax.swing.JMenu();
        exportPdf = new javax.swing.JMenuItem();
        kilepes = new javax.swing.JMenuItem();
        etteremMenu = new javax.swing.JMenu();
        etteremValt = new javax.swing.JMenuItem();
        etteremTorol = new javax.swing.JMenuItem();
        asztalMenu = new javax.swing.JMenu();
        ujAsztal = new javax.swing.JMenuItem();
        asztalTorol = new javax.swing.JMenuItem();
        jMenuItem1 = new javax.swing.JMenuItem();
        foglalasMenu = new javax.swing.JMenu();
        hozzaAd = new javax.swing.JMenuItem();
        edit = new javax.swing.JMenuItem();
        torol = new javax.swing.JMenuItem();
        reszletek = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Asztal foglalas");
        setResizable(false);

        kivalasztottEtteremLabel.setFont(new java.awt.Font("Calibri", 1, 24)); // NOI18N
        kivalasztottEtteremLabel.setText("jLabel1");

        foglalasFa.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                foglalasFaMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(foglalasFa);

        fajlMenu.setText("Fájl");

        exportPdf.setText("Mentés PDF-be");
        exportPdf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exportPdfActionPerformed(evt);
            }
        });
        fajlMenu.add(exportPdf);

        kilepes.setText("Kilépés");
        kilepes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kilepesActionPerformed(evt);
            }
        });
        fajlMenu.add(kilepes);

        menuSor.add(fajlMenu);

        etteremMenu.setText("Étterem");

        etteremValt.setText("Étterem váltása");
        etteremValt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                etteremValtActionPerformed(evt);
            }
        });
        etteremMenu.add(etteremValt);

        etteremTorol.setText("Étterem törlése");
        etteremTorol.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                etteremTorolActionPerformed(evt);
            }
        });
        etteremMenu.add(etteremTorol);

        asztalMenu.setText("Asztal");

        ujAsztal.setText("Új asztal");
        ujAsztal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ujAsztalActionPerformed(evt);
            }
        });
        asztalMenu.add(ujAsztal);

        asztalTorol.setText("Asztal törlése");
        asztalTorol.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                asztalTorolActionPerformed(evt);
            }
        });
        asztalMenu.add(asztalTorol);

        jMenuItem1.setText("Új típus");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        asztalMenu.add(jMenuItem1);

        etteremMenu.add(asztalMenu);

        menuSor.add(etteremMenu);

        foglalasMenu.setText("Foglalás");

        hozzaAd.setText("Foglalas felvétele");
        hozzaAd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                hozzaAdActionPerformed(evt);
            }
        });
        foglalasMenu.add(hozzaAd);

        edit.setText("Szerkesztés");
        edit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editActionPerformed(evt);
            }
        });
        foglalasMenu.add(edit);

        torol.setText("Törlés");
        torol.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                torolActionPerformed(evt);
            }
        });
        foglalasMenu.add(torol);

        reszletek.setText("Részletek megtekintése");
        reszletek.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                reszletekActionPerformed(evt);
            }
        });
        foglalasMenu.add(reszletek);

        menuSor.add(foglalasMenu);

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
        if(foglalasFa.getLastSelectedPathComponent()!=null){
            AddFoglalasDialog afd = new AddFoglalasDialog(this,true, (DefaultMutableTreeNode) foglalasFa.getLastSelectedPathComponent());
            afd.setVisible(true);
        }else{
            JOptionPane.showMessageDialog(errorFrame,"Nincs kiválasztva foglalás!","Hiba!",JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_editActionPerformed

    private void torolActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_torolActionPerformed
        if(foglalasFa.getLastSelectedPathComponent()!=null){
            DefaultMutableTreeNode selectedNode = (DefaultMutableTreeNode) foglalasFa.getLastSelectedPathComponent();
            Foglalas f = (Foglalas) selectedNode.getUserObject();
            int valasz=JOptionPane.showConfirmDialog(errorFrame,"Biztosan törölni szeretné?\n"+f,"Törlés",JOptionPane.YES_NO_OPTION,JOptionPane.WARNING_MESSAGE);
            if(valasz==JOptionPane.YES_OPTION){
                String sql="DELETE FROM `foglalas`  WHERE `foglalas_id`='"+f.getFoglalas_id()+"'";
                try{
                    Statement stmt= con.createStatement();
                    stmt.execute(sql);
                    boolean success=stmt.getUpdateCount()==1;
                    if(success){
                        foglalasFa.removeSelectionPath(foglalasFa.getSelectionPath());
                    }
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(errorFrame,"Sikertelen törlés!\n"+ex,"Hiba!",JOptionPane.ERROR_MESSAGE);
                }
            }
        }else{
            JOptionPane.showMessageDialog(errorFrame,"Nincs kiválasztva foglalás!","Hiba!",JOptionPane.ERROR_MESSAGE);
        }
        
    }//GEN-LAST:event_torolActionPerformed

    private void kilepesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kilepesActionPerformed
        System.exit(0);
    }//GEN-LAST:event_kilepesActionPerformed

    private void etteremValtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_etteremValtActionPerformed
        etteremValtas();
    }//GEN-LAST:event_etteremValtActionPerformed

    private void ujAsztalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ujAsztalActionPerformed
        AddAsztalDialog aad= new AddAsztalDialog(this,true);
        aad.setVisible(true);
    }//GEN-LAST:event_ujAsztalActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        AddTipusDialog atd= new AddTipusDialog(this,true);
        atd.setVisible(true);
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void asztalTorolActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_asztalTorolActionPerformed
        if(foglalasFa.getLastSelectedPathComponent()!=null){
            DefaultMutableTreeNode selectedNode = (DefaultMutableTreeNode) foglalasFa.getLastSelectedPathComponent();
            if (selectedNode.getUserObject() instanceof Asztal) {
                Asztal a = (Asztal) selectedNode.getUserObject();
                int biztos=JOptionPane.showConfirmDialog(errorFrame,"Az asztal tölésével az össze hozzátartozó foglalás elveszik!\nBiztosan törölni szeretné ezt az asztalt?","Törlés!",JOptionPane.WARNING_MESSAGE);
                if(biztos==JOptionPane.YES_OPTION){
                    String input="alapertek";
                    while(input!=null&&!input.equals(a.getAsztalNev()))
                     input=JOptionPane.showInputDialog(errorFrame,"A törléshez írja be az asztal nevét: "+a.getAsztalNev(),"Törlés!",JOptionPane.WARNING_MESSAGE);
                    if(input!=null){
                        try {
                            String sql = "DELETE FROM `foglalas` WHERE `asztal_id`='"+a.getAsztal_id()+"'";
                            Statement stmt = con.createStatement();
                            stmt.execute(sql);
                            sql="DELETE FROM `asztal` WHERE `asztal_id`='"+a.getAsztal_id()+"'";
                            stmt.execute(sql);
                            loadTreeFromDB();
                        } catch (SQLException sqle) {
                            JOptionPane.showMessageDialog(errorFrame,"Sikertelen törlés!\n"+sqle,"Hiba!",JOptionPane.ERROR_MESSAGE);
                        }
                    }
                }
            }else{
                JOptionPane.showMessageDialog(errorFrame,"A kiválasztott elem nem asztal!","Hiba!",JOptionPane.ERROR_MESSAGE);
            }
        }else{
            JOptionPane.showMessageDialog(errorFrame,"Nincs kiválasztva asztal!","Hiba!",JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_asztalTorolActionPerformed

    private void etteremTorolActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_etteremTorolActionPerformed
        int biztos=JOptionPane.showConfirmDialog(errorFrame,"Az étterem tölésével az össze hozzátartozó asztal és foglalás elveszik!\nBiztosan törölni szeretné ezt az éttermet?","Törlés!",JOptionPane.WARNING_MESSAGE);
                if(biztos==JOptionPane.YES_OPTION){
                    String nevInput="alapertek";
                    while(nevInput!=null&&!nevInput.equals(etterem.getNev())){
                        nevInput=JOptionPane.showInputDialog(errorFrame,"A törléshez írja be az asztal nevét: "+etterem.getNev(),"Törlés!",JOptionPane.WARNING_MESSAGE);
                    }
                    if(nevInput!=null){
                        try {
                            String sql = "SELECT `asztal_id` FROM `asztal` WHERE `etterem_id`='"+etterem.getId()+"'";
                            Statement selectStmt = con.createStatement();
                            Statement deleteStmt = con.createStatement();
                            ResultSet rs = selectStmt.executeQuery(sql);
                            while(rs.next()){
                                sql = "DELETE FROM `foglalas` WHERE `asztal_id`='"+rs.getInt("asztal_id")+"'";
                                deleteStmt.execute(sql);
                            }
                            rs.close();
                            sql="DELETE FROM `asztal` WHERE `etterem_id`='"+etterem.getId()+"'";
                            deleteStmt.execute(sql);
                            sql="DELETE FROM `nyitvatartas` WHERE `etterem_id`='"+etterem.getId()+"'";
                            deleteStmt.execute(sql);
                            sql="DELETE FROM `etterem` WHERE `etterem_id`='"+etterem.getId()+"'";
                            deleteStmt.execute(sql);
                            etteremValtas();
                        } catch (SQLException sqle) {
                            JOptionPane.showMessageDialog(errorFrame,"Sikertelen törlés!\n"+sqle,"Hiba!",JOptionPane.ERROR_MESSAGE);
                        }
                    }
                }
    }//GEN-LAST:event_etteremTorolActionPerformed

    private void foglalasFaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_foglalasFaMouseClicked
        if(evt.getClickCount()==2){
            reszletekMegjelenit();
        }
    }//GEN-LAST:event_foglalasFaMouseClicked

    private void reszletekActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_reszletekActionPerformed
        reszletekMegjelenit();
    }//GEN-LAST:event_reszletekActionPerformed

    private void exportPdfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exportPdfActionPerformed
        MentesDialog md = new MentesDialog(this,true);
        md.setVisible(true);
    }//GEN-LAST:event_exportPdfActionPerformed

    protected void loadTreeFromDB() throws SQLException {
        DefaultMutableTreeNode rootNode = new DefaultMutableTreeNode("root");
        foglalasFaModel = new DefaultTreeModel(rootNode);
        
        String todaysDateTime=dtf.format(LocalDateTime.now());
        String sql = "SELECT * FROM `asztal` WHERE `etterem_id`='"+etterem.getId()+"'";
        Statement etteremStmt = con.createStatement();
        ResultSet etteremRs = etteremStmt.executeQuery(sql);
        Asztal a;
        
        Foglalas f;
        while(etteremRs.next()){
            try {
                a= new Asztal(etteremRs.getInt(3),etterem.getNev(),etteremRs.getInt(1),getTipus(etteremRs.getInt(2)));
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
        foglalasFa.setModel(foglalasFaModel);
        foglalasFa.expandRow(0);
        foglalasFa.setRootVisible(false);
    }
    
    protected Tipus getTipus(int tipusId) throws SQLException{
        String sql="SELECT `tipus_ferohely` FROM `tipus` WHERE `tipus_id`='"+tipusId+"'";
        Statement stmt = con.createStatement();
        if(stmt.execute(sql)){
            ResultSet rs = stmt.executeQuery(sql);
            rs.next();
            int ferohely= rs.getInt("tipus_ferohely");
            rs.close();
            Tipus t = new Tipus(tipusId,ferohely);
            return t;
        }
        return new Tipus(0,0);
    }
    
    private void createShortcuts(){
        KeyStroke keyStrokeHozzaAd= KeyStroke.getKeyStroke(KeyEvent.VK_F, KeyEvent.CTRL_DOWN_MASK);
        hozzaAd.setAccelerator(keyStrokeHozzaAd);
        KeyStroke keyStrokeSzerkesztes= KeyStroke.getKeyStroke(KeyEvent.VK_E, KeyEvent.CTRL_DOWN_MASK);
        edit.setAccelerator(keyStrokeSzerkesztes);
    }
    private void etteremValtas(){
        try {
            EtteremValasztDialog evd = new EtteremValasztDialog(this,true);
            evd.setVisible(true);
            loadTreeFromDB();
            this.kivalasztottEtteremLabel.setText(etterem.getNev());
        } catch (SQLException sqle) {
            JOptionPane.showMessageDialog(errorFrame,"Sikertelen adatbázis kapcsolódás!\n"+sqle.getMessage(),"Hiba!",JOptionPane.ERROR_MESSAGE);
            System.exit(0);
        }
    }
    private void reszletekMegjelenit(){
        DefaultMutableTreeNode selectedNode = (DefaultMutableTreeNode) foglalasFa.getLastSelectedPathComponent();
        if (selectedNode.getUserObject() instanceof Foglalas) {
            Foglalas f=(Foglalas) selectedNode.getUserObject();
        
            ReszletekFrame rf = new ReszletekFrame(this,f);
            rf.setVisible(true);
        }
    }
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try
        {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            System.out.println(e.getMessage());
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
    private javax.swing.JMenu asztalMenu;
    private javax.swing.JMenuItem asztalTorol;
    private javax.swing.JMenuItem edit;
    private javax.swing.JMenu etteremMenu;
    private javax.swing.JMenuItem etteremTorol;
    private javax.swing.JMenuItem etteremValt;
    private javax.swing.JMenuItem exportPdf;
    private javax.swing.JMenu fajlMenu;
    private javax.swing.JTree foglalasFa;
    private javax.swing.JMenu foglalasMenu;
    private javax.swing.JMenuItem hozzaAd;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JMenuItem kilepes;
    private javax.swing.JLabel kivalasztottEtteremLabel;
    private javax.swing.JMenuBar menuSor;
    private javax.swing.JMenuItem reszletek;
    private javax.swing.JMenuItem torol;
    private javax.swing.JMenuItem ujAsztal;
    // End of variables declaration//GEN-END:variables
}
