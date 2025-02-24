package hu.szamalk.models;
//
import java.util.*;

public class Gyujtemeny {
    private int ferohely;
    private Media[] medias;

    public Gyujtemeny(){
        ferohely = 5;
        medias = new Media[ferohely];
    }

    private boolean isNemUgyanOlyan(Media media){
        boolean both = true;
        for(int i = 0; i < medias.length && both; i++){
            if(medias[i] != null) both = !medias[i].equals(media);
        }
        return both;
    }

    public Media doMediaEladas(int hanyadik){
        Media media = null;
        boolean both = hanyadik < 5 && hanyadik >= 0 && medias[hanyadik] != null;
        if(both){
            Media[] copyedMedia = Arrays.copyOf(medias, medias.length);
            ferohely--;
            media = copyedMedia[hanyadik];
        }
        return media;
    }

    public boolean doMediaVetel(Media media){
        boolean both = !isNemUgyanOlyan(media) && media == null;
        for(int i = 0; i < medias.length && !both; i++){
            both = medias[i] == null;
            medias[i] = both ? media : medias[i];
            ferohely += both ? 1 : 0;
        }
        return both;
    }

    private void doElore(){
        for (int i = 0; i < medias.length - 1; i++){
            if(medias[i] == null){
                boolean both = false;
                for (int j = i+1; j<medias.length && !both; j++){
                    both = medias[j] != null;
                    medias[i] = both ? medias[j] : null;
                }
            }
        }
    }
    public Media[] getMediak(){
        doElore();
        int i = 0;
        for (; i<medias.length; i++){
            if( medias[i] != null){
                break;
            }
        }
        return Arrays.copyOf(medias, i);
    }

    public void Rendezes(Mezo mezo){
        Media media;
        doElore();
        switch (mezo){
            case CIM:
                while(!Rendezett(mezo)){
                    for (int i = 0; i < medias.length - 1 && medias[i+1] != null; i++){
                        if(medias[i].getCim().charAt(0) > medias[i+1].getCim().charAt(0)){
                            media = medias[i];
                            medias[i] = medias[i+1];
                            medias[i+1] = media;
                        }
                    }
                }
                break;
            case SZERZO:
                while(!Rendezett(mezo)){
                    for (int i = 0; i < medias.length - 1 && medias[i+1] != null; i++){
                        if(medias[i].getSzerzo().charAt(0) > medias[i+1].getSzerzo().charAt(0)){
                            media = medias[i];
                            medias[i] = medias[i+1];
                            medias[i+1] = media;
                        }
                    }
                }
                break;
            case KIADAS:
                while(!Rendezett(mezo)){
                    for (int i = 0; i < medias.length - 1 && medias[i+1] != null; i++){
                        if(medias[i].getKiadasiEv() > medias[i+1].getKiadasiEv()){
                            media = medias[i];
                            medias[i] = medias[i+1];
                            medias[i+1] = media;
                        }
                    }
                }
                break;
        }
    }

    public boolean Rendezett(Mezo mezo){
        boolean both = true;
        doElore();
        switch (mezo){
            case CIM:
                for (int i = 0; i < medias.length - 1 && medias[i+1] != null && both; i++){
                    both = medias[i].getCim().charAt(0) > medias[i+1].getCim().charAt(0);
                }
                break;
            case SZERZO:
                for (int i = 0; i < medias.length - 1 && medias[i+1] != null && both; i++){
                    both = medias[i].getSzerzo().charAt(0) > medias[i+1].getSzerzo().charAt(0);
                }
                break;
            case KIADAS:
                for (int i = 0; i < medias.length - 1 && medias[i+1] != null && both; i++){
                    both = medias[i].getKiadasiEv() > medias[i+1].getKiadasiEv();
                }
                break;
        }
        return both;
    }

    public int getFerohely(){
        return ferohely;
    }

    public enum Mezo{
        CIM, SZERZO, KIADAS
    }
}
