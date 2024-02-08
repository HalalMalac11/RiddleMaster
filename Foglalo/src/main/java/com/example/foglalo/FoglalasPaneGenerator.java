package com.example.foglalo;

import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;

public class FoglalasPaneGenerator {
    public FoglalasPaneGenerator() {

    }

    public AnchorPane generateFogalalasPane(Foglalas f, int id){
        AnchorPane foglalasPane = new AnchorPane();
        foglalasPane.setPrefWidth(305.0);
        foglalasPane.setMinWidth(305.0);

        foglalasPane.setStyle("-fx-border-color: black; -fx-border-width: 2px; -fx-border-radius: 5px");
        String[] datumIdo = f.getIdopont().split(" ");

        Label name = new Label(f.getFoglaloNev()),
                asztalLabel = new Label("Asztal:"),
                asztalID = new Label(String.valueOf(f.getAsztalId())),
                emberSzam = new Label(f.getEmberSzam()+" fő"),
                telLabel = new Label("Tel.:"),
                tel = new Label(f.getFoglaloTSzam()),
                datum = new Label(datumIdo[0]),
                ido=new Label(datumIdo[1]),
                foglalasID = new Label(String.valueOf(id));

        name.setLayoutX(14.0);
        name.setLayoutY(14.0);
        asztalLabel.setLayoutX(14.0);
        asztalLabel.setLayoutY(38.0);
        asztalID.setLayoutX(52.0);
        asztalID.setLayoutY(38.0);
        emberSzam.setLayoutX(106.0);
        emberSzam.setLayoutY(38.0);
        telLabel.setLayoutX(14.0);
        telLabel.setLayoutY(65.0);
        tel.setLayoutX(38.0);
        tel.setLayoutY(65.0);
        datum.setLayoutX(229.0);
        datum.setLayoutY(14.0);
        ido.setLayoutX(229.0);
        ido.setLayoutY(30.0);
        foglalasID.setLayoutX(263.0);
        foglalasID.setLayoutY(65.0);

        foglalasPane.getChildren().addAll(name,asztalLabel,asztalID,emberSzam,telLabel,tel,datum,ido,foglalasID);
        return foglalasPane;
    }
}
