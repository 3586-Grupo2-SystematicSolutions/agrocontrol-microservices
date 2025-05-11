package com.agrocontrol.msvc_store.store.interfaces.acl;

public interface ProductsContextFacade {

    String getProductNameById(Long productId);

    String changeQuantityOfProduct(Long productId, int quantity, String action);
}
