package it.loooop.template.infrastructure.adapters.outbound.persistence;

import it.loooop.template.domain.implementation.testdatabuilder.FruitTestDataBuilder;
import it.loooop.template.domain.model.Fruit;
import it.loooop.template.infrastructure.adapters.outbound.persistence.repository.FruitRepository;
import it.loooop.template.infrastructure.adapters.outbound.persistence.testdatabuilder.FruitEntityTestDataBuilder;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class FruitPersistenceAdapterTest {

    private final FruitRepository fruitRepository = mock(FruitRepository.class);
    private final FruitPersistenceAdapter fruitPersistenceAdapterTest = new FruitPersistenceAdapter(fruitRepository);

    private static final long FRUIT_ID = 1L;

    @Test
    public void CreateFruitTest() {
        //GIVEN
        when(fruitRepository.save(FruitEntityTestDataBuilder.aFruitEntity())).thenReturn(FruitEntityTestDataBuilder.aFruitEntity());

        //WHEN
        Fruit testFruit = fruitPersistenceAdapterTest.saveFruit(FruitTestDataBuilder.aFruit());

        //THEN
        assertEquals(FruitTestDataBuilder.aFruit(), testFruit);
    }

    @Test
    public void GetFruitByIdTest() {
        //GIVEN
        when(fruitRepository.findById(FRUIT_ID)).thenReturn(Optional.of(FruitEntityTestDataBuilder.aFruitEntity()));

        //WHEN
        Optional<Fruit> testFruit = fruitPersistenceAdapterTest.getFruitById(FRUIT_ID);

        //THEN
        assertTrue(testFruit.isPresent());
        assertEquals(FruitTestDataBuilder.aFruit(), testFruit.get());
    }

}
