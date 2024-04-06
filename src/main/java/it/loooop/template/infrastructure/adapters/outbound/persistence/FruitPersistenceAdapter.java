package it.loooop.template.infrastructure.adapters.outbound.persistence;

import it.loooop.template.application.ports.outbound.FruitPersistencePort;
import it.loooop.template.domain.model.Fruit;
import it.loooop.template.infrastructure.adapters.outbound.persistence.mapper.FruitPersistenceMapper;
import it.loooop.template.infrastructure.adapters.outbound.persistence.repository.FruitRepository;
import lombok.RequiredArgsConstructor;
import org.mapstruct.factory.Mappers;

import java.util.Optional;

@RequiredArgsConstructor
public class FruitPersistenceAdapter implements FruitPersistencePort {

    private final FruitRepository fruitRepository;
    private final FruitPersistenceMapper fruitPersistenceMapper = Mappers.getMapper(FruitPersistenceMapper.class);


    @Override
    public Fruit saveFruit(Fruit fruit) {
        return fruitPersistenceMapper.toModel(fruitRepository.save(fruitPersistenceMapper.toEntity(fruit)));
    }

    @Override
    public Optional<Fruit> getFruitById(Long id) {
        return fruitRepository.findById(id).map(fruitPersistenceMapper::toModel);
    }
}
