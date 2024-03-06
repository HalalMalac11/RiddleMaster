package asztalFoglaloSwing;

public class Asztal {
    private String asztalNev;
    private int etteremId, asztalId, kapacitas;

    public Asztal(int index, String etteremNev, int asztalId, int kapacitas) {
        this.asztalNev = etteremNev+"_"+index;
        this.asztalId = asztalId;
        this.kapacitas =kapacitas;
    }


    public String getAsztalNev() {
        return asztalNev;
    }

    private void setAsztalNev(String asztalNev) {
        this.asztalNev = asztalNev;
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
