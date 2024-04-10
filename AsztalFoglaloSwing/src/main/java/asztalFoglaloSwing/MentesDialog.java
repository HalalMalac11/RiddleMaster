package asztalFoglaloSwing;

import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Paragraph;
import java.io.FileNotFoundException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.filechooser.FileSystemView;

public class MentesDialog extends javax.swing.JDialog implements iDateFormatting{
    private String utvonal;
    private DefaultComboBoxModel<Asztal> asztalokDCBM;
    private AsztalFoglaloMainFrame mainFrame;
    public MentesDialog(AsztalFoglaloMainFrame parent, boolean modal) {
        super(parent, modal);
        mainFrame=parent;
        asztalokDCBM = new DefaultComboBoxModel<Asztal>();
        initComponents();
        try {
            loadAsztalokModel();
        } catch (SQLException sqle) {
            JOptionPane.showMessageDialog(new JFrame(),"Sikertelen adatbázis művelet!\n"+sqle.getMessage(),"Hiba!",JOptionPane.ERROR_MESSAGE);
        }
        utvonal = FileSystemView.getFileSystemView().getDefaultDirectory().getPath();
        mentesUtvonalLabel.setText(utvonal);
        egyszeru.setSelected(true);
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        formatumGroup = new javax.swing.ButtonGroup();
        formatumLabel = new javax.swing.JLabel();
        egyszeru = new javax.swing.JRadioButton();
        reszletes = new javax.swing.JRadioButton();
        preview = new javax.swing.JLabel();
        datumKezd = new javax.swing.JTextField();
        kezdDatumLabel = new javax.swing.JLabel();
        vegDatumLabel = new javax.swing.JLabel();
        datumVeg = new javax.swing.JTextField();
        mentesUtvonalLabel = new javax.swing.JLabel();
        tallozas = new javax.swing.JButton();
        export = new javax.swing.JButton();
        asztalLabel = new javax.swing.JLabel();
        asztalCB = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("PDF-ként");

        formatumLabel.setText("Válasszon formátumot:");

        formatumGroup.add(egyszeru);
        egyszeru.setText("Egyszerű");

        formatumGroup.add(reszletes);
        reszletes.setText("Részletes");

        kezdDatumLabel.setText("Kezdő dátum: (yyyy-MM-dd)");

        vegDatumLabel.setText("Befejező dátum: (yyyy-MM-dd)");

        mentesUtvonalLabel.setText("jLabel3");

        tallozas.setText("Tallózás");
        tallozas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tallozasActionPerformed(evt);
            }
        });

        export.setText("Exportálás");
        export.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exportActionPerformed(evt);
            }
        });

        asztalLabel.setText("Asztal:");

        asztalCB.setModel(asztalokDCBM);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(tallozas)
                        .addGap(18, 18, 18)
                        .addComponent(mentesUtvonalLabel))
                    .addComponent(export)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(kezdDatumLabel)
                            .addComponent(vegDatumLabel)
                            .addComponent(reszletes)
                            .addComponent(formatumLabel)
                            .addComponent(egyszeru))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(datumKezd, javax.swing.GroupLayout.DEFAULT_SIZE, 178, Short.MAX_VALUE)
                            .addComponent(datumVeg)
                            .addComponent(preview, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(asztalLabel)
                        .addGap(18, 18, 18)
                        .addComponent(asztalCB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(formatumLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(egyszeru)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(reszletes))
                    .addComponent(preview, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(asztalLabel)
                    .addComponent(asztalCB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 17, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(datumKezd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(kezdDatumLabel))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(datumVeg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(vegDatumLabel))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tallozas)
                    .addComponent(mentesUtvonalLabel))
                .addGap(18, 18, 18)
                .addComponent(export)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tallozasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tallozasActionPerformed
        JFileChooser jf = new JFileChooser(FileSystemView.getFileSystemView());
        jf.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        int valasz = jf.showSaveDialog(null);  
        if (valasz == JFileChooser.APPROVE_OPTION){
            utvonal=jf.getSelectedFile().getAbsolutePath();
            mentesUtvonalLabel.setText(utvonal);
        }  
    }//GEN-LAST:event_tallozasActionPerformed

    private void exportActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exportActionPerformed
    try {
            String fajlNev="Foglalasok_";
            String foglalasSql ="SELECT * FROM `foglalas` WHERE `foglalas_idopont_kezd`>=";
            int datumKezdStatus=inputEllenorzes(datumKezd);
            String keresKezd="",keresVeg="";
            if(datumKezdStatus==1){
                keresKezd=datumKezd.getText();
                foglalasSql+="'"+keresKezd+"'";
                fajlNev+=keresKezd;
            }else if(datumKezdStatus==0){
                keresKezd=LocalDate.now().format(onlyDate);
                foglalasSql+="'"+keresKezd+"'";
                fajlNev+=keresKezd;
            }else{
                JOptionPane.showMessageDialog(new JFrame(),"Nem megfelelő formátumú kezdő dátum!","Hiba!",JOptionPane.ERROR_MESSAGE);
            }
            
            int datumVegStatus=inputEllenorzes(datumVeg);
            
            if(datumVegStatus==1){
                keresVeg=datumVeg.getText();
                foglalasSql+=" AND `foglalas_idopont_veg`'"+keresVeg+"'";
                fajlNev+="_"+keresVeg;
            }else if(datumVegStatus==-1){
                JOptionPane.showMessageDialog(new JFrame(),"Nem megfelelő formátumú vég dátum!","Hiba!",JOptionPane.ERROR_MESSAGE);
            }
            if(datumKezdStatus!=-1&&datumVegStatus!=-1){
                if(asztalCB.getSelectedIndex()!=0){
                    Asztal a = (Asztal) asztalCB.getSelectedItem();
                    foglalasSql+=" AND `asztal_id`='"+a.getAsztal_id()+"'";
                }
                String vegsoUtvonal=utvonal+"\\"+fajlNev+".pdf";
                vegsoUtvonal=vegsoUtvonal.replace('\\', '/');
                PdfWriter pw = new PdfWriter(vegsoUtvonal);
                PdfDocument pdfDoc = new PdfDocument(pw);
                Document doc = new Document(pdfDoc);
                pdfDoc.addNewPage();
                
                doc.close();
            }
        } catch (FileNotFoundException ex) {
            JOptionPane.showMessageDialog(new JFrame(),"A fájlt nem sikerült létrehozni!","Hiba!",JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_exportActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<Asztal> asztalCB;
    private javax.swing.JLabel asztalLabel;
    private javax.swing.JTextField datumKezd;
    private javax.swing.JTextField datumVeg;
    private javax.swing.JRadioButton egyszeru;
    private javax.swing.JButton export;
    private javax.swing.ButtonGroup formatumGroup;
    private javax.swing.JLabel formatumLabel;
    private javax.swing.JLabel kezdDatumLabel;
    private javax.swing.JLabel mentesUtvonalLabel;
    private javax.swing.JLabel preview;
    private javax.swing.JRadioButton reszletes;
    private javax.swing.JButton tallozas;
    private javax.swing.JLabel vegDatumLabel;
    // End of variables declaration//GEN-END:variables

    private int inputEllenorzes(JTextField datumField) {
        Pattern p = Pattern.compile("(?:^\\d{4}-\\d{2}-\\d{2}$)");
        Matcher m = p.matcher(datumField.getText());
        if(!datumField.getText().isBlank()&&!m.find()){
            return -1;
        }else if(datumField.getText().isBlank()){
            return 0;
        }
        return 1;
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
            
            asztalCB.setSelectedIndex(0);
    }
}