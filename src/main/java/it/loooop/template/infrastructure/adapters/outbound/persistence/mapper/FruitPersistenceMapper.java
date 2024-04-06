package it.loooop.template.infrastructure.adapters.outbound.persistence.mapper;

import it.loooop.template.domain.model.Fruit;
import it.loooop.template.infrastructure.adapters.outbound.persistence.entity.FruitEntity;
import org.mapstruct.Mapper;

@Mapper
public interface FruitPersistenceMapper {

    FruitEntity toEntity(Fruit fruit);

    Fruit toModel(FruitEntity fruitEntity);
}
