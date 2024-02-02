package com.example.foglalo;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;

public class HelloController implements iDateFormatting {
    @FXML
    private TextField foglaloNev, tSzam, asztalId, idopont;
    @FXML
    private Label feedBackLabel;

    @FXML
    protected void onSubmitButtonClicked(){
        Foglalas f = new Foglalas(foglaloNev.getText(),tSzam.getText(),Integer.parseInt(asztalId.getText()),idopont.getText());
        System.out.println(f);
        feedBackLabel.setText("Sucess!");
        feedBackLabel.setTextFill(Color.GREEN);
    }
}