package org.asa;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.asa.models.Input;
import org.asa.services.CheckoutService;
import org.asa.services.CheckoutServiceImpl;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {

        ObjectMapper objectMapper = new ObjectMapper();
        CheckoutService checkoutService = new CheckoutServiceImpl();

        String content = new Scanner(new File("src/main/resources/input.json")).useDelimiter("\\Z").next();
        Input input = objectMapper.readValue(content, Input.class);

        input.getInputs().forEach(inputData -> {
            if (inputData.getOffers().isEmpty()) {
                System.out.println("Checkout amount for cart is: "
                        + checkoutService.getCheckoutAmount(inputData.getFruits()));
            }
            else {
                System.out.println("Checkout amount for cart is: "
                        + checkoutService.getCheckoutAmount(inputData.getFruits(), inputData.getOffers()));
            }
        });

    }
}