package org.asa.services;

import org.asa.enums.Fruit;
import org.asa.enums.Offer;
import org.asa.offers.BuyOneGetOne;
import org.asa.offers.Offers;
import org.asa.offers.ThreeForPriceOfTwo;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

public class CheckoutServiceImpl implements CheckoutService {

    private final Map<Offer, Offers> offersMap;

    public CheckoutServiceImpl() {
        offersMap = new HashMap<>();
        offersMap.put(Offer.BUY_ONE_GET_ONE, new BuyOneGetOne());
        offersMap.put(Offer.THREE_FOR_PRICE_OF_TWO, new ThreeForPriceOfTwo());
    }

    @Override
    public int getCheckoutAmount(List<Fruit> fruits) {
        return getCheckoutAmount(getCartMap(fruits));
    }

    private int getCheckoutAmount(Map<Fruit, Integer> cartMap) {
        AtomicInteger amount = new AtomicInteger();
        cartMap.forEach((fruit, quantity) -> amount.addAndGet(fruit.getPrice() * quantity));
        return amount.get();
    }

    @Override
    public int getCheckoutAmount(List<Fruit> fruits, Map<Fruit, Offer> offers) {

        Map<Fruit, Integer> cartMap = getCartMap(fruits);
        int amount = getCheckoutAmount(cartMap);
        return applyOffers(cartMap, offers, amount);
    }

    private Map<Fruit, Integer> getCartMap(List<Fruit> fruits) {

        Map<Fruit, Integer> cartMap = new HashMap<>();
        fruits.forEach(fruit -> {
            cartMap.merge(fruit, 1, Integer::sum);
        });

        return cartMap;
    }

    private int applyOffers(Map<Fruit, Integer> cartMap, Map<Fruit, Offer> offers, int amount) {

        for (Fruit fruit: offers.keySet()) {
            Offer offer = offers.get(fruit);
            amount = offersMap.get(offer).applyOffer(cartMap, amount, fruit);
        }

        return amount;
    }
}
