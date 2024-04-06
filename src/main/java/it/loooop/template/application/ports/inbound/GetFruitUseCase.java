package it.loooop.template.application.ports.inbound;

import it.loooop.template.domain.exception.FruitNotFoundException;
import it.loooop.template.domain.model.Fruit;

public interface GetFruitUseCase {
    Fruit getFruitById(Long id) throws FruitNotFoundException;
}
