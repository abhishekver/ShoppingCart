package org.asa.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import org.asa.enums.Fruit;
import org.asa.enums.Offer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class InputData {

    List<Fruit> fruits = new ArrayList<>();

    Map<Fruit, Offer> offers = new HashMap<>();

}
