package it.loooop.template.domain.implementation;


import it.loooop.template.application.ports.inbound.CreateFruitUseCase;
import it.loooop.template.application.ports.outbound.FruitPersistencePort;
import it.loooop.template.domain.implementation.testdatabuilder.FruitTestDataBuilder;
import it.loooop.template.domain.model.Fruit;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class CreateFruitUseCaseImplTest {

    private final FruitPersistencePort fruitPersistencePort = mock(FruitPersistencePort.class);
    private final CreateFruitUseCase createFruitUseCaseTest = new CreateFruitUseCaseImpl(fruitPersistencePort);

    @Test
    public void CreateFruitTest() {
        //GIVEN
        when(fruitPersistencePort.saveFruit(FruitTestDataBuilder.aFruit())).thenReturn(FruitTestDataBuilder.aFruit());

        //WHEN
        Fruit testFruit = createFruitUseCaseTest.createFruit(FruitTestDataBuilder.aFruit());

        //THEN
        assertEquals(FruitTestDataBuilder.aFruit(), testFruit);
    }

}
