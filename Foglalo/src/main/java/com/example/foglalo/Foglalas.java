package com.example.foglalo;

import java.time.*;

public class Foglalas implements iDateFormatting{
    private String foglaloNev, foglaloTSzam;
    private int asztalId;
    private LocalDateTime idopont;

    public Foglalas(String foglaloNev, String foglaloTSzam, int asztalId, String formattedIdopont) throws OldDateException
    {   this.setFoglaloNev(foglaloNev);
        this.setFoglaloTSzam(foglaloTSzam);
        this.setAsztalId(asztalId);
        this.setIdopont(LocalDateTime.parse(formattedIdopont, dtf));
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

    public void setIdopont(LocalDateTime idopont) throws OldDateException{
        if (idopont.isBefore(LocalDateTime.now())){
            throw new OldDateException("A past date can't be set as reservation!");
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
