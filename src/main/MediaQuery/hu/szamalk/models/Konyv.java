package hu.szamalk.models;

import java.util.Objects;

public class Konyv{
    String cim;
    String szerzo;
    int kiadasiEv;

    public Konyv(String cim, String szerzo, int kiadasiEv) throws NemLetezoKonyvException {
        this.cim = cim;
        this.szerzo = szerzo;
        this.kiadasiEv = kiadasiEv;

        if(cim.length() < 6) throw new NemLetezoKonyvException();
    }

    public String getCim() {
        return cim;
    }

    public void setCim(String cim) {
        this.cim = cim;
    }

    public String getSzerzo() {
        return szerzo;
    }

    public void setSzerzo(String szerzo) {
        this.szerzo = szerzo;
    }

    public int getKiadasiEv() {
        return kiadasiEv;
    }

    public void setKiadasiEv(int kiadasiEv) {
        this.kiadasiEv = kiadasiEv;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Konyv konyv = (Konyv) o;
        return Objects.equals(cim, konyv.cim) && Objects.equals(szerzo, konyv.szerzo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cim, szerzo);
    }
}
