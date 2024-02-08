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

    private final FoglalasPaneGenerator fpg = new FoglalasPaneGenerator();
    private final FoglalasPaneList fpl= new FoglalasPaneList();

    @FXML
    protected void onSubmitButtonClicked(){
        Foglalas f;

        try {
            f = new Foglalas(foglaloNev.getText(),tSzam.getText(),Integer.parseInt(emberSzam.getText()),Integer.parseInt(asztalId.getText()),idopont.getText());
            System.out.println(f);
            feedBackLabel.setText("Success!");
            feedBackLabel.setTextFill(Color.GREEN);

            AnchorPane ujPane = fpg.generateFogalalasPane(f, fpl.getSize());
            fpl.addPane(ujPane);
            foglalasokFlowPane.getChildren().add(ujPane);
        }catch (OldDateException ode){
            feedBackLabel.setText(ode.toString());
            feedBackLabel.setTextFill(Color.RED);
        }
    }
}