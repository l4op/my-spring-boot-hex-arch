package it.loooop.template.domain.implementation.testobjectmother;

import it.loooop.template.domain.model.Fruit;

public class FruitTestObjectMother {
    public static Fruit aFruit() {
        return Fruit.builder()
                .id(1L)
                .name("name")
                .description("description")
                .build();
    }

}
