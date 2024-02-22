package asztalFoglaloSwing;

public class Asztal {
    private String etteremNev, asztalNev;
    private int etteremId, asztalId, tipus;

    public Asztal(int index, String etteremNev, int etteremId, int asztalId, int tipus) {
        this.etteremNev = etteremNev;
        this.asztalNev = etteremNev+"_"+index;
        this.etteremId = etteremId;
        this.asztalId = asztalId;
        this.tipus = tipus;
    }

    public String getEtteremNev() {
        return etteremNev;
    }

    private void setEtteremNev(String etteremNev) {
        this.etteremNev = etteremNev;
    }

    public String getAsztalNev() {
        return asztalNev;
    }

    private void setAsztalNev(String asztalNev) {
        this.asztalNev = asztalNev;
    }

    public int getEtteremId() {
        return etteremId;
    }

    private void setEtteremId(int etteremId) {
        this.etteremId = etteremId;
    }

    public int getAsztalId() {
        return asztalId;
    }

    private void setAsztalId(int asztalId) {
        this.asztalId = asztalId;
    }

    public int getTipus() {
        return tipus;
    }

    private void setTipus(int tipus) {
        this.tipus = tipus;
    }

    @Override
    public String toString() {
        return this.getAsztalNev();
    }
    
    
    
}
