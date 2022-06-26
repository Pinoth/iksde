import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class iksde {
    public static void main(String[] args){

        System.out.print("Zaczynamy rozgrywkę\n");
        Random generator = new Random();

        Rozgrywka MojaGra = new Rozgrywka(); //pozwala korzystać z metody rozgrywka
        MojaGra.PołóżKartęDrabinę();

        Gracz Pierwszy = new Gracz();
        Gracz Drugi = new Gracz();
        Gracz Trzeci = new Gracz();
        Gracz[] Gracze = new Gracz[] {Pierwszy, Drugi, Trzeci};

        Pierwszy.Wiek = generator.nextInt((90 - 10) + 1) + 10; //losowanie liczby 90-10
        Drugi.Wiek = generator.nextInt((90 - 10) + 1) + 10; //losowanie liczby 90-10
        Trzeci.Wiek = generator.nextInt((90 - 10) + 1) + 10; //losowanie liczby 90-10

        Gracz NajmlodszyGracz = null;

        for (Gracz g : Gracze) {
            System.out.println(g.Wiek);

            if (NajmlodszyGracz == null){
                NajmlodszyGracz = g; //testujemy pierwszy obiekt pętli - brak porównania
            }
            else {
                if (g.Wiek < NajmlodszyGracz.Wiek){
                    NajmlodszyGracz = g; //jeżeli bierzący gracz w tym obiegu pętli jest młodszy niż dotychczasowy najmł. to zamień
                }
            }

        }
        System.out.print("Wykryty najmłodszy gracz:");
        System.out.println(NajmlodszyGracz.Wiek);
        MojaGra.ZaczynającyGracz = NajmlodszyGracz;
        int WylosowanySabotarzysta = new Random().nextInt(Gracze.length);
        System.out.print("Wylosowany Gracz:");
        System.out.println(WylosowanySabotarzysta);
        Gracze[WylosowanySabotarzysta].Role = "Sabotarzysta";

       // Karta[] Talia = new Karta[67];
        ArrayList<Karta> Talia = new ArrayList<Karta>(); //tablica o dynamycznej długości
        KartaCelu[] KartyCelu = new KartaCelu[3];
        KartazDrabina KartaPoczatkowa = new KartazDrabina();


        for(int i=0; i<40; i++){ //tworzenie 40 kart tunelu
            Talia.add(new KartaTunelu());
        }

        for(int i=0; i<27; i++) { //tworzenie 27 kart akcji
            Talia.add(new KartyAkcji());
        }
        Collections.shuffle(Talia); //mieszanie talii (tasowanie)
        for(int i=0; i<3; i++){ //tworzenie 3 kart celu
            KartyCelu[i] = new KartaCelu();
        }

        int WylosowanaKartaCelu = new Random().nextInt(KartyCelu.length);
        KartyCelu[WylosowanaKartaCelu].maBarylke = true;

        int wymiar = 50;
        int srodek = wymiar/2;
        Karta[][] SiatkaGry = new Karta[wymiar][wymiar]; //tworzenie planszy 100x100
        SiatkaGry[srodek][srodek] = KartaPoczatkowa;
        SiatkaGry[srodek][srodek+8] = KartaPoczatkowa;
        SiatkaGry[srodek+2][srodek+8] = KartaPoczatkowa;
        SiatkaGry[srodek+-2][srodek+8] = KartaPoczatkowa;

        int index = Talia.size() - 1;
        Talia.remove(index);

        for (Gracz g : Gracze) {
            int i;
            for (i=0; i<6; i++) {
                g.DodajKarte(Talia.remove(Talia.size()-1));
            }
        }

        MojaGra.drukujStatusPlanszy(SiatkaGry, wymiar); //drukowanie planszy
        System.out.println("Aktualny Status Graczy");

        int i = 0;
        for (Gracz g : Gracze){
            i++;
            System.out.println(i);
            System.out.print("Ilość kart: ");
            System.out.println(g.Reka.size());
            System.out.println("Jakie karty: ");

            for (Karta k :g.Reka ) {    //drukowanie wszystkich kart z ręki gracza
                if (k.getClass() == KartyAkcji.class){ //spr czy akcja
                    System.out.print("Posiadam kartę akcji: ");
                    System.out.println(((KartyAkcji) k).type);
                }
                if (k.getClass() == KartaTunelu.class){ // spr czy tunel
                    System.out.println("Posiadam kartę tunelu: ");
                    System.out.print("North: ");
                    System.out.println(((KartaTunelu) k).North);
                    System.out.print("East: ");
                    System.out.println(((KartaTunelu) k).East);
                    System.out.print("South: ");
                    System.out.println(((KartaTunelu) k).South);
                    System.out.print("West: ");
                    System.out.println(((KartaTunelu) k).West);
                }
            }
        }

    }

}
