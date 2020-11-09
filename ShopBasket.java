import java.util.ArrayList;
import java.util.List;

public class ShopBasket {
    private User user;
    private List<Product> productList = new ArrayList<>();

    public void setUser(User user) {
        this.user = user;
    }

    public String getUser() {
        return user.toString();
    }

    public void addProduct(Product product) {
        this.productList.add(product);
    }
    
    public String getProducts() {
        String str = "";
        for (Product p : productList) {
            str = str + p.toString() + " ";
        }
        return str;
    }

    public void printInfo() {
        System.out.println(getUser() + ":\n" + getProducts());
    }
}
