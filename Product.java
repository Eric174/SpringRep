package mvc;

public class Product {
    private static int id_class = 0;
    private int id;
    private String title;
    private int cost;

    public Product(String title, int cost) {
        id = id_class++;
        this.title = title;
        this.cost = cost;
    }

    public static int getMaxId() {
        return id_class;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public static void setId_class(int val) {
        Product.id_class = val;
    }

    public String getTitle() {
        return title;
    }

    public int getCost() {
        return cost;
    }
}
