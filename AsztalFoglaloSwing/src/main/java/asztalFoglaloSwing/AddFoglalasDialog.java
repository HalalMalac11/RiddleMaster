package asztalFoglaloSwing;

import java.awt.Color;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeParseException;
import java.util.regex.Pattern;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.tree.DefaultMutableTreeNode;

public class AddFoglalasDialog extends javax.swing.JDialog implements iDateFormatting {
    private DefaultComboBoxModel<Asztal> asztalokDCBM;
    private JFrame errorFrame= new JFrame();
    private Foglalas eredeti;
    private boolean update, asztalBetoltve;
    private AsztalFoglaloMainFrame mainFrame;
    
    public AddFoglalasDialog(AsztalFoglaloMainFrame parent, boolean modal) {
        super(parent, modal);
        this.mainFrame=parent;
        update=false;
        asztalokDCBM = new DefaultComboBoxModel<Asztal>();
        initComponents();
        try{
            asztalBetoltve=false;
            loadAsztalokModel();
            asztalBetoltve=true;
        }catch (SQLException sqle) {
            JOptionPane.showMessageDialog(errorFrame,"Sikertelen adatbázis művelet!\n"+sqle.getMessage(),"Hiba!",JOptionPane.ERROR_MESSAGE);
            this.dispose();
        }
        setLocationRelativeTo(null);
        ferohelySegitsegValtas();
    }
    public AddFoglalasDialog(AsztalFoglaloMainFrame parent, boolean modal, Foglalas f) {
        this(parent,modal);
        update=true;
        eredeti=f;
        foglaloNev.setText(eredeti.getFoglalas_nev());
        tSzam.setText(eredeti.getFoglalas_telszam());
        emberSzam.setText(""+eredeti.getFoglalas_csoport_meret());
        datum.setText(eredeti.getIdopontKezdString(false).substring(0,10));
        idopontKezd.setText(eredeti.getIdopontKezdString(false).substring(11));
        idopontVeg.setText(eredeti.getIdopontVegString(false).substring(11));
        for (int i = 1; i < asztalokComboBox.getItemCount(); i++) {
            if (asztalokComboBox.getItemAt(i).getAsztal_id()==eredeti.getAsztal().getAsztal_id()) {
                asztalokComboBox.setSelectedIndex(i);
                break;
            }
        }
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
        asztalokComboBox = new javax.swing.JComboBox<>();
        emberSzamLabel = new javax.swing.JLabel();
        feedBackLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Foglalas felvétele");
        setResizable(false);

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
        asztalokComboBox.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                asztalokComboBoxItemStateChanged(evt);
            }
        });

        emberSzamLabel.setText("Csoport mérete: (max  fő)");

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
                        .addComponent(feedBackLabel)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(foglaloNevLabel)
                            .addComponent(tSzamLabel)
                            .addComponent(datumLabel)
                            .addComponent(idopontLabel)
                            .addComponent(asztalIdLabel)
                            .addComponent(emberSzamLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
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
                            .addComponent(asztalokComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(22, 22, 22))))
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
        int hibakod=0;

        hibakod=uresCheck();
        if(hibakod==0){
            Foglalas f;

            try {
                Asztal a = (Asztal) asztalokComboBox.getSelectedItem();
                String ujIdopontKezd = datum.getText()+" "+idopontKezd.getText()+":00";
                LocalDateTime foglalas_idopont_kezd = LocalDateTime.parse(ujIdopontKezd,FULLDATETIME);
                if (foglalas_idopont_kezd.isBefore(LocalDateTime.now())){
                    throw new OldDateException("5");
                }
                f = new Foglalas(0,foglaloNev.getText(),tSzam.getText(),Integer.parseInt(emberSzam.getText()),a,new String(ujIdopontKezd),datum.getText()+" "+idopontVeg.getText()+":00");
                if(update){
                    f.setFoglalas_id(eredeti.getFoglalas_id());
                }
                if(lefoglalhato(f)){
                    if(!nyitvatartasonKivuli(f)){
                        if (!update){
                            if(addFoglalas(f)){
                                feedBackLabel.setText("Sikeres hozzáadás!");
                                feedBackLabel.setForeground(Color.green);
                            }else{
                                feedBackLabel.setText("A hozzáadás sikertelen!");
                                feedBackLabel.setForeground(Color.red);
                            }
                        }else{

                            if(updateFoglalas(f)){
                            feedBackLabel.setText("Sikeres szerkesztés!");
                            feedBackLabel.setForeground(Color.green);
                            }else{
                                feedBackLabel.setText("A szerkesztés sikertelen!");
                                feedBackLabel.setForeground(Color.red);
                            }
                        }
                    }else{
                        hibakod=18;
                    }
                }else{
                    hibakod=17;
                }
            }catch (OldDateException | InvalidTimeException | IllegalArgumentException | DateTimeParseException ex){
                hibakod=10;
                if(ex instanceof DateTimeParseException){
                    hibakod+=6;
                }else{
                    hibakod+=Integer.parseInt(ex.getMessage());
                }
                feedBackLabel.setText("A hozzáadás sikertelen!");
                feedBackLabel.setForeground(Color.red);
            } catch (SQLException sqle) {
                JOptionPane.showMessageDialog(errorFrame,"Adatbázis hiba!\n"+sqle.getMessage(),"Hiba!",JOptionPane.ERROR_MESSAGE);
                System.exit(0);
            } catch (ClassNotFoundException cnfe) {
                JOptionPane.showMessageDialog(errorFrame,"Sikertelen driver betöltés!\n"+cnfe.getMessage(),"Hiba!",JOptionPane.ERROR_MESSAGE);
                System.exit(0);
            }
        }
        if(hibakod!=0){
            String[] mezok={"","Név","Telefonszám","Asztal","Csoport mérete","Dátum","Időpont"};
            String[] hibaFoTipus={"A * mező nem lehet üres! ","Hiba a(z) * megadásánál!"};
            String[] hibaAlTipus={"","A csoport mérete nem lehet kisebb mint 1!","A csoport mérete nem lehet nagyobb mint az asztal kapacitása!","Nem értelmezhető időpont","Az időpont vége nem lehet az időpont kezdete előtt!","A foglalás nem lehet múltbéli időponton!","Nem várt dátum vagy idő formátum!","A foglalás időpontja nem eshet egybe egy másikéval ugyanannál az asztalnál!","A foglalás időpontja nem lehet a nyitvatartáson kívűl!"};
            String hibaUzenet="";
            if(hibakod<10){
                hibaUzenet=hibaFoTipus[0].replace("*",mezok[hibakod]);
            }else{
                hibaUzenet=hibaFoTipus[1].replace("*",mezok[((hibakod>12)?6:4)])+"\n"+hibaAlTipus[hibakod-10];
            }
            JOptionPane.showMessageDialog(errorFrame,hibaUzenet,"Hiba!",JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_submitButtonActionPerformed

    private void asztalokComboBoxItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_asztalokComboBoxItemStateChanged
        if(asztalBetoltve)
            ferohelySegitsegValtas();
    }//GEN-LAST:event_asztalokComboBoxItemStateChanged
    public boolean addFoglalas(Foglalas f) throws SQLException, ClassNotFoundException{
        String sql="INSERT INTO "+
            "`foglalas` (`foglalas_id`, `foglalas_nev`, `foglalas_telszam`, `foglalas_csoport_meret`, `asztal_id`, `foglalas_idopont_kezd`, `foglalas_idopont_veg`) "+
            "VALUES "+
            "(NULL, '"+f.getFoglalas_nev()+"', '"+f.getFoglalas_telszam()+"', '"+f.getFoglalas_csoport_meret()+"', '"+f.getAsztal().getAsztal_id()+"', '"+f.getIdopontKezdString(true)+"', '"+f.getIdopontVegString(true)+"');";
        Statement stmt = AsztalFoglaloMainFrame.con.createStatement();
        stmt.execute(sql);
        boolean success=stmt.getUpdateCount()==1;
        if(success){
            mainFrame.loadTreeFromDB();
        }
        return success;
    }
    public boolean updateFoglalas(Foglalas f) throws SQLException, ClassNotFoundException{
        String sql="UPDATE `foglalas` SET `foglalas_nev`='"+f.getFoglalas_nev()+"',`foglalas_telszam`='"+f.getFoglalas_telszam()+"',`foglalas_csoport_meret`='"+f.getFoglalas_csoport_meret()+"',`asztal_id`='"+f.getAsztal().getAsztal_id()+"',`foglalas_idopont_kezd`='"+f.getIdopontKezdString(true)+"',`foglalas_idopont_veg`='"+f.getIdopontVegString(true)+"' WHERE `foglalas_id`='"+eredeti.getFoglalas_id()+"'";
        Statement stmt =AsztalFoglaloMainFrame.con.createStatement();
        stmt.execute(sql);
        boolean success=stmt.getUpdateCount()==1;
        if(success){
            mainFrame.loadTreeFromDB();
        }
        return success;
    }
    public boolean lefoglalhato(Foglalas ujFoglalas) throws SQLException
    {
        String sql ="SELECT `foglalas_id`,`asztal_id` FROM `foglalas` WHERE (((`foglalas_idopont_veg`>'"+ujFoglalas.getIdopontKezdString(true)+"' AND `foglalas_idopont_kezd`<'"+ujFoglalas.getIdopontVegString(true)+"') OR (`foglalas_idopont_kezd`='"+ujFoglalas.getIdopontKezdString(true)+"')) OR (`foglalas_idopont_kezd`<'"+ujFoglalas.getIdopontVegString(true)+"' AND `foglalas_idopont_kezd`>'"+ujFoglalas.getIdopontKezdString(true)+"')) AND `asztal_id`='"+ujFoglalas.getAsztal().getAsztal_id()+"' AND `foglalas`.`foglalas_id`!='"+ujFoglalas.getFoglalas_id()+"';";
        System.out.println(sql);
        Statement stmt =AsztalFoglaloMainFrame.con.createStatement();
        ResultSet rs = stmt.executeQuery(sql);
        boolean foglalhato=!rs.next();
        rs.close();
        return foglalhato;
    }
    
    private boolean nyitvatartasonKivuli(Foglalas ujFoglalas){
        LocalTime[][] nyitvatartas=mainFrame.getEtterem().getNyitvatartas();
        int nap = ujFoglalas.getFoglalas_idopont_kezd().getDayOfWeek().getValue();
        LocalTime idopontKezdTime=ujFoglalas.getFoglalas_idopont_kezd().toLocalTime(),idopontVegTime=ujFoglalas.getFoglalas_idopont_veg().toLocalTime();
        return (idopontKezdTime.isBefore(nyitvatartas[nap][0])||idopontVegTime.isBefore(nyitvatartas[nap][1]));
    }
    
    private void loadAsztalokModel() throws SQLException{
        String sql="SELECT * FROM `asztal` WHERE `etterem_id`='"+mainFrame.getEtterem().getId()+"'";
        Statement stmt = AsztalFoglaloMainFrame.con.createStatement();
        ResultSet rs = stmt.executeQuery(sql);
        Asztal a=new Asztal("Válasszon asztalt");
        asztalokDCBM.addElement(a);
        while(rs.next()){
            a= new Asztal(rs.getInt("asztal_szam"),mainFrame.getEtterem().getNev(),rs.getInt("asztal_id"),mainFrame.getTipus(rs.getInt("tipus_id")));
            asztalokDCBM.addElement(a);
        }
            asztalokComboBox.setSelectedIndex(0);
    }
    
    
    
    private void validateIdopont(String[] idopont) throws InvalidTimeException{
        LocalDate ld = LocalDate.parse(datum.getText());
        int nap = ld.getDayOfWeek().getValue();
        LocalTime[][] nyitvatartas=mainFrame.getEtterem().getNyitvatartas();
        for (int i = 0; i < 2; i++) {
            String[] idopontSplit= idopont[i].split(":");
            LocalTime idopontTimeInstance = LocalTime.of(Integer.parseInt(idopontSplit[0]),Integer.parseInt(idopontSplit[1]));
            if(nyitvatartas[nap-1][0].isAfter(idopontTimeInstance)||nyitvatartas[nap-1][1].isBefore(idopontTimeInstance)){
                throw new InvalidTimeException("0");
            }
        }
        
    }
    
    private int uresCheck(){
        int hibakod=1;
        if(this.foglaloNev.getText().trim().isEmpty()){
            return hibakod;
        }
        hibakod++;
        if(this.tSzam.getText().trim().isEmpty()){
            return hibakod;
        }
        hibakod++;
        if(this.asztalokComboBox.getSelectedIndex()<1){
            return hibakod;
        }
        hibakod++;
        if(this.emberSzam.getText().trim().isEmpty()){
            return hibakod;
        }
        hibakod++;
        if(this.datum.getText().trim().isEmpty()){
            return hibakod;
        }
        hibakod++;
        if(this.idopontKezd.getText().trim().isEmpty()){
            return hibakod;
        }
        if(this.idopontVeg.getText().trim().isEmpty()){
            return hibakod;
        }
        return 0;
    }

    private void ferohelySegitsegValtas(){
        String hintSzam="0";
        if(asztalokComboBox.getSelectedIndex()!=0){
            Asztal a = (Asztal) asztalokComboBox.getSelectedItem();
            hintSzam=""+a.getTipus().getTipus_ferohely();
        }
        emberSzamLabel.setText(emberSzamLabel.getText().replaceAll("(?:\\s{1}\\d*\\s{1})",(" "+hintSzam+" ")));
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
