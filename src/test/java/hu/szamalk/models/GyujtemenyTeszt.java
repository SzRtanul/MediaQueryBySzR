package hu.szamalk.models;
//
public class GyujtemenyTeszt {
    String[][] konyvek = new String[][]{
            {"Grow","12 Parnacs","1986"},
            {"Draw","A Grokaku ékköve","1985"},
            {"Draw Grow","Valami random","1987"},
            {"Grow","Ez nagyon szép lehetett","1999"},
            {"Growi","Szerintem ez különleges","100"},
            {"Grows","My Ego","2022"}
    };

    public void isNincsEgyforma(){
        Gyujtemeny gyujtemeny = new Gyujtemeny();
    }

    public void isNemTobb5nel(){
        Gyujtemeny gyujtemeny = new Gyujtemeny();
        try {
            for(int i = 0; i < konyvek.length; i++){
                gyujtemeny.doMediaVetel(new Media(new Konyv(konyvek[i][0], konyvek[i][1], Integer.parseInt(konyvek[i][2])), 13, new Kategoria("sdf")));
            }
        }catch (NemLetezoKonyvException e){

        }
    }
}
