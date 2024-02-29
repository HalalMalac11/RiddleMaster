package asztalFoglaloSwing;

public class Asztal {
    private String etteremNev, asztalNev;
    private int etteremId, asztalId, kapacitas;

    public Asztal(int index, String etteremNev, int etteremId, int asztalId, int kapacitas) {
        this.etteremNev = etteremNev;
        this.asztalNev = etteremNev+"_"+index;
        this.etteremId = etteremId;
        this.asztalId = asztalId;
        this.kapacitas =kapacitas;
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

    public int getKapacitas() {
        return kapacitas;
    }

    private void setKapacitas(int kapacitas) {
        this.kapacitas = kapacitas;
    }

    

    @Override
    public String toString() {
        return this.getAsztalNev();
    }
    
    
    
}
