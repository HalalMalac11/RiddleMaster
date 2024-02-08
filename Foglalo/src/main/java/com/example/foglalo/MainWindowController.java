package com.example.foglalo;

import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;

import java.time.DateTimeException;
import java.time.LocalDateTime;


public class MainWindowController implements iDateFormatting {
    public FlowPane foglalasokFlowPane;
    public DatePicker datum;
    @FXML
    private TextField foglaloNev, tSzam, emberSzam, asztalId,idopont;
    @FXML
    private Label feedBackLabel;

    private final FoglalasPaneGenerator fpg = new FoglalasPaneGenerator();
    private final FoglalasPaneList fpl= new FoglalasPaneList();

    @FXML
    protected void onSubmitButtonClicked(){
        Foglalas f;

        try {
            String[] idopontSplit= idopont.getText().split(":");
            if (Integer.parseInt(idopontSplit[0])>23||Integer.parseInt(idopontSplit[0])<0||Integer.parseInt(idopontSplit[1])>59||Integer.parseInt(idopontSplit[1])<0){
                throw new InvalidTimeException("Inavlid időpont");
            }
            f = new Foglalas(foglaloNev.getText(),tSzam.getText(),Integer.parseInt(emberSzam.getText()),Integer.parseInt(asztalId.getText()), new String(datum.getValue().toString()+" "+idopont.getText()+":00"));
            System.out.println(f);
            feedBackLabel.setText("Success!");
            feedBackLabel.setTextFill(Color.GREEN);

            AnchorPane ujPane = fpg.generateFogalalasPane(f, fpl.getSize());
            fpl.addPane(ujPane);
            foglalasokFlowPane.getChildren().add(ujPane);
        }catch (OldDateException ode){
            feedBackLabel.setText(ode.toString());
            feedBackLabel.setTextFill(Color.RED);
        }catch (InvalidTimeException ite){
            feedBackLabel.setText(ite.toString());
            feedBackLabel.setTextFill(Color.RED);
        }catch (IllegalArgumentException iae){
            feedBackLabel.setText(iae.toString());
            feedBackLabel.setTextFill(Color.RED);
        }
    }
}