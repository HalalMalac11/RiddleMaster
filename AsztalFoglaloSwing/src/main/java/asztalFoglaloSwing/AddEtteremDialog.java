package asztalFoglaloSwing;


import java.awt.Frame;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalTime;
import java.util.StringTokenizer;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class AddEtteremDialog extends javax.swing.JDialog implements iDateFormatting {
    
    private boolean alreadyFilled;
    private AsztalFoglaloMainFrame mainFrame;
    private EtteremValasztDialog parent;
    private JTextField[][] nyitvatartasMezok;
    private boolean update;
    private Etterem updateEtterem;

    public AddEtteremDialog(EtteremValasztDialog parent, boolean modal, AsztalFoglaloMainFrame mainFrame) {
        super(parent, modal);
        this.mainFrame=mainFrame;
        this.alreadyFilled=false;
        this.parent=parent;
        initComponents();
        setLocationRelativeTo(null);
        fillNyitvatartasMezok();
    }

    public AddEtteremDialog(AsztalFoglaloMainFrame mainFrame, boolean modal,Etterem updateEtterem) {
        super(mainFrame, modal);
        this.mainFrame = mainFrame;
        this.updateEtterem = updateEtterem;
         initComponents();
        setLocationRelativeTo(null);
        fillNyitvatartasMezok();
        feltoltesFrissiteshez();
    }
    
    

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        etteremNev = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        hNyitas = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        hZaras = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        kNyitas = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        kZaras = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        szeNyitas = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        szeZaras = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        csNyitas = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        csZaras = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        pNyitas = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        pZaras = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        szoNyitas = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        szoZaras = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        vNyitas = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        vZaras = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        submit = new javax.swing.JButton();
        fill = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Étterem hozzáadása");

        jLabel1.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        jLabel1.setText("Étterem hozzáadása");

        jLabel2.setText("Név:");

        jLabel3.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        jLabel3.setText("Nyitvatartás");

        jLabel4.setText("Hetfő:");

        hNyitas.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                hNyitasFocusLost(evt);
            }
        });

        jLabel5.setText("-");

        hZaras.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                hZarasFocusLost(evt);
            }
        });

        jLabel6.setText("Kedd:");

        jLabel7.setText("-");

        jLabel8.setText("Szerda:");

        jLabel9.setText("-");

        jLabel10.setText("Csütörtök:");

        jLabel11.setText("-");

        jLabel12.setText("Péntek:");

        jLabel13.setText("-");

        jLabel14.setText("Szombat:");

        jLabel15.setText("-");

        jLabel16.setText("Vasárnap:");

        jLabel17.setText("-");

        jLabel18.setText("(HH:mm)");

        submit.setText("Hozzáadás");
        submit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                submitActionPerformed(evt);
            }
        });

        fill.setText("Összesre");
        fill.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fillActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jLabel1)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jLabel2)
                            .addGap(18, 18, 18)
                            .addComponent(etteremNev)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel18))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(jLabel6)
                            .addComponent(jLabel8)
                            .addComponent(jLabel10)
                            .addComponent(jLabel12)
                            .addComponent(jLabel14)
                            .addComponent(jLabel16))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(hNyitas, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(hZaras, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(fill))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(kNyitas, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel7)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(kZaras, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(szeNyitas, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel9)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(szeZaras, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(csNyitas, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel11)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(csZaras, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(pNyitas, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel13)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(pZaras, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(szoNyitas, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel15)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(szoZaras, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(vNyitas, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel17)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(vZaras, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addComponent(submit))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(etteremNev, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel18))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(hNyitas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(hZaras, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(fill))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(kNyitas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7)
                    .addComponent(kZaras, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(szeNyitas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9)
                    .addComponent(szeZaras, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(csNyitas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11)
                    .addComponent(csZaras, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(pNyitas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel13)
                    .addComponent(pZaras, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14)
                    .addComponent(szoNyitas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel15)
                    .addComponent(szoZaras, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel16)
                    .addComponent(vNyitas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel17)
                    .addComponent(vZaras, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 13, Short.MAX_VALUE)
                .addComponent(submit)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void hZarasFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_hZarasFocusLost
        fillNyitvatartas();
    }//GEN-LAST:event_hZarasFocusLost

    private void hNyitasFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_hNyitasFocusLost
        fillNyitvatartas();
    }//GEN-LAST:event_hNyitasFocusLost

    private void fillActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fillActionPerformed
        this.alreadyFilled=false;
        fillNyitvatartas();
    }//GEN-LAST:event_fillActionPerformed

    private void submitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_submitActionPerformed
        boolean allFilled= true;
        if(!this.etteremNev.getText().isEmpty()){
            for (int i = 0; i < nyitvatartasMezok.length; i++) {
                for (int j = 0; j < nyitvatartasMezok[i].length; j++) {
                    if(nyitvatartasMezok[i][j].getText().isEmpty()){
                    allFilled=false;
                    }
                }
            }
            if (allFilled) {
                try {
                    String sql="";
                        if(!update){
                            sql="INSERT INTO `etterem`(`etterem_nev`) VALUES ('"+this.etteremNev.getText()+"')";
                        }else{
                            sql="UPDATE `etterem` SET `etterem_nev`='"+this.etteremNev.getText()+"' WHERE `etterem_id`='"+updateEtterem.getId()+"'";
                        }
                        AsztalFoglaloMainFrame.getStmt().execute(sql);
                        int ujEtteremId=0;
                        if(!update){
                            sql ="SELECT `etterem_id` FROM `etterem` WHERE `etterem_nev` LIKE '"+this.etteremNev.getText()+"'";
                            ResultSet ujEtterem = AsztalFoglaloMainFrame.getStmt().executeQuery(sql);;
                            ujEtterem.next();
                            ujEtteremId=ujEtterem.getInt(1);
                        }else{
                            ujEtteremId=updateEtterem.getId();
                        }
                        String[][] nyitvatartas= new String[7][2];
                        for (int i = 0; i < nyitvatartasMezok.length; i++) {
                            StringTokenizer st = new StringTokenizer(nyitvatartasMezok[i][0].getText(),":");
                            nyitvatartas[i][0]=LocalTime.of(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken())).format(ONLYTIME);
                            st = new StringTokenizer(nyitvatartasMezok[i][1].getText(),":");
                            nyitvatartas[i][1]=LocalTime.of(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken())).format(ONLYTIME);
                            if(!update){
                                sql ="INSERT INTO `nyitvatartas`(`etterem_id`, `nyitvatartas_nap`, `nyitvatartas_nyitas`, `nyitvatartas_zaras`) VALUES ('"+ujEtteremId+"','"+(i+1)+"','"+nyitvatartasMezok[i][0].getText()+":00"+"','"+nyitvatartasMezok[i][1].getText()+":00"+"')";
                            }else{
                                sql="UPDATE `nyitvatartas` SET `nyitvatartas_nyitas`='"+nyitvatartasMezok[i][0].getText()+":00', `nyitvatartas_zaras`='"+nyitvatartasMezok[i][1].getText()+":00' WHERE `etterem_id`='"+updateEtterem.getId()+"' AND `nyitvatartas_nap`='"+(i+1)+"'";
                            }
                            AsztalFoglaloMainFrame.getStmt().execute(sql);
                        }
                        mainFrame.setEtterem(new Etterem(this.etteremNev.getText(),ujEtteremId,nyitvatartas));
                        parent.etteremAdded=true;
                        this.dispose();
                    
                        
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(new JFrame(),"Létezik már ilyen nevű étterem!","Hiba!",JOptionPane.ERROR_MESSAGE);
                }
            }else{
                JOptionPane.showMessageDialog(new JFrame(),"Töltse ki az összes mezőt!","Hiba!",JOptionPane.ERROR_MESSAGE);
            }
        }else{
            JOptionPane.showMessageDialog(new JFrame(),"Töltse ki az összes mezőt!","Hiba!",JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_submitActionPerformed

    private void fillNyitvatartas(){
        if(!alreadyFilled){
            if(!hNyitas.getText().trim().isEmpty()&&!hZaras.getText().trim().isEmpty()){
                int valasz = JOptionPane.showConfirmDialog(new JFrame(),"Szeretné kitölteni a többi napot is a hétfői nyitvtartással?","Üzenet",JOptionPane.YES_NO_OPTION);
                if(valasz==JOptionPane.YES_OPTION){
                    for (int i = 0; i < nyitvatartasMezok.length; i++) {
                        for (int j = 0; j < nyitvatartasMezok[i].length; j++) {
                            nyitvatartasMezok[i][j].setText(nyitvatartasMezok[0][j].getText());
                        }
                    }
                    this.alreadyFilled=true;
                }
            }
        }
    }
    
    private void fillNyitvatartasMezok(){
        this.nyitvatartasMezok=new JTextField[][]{
            {this.hNyitas,this.hZaras},
            {this.kNyitas,this.kZaras},
            {this.szeNyitas,this.szeZaras},
            {this.csNyitas,this.csZaras},
            {this.pNyitas,this.pZaras},
            {this.szoNyitas,this.szoZaras},
            {this.vNyitas,this.vZaras}
        };
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField csNyitas;
    private javax.swing.JTextField csZaras;
    private javax.swing.JTextField etteremNev;
    private javax.swing.JButton fill;
    private javax.swing.JTextField hNyitas;
    private javax.swing.JTextField hZaras;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JTextField kNyitas;
    private javax.swing.JTextField kZaras;
    private javax.swing.JTextField pNyitas;
    private javax.swing.JTextField pZaras;
    private javax.swing.JButton submit;
    private javax.swing.JTextField szeNyitas;
    private javax.swing.JTextField szeZaras;
    private javax.swing.JTextField szoNyitas;
    private javax.swing.JTextField szoZaras;
    private javax.swing.JTextField vNyitas;
    private javax.swing.JTextField vZaras;
    // End of variables declaration//GEN-END:variables

    private void feltoltesFrissiteshez() {
        etteremNev.setText(updateEtterem.getNev());
        String nyitvatartas[][]=updateEtterem.getNyitvatartas();
        
        for (int i = 0; i < nyitvatartasMezok.length; i++) {
            nyitvatartasMezok[i][0].setText(nyitvatartas[i][0]);
            nyitvatartasMezok[i][1].setText(nyitvatartas[i][1]);
        }
    }
}
