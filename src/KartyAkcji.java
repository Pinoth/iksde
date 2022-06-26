import java.util.Random;

public class KartyAkcji extends Karta{
    char type;

    public KartyAkcji() {
        char[] types = new char[] {'w','k','l'}; //tablica typów kart (wózek, kilof, lampa)
        int WylosowanyTyp = new Random().nextInt(types.length);
        this.type = types[WylosowanyTyp];

    }
}
