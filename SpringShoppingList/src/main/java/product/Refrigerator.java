package product;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.*;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;

@Component
@Lazy
public class Refrigerator {

    @Autowired
    private ApplicationContext context;
    private Map<String, FoodItem> nameToProduct;
    private Map<String, Map.Entry<List<FoodItem>, Integer>> productToActualToExpectedCount;

    @Autowired
    public Refrigerator(Map<String, FoodItem> nameToProduct) {
        this.nameToProduct=nameToProduct;
    }

    public void fillIntInfo() {
        this.productToActualToExpectedCount = new HashMap<>();
        System.out.println("Для каждого типа продукта введите желаемое количество продуктов: ");
        Scanner scanner = new Scanner(System.in);
        nameToProduct.forEach((k, v) -> {
            System.out.print(k + ":");
            int count = scanner.nextInt();
            productToActualToExpectedCount.put(k, new AbstractMap.SimpleEntry<>(generateItems(k), count));
        });
    }

    private List<FoodItem> generateItems(String name){
        int random = ThreadLocalRandom.current().nextInt(10);
        return Arrays.stream(new Object[random])
                .map(e-> context.getBean(name, FoodItem.class))
                .collect(Collectors.toList());
    }

    public Map<String, Map.Entry<List<FoodItem>, Integer>> getProductToActualToExpectedCount() {
        return productToActualToExpectedCount;
    }
}
