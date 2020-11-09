import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope(value = "prototype")
public class Product {
    @Value("None")
    String name;
    @Value("0")
    int cost;

    @Override
    public String toString() {
        return "Product: " + name + " cost = " + cost;
    }
}
