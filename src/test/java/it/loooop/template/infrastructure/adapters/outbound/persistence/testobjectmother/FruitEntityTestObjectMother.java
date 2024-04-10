package it.loooop.template.infrastructure.adapters.outbound.persistence.testobjectmother;

import it.loooop.template.infrastructure.adapters.outbound.persistence.entity.FruitEntity;

public class FruitEntityTestObjectMother {
    public static FruitEntity aFruitEntity() {
        return FruitEntity.builder()
                .id(1L)
                .name("name")
                .description("description")
                .build();
    }
}
