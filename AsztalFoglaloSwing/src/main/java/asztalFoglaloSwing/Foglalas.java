package asztalFoglaloSwing;

import java.time.*;
import java.time.format.DateTimeParseException;

public class Foglalas implements iDateFormatting{
    private String foglalas_nev, foglalas_telszam;
    private int foglalas_id, foglalas_csoport_meret;
    private LocalDateTime foglalas_idopont_kezd, foglalas_idopont_veg;
    private Asztal asztal;

    public Foglalas(int foglalas_id, String foglalas_nev, String foglalas_telszam, int foglalas_csoport_meret, Asztal asztal, String formattedIdopontKezd, String formattedIdopontVeg) throws IllegalArgumentException, DateTimeParseException {   
        this.setFoglalas_id(foglalas_id);
        this.setFoglalas_nev(foglalas_nev);
        this.setFoglalas_telszam(foglalas_telszam);
        this.setAsztal(asztal);
        this.setFoglalas_csoport_meret(foglalas_csoport_meret);
        this.setFoglalas_idopont_kezd(LocalDateTime.parse(formattedIdopontKezd, FULLDATETIME));
        this.setFoglalas_idopont_veg(LocalDateTime.parse(formattedIdopontVeg, FULLDATETIME));
    }

    public int getFoglalas_id() {
        return foglalas_id;
    }

    public void setFoglalas_id(int foglalas_id) {
        this.foglalas_id = foglalas_id;
    }
    

    public String getFoglalas_nev() {
        return foglalas_nev;
    }

    public void setFoglalas_nev(String foglalas_nev) {
        this.foglalas_nev = foglalas_nev;
    }

    public String getFoglalas_telszam() {
        return foglalas_telszam;
    }

    public void setFoglalas_telszam(String foglalas_telszam) {
        this.foglalas_telszam = foglalas_telszam;
    }
    
    public int getFoglalas_csoport_meret() {
        return foglalas_csoport_meret;
    }

    public void setFoglalas_csoport_meret(int emberszam) throws IllegalArgumentException{
        int asztalKapacitas = asztal.getTipus().getTipus_ferohely();
        if (emberszam<1){
            throw new IllegalArgumentException("A csoport mérete nem lehet kisebb mint 1!");
        }else if(emberszam>asztalKapacitas){
            throw new IllegalArgumentException("A csoport mérete nem lehet nagyobb mint az asztal kapacitása!");
        }
        this.foglalas_csoport_meret = emberszam;
    }

    public Asztal getAsztal() {
        return asztal;
    }

    public void setAsztal(Asztal asztal) {
        this.asztal = asztal;
    }

    public String getIdopontKezdString(boolean withSeconds) {
        String idopont= FULLDATETIME.format(foglalas_idopont_kezd);
        if (withSeconds) {
            return idopont;
        }
        return idopont.substring(0,idopont.length()-3);
    }

    public LocalDateTime getFoglalas_idopont_kezd() {
        return foglalas_idopont_kezd;
    }
    
    public void setFoglalas_idopont_kezd(LocalDateTime foglalas_idopont_kezd){
        this.foglalas_idopont_kezd = foglalas_idopont_kezd;
    }
    
    public String getIdopontVegString(boolean withSeconds) {
        String idopont= FULLDATETIME.format(foglalas_idopont_veg);
        if (withSeconds) {
            return idopont;
        }
        return idopont.substring(0,idopont.length()-3);
    }
    
    public LocalDateTime getFoglalas_idopont_veg() {
        return foglalas_idopont_veg;
    }

    public void setFoglalas_idopont_veg(LocalDateTime foglalas_idopont_veg){
        this.foglalas_idopont_veg = foglalas_idopont_veg;
    }
    
    public String getIdoIntervallumString(){
        return ""+this.getIdopontKezdString(false)+" - "+(this.getFoglalas_idopont_veg().getHour()<10?"0"+this.getFoglalas_idopont_veg().getHour():this.getFoglalas_idopont_veg().getHour())+":"+(this.getFoglalas_idopont_veg().getMinute()<10?"0"+this.getFoglalas_idopont_veg().getMinute():this.getFoglalas_idopont_veg().getMinute());
    }
    
    

    @Override
    public String toString() {
        return this.getFoglalas_nev()+" "+this.getIdoIntervallumString();
    }
}
