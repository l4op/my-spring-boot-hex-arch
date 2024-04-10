package it.loooop.template.infrastructure.adapters.inbound.rest.testobjectmother;

import it.loooop.template.infrastructure.adapters.inbound.rest.response.GetFruitResponse;

public class GetFruitResponseTestObjectMother {

    public static GetFruitResponse aGetFruitResponse() {
        return GetFruitResponse.builder()
                .id(1L)
                .name("name")
                .description("description")
                .build();
    }
}
