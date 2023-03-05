package org.asa.offers;

import org.asa.enums.Fruit;

import java.util.Map;

@FunctionalInterface
public interface Offers {

    int applyOffer(Map<Fruit, Integer> cartMap, int preDiscountAmount, Fruit fruit);

}
