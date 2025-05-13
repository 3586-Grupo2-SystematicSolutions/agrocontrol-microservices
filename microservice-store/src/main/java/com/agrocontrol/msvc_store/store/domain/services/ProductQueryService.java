package com.agrocontrol.msvc_store.store.domain.services;

import com.agrocontrol.msvc_store.store.domain.model.aggregates.Product;
import com.agrocontrol.msvc_store.store.domain.model.queries.*;

import java.util.List;
import java.util.Optional;

public interface ProductQueryService {
    List<Product> handle(GetProductByUserIdQuery query);
    List<Product> handle(GetProductsNotOwnedByUserIdQuery query);
    Optional<Product> handle(GetProductByIdQuery query);
    Optional<Product> handle(GetProductByNameQuery query);
    Optional<Product> handle(GetProductNameByIdQuery query);
    boolean handle(CheckProductByIdQuery query);
}
