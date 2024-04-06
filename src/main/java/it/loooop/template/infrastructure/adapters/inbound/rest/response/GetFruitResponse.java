package it.loooop.template.infrastructure.adapters.inbound.rest.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class GetFruitResponse {

    private Long id;
    private String name;
    private String description;

}
