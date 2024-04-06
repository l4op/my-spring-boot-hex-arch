package it.loooop.template.application.ports.outbound;

import it.loooop.template.domain.model.Fruit;

import java.util.Optional;

public interface FruitPersistencePort {
    Fruit saveFruit(Fruit fruit);
    Optional<Fruit> getFruitById(Long id);
}
