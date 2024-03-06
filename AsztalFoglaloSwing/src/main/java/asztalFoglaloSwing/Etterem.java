package asztalFoglaloSwing;

public class Etterem {
    String nev;
    int id;

    public Etterem(String nev, int id) {
        this.setNev(nev);
        this.setId(id);
    }

    public String getNev() {
        return nev;
    }

    private void setNev(String nev) {
        this.nev = nev;
    }

    public int getId() {
        return id;
    }

    private void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return this.getNev();
    }
    
    
}

