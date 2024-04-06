package it.loooop.template.domain.implementation;

import it.loooop.template.application.ports.inbound.CreateFruitUseCase;
import it.loooop.template.application.ports.outbound.FruitPersistencePort;
import it.loooop.template.domain.model.Fruit;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class CreateFruitUseCaseImpl implements CreateFruitUseCase {

    private final FruitPersistencePort fruitPersistencePort;

    @Override
    public Fruit createFruit(Fruit fruit) {
        return fruitPersistencePort.saveFruit(fruit);
    }
}
