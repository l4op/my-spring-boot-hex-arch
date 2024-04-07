package it.loooop.template.domain.implementation.testdatabuilder;

import it.loooop.template.domain.model.Fruit;

public class FruitTestDataBuilder {
    public static Fruit aFruit() {
        return Fruit.builder()
                .id(1L)
                .name("name")
                .description("description")
                .build();
    }

}
