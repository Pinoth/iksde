public class Rozgrywka {
    int Runda = 0;
    int LiczbaGraczy = 3;
    Gracz ZaczynającyGracz;
    int KartywTalii;

    public void WylosujRoleGracza() {
        System.out.print("Losuje role gracza");
    }
    public void RozłóżKartyCelu() {
        System.out.print("RozłóżKartyCelu");
        }
    public void PołóżKartęDrabinę() {
        System.out.print("PołóżKartęDrabina\n");
    }

    public void drukujStatusPlanszy(Karta[][] SiatkaGry, int wymiar) {
        for(int i = 0; i < wymiar; i++) { //drukowanie macierzy (1w - wszystkie kolumny, 2w - wszystkie kolumny)
            for(int j = 0; j < wymiar; j++) {
                if (SiatkaGry[i][j] == null) {
                    System.out.print("o");
                }
                else{
                    System.out.print("x");
                }
            }
            System.out.println();
        }
    }
}
