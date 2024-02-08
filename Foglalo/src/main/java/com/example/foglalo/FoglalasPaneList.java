package com.example.foglalo;

import javafx.scene.layout.AnchorPane;

import java.util.ArrayList;

public class FoglalasPaneList {
    private ArrayList<AnchorPane> paneLista;

    public FoglalasPaneList() {
        this.paneLista = new ArrayList<AnchorPane>();
    }

    public void addPane(AnchorPane ap){
        this.paneLista.add(ap);
    }

    public void removePaneById(int id){
        this.paneLista.remove(id);
    }

    public int getSize(){
        return this.paneLista.size();
    }
}
