package it.loooop.template.application.ports.inbound;

import it.loooop.template.domain.model.Fruit;

public interface CreateFruitUseCase {
    Fruit createFruit(Fruit fruit);
}
