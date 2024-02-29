package asztalFoglaloSwing;

import java.time.*;
import java.time.format.DateTimeParseException;

public class Foglalas implements iDateFormatting{
    private String foglaloNev, foglaloTSzam;
    private int emberSzam;
    private LocalDateTime idopontKezd, idopontVeg;
    private Asztal asztal;

    public Foglalas(String foglaloNev, String foglaloTSzam, Asztal asztal,int emberSzam, String formattedIdopontKezd, String formattedIdopontVeg) throws OldDateException, IllegalArgumentException, InvalidTimeException
    {   this.setFoglaloNev(foglaloNev);
        this.setFoglaloTSzam(foglaloTSzam);
        this.setAsztal(asztal);
        this.setEmberSzam(emberSzam);
        this.setIdopontKezd(LocalDateTime.parse(formattedIdopontKezd, dtf));
        this.setIdopontVeg(LocalDateTime.parse(formattedIdopontVeg, dtf));
    }

    public int getEmberSzam() {
        return emberSzam;
    }

    public void setEmberSzam(int emberszam) throws IllegalArgumentException{
        int asztalKapacitas = asztal.getKapacitas();
        if (emberszam<1){
            throw new IllegalArgumentException("A csoport mérete nem lehet kisebb mint 1!");
        }else if(emberszam>asztalKapacitas){
            throw new IllegalArgumentException("A csoport mérete nem lehet nagyobb mint az asztal kapacitása: "+asztalKapacitas+" fő!");
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

    public Asztal getAsztal() {
        return asztal;
    }

    public void setAsztal(Asztal asztal) {
        this.asztal = asztal;
    }

    public String getIdopontKezdString() {
        return dtf.format(idopontKezd);
    }

    public LocalDateTime getIdopontKezd() {
        return idopontKezd;
    }
    
    public void setIdopontKezd(LocalDateTime idopontKezd) throws OldDateException{
        if (idopontKezd.isBefore(LocalDateTime.now())){
            throw new OldDateException("Egy múltbéli dátumra nem lehet foglalni!");
        }
        this.idopontKezd = idopontKezd;
    }
    
    public String getIdopontVegString() {
        return dtf.format(idopontVeg);
    }
    
    public LocalDateTime getIdopontVeg() {
        return idopontVeg;
    }

    public void setIdopontVeg(LocalDateTime idopontVeg) throws OldDateException{
        if (idopontVeg.isBefore(this.getIdopontKezd())){
            throw new OldDateException("Az időpontnak nem lehet vége mielőtt elkezdődik!");
        }
        this.idopontVeg = idopontVeg;
    }
    
    public String getIdoIntervallumString(){
        return ""+this.getIdopontKezdString()+" - "+this.getIdopontVeg().getHour()+":"+this.getIdopontVeg().getMinute()+":00";
    }

    @Override
    public String toString() {
        return this.getFoglaloNev()+" "+this.getIdoIntervallumString();
    }
}
