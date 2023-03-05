package org.asa.offers;

import org.asa.enums.Fruit;

import java.util.Map;

public class ThreeForPriceOfTwo implements Offers {

    @Override
    public int applyOffer(Map<Fruit, Integer> cartMap, int preDiscountAmount, Fruit fruit) {
        int orangeCount = cartMap.get(fruit);
        return preDiscountAmount - orangeCount/3 * fruit.getPrice();
    }
}
