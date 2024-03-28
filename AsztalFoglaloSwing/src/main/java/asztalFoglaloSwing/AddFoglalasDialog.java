package asztalFoglaloSwing;

import java.awt.Color;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.tree.DefaultMutableTreeNode;

public class AddFoglalasDialog extends javax.swing.JDialog {
    private DefaultComboBoxModel<Asztal> asztalokDCBM;
    private JFrame errorFrame= new JFrame();
    private Foglalas eredeti;
    private boolean update;
    private DefaultMutableTreeNode updatableNode;

    AsztalFoglaloMainFrame parent;
    public AddFoglalasDialog(AsztalFoglaloMainFrame parent, boolean modal) {
        super(parent, modal);
        this.parent=parent;
        update=false;
        asztalokDCBM = new DefaultComboBoxModel<Asztal>();
        initComponents();
        try{
            loadAsztalokModel();
        }catch (SQLException sqle) {
            JOptionPane.showMessageDialog(errorFrame,"Sikertelen adatbázis művelet!\n"+sqle.getMessage(),"Hiba!",JOptionPane.ERROR_MESSAGE);
            System.exit(0);
        }
        setLocationRelativeTo(null);
    }
    public AddFoglalasDialog(AsztalFoglaloMainFrame parent, boolean modal, DefaultMutableTreeNode treeNode) {
        this(parent,modal);
        update=true;
        updatableNode=treeNode;
        eredeti=(Foglalas) treeNode.getUserObject();
        parent.foglalasokLista.remove(eredeti);
        foglaloNev.setText(eredeti.getFoglalas_nev());
        tSzam.setText(eredeti.getFoglalas_telszam());
        emberSzam.setText(""+eredeti.getFoglalas_csoport_meret());
        datum.setText(eredeti.getIdopontKezdString(false).substring(0,10));
        idopontKezd.setText(eredeti.getIdopontKezdString(false).substring(11));
        idopontVeg.setText(eredeti.getIdopontVegString(false).substring(11));
        asztalokComboBox.setSelectedItem(eredeti.getAsztal());
        this.setTitle("Foglalás szerkesztése");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        asztalIdLabel = new javax.swing.JLabel();
        datumLabel = new javax.swing.JLabel();
        idopontLabel = new javax.swing.JLabel();
        datum = new javax.swing.JTextField();
        idopontKezd = new javax.swing.JTextField();
        kotojelLabel = new javax.swing.JLabel();
        idopontVeg = new javax.swing.JTextField();
        submitButton = new javax.swing.JButton();
        foglaloNev = new javax.swing.JTextField();
        tSzam = new javax.swing.JTextField();
        emberSzam = new javax.swing.JTextField();
        foglaloNevLabel = new javax.swing.JLabel();
        tSzamLabel = new javax.swing.JLabel();
        asztalokComboBox = new javax.swing.JComboBox<Asztal>();
        emberSzamLabel = new javax.swing.JLabel();
        feedBackLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Foglalas felvétele");

        asztalIdLabel.setText("Asztal ID:");

        datumLabel.setText("Dátum (yyyy-MM-dd):");

        idopontLabel.setText("Időpont (HH:mm):");

        idopontKezd.setToolTipText("");

        kotojelLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        kotojelLabel.setText("-");

        submitButton.setText("Ok");
        submitButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                submitButtonActionPerformed(evt);
            }
        });

        foglaloNevLabel.setText("Foglaló neve:");

        tSzamLabel.setText("Telefonszám:");

        asztalokComboBox.setModel(asztalokDCBM);

        emberSzamLabel.setText("Csoport mérete:");

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
                            .addComponent(tSzam)
                            .addComponent(foglaloNev)
                            .addComponent(emberSzam)
                            .addComponent(datum)
                            .addComponent(asztalokComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
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
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void submitButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_submitButtonActionPerformed

        if(!isUres()){
            Foglalas f;

            try {
                validateIdopont(new String[]{idopontKezd.getText(),idopontVeg.getText()});
                Asztal a = (Asztal) asztalokComboBox.getSelectedItem();

                f = new Foglalas(0,foglaloNev.getText(),tSzam.getText(),Integer.parseInt(emberSzam.getText()),a,new String(datum.getText()+" "+idopontKezd.getText()+":00"),new String(datum.getText()+" "+idopontVeg.getText()+":00"));
                if (!update){
                    if(addFoglalas(f)){
                        feedBackLabel.setText("Sikeres hozzáadás!");
                        feedBackLabel.setForeground(Color.green);
                    }else{
                        feedBackLabel.setText("A hozzáadás sikertelen!");
                        feedBackLabel.setForeground(Color.red);
                    }
                }else{
                    f.setFoglalas_id(eredeti.getFoglalas_id());
                    if(updateFoglalas(f)){
                    feedBackLabel.setText("Sikeres szerkesztés!");
                    feedBackLabel.setForeground(Color.green);
                    }else{
                        feedBackLabel.setText("A szerkesztés sikertelen!");
                        feedBackLabel.setForeground(Color.red);
                    }
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
    public boolean addFoglalas(Foglalas f) throws SQLException, ClassNotFoundException{
        if (lefoglalhato(f)) {
            
            String sql="INSERT INTO "+
                    "`foglalas` (`foglalas_id`, `foglalas_nev`, `foglalas_telszam`, `foglalas_csoport_meret`, `asztal_id`, `foglalas_idopont_kezd`, `foglalas_idopont_veg`) "+
                    "VALUES "+
                    "(NULL, '"+f.getFoglalas_nev()+"', '"+f.getFoglalas_telszam()+"', '"+f.getFoglalas_csoport_meret()+"', '"+f.getAsztal().getAsztal_id()+"', '"+f.getIdopontKezdString(true)+"', '"+f.getIdopontVegString(true)+"');";
            Statement stmt = AsztalFoglaloMainFrame.con.createStatement();
            stmt.execute(sql);
            boolean success=stmt.getUpdateCount()==1;
            System.out.println(success);
            if(success){
                parent.loadListFromDB();
                parent.loadTreeFromDB();
            }
            return success;
        }
        return false;
    }
    public boolean updateFoglalas(Foglalas f) throws SQLException, ClassNotFoundException{
        if (lefoglalhato(f)) {
            
            String sql="UPDATE `foglalas` SET `foglalas_nev`='"+f.getFoglalas_nev()+"',`foglalas_telszam`='"+f.getFoglalas_telszam()+"',`foglalas_csoport_meret`='"+f.getFoglalas_csoport_meret()+"',`asztal_id`='"+f.getAsztal().getAsztal_id()+"',`foglalas_idopont_kezd`='"+f.getIdopontKezdString(true)+"',`foglalas_idopont_veg`='"+f.getIdopontVegString(true)+"' WHERE `foglalas_id`='"+eredeti.getFoglalas_id()+"'";
            Statement stmt =AsztalFoglaloMainFrame.con.createStatement();
            stmt.execute(sql);
            boolean success=stmt.getUpdateCount()==1;
            if(success){
                parent.loadListFromDB();
                parent.loadTreeFromDB();
            }
            return success;
        }
        return false;
    }
    public boolean lefoglalhato(Foglalas ujFoglalas) throws SQLException
    {
        String sql ="SELECT `foglalas_id`,`asztal_id` FROM `foglalas` WHERE (((`foglalas_idopont_veg`>'"+ujFoglalas.getIdopontKezdString(true)+"' AND `foglalas_idopont_kezd`<'"+ujFoglalas.getIdopontVegString(true)+"') OR (`foglalas_idopont_kezd`='"+ujFoglalas.getIdopontKezdString(true)+"')) OR (`foglalas_idopont_kezd`<'"+ujFoglalas.getIdopontVegString(true)+"' AND `foglalas_idopont_kezd`>'"+ujFoglalas.getIdopontKezdString(true)+"')) AND `asztal_id`='"+ujFoglalas.getAsztal().getAsztal_id()+"' AND `foglalas`.`foglalas_id`!='"+ujFoglalas.getFoglalas_id()+"';";
        Statement stmt =AsztalFoglaloMainFrame.con.createStatement();
        ResultSet rs = stmt.executeQuery(sql);
        boolean foglalhato=!rs.next();
        rs.close();
        return foglalhato;
            
        
        /*for (int i = 0; i < parent.foglalasokLista.size(); i++) {
            Foglalas f = parent.foglalasokLista.get(i);
            if(f.getAsztal().getAsztal_id()==ujFoglalas.getAsztal().getAsztal_id()){
                LocalDateTime 
                            marFoglaltIdoKezd = parent.foglalasokLista.get(i).getFoglalas_idopont_kezd(),
                            marFoglaltIdoVeg = parent.foglalasokLista.get(i).getFoglalas_idopont_veg();
                
                if((ujFoglalas.getFoglalas_idopont_kezd().isBefore(marFoglaltIdoVeg)&&ujFoglalas.getFoglalas_idopont_kezd().isAfter(marFoglaltIdoKezd))||ujFoglalas.getFoglalas_idopont_kezd().equals(marFoglaltIdoKezd)){
                    return false;
                    
                }
            }
        }
        for (int i = parent.foglalasokLista.size()-1; i > 0; i--) {
            Foglalas f = parent.foglalasokLista.get(i);
            if(f.getAsztal().getAsztal_id()==ujFoglalas.getAsztal().getAsztal_id()){
                LocalDateTime 
                            marFoglaltIdoKezd = parent.foglalasokLista.get(i).getFoglalas_idopont_kezd(),
                            marFoglaltIdoVeg = parent.foglalasokLista.get(i).getFoglalas_idopont_veg();
                
                if(ujFoglalas.getFoglalas_idopont_veg().isAfter(marFoglaltIdoKezd)&&ujFoglalas.getFoglalas_idopont_kezd().isBefore(marFoglaltIdoKezd)){
                    return false;
                }
            }
        }*/
    }
    
    private void loadAsztalokModel() throws SQLException{
        String sql="SELECT `asztal`.`etterem_id`,`asztal`.`asztal_id`,`tipus_id`,`asztal_szam` FROM `asztal` "
                + "INNER JOIN `etterem` ON `etterem`.`etterem_id`=`asztal`.`etterem_id` "
                + "WHERE `asztal`.`etterem_id`='"+parent.getEtterem().getId()+"'";
        Statement stmt = AsztalFoglaloMainFrame.con.createStatement();
        ResultSet rs = stmt.executeQuery(sql);
        Asztal a;
        while(rs.next()){
            a= new Asztal(rs.getInt(4),parent.getEtterem().getNev(),rs.getInt(2),parent.getTipus(rs.getInt(4)));
            asztalokDCBM.addElement(a);
        }
    }
    
    
    
    private void validateIdopont(String[] idopont) throws InvalidTimeException{
        LocalDate ld = LocalDate.parse(datum.getText());
        int nap = ld.getDayOfWeek().getValue();
        LocalTime[][] nyitvatartas=parent.getEtterem().getNyitvatartas();
        for (int i = 0; i < 2; i++) {
            
            String[] idopontSplit= idopont[i].split(":");
            LocalTime idopontTimeInstance = LocalTime.of(Integer.parseInt(idopontSplit[0]),Integer.parseInt(idopontSplit[1]));
            if (Integer.parseInt(idopontSplit[0])>23||Integer.parseInt(idopontSplit[0])<0||Integer.parseInt(idopontSplit[1])>59||Integer.parseInt(idopontSplit[1])<0){
                throw new InvalidTimeException("Inavlid időpont");
            }else if(nyitvatartas[nap-1][0].isAfter(idopontTimeInstance)||nyitvatartas[nap-1][1].isBefore(idopontTimeInstance)){
                throw new InvalidTimeException("Nyitvatartáson kívüli időpont");
            }
        }
        String[] idopontKezdSplit= idopont[0].split(":");
        String[] idopontVegSplit= idopont[0].split(":");

        LocalTime idopontKezdTimeInstance = LocalTime.of(Integer.parseInt(idopontKezdSplit[0]),Integer.parseInt(idopontKezdSplit[1])),
                idopontVegTimeInstance = LocalTime.of(Integer.parseInt(idopontVegSplit[0]),Integer.parseInt(idopontVegSplit[1]));
        
        if (idopontKezdTimeInstance.isAfter(idopontVegTimeInstance)) {
            throw new InvalidTimeException("Az időpont vége nem lehet az időpont kezdete előtt");
        }
    }
    
    private boolean isUres(){
        if(this.foglaloNev.getText().trim().isEmpty()||this.tSzam.getText().trim().isEmpty()||this.asztalokComboBox.getSelectedIndex()==-1||this.emberSzam.getText().trim().isEmpty()||this.datum.getText().trim().isEmpty()||this.idopontKezd.getText().trim().isEmpty()||this.idopontVeg.getText().trim().isEmpty()){
            return true;
        }
        return false;
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
    private javax.swing.JLabel kotojelLabel;
    private javax.swing.JButton submitButton;
    private javax.swing.JTextField tSzam;
    private javax.swing.JLabel tSzamLabel;
    // End of variables declaration//GEN-END:variables
}
