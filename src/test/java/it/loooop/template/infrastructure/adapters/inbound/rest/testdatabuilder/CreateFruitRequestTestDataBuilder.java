package it.loooop.template.infrastructure.adapters.inbound.rest.testdatabuilder;

import it.loooop.template.infrastructure.adapters.inbound.rest.request.CreateFruitRequest;

public class CreateFruitRequestTestDataBuilder {
    public static CreateFruitRequest aCreateFruitRequest() {
        return CreateFruitRequest.builder()
                .name("name")
                .description("description")
                .build();
    }
}
