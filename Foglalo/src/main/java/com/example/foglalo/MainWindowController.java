package com.example.foglalo;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;


public class MainWindowController implements iDateFormatting {
    public FlowPane foglalasokFlowPane;
    @FXML
    private TextField foglaloNev, tSzam, emberSzam, asztalId, idopont;
    @FXML
    private Label feedBackLabel;
    private void generateFogalalasPane(Foglalas f){
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
                ido=new Label(datumIdo[1]);

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

        foglalasPane.getChildren().addAll(name,asztalLabel,asztalID,emberSzam,telLabel,tel,datum,ido);
        foglalasokFlowPane.getChildren().add(foglalasPane);
    }

    @FXML
    protected void onSubmitButtonClicked(){
        Foglalas f;

        try {
            f = new Foglalas(foglaloNev.getText(),tSzam.getText(),Integer.parseInt(emberSzam.getText()),Integer.parseInt(asztalId.getText()),idopont.getText());
            System.out.println(f);
            feedBackLabel.setText("Success!");
            feedBackLabel.setTextFill(Color.GREEN);
            generateFogalalasPane(f);
        }catch (OldDateException ode){
            feedBackLabel.setText(ode.toString());
            feedBackLabel.setTextFill(Color.RED);
        }
    }
}