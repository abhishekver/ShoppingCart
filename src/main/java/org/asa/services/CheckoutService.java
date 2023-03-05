package org.asa.services;

import org.asa.enums.Fruit;
import org.asa.enums.Offer;
import org.asa.offers.Offers;

import java.util.List;
import java.util.Map;

public interface CheckoutService {

    int getCheckoutAmount(List<Fruit> fruits);

    int getCheckoutAmount(List<Fruit> fruits, Map<Fruit, Offer> offers);

}
