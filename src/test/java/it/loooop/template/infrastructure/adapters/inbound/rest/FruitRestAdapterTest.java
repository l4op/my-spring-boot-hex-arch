package it.loooop.template.infrastructure.adapters.inbound.rest;

import it.loooop.template.application.ports.inbound.CreateFruitUseCase;
import it.loooop.template.application.ports.inbound.GetFruitUseCase;
import it.loooop.template.domain.implementation.testobjectmother.FruitTestObjectMother;
import it.loooop.template.infrastructure.adapters.inbound.rest.mapper.FruitRestMapper;
import it.loooop.template.infrastructure.adapters.inbound.rest.response.CreateFruitResponse;
import it.loooop.template.infrastructure.adapters.inbound.rest.response.GetFruitResponse;
import it.loooop.template.infrastructure.adapters.inbound.rest.testobjectmother.CreateFruitRequestTestObjectMother;
import it.loooop.template.infrastructure.adapters.inbound.rest.testobjectmother.CreateFruitResponseTestObjectMother;
import it.loooop.template.infrastructure.adapters.inbound.rest.testobjectmother.GetFruitResponseTestObjectMother;
import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;

public class FruitRestAdapterTest {

    private final CreateFruitUseCase createFruitUseCase = mock(CreateFruitUseCase.class);
    private final GetFruitUseCase getFruitUseCase = mock(GetFruitUseCase.class);
    private final FruitRestAdapter fruitRestAdapterTest = new FruitRestAdapter(createFruitUseCase, getFruitUseCase);
    private final FruitRestMapper fruitRestMapper = Mappers.getMapper(FruitRestMapper.class);
    private static final long FRUIT_ID = 1L;

    @Test
    public void createFruitTest() {
        //GIVEN
        when(createFruitUseCase.createFruit(fruitRestMapper.toModel(CreateFruitRequestTestObjectMother.aCreateFruitRequest()))).thenReturn(FruitTestObjectMother.aFruit());

        //WHEN
        ResponseEntity<CreateFruitResponse> testResponse = fruitRestAdapterTest.createFruit(CreateFruitRequestTestObjectMother.aCreateFruitRequest());

        //THEN
        verify(createFruitUseCase, times(1)).createFruit(fruitRestMapper.toModel(CreateFruitRequestTestObjectMother.aCreateFruitRequest()));
        assertEquals(HttpStatus.CREATED, testResponse.getStatusCode());
        assertNotNull(testResponse.getBody());
        assertEquals(CreateFruitResponseTestObjectMother.aCreateFruitResponse(), testResponse.getBody());
    }

    @Test
    public void getFruitTest() {
        //GIVEN
        when(getFruitUseCase.getFruitById(FRUIT_ID)).thenReturn(FruitTestObjectMother.aFruit());

        //WHEN
        ResponseEntity<GetFruitResponse> testResponse = fruitRestAdapterTest.getFruit(FRUIT_ID);

        //THEN
        verify(getFruitUseCase, times(1)).getFruitById(FRUIT_ID);
        assertEquals(HttpStatus.OK, testResponse.getStatusCode());
        assertNotNull(testResponse.getBody());
        assertEquals(GetFruitResponseTestObjectMother.aGetFruitResponse(), testResponse.getBody());
    }
}
