package hu.szamalk.models;

import java.beans.JavaBean;
import java.io.Serializable;
import java.util.UUID;

public class Media extends Konyv implements Serializable {
    private UUID id;
    private int ar;
    private Kategoria kategoria;

    public Media(Konyv konyv, int ar, Kategoria kategoria) throws NemLetezoKonyvException {
        super(konyv.getCim(), konyv.getSzerzo(), konyv.getKiadasiEv());
        this.id = new UUID(Long.MIN_VALUE, Long.MAX_VALUE);
        this.ar = ar;
        this.kategoria = kategoria;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public int getAr() {
        return ar;
    }

    public void setAr(int ar) {
        this.ar = ar;
    }

    public Kategoria getKategoria() {
        return kategoria;
    }

    public void setKategoria(Kategoria kategoria) {
        this.kategoria = new Kategoria(kategoria.getLeiras());
    }

    public Media Clone(){
        Media media = null;
        try {
            media = new Media(new Konyv(getCim(), getSzerzo(), getKiadasiEv()), ar, kategoria);
        } catch (NemLetezoKonyvException e) {
            return null;
        }
        return media;
    }
}
