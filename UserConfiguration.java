import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan()
public class UserConfiguration {
    @Bean
    public ShopBasket shopBasket() {
        ShopBasket basket = new ShopBasket();
        basket.setUser(new User(30, "Butters"));
        basket.addProduct(new Product());
        basket.addProduct(new Product());
        return basket;
    }
}