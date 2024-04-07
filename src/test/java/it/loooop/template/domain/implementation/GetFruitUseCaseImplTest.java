package it.loooop.template.domain.implementation;

import it.loooop.template.application.ports.inbound.GetFruitUseCase;
import it.loooop.template.application.ports.outbound.FruitPersistencePort;
import it.loooop.template.domain.exception.FruitNotFoundException;
import it.loooop.template.domain.implementation.testdatabuilder.FruitTestDataBuilder;
import it.loooop.template.domain.model.Fruit;

import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class GetFruitUseCaseImplTest {
    private final FruitPersistencePort fruitPersistencePort = mock(FruitPersistencePort.class);
    private final GetFruitUseCase getFruitUseCaseTest = new GetFruitUseCaseImpl(fruitPersistencePort);
    private static final long FRUIT_ID = 1L;

    @Test
    public void GetFruitByIdTest() {
        //GIVEN
        when(fruitPersistencePort.getFruitById(FRUIT_ID)).thenReturn(Optional.of(FruitTestDataBuilder.aFruit()));

        //WHEN
        Fruit testFruit = getFruitUseCaseTest.getFruitById(FRUIT_ID);

        //THEN
        assertEquals(FruitTestDataBuilder.aFruit(), testFruit);
    }

    @Test
    public void GetFruitByIdThrowsFruitNotFoundExceptionTest() {
        //GIVEN
        when(fruitPersistencePort.getFruitById(FRUIT_ID)).thenReturn(Optional.empty());

        //WHEN
        FruitNotFoundException exception = assertThrows(FruitNotFoundException.class, () -> getFruitUseCaseTest.getFruitById(FRUIT_ID));
        String expectedMessage = "Fruit not found [id]: 1";
        String actualMessage = exception.getMessage();

        //THEN
        assertTrue(actualMessage.contains(expectedMessage));
    }
}
