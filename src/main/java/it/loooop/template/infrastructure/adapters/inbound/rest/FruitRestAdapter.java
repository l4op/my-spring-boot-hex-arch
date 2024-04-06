package it.loooop.template.infrastructure.adapters.inbound.rest;

import it.loooop.template.application.ports.inbound.CreateFruitUseCase;
import it.loooop.template.application.ports.inbound.GetFruitUseCase;
import it.loooop.template.domain.model.Fruit;
import it.loooop.template.infrastructure.adapters.inbound.rest.mapper.FruitRestMapper;
import it.loooop.template.infrastructure.adapters.inbound.rest.request.CreateFruitRequest;
import it.loooop.template.infrastructure.adapters.inbound.rest.response.CreateFruitResponse;
import it.loooop.template.infrastructure.adapters.inbound.rest.response.GetFruitResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.mapstruct.factory.Mappers;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1")
@RequiredArgsConstructor
public class FruitRestAdapter {

    private final CreateFruitUseCase createFruitUseCase;
    private final GetFruitUseCase getFruitUseCase;

    private final FruitRestMapper fruitRestMapper = Mappers.getMapper(FruitRestMapper.class);

    @PostMapping(value = "/fruits")
    public ResponseEntity<CreateFruitResponse> createFruit(@RequestBody @Valid CreateFruitRequest createFruitRequest) {

        Fruit fruit = createFruitUseCase.createFruit(fruitRestMapper.toModel(createFruitRequest));

        return new ResponseEntity<>(fruitRestMapper.toCreateFruitResponse(fruit), HttpStatus.CREATED);
    }

    @GetMapping(value = "/fruits/{id}")
    public ResponseEntity<GetFruitResponse> getFruit(@PathVariable Long id) {
        Fruit fruit = getFruitUseCase.getFruitById(id);
        return new ResponseEntity<>(fruitRestMapper.toGetFruitResponse(fruit), HttpStatus.OK);
    }
}
