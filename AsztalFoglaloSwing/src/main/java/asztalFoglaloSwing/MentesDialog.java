package asztalFoglaloSwing;

import javax.swing.JFileChooser;
import javax.swing.filechooser.FileSystemView;

public class MentesDialog extends javax.swing.JDialog {
    private String utvonal;
    public MentesDialog(AsztalFoglaloMainFrame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        utvonal = FileSystemView.getFileSystemView().getDefaultDirectory().getPath();
        mentesUtvonalLabel.setText(utvonal);
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
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
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

        jLabel1.setText("Kezdő dátum: (yyyy-MM-dd)");

        jLabel2.setText("Befejező dátum: (yyyy-MM-dd)");

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
                            .addComponent(jLabel1)
                            .addComponent(jLabel2)
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
                    .addComponent(jLabel1))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(datumVeg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
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
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel mentesUtvonalLabel;
    private javax.swing.JLabel preview;
    private javax.swing.JRadioButton reszletes;
    private javax.swing.JButton tallozas;
    // End of variables declaration//GEN-END:variables
}
