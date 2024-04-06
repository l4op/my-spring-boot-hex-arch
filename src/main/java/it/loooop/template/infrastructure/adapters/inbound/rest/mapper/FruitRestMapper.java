package it.loooop.template.infrastructure.adapters.inbound.rest.mapper;

import it.loooop.template.domain.model.Fruit;
import it.loooop.template.infrastructure.adapters.inbound.rest.request.CreateFruitRequest;
import it.loooop.template.infrastructure.adapters.inbound.rest.response.CreateFruitResponse;
import it.loooop.template.infrastructure.adapters.inbound.rest.response.GetFruitResponse;
import org.mapstruct.Mapper;

@Mapper
public interface FruitRestMapper {

    Fruit toModel(CreateFruitRequest createFruitRequest);
    CreateFruitResponse toCreateFruitResponse(Fruit fruit);
    GetFruitResponse toGetFruitResponse(Fruit fruit);

}
