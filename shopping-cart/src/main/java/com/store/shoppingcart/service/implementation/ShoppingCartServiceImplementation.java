package com.store.shoppingcart.service.implementation;

import com.store.shoppingcart.domain.ShoppingCart;
import com.store.shoppingcart.domain.ShoppingCartItem;
import com.store.shoppingcart.repository.ShoppingCartItemRepository;
import com.store.shoppingcart.repository.ShoppingCartRepository;
import com.store.shoppingcart.service.ShoppingCartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@Service
@Component
public class ShoppingCartServiceImplementation extends GenericServiceImplementation<ShoppingCart, Long, ShoppingCartRepository> implements ShoppingCartService {
    private final WebClient webClient;

    @Autowired
    private ShoppingCartItemRepository shoppingCartItemRepository;

    public ShoppingCartServiceImplementation(ShoppingCartRepository repository, WebClient webClient){
        super(repository);
        this.webClient = webClient;
    }

    @Override
    public void save(ShoppingCart shoppingCart){
        this.webClient.get()
                .uri("/user/" + String.valueOf(shoppingCart.getUser_id()))
                .accept(MediaType.APPLICATION_JSON)
                .exchangeToMono(response -> {
                    if (response.statusCode().equals(HttpStatus.OK)) {
                        ShoppingCart cart = repository.save(shoppingCart);
                        for(ShoppingCartItem item: cart.getItems()){
                            ShoppingCartItem cartItem = new ShoppingCartItem();

                            cartItem.setShoppingCart(cart);
                            cartItem.setProduct_id(item.getProduct_id());

                            shoppingCartItemRepository.save(cartItem);
                        }

                        return response.toEntity(String.class);
                    }
                    else if(response.statusCode().equals(HttpStatus.NOT_FOUND)) {
                        System.out.println("Usuário não encontrado");
                        return response.toEntity(String.class);
                    }else {
                        return response.createError();
                    }
                }).block();
    }
}
