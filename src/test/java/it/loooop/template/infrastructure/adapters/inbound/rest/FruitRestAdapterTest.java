package it.loooop.template.infrastructure.adapters.inbound.rest;

import it.loooop.template.application.ports.inbound.CreateFruitUseCase;
import it.loooop.template.application.ports.inbound.GetFruitUseCase;
import it.loooop.template.domain.implementation.testdatabuilder.FruitTestDataBuilder;
import it.loooop.template.infrastructure.adapters.inbound.rest.mapper.FruitRestMapper;
import it.loooop.template.infrastructure.adapters.inbound.rest.response.CreateFruitResponse;
import it.loooop.template.infrastructure.adapters.inbound.rest.response.GetFruitResponse;
import it.loooop.template.infrastructure.adapters.inbound.rest.testdatabuilder.CreateFruitRequestTestDataBuilder;
import it.loooop.template.infrastructure.adapters.inbound.rest.testdatabuilder.CreateFruitResponseTestDataBuilder;
import it.loooop.template.infrastructure.adapters.inbound.rest.testdatabuilder.GetFruitResponseTestDataBuilder;
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
        when(createFruitUseCase.createFruit(fruitRestMapper.toModel(CreateFruitRequestTestDataBuilder.aCreateFruitRequest()))).thenReturn(FruitTestDataBuilder.aFruit());

        //WHEN
        ResponseEntity<CreateFruitResponse> testResponse = fruitRestAdapterTest.createFruit(CreateFruitRequestTestDataBuilder.aCreateFruitRequest());

        //THEN
        verify(createFruitUseCase, times(1)).createFruit(fruitRestMapper.toModel(CreateFruitRequestTestDataBuilder.aCreateFruitRequest()));
        assertEquals(HttpStatus.CREATED, testResponse.getStatusCode());
        assertNotNull(testResponse.getBody());
        assertEquals(CreateFruitResponseTestDataBuilder.aCreateFruitResponse(), testResponse.getBody());
    }

    @Test
    public void getFruitTest() {
        //GIVEN
        when(getFruitUseCase.getFruitById(FRUIT_ID)).thenReturn(FruitTestDataBuilder.aFruit());

        //WHEN
        ResponseEntity<GetFruitResponse> testResponse = fruitRestAdapterTest.getFruit(FRUIT_ID);

        //THEN
        verify(getFruitUseCase, times(1)).getFruitById(FRUIT_ID);
        assertEquals(HttpStatus.OK, testResponse.getStatusCode());
        assertNotNull(testResponse.getBody());
        assertEquals(GetFruitResponseTestDataBuilder.aGetFruitResponse(), testResponse.getBody());
    }
}
