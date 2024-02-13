package asztalFoglaloSwing;

import javax.swing.JPanel;

public class FoglalasPanelGenerator {
    public FoglalasPanelGenerator() {

    }

    public JPanel generateFogalalasPanel(Foglalas f, int id){
        JPanel foglalasPanel = new JPanel();
        /*foglalasPanel.setPrefWidth(305.0);
        foglalasPanel.setMinWidth(305.0);

        foglalasPanel.setStyle("-fx-border-color: black; -fx-border-width: 2px; -fx-border-radius: 5px");
        String[] datumIdo = f.getIdopont().split(" ");

        JLabel name = new JLabel(f.getFoglaloNev()),
                asztalJLabel = new JLabel("Asztal:"),
                asztalID = new JLabel(String.valueOf(f.getAsztalId())),
                emberSzam = new JLabel(f.getEmberSzam()+" fő"),
                telJLabel = new JLabel("Tel.:"),
                tel = new JLabel(f.getFoglaloTSzam()),
                datum = new JLabel(datumIdo[0]),
                ido=new JLabel(datumIdo[1]),
                foglalasID = new JLabel(String.valueOf(id));

        name.setLayoutX(14.0);
        name.setLayoutY(14.0);
        asztalJLabel.setLayoutX(14.0);
        asztalJLabel.setLayoutY(38.0);
        asztalID.setLayoutX(52.0);
        asztalID.setLayoutY(38.0);
        emberSzam.setLayoutX(106.0);
        emberSzam.setLayoutY(38.0);
        telJLabel.setLayoutX(14.0);
        telJLabel.setLayoutY(65.0);
        tel.setLayoutX(38.0);
        tel.setLayoutY(65.0);
        datum.setLayoutX(229.0);
        datum.setLayoutY(14.0);
        ido.setLayoutX(229.0);
        ido.setLayoutY(30.0);
        foglalasID.setLayoutX(263.0);
        foglalasID.setLayoutY(65.0);

        foglalasPanel.getChildren().addAll(name,asztalJLabel,asztalID,emberSzam,telJLabel,tel,datum,ido,foglalasID);*/
        
        return foglalasPanel;
    }
}
