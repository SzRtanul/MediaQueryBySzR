package hu.szamalk.models;

import java.util.*;

public class Gyujtemeny {
    int ferohely;
    Media[] medias;

    public Gyujtemeny(){
        ferohely = 5;
        medias = new Media[ferohely];
    }

    public Media doMediaVetel(int hanyadik){
        Media media = null;
        boolean both = hanyadik < 5 && hanyadik >= 0 && medias[hanyadik] != null;
        if(both){
            Media[] copyedMedia = Arrays.copyOf(medias, medias.length);
            ferohely--;
            media = copyedMedia[hanyadik];
        }
        return media;
    }

    public boolean doMediaEladas(Media media){
        boolean both = false;
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

    public void Rendezes(Mezo mezo){
        Media media;
        doElore();
        switch (mezo){
            case CIM:
                while(!Rendezett(mezo)){
                    for (int i = 0; i < medias.length - 1 && medias[i+1] != null; i++){
                        if(medias[i].cim.charAt(0) > medias[i+1].cim.charAt(0)){
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
                        if(medias[i].szerzo.charAt(0) > medias[i+1].szerzo.charAt(0)){
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
                        if(medias[i].kiadasiEv > medias[i+1].kiadasiEv){
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
        for (int i = 0; i < medias.length - 1 && medias[i+1] != null && both; i++){
            both = medias[i].cim.charAt(0) > medias[i+1].cim.charAt(0);
        }
        switch (mezo){
            case CIM:
                for (int i = 0; i < medias.length - 1 && medias[i+1] != null && both; i++){
                    both = medias[i].cim.charAt(0) > medias[i+1].cim.charAt(0);
                }
                break;
            case SZERZO:
                for (int i = 0; i < medias.length - 1 && medias[i+1] != null && both; i++){
                    both = medias[i].szerzo.charAt(0) > medias[i+1].szerzo.charAt(0);
                }
                break;
            case KIADAS:
                for (int i = 0; i < medias.length - 1 && medias[i+1] != null && both; i++){
                    both = medias[i].kiadasiEv > medias[i+1].kiadasiEv;
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
