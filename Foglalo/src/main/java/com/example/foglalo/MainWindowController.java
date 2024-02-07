package com.example.foglalo;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;

import java.io.IOException;

public class MainWindowController implements iDateFormatting {
    public FlowPane foglalasokFlowPane;
    @FXML
    private TextField foglaloNev, tSzam, asztalId, idopont;
    @FXML
    private Label feedBackLabel;


    @FXML
    protected void onSubmitButtonClicked(){
        Foglalas f;

        try {
            f = new Foglalas(foglaloNev.getText(),tSzam.getText(),Integer.parseInt(asztalId.getText()),idopont.getText());
            System.out.println(f);
            feedBackLabel.setText("Success!");
            feedBackLabel.setTextFill(Color.GREEN);
            try {
                foglalasokFlowPane.getChildren().add(FXMLLoader.load(getClass().getResource("FoglalasBox.fxml")));
            }catch (IOException ioe){
                System.out.println(ioe.getMessage());
            }
        }catch (OldDateException ode){
            feedBackLabel.setText(ode.toString());
            feedBackLabel.setTextFill(Color.RED);
        }
    }
}