package com.agrocontrol.msvc_store.store.application.internal.commandservices;


import com.agrocontrol.msvc_store.store.application.internal.outboundservices.acl.ExternalProfileService;
import com.agrocontrol.msvc_store.store.domain.model.aggregates.PaymentProduct;
import com.agrocontrol.msvc_store.store.domain.model.aggregates.Product;
import com.agrocontrol.msvc_store.store.domain.model.commands.CreatePaymentProductCommand;
import com.agrocontrol.msvc_store.store.domain.services.PaymentProductCommandService;
import com.agrocontrol.msvc_store.store.infrastructure.persistence.jpa.repositories.PaymentProductRepository;
import com.agrocontrol.msvc_store.store.infrastructure.persistence.jpa.repositories.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PaymentProductCommandServiceImpl implements PaymentProductCommandService {
    private final PaymentProductRepository paymentProductRepository;
    private final ProductRepository productRepository;
    private final ExternalProfileService externalProfileService;

    public PaymentProductCommandServiceImpl(PaymentProductRepository paymentProductRepository,
                                            ProductRepository productRepository,
                                            ExternalProfileService externalProfileService) {
        this.paymentProductRepository = paymentProductRepository;
        this.productRepository = productRepository;
        this.externalProfileService = externalProfileService;
    }

    @Override
    public Optional<PaymentProduct> handle(CreatePaymentProductCommand command) {
        var product = productRepository.findById(command.productId())
                .orElseThrow(() -> new IllegalArgumentException("The product not exist with id" + command.productId()));

        externalProfileService.existsAgriculturalProducer(command.userId()).join(); // Verify if the user is an agricultural producer

        Long distributorId = product.getUserId();
        String productName = product.getName();
        double totalCost = product.getUnitPrice() * command.quantityProduct();

        product.decreaseQuantity(command.quantityProduct());
        this.productRepository.save(product);

        var paymentProduct = new PaymentProduct(command, productName, distributorId, totalCost);

        var paymentProductCreated = paymentProductRepository.save(paymentProduct);

        if (!this.verifyExistenceProductByIdAndUserId(product, command.userId(), command.quantityProduct())) {
            var newProduct = new Product(command.userId(), product.getId(), product.getName(), product.getQuantityPerUnit(), product.getUnitPrice(),
                    command.quantityProduct(), product.getPhotoUrl());

            this.productRepository.save(newProduct);
        }

        return Optional.of(paymentProductCreated);
    }

    private boolean verifyExistenceProductByIdAndUserId(Product product, Long userId, Integer quantity) {
        var productExist = this.productRepository.findByPreviousIdAndUserId(product.getId(), userId)
                .orElse(null);

        if (productExist != null) {
            productExist.increaseQuantity(quantity);
            this.productRepository.save(productExist);
            return true;
        } else {
            return false;
        }
    }
}
