package asztalFoglaloSwing;

import java.util.ArrayList;
import javax.swing.JPanel;

public class FoglalasPanelList {
    private ArrayList<JPanel> panelLista;

    public FoglalasPanelList() {
        this.panelLista = new ArrayList<JPanel>();
    }

    public void addPanel(JPanel jp){
        this.panelLista.add(jp);
    }

    public void removePaneById(int id){
        this.panelLista.remove(id);
    }

    public int getSize(){
        return this.panelLista.size();
    }
}
