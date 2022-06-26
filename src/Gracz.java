import java.util.ArrayList;

public class Gracz {
    int IleKart = 6;
    int IleBarylek;
    int KartyNaRece = 6;
    String Role = "kopacz";
    ArrayList<Karta> Reka = new ArrayList<Karta>(); //dynamiczna ilość kart gracza (ręka)
   public int Wiek;

    public void DodajKarte(Karta karta){
        Reka.add(karta);
    }
    public void WymienKarte() {
        System.out.print("Wymien Karte");
    }

    public void ZagrajKarteTunelu() {
        System.out.print("Zagraj Karte Tunelu");
    }

    public void ZagrajKarteAkcji() {
        System.out.print("Zagraj Karte Akcji");
    }
}
