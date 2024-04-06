package it.loooop.template.infrastructure.adapters.binding;

import it.loooop.template.domain.implementation.CreateFruitUseCaseImpl;
import it.loooop.template.domain.implementation.GetFruitUseCaseImpl;
import it.loooop.template.infrastructure.adapters.outbound.persistence.FruitPersistenceAdapter;
import it.loooop.template.infrastructure.adapters.outbound.persistence.repository.FruitRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanBinder {

    @Bean
    public FruitPersistenceAdapter fruitPersistenceAdapter(FruitRepository fruitRepository) {
        return new FruitPersistenceAdapter(fruitRepository);
    }

    @Bean
    public CreateFruitUseCaseImpl createFruitUseCaseImpl(FruitPersistenceAdapter fruitPersistenceAdapter) {
        return new CreateFruitUseCaseImpl(fruitPersistenceAdapter);
    }

    @Bean
    public GetFruitUseCaseImpl getFruitUseCaseImpl(FruitPersistenceAdapter fruitPersistenceAdapter) {
        return new GetFruitUseCaseImpl(fruitPersistenceAdapter);
    }
}
