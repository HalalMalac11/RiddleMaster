package com.example.foglalo;

import java.time.*;
import java.time.format.*;

public class Foglalas implements iDateFormatting{
    private String foglaloNev, foglaloTSzam;
    private int asztalId;
    private LocalDateTime idopont;

    public Foglalas(String foglaloNev, String foglaloTSzam, int asztalId, String formattedIdopont)
    {   this.foglaloNev = foglaloNev;
        this.foglaloTSzam = foglaloTSzam;
        this.asztalId = asztalId;
        this.idopont = LocalDateTime.parse(formattedIdopont, dtf);
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

    public LocalDateTime getIdopont() {
        return idopont;
    }

    public void setIdopont(LocalDateTime idopont) {
        this.idopont = idopont;
    }

}
