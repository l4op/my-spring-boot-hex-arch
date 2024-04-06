package it.loooop.template.infrastructure.adapters.outbound.persistence.repository;

import it.loooop.template.infrastructure.adapters.outbound.persistence.entity.FruitEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FruitRepository extends JpaRepository<FruitEntity, Long> {

}
