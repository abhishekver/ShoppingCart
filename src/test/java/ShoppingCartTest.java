import org.asa.enums.Fruit;
import org.asa.enums.Offer;
import org.asa.services.CheckoutService;
import org.asa.services.CheckoutServiceImpl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ShoppingCartTest {

    CheckoutService checkoutService;

    @Before
    public void setUp() {
        checkoutService = new CheckoutServiceImpl();
    }

    @Test
    public void testBasic() {
        List<Fruit> fruits = Arrays.asList(Fruit.APPLE, Fruit.ORANGE, Fruit.ORANGE, Fruit.ORANGE, Fruit.APPLE);
        int amount = checkoutService.getCheckoutAmount(fruits);
        Assert.assertEquals(195, amount);
    }

    @Test
    public void testWithOffers() {
        List<Fruit> fruits = Arrays.asList(Fruit.APPLE, Fruit.ORANGE, Fruit.ORANGE, Fruit.ORANGE, Fruit.APPLE,
                Fruit.APPLE, Fruit.ORANGE, Fruit.ORANGE, Fruit.ORANGE, Fruit.APPLE, Fruit.ORANGE);
        Map<Fruit, Offer> offerMap = new HashMap<>();
        offerMap.put(Fruit.APPLE, Offer.BUY_ONE_GET_ONE);
        offerMap.put(Fruit.ORANGE, Offer.THREE_FOR_PRICE_OF_TWO);
        int amount = checkoutService.getCheckoutAmount(fruits, offerMap);
        Assert.assertEquals(245, amount);
    }


}
