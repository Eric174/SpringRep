import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Application {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(UserConfiguration.class);
        UserService userService = context.getBean("userService", UserService.class);
        userService.printAllUsers();

        ShopBasket basket = context.getBean("shopBasket", ShopBasket.class);
        basket.printInfo();
    }
}
