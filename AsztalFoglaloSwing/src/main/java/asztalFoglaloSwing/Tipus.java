package asztalFoglaloSwing;

public class Tipus {
    private int tipus_id,tipus_ferohely;

    public Tipus(int tipus_id, int tipus_ferohely) {
        this.tipus_id = tipus_id;
        this.tipus_ferohely = tipus_ferohely;
    }

    public int getTipus_id() {
        return tipus_id;
    }

    private void setTipus_id(int tipus_id) {
        this.tipus_id = tipus_id;
    }

    public int getTipus_ferohely() {
        return tipus_ferohely;
    }

    public void setTipus_ferohely(int tipus_ferohely) {
        this.tipus_ferohely = tipus_ferohely;
    }

    @Override
    public String toString() {
        return ""+this.getTipus_ferohely();
    }
    
}
