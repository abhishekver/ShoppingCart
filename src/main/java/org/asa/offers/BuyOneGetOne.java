package org.asa.offers;

import org.asa.enums.Fruit;

import java.util.Map;

public class BuyOneGetOne implements Offers {

    @Override
    public int applyOffer(Map<Fruit, Integer> cartMap, int preDiscountAmount, Fruit fruit) {
        int appleCount = cartMap.get(fruit);
        return preDiscountAmount - appleCount/2 * fruit.getPrice();
    }
}
