package it.loooop.template.infrastructure.adapters.outbound.persistence.testdatabuilder;

import it.loooop.template.infrastructure.adapters.outbound.persistence.entity.FruitEntity;

public class FruitEntityTestDataBuilder {
    public static FruitEntity aFruitEntity() {
        return FruitEntity.builder()
                .id(1L)
                .name("name")
                .description("description")
                .build();
    }
}
