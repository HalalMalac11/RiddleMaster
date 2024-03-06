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
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.StringTokenizer;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class AsztalFoglaloMainFrame extends javax.swing.JFrame {
    //private final String dbURL="jdbc:mysql://nebet.hu/c31kissM_db",dbUser="c31kissM",dbPass="ogqgtWAALB8!b";
    private final String dbURL="jdbc:mysql://localhost:3306/foglalas",dbUser="foglalas_kezelo",dbPass="4N6jqhr7dnwCACRI";
    private DefaultListModel<Foglalas> foglalasokLista;
    private DefaultComboBoxModel<Asztal> asztalokDCBM;
    private JFrame errorFrame= new JFrame();
    private Etterem etterem;
    public Connection con;
    
    public AsztalFoglaloMainFrame() {
        foglalasokLista= new DefaultListModel<Foglalas>();
        asztalokDCBM = new DefaultComboBoxModel<Asztal>();
        try {
            con = DriverManager.getConnection(dbURL,dbUser,dbPass);
            EtteremValasztDialog evd = new EtteremValasztDialog(this,true);
            evd.setVisible(true);
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

    public Etterem getEtterem() {
        return etterem;
    }

    public void setEtterem(Etterem etterem) {
        this.etterem = etterem;
    }
    

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
        kotojelLabel = new javax.swing.JLabel();
        idopontVeg = new javax.swing.JTextField();
        asztalokComboBox = new javax.swing.JComboBox<Asztal>();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();

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
        jList3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jList3MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jList3);

        kotojelLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        kotojelLabel.setText("-");

        asztalokComboBox.setModel(asztalokDCBM);

        jMenu1.setText("File");
        jMenuBar1.add(jMenu1);

        jMenu2.setText("Edit");

        jMenuItem1.setText("jMenuItem1");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem1);

        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

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
                                .addComponent(kotojelLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
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
                            .addComponent(kotojelLabel)
                            .addComponent(idopontVeg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(submitButton)
                            .addComponent(feedBackLabel))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jScrollPane1))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void submitButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_submitButtonActionPerformed
               
        if(!isUres()){
            Foglalas f;
            LocalDate ld = LocalDate.parse(datum.getText());
            int nap = ld.getDayOfWeek().getValue();
            try {
                String[] idopontSplit= idopontKezd.getText().split(":");
                if (Integer.parseInt(idopontSplit[0])>23||Integer.parseInt(idopontSplit[0])<0||Integer.parseInt(idopontSplit[1])>59||Integer.parseInt(idopontSplit[1])<0){
                    throw new InvalidTimeException("Inavlid időpont");
                }
                idopontSplit= idopontVeg.getText().split(":");
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
            }catch (OldDateException | InvalidTimeException | IllegalArgumentException ex){
                JOptionPane.showMessageDialog(errorFrame,ex.getMessage(),"Hiba!",JOptionPane.ERROR_MESSAGE);
                feedBackLabel.setText("A hozzáadás sikertelen!");
                feedBackLabel.setForeground(Color.red);
            } catch (SQLException sqle) {
                JOptionPane.showMessageDialog(errorFrame,sqle.getMessage(),"Hiba!",JOptionPane.ERROR_MESSAGE);
                System.exit(0);
            } catch (ClassNotFoundException cnfe) {
                JOptionPane.showMessageDialog(errorFrame,"Sikertelen driver betöltés!\n"+cnfe.getMessage(),"Hiba!",JOptionPane.ERROR_MESSAGE);
                System.exit(0);
            }
        }else{
            JOptionPane.showMessageDialog(errorFrame,"Kérem töltse ki az összes mezőt!","Hiba!",JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_submitButtonActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jList3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jList3MouseClicked
        if(evt.getClickCount()==2){
            ReszletekFrame rf = new ReszletekFrame(jList3.getSelectedValue());
            rf.setEtteremNev(etterem.getNev());
            rf.setVisible(true);
        }
    }//GEN-LAST:event_jList3MouseClicked

    private void loadListFromDB() throws SQLException, ClassNotFoundException{
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
        String sql="SELECT `etterem_id`,`asztalok`.`id`,`tipus`,`szam` FROM `asztalok` "
                + "INNER JOIN `ettermek` ON `ettermek`.`id`=`etterem_id` "
                + "WHERE `etterem_id`='"+etterem.getId()+"'";
        Statement stmt= con.createStatement();
        if(stmt.execute(sql)){
            ResultSet rs = stmt.getResultSet();
            Asztal a;
            while(rs.next()){
                a= new Asztal(rs.getInt(4),etterem.getNev(),rs.getInt(2),getAsztalKapacitas(rs.getInt(4)));
                asztalokDCBM.addElement(a);
            }
        }
    }
    
    private int getAsztalKapacitas(int tipusId) throws SQLException{
        String sql="SELECT `ferohely` FROM `asztal_tipusok` WHERE `id`='"+tipusId+"'";
        Statement stmt= con.createStatement();
        if(stmt.execute(sql)){
            ResultSet rs = stmt.getResultSet();
            rs.next();
            return rs.getInt(1);
        }
        return 0;
    }
    
    private boolean isUres(){
        if(this.foglaloNev.getText().trim().isEmpty()||this.tSzam.getText().trim().isEmpty()||this.asztalokComboBox.getSelectedIndex()==-1||this.emberSzam.getText().trim().isEmpty()||this.datum.getText().trim().isEmpty()||this.idopontKezd.getText().trim().isEmpty()||this.idopontVeg.getText().trim().isEmpty()){
            return true;
        }
        return false;
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
    private javax.swing.JList<Foglalas> jList3;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel kotojelLabel;
    private javax.swing.JButton submitButton;
    private javax.swing.JTextField tSzam;
    private javax.swing.JLabel tSzamLabel;
    // End of variables declaration//GEN-END:variables
}
