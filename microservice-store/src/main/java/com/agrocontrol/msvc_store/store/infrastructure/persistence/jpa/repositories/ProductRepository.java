package com.agrocontrol.msvc_store.store.infrastructure.persistence.jpa.repositories;

import com.agrocontrol.msvc_store.store.domain.model.aggregates.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    Optional<Product> findByName(String name);

    List<Product> findByUserId(Long userId);

    List<Product> findByUserIdIsNot(Long userId);

    Optional<Product> findByPreviousIdAndUserId(Long previousId, Long userId);

    Optional<Product> findNameById(Long id);
}
