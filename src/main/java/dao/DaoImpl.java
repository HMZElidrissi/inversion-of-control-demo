package dao;

public class DaoImpl implements IDao {
    @Override
    public double getData() {
        System.out.println("Getting data from DaoImpl");
        double temp = 23.0;
        return temp;
    }
}
