package pres;

import dao.IDao;
import metier.IMetier;

import java.io.File;
import java.io.FileNotFoundException;
import java.lang.reflect.Method;
import java.util.Scanner;

public class PresentationV2 {
    public static void main(String[] args)  {
        try {
            Scanner scanner = new Scanner(new File("config.txt"));
            // DaoImpl d = new DaoImpl();
            String daoClassName = scanner.nextLine();
            Class cDao = Class.forName(daoClassName);
            IDao dao = (IDao) cDao.getConstructor().newInstance();

            // MetierImpl metier = new MetierImpl(d);
            String metierClassnme = scanner.nextLine();
            Class cMetier = Class.forName(metierClassnme);
            IMetier metier = (IMetier) cMetier.getConstructor().newInstance();

            // metier.setDao(d);
            Method setDao  = cMetier.getDeclaredMethod("setDao", IDao.class);
            setDao.invoke(metier, dao);

            System.out.println("RES="+metier.calcul());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
