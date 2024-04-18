package asztalFoglaloSwing;

import java.time.LocalDateTime;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import java.awt.event.KeyEvent;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeCellRenderer;
import javax.swing.tree.DefaultTreeModel;
import java.time.LocalTime;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import static asztalFoglaloSwing.iDateFormatting.FULLDATETIME;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;

public class AsztalFoglaloMainFrame extends javax.swing.JFrame implements iDateFormatting {

    //private final String dbURL="jdbc:mysql://nebet.hu/c31kissM_db",dbUser="c31kissM",dbPass="ogqgtWAALB8!b";
    private final String dbURL = "jdbc:mysql://localhost:3306/asztalfoglalo", dbUser = "foglalas_kezelo", dbPass = "4N6jqhr7dnwCACRI";
    protected DefaultTreeModel foglalasFaModel;
    private JFrame errorFrame = new JFrame();
    private Etterem etterem;
    private Connection con;
    private static Statement stmt;

    public AsztalFoglaloMainFrame() {
        initComponents();
        try {
            con = DriverManager.getConnection(dbURL, dbUser, dbPass);
            stmt = con.createStatement();
            EtteremValasztDialog evd = new EtteremValasztDialog(this, true);
            evd.setVisible(true);
            faBetolt();
        } catch (SQLException sqle) {
            JOptionPane.showMessageDialog(errorFrame, "Sikertelen adatbázis kapcsolódás!\n" + sqle.getMessage(), "Hiba!", JOptionPane.ERROR_MESSAGE);
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

    public static Statement getStmt() {
        return stmt;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        kivalasztottEtteremLabel = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        foglalasFa = new javax.swing.JTree();
        searchField = new javax.swing.JTextField();
        search = new javax.swing.JButton();
        menuSor = new javax.swing.JMenuBar();
        fajlMenu = new javax.swing.JMenu();
        exportPdf = new javax.swing.JMenuItem();
        kilepes = new javax.swing.JMenuItem();
        etteremMenu = new javax.swing.JMenu();
        etteremAlMenu = new javax.swing.JMenu();
        etteremValt = new javax.swing.JMenuItem();
        etteremSzerkeszt = new javax.swing.JMenuItem();
        etteremTorol = new javax.swing.JMenuItem();
        asztalMenu = new javax.swing.JMenu();
        ujAsztal = new javax.swing.JMenuItem();
        asztalTorol = new javax.swing.JMenuItem();
        ujTipus = new javax.swing.JMenuItem();
        foglalasMenu = new javax.swing.JMenu();
        hozzaAd = new javax.swing.JMenuItem();
        edit = new javax.swing.JMenuItem();
        torol = new javax.swing.JMenuItem();
        reszletek = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Asztal foglaló");
        setResizable(false);

        kivalasztottEtteremLabel.setFont(new java.awt.Font("Calibri", 1, 24)); // NOI18N
        kivalasztottEtteremLabel.setText("jLabel1");

        foglalasFa.setBorder(javax.swing.BorderFactory.createEmptyBorder(10, 10, 10, 10));
        foglalasFa.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                foglalasFaMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(foglalasFa);

        searchField.setToolTipText("<html>\n\"<i>név</i>\" keresés név alapján<br>\n\"_<i>asztal száma</i>\" keresés az asztal száma alapján<br>\n\"#<i>csoport mérete</i>\" keresés a csoportnak a mérete alapján<br>\n\"<i>dátum</i>\" keresés név alapján<br>\n\"k:<i>12:00</i>\" keresés az iddőpont kezdete alapján<br>\n\"v:<i>12:00</i>\" keresés az iddőpont vége alapján\n");
        searchField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchFieldActionPerformed(evt);
            }
        });

        search.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/magnifier.png"))); // NOI18N
        search.setMaximumSize(new java.awt.Dimension(60, 60));
        search.setMinimumSize(new java.awt.Dimension(60, 60));
        search.setPreferredSize(new java.awt.Dimension(60, 60));
        search.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchActionPerformed(evt);
            }
        });

        fajlMenu.setText("Fájl");

        exportPdf.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/pdf.png"))); // NOI18N
        exportPdf.setText("Mentés PDF-be");
        exportPdf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exportPdfActionPerformed(evt);
            }
        });
        fajlMenu.add(exportPdf);

        kilepes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/exit.png"))); // NOI18N
        kilepes.setText("Kilépés");
        kilepes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kilepesActionPerformed(evt);
            }
        });
        fajlMenu.add(kilepes);

        menuSor.add(fajlMenu);

        etteremMenu.setText("Étterem");

        etteremAlMenu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/restaurantIcon.png"))); // NOI18N
        etteremAlMenu.setText("Étterem");

        etteremValt.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/restaurantChangeIcon.png"))); // NOI18N
        etteremValt.setText("Étterem váltása");
        etteremValt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                etteremValtActionPerformed(evt);
            }
        });
        etteremAlMenu.add(etteremValt);

        etteremSzerkeszt.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/restaurantEdit.png"))); // NOI18N
        etteremSzerkeszt.setText("Étterem szerkesztése");
        etteremSzerkeszt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                etteremSzerkesztActionPerformed(evt);
            }
        });
        etteremAlMenu.add(etteremSzerkeszt);

        etteremTorol.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/restaurantDelete.png"))); // NOI18N
        etteremTorol.setText("Étterem törlése");
        etteremTorol.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                etteremTorolActionPerformed(evt);
            }
        });
        etteremAlMenu.add(etteremTorol);

        etteremMenu.add(etteremAlMenu);

        asztalMenu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/table.png"))); // NOI18N
        asztalMenu.setText("Asztal");

        ujAsztal.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/tableAdd.png"))); // NOI18N
        ujAsztal.setText("Új asztal");
        ujAsztal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ujAsztalActionPerformed(evt);
            }
        });
        asztalMenu.add(ujAsztal);

        asztalTorol.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/tableDelete.png"))); // NOI18N
        asztalTorol.setText("Asztal törlése");
        asztalTorol.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                asztalTorolActionPerformed(evt);
            }
        });
        asztalMenu.add(asztalTorol);

        ujTipus.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/chair.png"))); // NOI18N
        ujTipus.setText("Új típus");
        ujTipus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ujTipusActionPerformed(evt);
            }
        });
        asztalMenu.add(ujTipus);

        etteremMenu.add(asztalMenu);

        menuSor.add(etteremMenu);

        foglalasMenu.setText("Foglalás");

        hozzaAd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/bookAdd.png"))); // NOI18N
        hozzaAd.setText("Foglalas felvétele");
        hozzaAd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                hozzaAdActionPerformed(evt);
            }
        });
        foglalasMenu.add(hozzaAd);

        edit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/bookEdit.png"))); // NOI18N
        edit.setText("Szerkesztés");
        edit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editActionPerformed(evt);
            }
        });
        foglalasMenu.add(edit);

        torol.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/bookDelete.png"))); // NOI18N
        torol.setText("Törlés");
        torol.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                torolActionPerformed(evt);
            }
        });
        foglalasMenu.add(torol);

        reszletek.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/book.png"))); // NOI18N
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
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 362, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(kivalasztottEtteremLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(searchField, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(search, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(kivalasztottEtteremLabel)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(searchField, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(search, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void hozzaAdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_hozzaAdActionPerformed
        AddFoglalasDialog afd = new AddFoglalasDialog(this, true);
        afd.setVisible(true);
    }//GEN-LAST:event_hozzaAdActionPerformed

    private void editActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editActionPerformed
        if (foglalasFa.getLastSelectedPathComponent() != null) {
            DefaultMutableTreeNode selected = (DefaultMutableTreeNode) foglalasFa.getLastSelectedPathComponent();
            if (selected.getUserObject() instanceof Foglalas) {
                Foglalas f = (Foglalas) selected.getUserObject();
                AddFoglalasDialog afd = new AddFoglalasDialog(this, true, f);
                afd.setVisible(true);
            } else {
                JOptionPane.showMessageDialog(errorFrame, "A kiválasztott elem nem egy foglalás!", "Hiba!", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(errorFrame, "Nincs kiválasztva foglalás!", "Hiba!", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_editActionPerformed

    private void torolActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_torolActionPerformed
        if (foglalasFa.getLastSelectedPathComponent() != null) {
            DefaultMutableTreeNode selectedNode = (DefaultMutableTreeNode) foglalasFa.getLastSelectedPathComponent();
            if (selectedNode.getUserObject() instanceof Foglalas) {
                Foglalas f = (Foglalas) selectedNode.getUserObject();
                int valasz = JOptionPane.showConfirmDialog(errorFrame, "Biztosan törölni szeretné?\n" + f, "Törlés", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
                if (valasz == JOptionPane.YES_OPTION) {
                    String sql = "DELETE FROM `foglalas` WHERE `foglalas_id`='" + f.getFoglalas_id() + "'";
                    try {
                        Statement stmt = con.createStatement();
                        stmt.execute(sql);
                        boolean success = stmt.getUpdateCount() == 1;
                        if (success) {
                            faBetolt();
                        }
                    } catch (SQLException ex) {
                        JOptionPane.showMessageDialog(errorFrame, "Sikertelen törlés!\n" + ex, "Hiba!", JOptionPane.ERROR_MESSAGE);
                    }
                }
            } else {
                JOptionPane.showMessageDialog(errorFrame, "A kiválasztott elem nem foglalás!", "Hiba!", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(errorFrame, "Nincs kiválasztva foglalás!", "Hiba!", JOptionPane.ERROR_MESSAGE);
        }

    }//GEN-LAST:event_torolActionPerformed

    private void kilepesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kilepesActionPerformed
        System.exit(0);
    }//GEN-LAST:event_kilepesActionPerformed

    private void etteremValtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_etteremValtActionPerformed
        etteremValtas();
    }//GEN-LAST:event_etteremValtActionPerformed

    private void ujAsztalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ujAsztalActionPerformed
        AddAsztalDialog aad = new AddAsztalDialog(this, true);
        aad.setVisible(true);
    }//GEN-LAST:event_ujAsztalActionPerformed

    private void ujTipusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ujTipusActionPerformed
        AddTipusDialog atd = new AddTipusDialog(this, true);
        atd.setVisible(true);
    }//GEN-LAST:event_ujTipusActionPerformed

    private void asztalTorolActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_asztalTorolActionPerformed
        if (foglalasFa.getLastSelectedPathComponent() != null) {
            DefaultMutableTreeNode selectedNode = (DefaultMutableTreeNode) foglalasFa.getLastSelectedPathComponent();
            if (selectedNode.getUserObject() instanceof Asztal) {
                Asztal a = (Asztal) selectedNode.getUserObject();
                int biztos = JOptionPane.showConfirmDialog(errorFrame, "Az asztal tölésével az össze hozzátartozó foglalás elveszik!\nBiztosan törölni szeretné ezt az asztalt?", "Törlés!", JOptionPane.WARNING_MESSAGE);
                if (biztos == JOptionPane.YES_OPTION) {
                    String input = "alapertek";
                    while (input != null && !input.equals(a.getAsztalNev())) {
                        input = JOptionPane.showInputDialog(errorFrame, "A törléshez írja be az asztal nevét: " + a.getAsztalNev(), "Törlés!", JOptionPane.WARNING_MESSAGE);
                    }
                    if (input != null) {
                        try {
                            String sql = "DELETE FROM `foglalas` WHERE `asztal_id`='" + a.getAsztal_id() + "'";
                            Statement stmt = con.createStatement();
                            stmt.execute(sql);
                            sql = "DELETE FROM `asztal` WHERE `asztal_id`='" + a.getAsztal_id() + "'";
                            stmt.execute(sql);
                            faBetolt();
                        } catch (SQLException sqle) {
                            JOptionPane.showMessageDialog(errorFrame, "Sikertelen törlés!\n" + sqle, "Hiba!", JOptionPane.ERROR_MESSAGE);
                        }
                    }
                }
            } else {
                JOptionPane.showMessageDialog(errorFrame, "A kiválasztott elem nem asztal!", "Hiba!", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(errorFrame, "Nincs kiválasztva asztal!", "Hiba!", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_asztalTorolActionPerformed

    private void etteremTorolActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_etteremTorolActionPerformed
        int biztos = JOptionPane.showConfirmDialog(errorFrame, "Az étterem tölésével az össze hozzátartozó asztal és foglalás elveszik!\nBiztosan törölni szeretné ezt az éttermet?", "Törlés!", JOptionPane.WARNING_MESSAGE);
        if (biztos == JOptionPane.YES_OPTION) {
            String nevInput = "alapertek";
            while (nevInput != null && !nevInput.equals(etterem.getNev())) {
                nevInput = JOptionPane.showInputDialog(errorFrame, "A törléshez írja be az asztal nevét: " + etterem.getNev(), "Törlés!", JOptionPane.WARNING_MESSAGE);
            }
            if (nevInput != null) {
                try {
                    String sql = "SELECT `asztal_id` FROM `asztal` WHERE `etterem_id`='" + etterem.getId() + "'";
                    Statement selectStmt = con.createStatement();
                    Statement deleteStmt = con.createStatement();
                    ResultSet rs = selectStmt.executeQuery(sql);
                    while (rs.next()) {
                        sql = "DELETE FROM `foglalas` WHERE `asztal_id`='" + rs.getInt("asztal_id") + "'";
                        deleteStmt.execute(sql);
                    }
                    rs.close();
                    sql = "DELETE FROM `asztal` WHERE `etterem_id`='" + etterem.getId() + "'";
                    deleteStmt.execute(sql);
                    sql = "DELETE FROM `nyitvatartas` WHERE `etterem_id`='" + etterem.getId() + "'";
                    deleteStmt.execute(sql);
                    sql = "DELETE FROM `etterem` WHERE `etterem_id`='" + etterem.getId() + "'";
                    deleteStmt.execute(sql);
                    etteremValtas();
                } catch (SQLException sqle) {
                    JOptionPane.showMessageDialog(errorFrame, "Sikertelen törlés!\n" + sqle, "Hiba!", JOptionPane.ERROR_MESSAGE);
                }
            }
        }
    }//GEN-LAST:event_etteremTorolActionPerformed

    private void foglalasFaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_foglalasFaMouseClicked
        if (evt.getClickCount() == 2) {
            reszletekMegjelenit();
        }
    }//GEN-LAST:event_foglalasFaMouseClicked

    private void reszletekActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_reszletekActionPerformed
        reszletekMegjelenit();
    }//GEN-LAST:event_reszletekActionPerformed

    private void exportPdfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exportPdfActionPerformed
        MentesDialog md = new MentesDialog(this, true);
        md.setVisible(true);
    }//GEN-LAST:event_exportPdfActionPerformed

    private void searchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchActionPerformed
        kereses();
    }//GEN-LAST:event_searchActionPerformed

    private void searchFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchFieldActionPerformed
        kereses();
    }//GEN-LAST:event_searchFieldActionPerformed

    private void etteremSzerkesztActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_etteremSzerkesztActionPerformed
        AddEtteremDialog aed = new AddEtteremDialog(this, true, etterem);
        aed.setVisible(true);
    }//GEN-LAST:event_etteremSzerkesztActionPerformed

    private String getKeresesWhere(String keresettSzoveg) {
        Pattern pattern = Pattern.compile("(?:^[a-zA-ZíűáéúőóüöÍŰÁÉÚŐÓÜÖ ]+$)");
        Matcher matcher = pattern.matcher(keresettSzoveg);
        if (matcher.find()) {
            return "`foglalas_nev` LIKE '%" + keresettSzoveg + "%' ";
        }
        pattern = Pattern.compile("(?:^_{1} ?\\d+$)");
        matcher = pattern.matcher(keresettSzoveg);
        if (matcher.find()) {
            keresettSzoveg = keresettSzoveg.substring(1).trim();
            return "`asztal_szam` = '" + keresettSzoveg + "' ";
        }
        pattern = Pattern.compile("(?:^#{1} ?\\d+$)");
        matcher = pattern.matcher(keresettSzoveg);
        if (matcher.find()) {
            keresettSzoveg = keresettSzoveg.substring(1).trim();
            return "`foglalas_csoport_meret` = '" + keresettSzoveg + "' ";
        }

        pattern = Pattern.compile("(?:^[0-9]{4}-[0-9]{2}-[0-9]{2}$)");
        matcher = pattern.matcher(keresettSzoveg);
        if (matcher.find()) {
            if (validIdo(keresettSzoveg, true)) {
                return "`foglalas_idopont_kezd` LIKE '%" + keresettSzoveg + "%' ";
            }
        }
        pattern = Pattern.compile("(?:^k: ?[0-9]{2}:[0-9]{2}$)");
        matcher = pattern.matcher(keresettSzoveg);
        if (matcher.find()) {
            keresettSzoveg = keresettSzoveg.substring(2).trim();
            if (validIdo(keresettSzoveg, false)) {
                return "`foglalas_idopont_kezd` LIKE '%" + keresettSzoveg + ":00%' ";
            }
        }
        pattern = Pattern.compile("(?:^v: ?[0-9]{2}:[0-9]{2}$)");
        matcher = pattern.matcher(keresettSzoveg);
        if (matcher.find()) {
            keresettSzoveg = keresettSzoveg.substring(2).trim();
            if (validIdo(keresettSzoveg, false)) {
                return "`foglalas_idopont_veg` LIKE '%" + keresettSzoveg + ":00%' ";
            }
        }
        return "";
    }

    private void kereses() {
        String keresettSzoveg = searchField.getText().trim();
        try {
            if (keresettSzoveg.isEmpty()) {
                faBetolt();
            } else {
                faBetolt(getKeresesWhere(keresettSzoveg));
            }
        } catch (SQLException sqle) {
            JOptionPane.showMessageDialog(
                    errorFrame,
                    "Sikertelen adatbázis kapcsolódás!\n" + sqle.getMessage(),
                    "Hiba!",
                    JOptionPane.ERROR_MESSAGE);
        }
    }

    private boolean validIdo(String idopont, boolean datum) {
        try {
            if (datum) {
                LocalDate.parse(idopont, ONLYDATE);
            } else {
                LocalTime.parse(idopont, ONLYTIME);
            }
            return true;
        } catch (DateTimeParseException dtpe) {
        }
        return false;
    }

    public void faBetolt() throws SQLException {
        faBetolt("");
    }

    public void faBetolt(String keresesWhere) throws SQLException {
        DefaultMutableTreeNode rootNode = new DefaultMutableTreeNode("root");
        foglalasFaModel = new DefaultTreeModel(rootNode);

        String most = FULLDATETIME.format(LocalDateTime.now());
        String alapWhere = "`foglalas_idopont_kezd`>'" + most + "'";
        boolean asztalKeres=false;
        if(!keresesWhere.isEmpty()){
            asztalKeres= keresesWhere.substring(1,2).equals("a");
        }
        String sql = "SELECT * FROM `asztal` WHERE `etterem_id`='" + etterem.getId() 
                + "'"+(asztalKeres?" AND "+keresesWhere:"");
        Statement asztalStmt = getStmt();
        ResultSet asztalRs = asztalStmt.executeQuery(sql);
        Asztal a;
        Foglalas f;
        
        while (asztalRs.next()) {
            try {
                a = new Asztal(asztalRs.getInt("asztal_szam"), 
                        etterem.getNev(), 
                        asztalRs.getInt("asztal_id"), 
                        getTipus(asztalRs.getInt("tipus_id"))
                );
                
                DefaultMutableTreeNode asztalNode = new DefaultMutableTreeNode(a);

                
                sql = "SELECT * "
                        + "FROM `foglalas` "
                        + "WHERE " + (keresesWhere.isEmpty()||asztalKeres ? alapWhere : keresesWhere)
                        + " AND `foglalas`.`asztal_id`='" + a.getAsztal_id()
                        + "' ORDER BY `foglalas_idopont_kezd`";
                Statement foglalasStmt = getStmt().getConnection().createStatement();
                ResultSet foglalasRs = foglalasStmt.executeQuery(sql);
                
                boolean vanFoglalas = false;
                while (foglalasRs.next()) {
                    vanFoglalas = true;
                    f = new Foglalas(foglalasRs.getInt("foglalas_id"),
                            foglalasRs.getString("foglalas_nev"),
                            foglalasRs.getString("foglalas_telszam"),
                            foglalasRs.getInt("foglalas_csoport_meret"),
                            a,
                            foglalasRs.getString("foglalas_idopont_kezd"),
                            foglalasRs.getString("foglalas_idopont_veg"));
                    DefaultMutableTreeNode foglalasNode = new DefaultMutableTreeNode(f);
                    asztalNode.add(foglalasNode);
                }
                foglalasRs.close();

                if (!vanFoglalas) {
                    asztalNode.add(new DefaultMutableTreeNode("Ehhez az asztalhoz nem tartoznak foglalások!"));
                }
                if (!keresesWhere.isEmpty() && !vanFoglalas) {
                } else {
                    rootNode.add(asztalNode);
                }
            } catch (IllegalArgumentException ex) {
                JOptionPane.showMessageDialog(errorFrame, 
                        "Ennek nem kéne megtörténni!\n" + ex.getMessage(), 
                        "Hiba!", 
                        JOptionPane.ERROR_MESSAGE
                );
                System.exit(0);
            }
        }
        asztalRs.close();

        foglalasFa.setModel(foglalasFaModel);
        foglalasFa.expandRow(0);
        foglalasFa.setRootVisible(false);
    }

    public static Tipus getTipus(int tipusId) throws SQLException {
        String sql = "SELECT `tipus_ferohely` FROM `tipus` WHERE `tipus_id`='" + tipusId + "'";
        Statement stmt = getStmt().getConnection().createStatement();
        if (stmt.execute(sql)) {
            ResultSet rs = stmt.executeQuery(sql);
            rs.next();
            int ferohely = rs.getInt("tipus_ferohely");
            rs.close();
            Tipus t = new Tipus(tipusId, ferohely);
            return t;
        }
        return new Tipus(0, 0);
    }

    private void createShortcuts() {
        KeyStroke keyStrokeHozzaAd = KeyStroke.getKeyStroke(KeyEvent.VK_F, KeyEvent.CTRL_DOWN_MASK);
        hozzaAd.setAccelerator(keyStrokeHozzaAd);
        KeyStroke keyStrokeSzerkesztes = KeyStroke.getKeyStroke(KeyEvent.VK_E, KeyEvent.CTRL_DOWN_MASK);
        edit.setAccelerator(keyStrokeSzerkesztes);
    }

    private void etteremValtas() {
        try {
            EtteremValasztDialog evd = new EtteremValasztDialog(this, true);
            evd.setVisible(true);
            faBetolt();
            this.kivalasztottEtteremLabel.setText(etterem.getNev());
        } catch (SQLException sqle) {
            JOptionPane.showMessageDialog(errorFrame, "Sikertelen adatbázis kapcsolódás!\n" + sqle.getMessage(), "Hiba!", JOptionPane.ERROR_MESSAGE);
            System.exit(0);
        }
    }

    private void reszletekMegjelenit() {
        DefaultMutableTreeNode selectedNode = (DefaultMutableTreeNode) foglalasFa.getLastSelectedPathComponent();

        if (selectedNode != null && selectedNode.getUserObject() instanceof Foglalas) {
            Foglalas f = (Foglalas) selectedNode.getUserObject();

            ReszletekFrame rf = new ReszletekFrame(this, f);
            rf.setVisible(true);
        }
    }

    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            URL tableURL = AsztalFoglaloMainFrame.class.getResource("/images/table2.png");
            Icon tableIcon = new ImageIcon(tableURL);
            URL bookURL = AsztalFoglaloMainFrame.class.getResource("/images/book.png");
            Icon bookIcon = new ImageIcon(bookURL);

            UIManager.put("Tree.closedIcon", tableIcon);
            UIManager.put("Tree.openIcon", tableIcon);
            UIManager.put("Tree.leafIcon", bookIcon);
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
    private javax.swing.JMenu etteremAlMenu;
    private javax.swing.JMenu etteremMenu;
    private javax.swing.JMenuItem etteremSzerkeszt;
    private javax.swing.JMenuItem etteremTorol;
    private javax.swing.JMenuItem etteremValt;
    private javax.swing.JMenuItem exportPdf;
    private javax.swing.JMenu fajlMenu;
    private javax.swing.JTree foglalasFa;
    private javax.swing.JMenu foglalasMenu;
    private javax.swing.JMenuItem hozzaAd;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JMenuItem kilepes;
    private javax.swing.JLabel kivalasztottEtteremLabel;
    private javax.swing.JMenuBar menuSor;
    private javax.swing.JMenuItem reszletek;
    private javax.swing.JButton search;
    private javax.swing.JTextField searchField;
    private javax.swing.JMenuItem torol;
    private javax.swing.JMenuItem ujAsztal;
    private javax.swing.JMenuItem ujTipus;
    // End of variables declaration//GEN-END:variables

}
