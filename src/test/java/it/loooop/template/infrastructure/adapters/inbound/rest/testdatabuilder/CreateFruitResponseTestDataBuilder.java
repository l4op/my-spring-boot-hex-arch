package it.loooop.template.infrastructure.adapters.inbound.rest.testdatabuilder;

import it.loooop.template.infrastructure.adapters.inbound.rest.response.CreateFruitResponse;

public class CreateFruitResponseTestDataBuilder {

    public static CreateFruitResponse aCreateFruitResponse() {
        return CreateFruitResponse.builder()
                .id(1L)
                .name("name")
                .description("description")
                .build();
    }
}
