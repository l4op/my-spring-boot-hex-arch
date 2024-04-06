package it.loooop.template.domain.implementation;

import it.loooop.template.application.ports.inbound.GetFruitUseCase;
import it.loooop.template.application.ports.outbound.FruitPersistencePort;
import it.loooop.template.domain.exception.FruitNotFoundException;
import it.loooop.template.domain.model.Fruit;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class GetFruitUseCaseImpl implements GetFruitUseCase {

    private final FruitPersistencePort fruitPersistencePort;
    @Override
    public Fruit getFruitById(Long id) {
        return fruitPersistencePort.getFruitById(id)
                .orElseThrow(() -> new FruitNotFoundException(String.format("Fruit not found [id]: %s", id)));
    }
}
