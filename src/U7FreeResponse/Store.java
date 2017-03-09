package U7FreeResponse;

import java.util.ArrayList;

public class Store {
    private ArrayList<StockItem> myStockList;

    public Store() {
        myStockList = new ArrayList<>();
    }

    public void add(StockItem s) {
        myStockList.add(s);
    }

    public double removeAll(int idnum) {
        double product = 1;
        int removed = 0;
        for (int i = 0; i < myStockList.size(); i++) {
            StockItem item = myStockList.get(i);
            if (item.getIdnum() == idnum) {
                myStockList.remove(i);
                product *= item.getPrice();
                removed++;
            }
        }
        return product * removed;
    }

    public void replace(StockItem x, StockItem y) {
        int size = myStockList.size();
        for (int i = 0; i < size; i++) {
            StockItem item = myStockList.get(i);
            if (item.getIdnum() == x.getIdnum()) {
                myStockList.set(i, y);
                break;
            }
        }
    }

    public void list() {
        System.out.println("ID\tName\t\tPrice\tQuantity");
        System.out.println("--\t----\t\t-----\t--------");

        int size = myStockList.size();
        for (int i = 0; i < size; i++) {
            System.out.println(myStockList.get(i));
        }
    }
}
