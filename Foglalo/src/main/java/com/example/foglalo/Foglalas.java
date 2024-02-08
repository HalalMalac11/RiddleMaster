package com.example.foglalo;

import java.time.*;
import java.time.format.DateTimeParseException;

public class Foglalas implements iDateFormatting{
    private String foglaloNev, foglaloTSzam;
    private int asztalId, emberSzam;
    private LocalDateTime idopont;

    public Foglalas(String foglaloNev, String foglaloTSzam,int emberSzam, int asztalId, String formattedIdopont) throws OldDateException, IllegalArgumentException, InvalidTimeException
    {   this.setFoglaloNev(foglaloNev);
        this.setFoglaloTSzam(foglaloTSzam);
        this.setEmberSzam(emberSzam);
        this.setAsztalId(asztalId);
        this.setIdopont(LocalDateTime.parse(formattedIdopont, dtf));
    }

    public int getEmberSzam() {
        return emberSzam;
    }

    public void setEmberSzam(int emberszam) throws IllegalArgumentException{
        if (emberszam<1){
            throw new IllegalArgumentException("Az fők száma nem lehet kisebb mint 1!");
        }
        this.emberSzam = emberszam;
    }

    public String getFoglaloNev() {
        return foglaloNev;
    }

    public void setFoglaloNev(String foglaloNev) {
        this.foglaloNev = foglaloNev;
    }

    public String getFoglaloTSzam() {
        return foglaloTSzam;
    }

    public void setFoglaloTSzam(String foglaloTSzam) {
        this.foglaloTSzam = foglaloTSzam;
    }

    public int getAsztalId() {
        return asztalId;
    }

    public void setAsztalId(int asztalId) {
        this.asztalId = asztalId;
    }

    public String getIdopont() {
        return dtf.format(idopont);
    }

    public void setIdopont(LocalDateTime idopont) throws OldDateException,InvalidTimeException{
        if (idopont.isBefore(LocalDateTime.now())){
            throw new OldDateException("Egy múltbéli dátumra nem lehet foglalni!");
        }
        this.idopont = idopont;
    }

    @Override
    public String toString() {
        return "Foglalas{" +
                "foglaloNev='" + this.getFoglaloNev() + '\'' +
                ", foglaloTSzam='" + this.getFoglaloTSzam() + '\'' +
                ", asztalId=" + this.getAsztalId() +
                ", idopont=" + this.getIdopont() +
                '}';
    }
}
