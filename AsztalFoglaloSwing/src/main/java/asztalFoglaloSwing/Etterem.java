package asztalFoglaloSwing;

import java.time.LocalTime;


public class Etterem {
    private String nev;
    private int id;
    private String[][] nyitvatartas;

    public Etterem(String nev, int id, String[][] nyitvatartas) {
        this.setNev(nev);
        this.setId(id);
        this.setNyitvatartas(nyitvatartas);
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

    public String[][] getNyitvatartas() {
        return nyitvatartas;
    }

    public void setNyitvatartas(String[][] nyitvatartas) {
        this.nyitvatartas = nyitvatartas;
    }

    @Override
    public String toString() {
        return this.getNev();
    }
    
    
}

