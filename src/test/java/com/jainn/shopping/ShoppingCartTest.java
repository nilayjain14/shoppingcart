package com.jainn.shopping;

import org.junit.Assert;
import org.junit.Test;

public class ShoppingCartTest {

    @Test
    public void testCreateEmptyShoppingCart() {
        ShoppingCart cart = new ShoppingCart();
        Assert.assertEquals(0, cart.getProductCount());
    }

    @Test
    public void testAddSingleProductToShoppingCart() {
        ShoppingCart cart = new ShoppingCart();
        Product product = new Product("Gatsby hair cream", 1, 30.0);
        cart.addProduct(product);
        Assert.assertEquals(1, cart.getProductCount());
        Assert.assertEquals(30.0, cart.getTotalCartValue(),0.0);
    }

    @Test
    public void addDifferentProductsToTheCart(){
        ShoppingCart cart = new ShoppingCart();
        Product gatsByCream = new Product("Gatsby hair cream", 1, 30.0);
        Product bvlgiriSoap = new Product("Bvlgiri Soap", 1, 100.0);
        cart.addProduct(gatsByCream);
        cart.addProduct(bvlgiriSoap);
        Assert.assertEquals(2, cart.getProductCount());
        Assert.assertEquals(130.0, cart.getTotalCartValue(),0.0);
    }

    @Test
    public void testAddMultipleQuantityOfAProductAndApplyOfferToCart() {
        IOffer offer = new BuyXItemGetYItemFreeOffer(2,1);
        ShoppingCart cart = new ShoppingCart();
        cart.setOffer(offer);
        Product product = new Product("Gatsby hair cream", 5, 150.0);
        cart.addProduct(product);
        Assert.assertEquals(1, cart.getProductCount());
        Assert.assertEquals(120.0, cart.getTotalCartValue(),0.0);
    }

    @Test
    public void addDifferentProductsAndAppyOfferToTheCart(){
        ShoppingCart cart = new ShoppingCart();
        Product gatsByCream = new Product("Gatsby hair cream", 3, 90.0);
        Product bvlgiriSoap = new Product("Bvlgiri Soap", 2, 200.0);
        cart.setOffer(new BuyXItemGetYItemFreeOffer(2,1));
        cart.addProduct(gatsByCream);
        cart.setOffer(new NoOffer());
        cart.addProduct(bvlgiriSoap);
        Assert.assertEquals(2, cart.getProductCount());
        Assert.assertEquals(260.0, cart.getTotalCartValue(),0.0);
    }
}
