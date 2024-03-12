package com.store.product.service.implementation;

import com.store.product.domain.Product;
import com.store.product.repository.ProductRepository;
import com.store.product.service.ProductsService;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImplementation extends GenericServiceImplementation<Product, Long, ProductRepository> implements ProductsService{
    public ProductServiceImplementation(ProductRepository repository){
        super(repository);
    }

}
