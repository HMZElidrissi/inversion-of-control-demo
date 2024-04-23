package pres;

import dao.DaoImpl;
import metier.MetierImpl;

public class PresentationV1 {
    public static void main(String[] args) {
        /**
         * Injection des dépendances par instanciation statiqueb => new
         */
        DaoImpl d = new DaoImpl();
        MetierImpl metier = new MetierImpl(d); // Injection des dépendances via le constructeur
        // metier.setDao(d); // Injection via le setter
        System.out.println("RES = " + metier.calcul());

    }
}
