package U7FreeResponse;

public class StockItem {
    private String name;
    private int idnum;
    private double price;
    private int numOnShelf;

    public StockItem(String n, int id, double p, int num) {
        name = n;
        idnum = id;
        price = p;
        numOnShelf = num;
    }

    public int getNumOnShelf() {
        return numOnShelf;
    }

    public double getPrice() {
        return price;
    }

    public int getIdnum() {
        return idnum;
    }

    public String getName() {
        return name;
    }

    public void setPrice(double p) {
        price = p;
    }

    public void remove(int n) {
        numOnShelf -= n > numOnShelf ? numOnShelf : n;
    }

    public void add(int n) {
        numOnShelf += n;
    }

    public String toString() {
        if (name.length() >= 8)
            return (idnum + "\t" + name + "\t$" + price + "\t" + numOnShelf);
        else
            return (idnum + "\t" + name + "\t\t$" + price + "\t" + numOnShelf);
    }
}
