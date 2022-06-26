import java.util.Random;

public class KartaPola extends Karta{
    boolean North;
    boolean East;
    boolean South;
    boolean West;

    public KartaPola() { //konstruktor - wykonywany za każdym razem jak pojawia się nowy obiekt
        Random generator = new Random();
        this.North = generator.nextBoolean();
        this.East = generator.nextBoolean();
        this.South = generator.nextBoolean();
        this.West = generator.nextBoolean();
    }
}

