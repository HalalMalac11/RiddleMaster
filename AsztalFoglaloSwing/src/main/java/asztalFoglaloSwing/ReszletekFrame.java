package asztalFoglaloSwing;

public class ReszletekFrame extends javax.swing.JFrame {

    public ReszletekFrame(Foglalas foglalas) {
        initComponents();
        this.etteremNev.setText(foglalas.getAsztal().getEtteremNev());
        this.fogaloNevLabel.setText(foglalas.getFoglaloNev());
        this.tSzamLabel.setText(foglalas.getFoglaloTSzam());
        this.emberSzamLabel.setText(""+foglalas.getEmberSzam());
        this.asztalIdLabel.setText(""+foglalas.getAsztal().getAsztalId());
        this.asztalMaxKapacitasLabel.setText(""+foglalas.getAsztal().getKapacitas());
        setLocationRelativeTo(null);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        etteremNev = new javax.swing.JLabel();
        fogaloNevLabel = new javax.swing.JLabel();
        idopontLabel = new javax.swing.JLabel();
        tSzamLabel = new javax.swing.JLabel();
        csoportMereteLabel = new javax.swing.JLabel();
        emberSzamLabel = new javax.swing.JLabel();
        foLabel = new javax.swing.JLabel();
        asztalLabel = new javax.swing.JLabel();
        idLabel = new javax.swing.JLabel();
        asztalIdLabel = new javax.swing.JLabel();
        asztalKapacitasLabel = new javax.swing.JLabel();
        asztalMaxKapacitasLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        etteremNev.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        etteremNev.setText("Sample Etterem");

        fogaloNevLabel.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        fogaloNevLabel.setText("Sample Janos");

        idopontLabel.setText("2024. 11. 03. 18:30-19:00");

        tSzamLabel.setText("+36705260034");

        csoportMereteLabel.setText("Csoport mérete:");

        emberSzamLabel.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        emberSzamLabel.setText("12");

        foLabel.setText("fő");

        asztalLabel.setText("Asztal:");

        idLabel.setText("Azonosító:");

        asztalIdLabel.setText("1");

        asztalKapacitasLabel.setText("Asztal férőhelyeinek száma:");

        asztalMaxKapacitasLabel.setText("12");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(fogaloNevLabel)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(etteremNev)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 60, Short.MAX_VALUE)
                                .addComponent(idopontLabel)))
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(csoportMereteLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(emberSzamLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(foLabel))
                            .addComponent(tSzamLabel))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(asztalLabel)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(idLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(asztalIdLabel))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(asztalKapacitasLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(asztalMaxKapacitasLabel)))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(etteremNev)
                    .addComponent(idopontLabel))
                .addGap(18, 18, 18)
                .addComponent(fogaloNevLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tSzamLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(csoportMereteLabel)
                    .addComponent(emberSzamLabel)
                    .addComponent(foLabel))
                .addGap(18, 18, 18)
                .addComponent(asztalLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(idLabel)
                    .addComponent(asztalIdLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(asztalKapacitasLabel)
                    .addComponent(asztalMaxKapacitasLabel))
                .addContainerGap(98, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel asztalIdLabel;
    private javax.swing.JLabel asztalKapacitasLabel;
    private javax.swing.JLabel asztalLabel;
    private javax.swing.JLabel asztalMaxKapacitasLabel;
    private javax.swing.JLabel csoportMereteLabel;
    private javax.swing.JLabel emberSzamLabel;
    private javax.swing.JLabel etteremNev;
    private javax.swing.JLabel foLabel;
    private javax.swing.JLabel fogaloNevLabel;
    private javax.swing.JLabel idLabel;
    private javax.swing.JLabel idopontLabel;
    private javax.swing.JLabel tSzamLabel;
    // End of variables declaration//GEN-END:variables
}
