package it.loooop.template.infrastructure.adapters.inbound.rest.testobjectmother;

import it.loooop.template.infrastructure.adapters.inbound.rest.request.CreateFruitRequest;

public class CreateFruitRequestTestObjectMother {
    public static CreateFruitRequest aCreateFruitRequest() {
        return CreateFruitRequest.builder()
                .name("name")
                .description("description")
                .build();
    }
}
