package asztalFoglaloSwing;

import java.awt.Frame;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalTime;
import java.util.StringTokenizer;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
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
        this.mainFrame = mainFrame;
        this.alreadyFilled = false;
        this.parent = parent;
        initComponents();
        setLocationRelativeTo(null);
        fillNyitvatartasMezok();
    }

    public AddEtteremDialog(AsztalFoglaloMainFrame mainFrame, boolean modal, Etterem updateEtterem) {
        super(mainFrame, modal);
        this.mainFrame = mainFrame;
        this.updateEtterem = updateEtterem;
        initComponents();
        setLocationRelativeTo(null);
        fillNyitvatartasMezok();
        feltoltesFrissiteshez();
        submit.setText("Frissítés");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        cimLabel = new javax.swing.JLabel();
        nevLabel = new javax.swing.JLabel();
        etteremNev = new javax.swing.JTextField();
        nyitvatartasLabel = new javax.swing.JLabel();
        hetfoLabel = new javax.swing.JLabel();
        hNyitas = new javax.swing.JTextField();
        kotojel1 = new javax.swing.JLabel();
        hZaras = new javax.swing.JTextField();
        keddLabel = new javax.swing.JLabel();
        kNyitas = new javax.swing.JTextField();
        kotojel2 = new javax.swing.JLabel();
        kZaras = new javax.swing.JTextField();
        szerdaLabel = new javax.swing.JLabel();
        szeNyitas = new javax.swing.JTextField();
        kotojel3 = new javax.swing.JLabel();
        szeZaras = new javax.swing.JTextField();
        csutortokLabel = new javax.swing.JLabel();
        csNyitas = new javax.swing.JTextField();
        kotojel4 = new javax.swing.JLabel();
        csZaras = new javax.swing.JTextField();
        pentekLabel = new javax.swing.JLabel();
        pNyitas = new javax.swing.JTextField();
        kotojel5 = new javax.swing.JLabel();
        pZaras = new javax.swing.JTextField();
        szombatLabel = new javax.swing.JLabel();
        szoNyitas = new javax.swing.JTextField();
        kotojel6 = new javax.swing.JLabel();
        szoZaras = new javax.swing.JTextField();
        vasarnapLabel = new javax.swing.JLabel();
        vNyitas = new javax.swing.JTextField();
        kotojel7 = new javax.swing.JLabel();
        vZaras = new javax.swing.JTextField();
        formatSegitsegLabel = new javax.swing.JLabel();
        submit = new javax.swing.JButton();
        fill = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Étterem hozzáadása");

        cimLabel.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        cimLabel.setText("Étterem hozzáadása");

        nevLabel.setText("Név:");

        nyitvatartasLabel.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        nyitvatartasLabel.setText("Nyitvatartás");

        hetfoLabel.setText("Hetfő:");

        hNyitas.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                hNyitasFocusLost(evt);
            }
        });

        kotojel1.setText("-");

        hZaras.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                hZarasFocusLost(evt);
            }
        });

        keddLabel.setText("Kedd:");

        kotojel2.setText("-");

        szerdaLabel.setText("Szerda:");

        kotojel3.setText("-");

        csutortokLabel.setText("Csütörtök:");

        kotojel4.setText("-");

        pentekLabel.setText("Péntek:");

        kotojel5.setText("-");

        szombatLabel.setText("Szombat:");

        kotojel6.setText("-");

        vasarnapLabel.setText("Vasárnap:");

        kotojel7.setText("-");

        formatSegitsegLabel.setText("(HH:mm)");

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
                        .addComponent(cimLabel)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(nevLabel)
                            .addGap(18, 18, 18)
                            .addComponent(etteremNev)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(nyitvatartasLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(formatSegitsegLabel))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(hetfoLabel)
                            .addComponent(keddLabel)
                            .addComponent(szerdaLabel)
                            .addComponent(csutortokLabel)
                            .addComponent(pentekLabel)
                            .addComponent(szombatLabel)
                            .addComponent(vasarnapLabel))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(hNyitas, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(kotojel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(hZaras, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(fill))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(kNyitas, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(kotojel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(kZaras, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(szeNyitas, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(kotojel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(szeZaras, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(csNyitas, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(kotojel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(csZaras, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(pNyitas, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(kotojel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(pZaras, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(szoNyitas, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(kotojel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(szoZaras, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(vNyitas, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(kotojel7)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(vZaras, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addComponent(submit))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(cimLabel)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nevLabel)
                    .addComponent(etteremNev, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nyitvatartasLabel)
                    .addComponent(formatSegitsegLabel))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(hetfoLabel)
                    .addComponent(hNyitas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(kotojel1)
                    .addComponent(hZaras, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(fill))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(keddLabel)
                    .addComponent(kNyitas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(kotojel2)
                    .addComponent(kZaras, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(szerdaLabel)
                    .addComponent(szeNyitas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(kotojel3)
                    .addComponent(szeZaras, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(csutortokLabel)
                    .addComponent(csNyitas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(kotojel4)
                    .addComponent(csZaras, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(pentekLabel)
                    .addComponent(pNyitas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(kotojel5)
                    .addComponent(pZaras, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(szombatLabel)
                    .addComponent(szoNyitas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(kotojel6)
                    .addComponent(szoZaras, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(vasarnapLabel)
                    .addComponent(vNyitas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(kotojel7)
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
        this.alreadyFilled = false;
        fillNyitvatartas();
    }//GEN-LAST:event_fillActionPerformed

    private void submitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_submitActionPerformed
        String hibaUzenet=uresCheck();
        
        if (hibaUzenet.isEmpty()) {
            hibaUzenet=formatumCheck();
            if (hibaUzenet.isEmpty()) {
                try {
                    String sql = "";
                    if (!update) {
                        sql = "INSERT INTO `etterem`(`etterem_nev`) VALUES ('" + this.etteremNev.getText().trim() + "')";
                    } else {
                        sql = "UPDATE `etterem` SET `etterem_nev`='" + this.etteremNev.getText().trim() + "' WHERE `etterem_id`='" + updateEtterem.getId() + "'";
                    }
                    AsztalFoglaloMainFrame.getStmt().execute(sql);
                    int ujEtteremId = 0;
                    if (!update) {
                        sql = "SELECT `etterem_id` FROM `etterem` WHERE `etterem_nev` LIKE '" + this.etteremNev.getText().trim() + "'";
                        ResultSet ujEtterem = AsztalFoglaloMainFrame.getStmt().executeQuery(sql);;
                        ujEtterem.next();
                        ujEtteremId = ujEtterem.getInt(1);
                    } else {
                        ujEtteremId = updateEtterem.getId();
                    }
                    String[][] nyitvatartas = new String[7][2];
                    for (int i = 0; i < nyitvatartasMezok.length; i++) {
                        StringTokenizer st = new StringTokenizer(nyitvatartasMezok[i][0].getText(), ":");
                        nyitvatartas[i][0] = LocalTime.of(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())).format(ONLYTIME);
                        st = new StringTokenizer(nyitvatartasMezok[i][1].getText(), ":");
                        nyitvatartas[i][1] = LocalTime.of(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())).format(ONLYTIME);
                        if (!update) {
                            sql = "INSERT INTO `nyitvatartas`(`etterem_id`, `nyitvatartas_nap`, `nyitvatartas_nyitas`, `nyitvatartas_zaras`) VALUES ('" + ujEtteremId + "','" + (i + 1) + "','" + nyitvatartasMezok[i][0].getText().trim() + ":00" + "','" + nyitvatartasMezok[i][1].getText().trim() + ":00" + "')";
                        } else {
                            sql = "UPDATE `nyitvatartas` SET `nyitvatartas_nyitas`='" + nyitvatartasMezok[i][0].getText().trim() + ":00', `nyitvatartas_zaras`='" + nyitvatartasMezok[i][1].getText().trim() + ":00' WHERE `etterem_id`='" + updateEtterem.getId() + "' AND `nyitvatartas_nap`='" + (i + 1) + "'";
                        }
                        AsztalFoglaloMainFrame.getStmt().execute(sql);
                    }
                    mainFrame.setEtterem(new Etterem(this.etteremNev.getText().trim(), ujEtteremId, nyitvatartas));
                    parent.etteremAdded = true;
                    this.dispose();

                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(new JFrame(), "Létezik már ilyen nevű étterem!", "Hiba!", JOptionPane.ERROR_MESSAGE);
                }
            }else{
                JOptionPane.showMessageDialog(new JFrame(),hibaUzenet, "Hiba!", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(new JFrame(),hibaUzenet, "Hiba!", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_submitActionPerformed

    private void fillNyitvatartas() {
        if (!alreadyFilled) {
            if (!hNyitas.getText().trim().isEmpty() && !hZaras.getText().trim().isEmpty()) {
                int valasz = JOptionPane.showConfirmDialog(new JFrame(), "Szeretné kitölteni a többi napot is a hétfői nyitvtartással?", "Üzenet", JOptionPane.YES_NO_OPTION);
                if (valasz == JOptionPane.YES_OPTION) {
                    for (int i = 0; i < nyitvatartasMezok.length; i++) {
                        for (int j = 0; j < nyitvatartasMezok[i].length; j++) {
                            nyitvatartasMezok[i][j].setText(nyitvatartasMezok[0][j].getText());
                        }
                    }
                    this.alreadyFilled = true;
                }
            }
        }
    }

    private void fillNyitvatartasMezok() {
        this.nyitvatartasMezok = new JTextField[][]{
            {this.hNyitas, this.hZaras},
            {this.kNyitas, this.kZaras},
            {this.szeNyitas, this.szeZaras},
            {this.csNyitas, this.csZaras},
            {this.pNyitas, this.pZaras},
            {this.szoNyitas, this.szoZaras},
            {this.vNyitas, this.vZaras}
        };
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel cimLabel;
    private javax.swing.JTextField csNyitas;
    private javax.swing.JTextField csZaras;
    private javax.swing.JLabel csutortokLabel;
    private javax.swing.JTextField etteremNev;
    private javax.swing.JButton fill;
    private javax.swing.JLabel formatSegitsegLabel;
    private javax.swing.JTextField hNyitas;
    private javax.swing.JTextField hZaras;
    private javax.swing.JLabel hetfoLabel;
    private javax.swing.JTextField kNyitas;
    private javax.swing.JTextField kZaras;
    private javax.swing.JLabel keddLabel;
    private javax.swing.JLabel kotojel1;
    private javax.swing.JLabel kotojel2;
    private javax.swing.JLabel kotojel3;
    private javax.swing.JLabel kotojel4;
    private javax.swing.JLabel kotojel5;
    private javax.swing.JLabel kotojel6;
    private javax.swing.JLabel kotojel7;
    private javax.swing.JLabel nevLabel;
    private javax.swing.JLabel nyitvatartasLabel;
    private javax.swing.JTextField pNyitas;
    private javax.swing.JTextField pZaras;
    private javax.swing.JLabel pentekLabel;
    private javax.swing.JButton submit;
    private javax.swing.JTextField szeNyitas;
    private javax.swing.JTextField szeZaras;
    private javax.swing.JLabel szerdaLabel;
    private javax.swing.JTextField szoNyitas;
    private javax.swing.JTextField szoZaras;
    private javax.swing.JLabel szombatLabel;
    private javax.swing.JTextField vNyitas;
    private javax.swing.JTextField vZaras;
    private javax.swing.JLabel vasarnapLabel;
    // End of variables declaration//GEN-END:variables

    private void feltoltesFrissiteshez() {
        etteremNev.setText(updateEtterem.getNev());
        String nyitvatartas[][] = updateEtterem.getNyitvatartas();

        for (int i = 0; i < nyitvatartasMezok.length; i++) {
            nyitvatartasMezok[i][0].setText(nyitvatartas[i][0]);
            nyitvatartasMezok[i][1].setText(nyitvatartas[i][1]);
        }
    }
    private String uresCheck(){
        if (this.etteremNev.getText().isEmpty()) {
            return "Az étterem neve mező nem lehet üres!";
        }
        for (int i = 0; i < nyitvatartasMezok.length; i++) {
            for (int j = 0; j < nyitvatartasMezok[i].length; j++) {
                if (nyitvatartasMezok[i][j].getText().isEmpty()) {
                    return "A nyitvatartás egy mezeje sem lehet üres!";
                }
            }
        }
        return "";
    }
    private String formatumCheck(){
        Pattern pattern = Pattern.compile("(?:^[a-zA-ZíűáéúőóüöÍŰÁÉÚŐÓÜÖ ]*$)");
        Matcher matcher = pattern.matcher(this.etteremNev.getText().trim());
        if (!matcher.find()) {
            return "Az étterem neve csak a magyar ábécé betűit és szóközt tartalmazhat!!";
        }
        pattern = Pattern.compile("(?:^[0-9]{2}:[0-9]{2}$)");
        
        for (int i = 0; i < nyitvatartasMezok.length; i++) {
            for (int j = 0; j < nyitvatartasMezok[i].length; j++) {
                matcher = pattern.matcher(nyitvatartasMezok[i][j].getText().trim());
                if (!matcher.find()) {
                    return "Nem megfelelő idő formátum!";
                }
                try {
                    LocalTime lt = LocalTime.parse(nyitvatartasMezok[i][j].getText().trim(),ONLYTIME);
                } catch (Exception e) {
                    return "Invalid idő!";
                }
            }
        }
        return "";
    }
}
