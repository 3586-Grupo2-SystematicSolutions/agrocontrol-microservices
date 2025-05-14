package com.agrocontrol.msvc_store.store.application.internal.queryservices;

import com.agrocontrol.msvc_store.store.application.internal.outboundservices.acl.ExternalProfileService;
import com.agrocontrol.msvc_store.store.domain.model.aggregates.Product;
import com.agrocontrol.msvc_store.store.domain.model.queries.*;
import com.agrocontrol.msvc_store.store.domain.services.ProductQueryService;
import com.agrocontrol.msvc_store.store.infrastructure.persistence.jpa.repositories.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductQueryServiceImpl implements ProductQueryService {

    private final ProductRepository productRepository;
    private final ExternalProfileService externalProfileService;

    public ProductQueryServiceImpl(ProductRepository productRepository, ExternalProfileService externalProfileService) {
        this.productRepository = productRepository;
        this.externalProfileService = externalProfileService;
    }

    @Override
    public List<Product> handle(GetProductByUserIdQuery query) {
        externalProfileService.existsDistributor(query.userId());
        return productRepository.findByUserId(query.userId());
    }

    @Override
    public List<Product> handle(GetProductsNotOwnedByUserIdQuery query) {
        return productRepository.findByUserIdIsNot(query.userId());
    }

    @Override
    public Optional<Product> handle(GetProductByIdQuery query) {
        return productRepository.findById(query.productId());
    }

    @Override
    public Optional<Product> handle(GetProductByNameQuery query) {
        return productRepository.findByName(query.name());
    }

    @Override
    public Optional<Product> handle(GetProductNameByIdQuery query) {
        return productRepository.findNameById(query.id());
    }

    @Override
    public boolean handle(CheckProductByIdQuery query) {
        return productRepository.existsById(query.id());
    }


}
