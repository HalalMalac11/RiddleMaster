package asztalFoglaloSwing;

public class Asztal {
    private String asztalNev;
    private int asztal_id, tipus_ferohely;

    public Asztal(int index, String etterem_nev, int asztal_id, int tipus_ferohely) {
        this.asztalNev = etterem_nev+"_"+index;
        this.asztal_id = asztal_id;
        this.tipus_ferohely =tipus_ferohely;
    }


    public String getAsztalNev() {
        return asztalNev;
    }

    private void setAsztalNev(String asztalNev) {
        this.asztalNev = asztalNev;
    }

    public int getAsztal_id() {
        return asztal_id;
    }

    private void setAsztal_id(int asztal_id) {
        this.asztal_id = asztal_id;
    }

    public int getTipus_ferohely() {
        return tipus_ferohely;
    }

    private void setTipus_ferohely(int tipus_ferohely) {
        this.tipus_ferohely = tipus_ferohely;
    }

    

    @Override
    public String toString() {
        return this.getAsztalNev();
    }
    
    
    
}
