package com.jainn.service;

import com.jainn.model.ShoppingCart;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;

public class ShoppingCartServiceTest {

    ShoppingCartService shoppingCartService = new ShoppingCartService();
    ArrayList<ShoppingCart> shoppingCarts = new ArrayList<ShoppingCart>();

    @Test
    public void addProductsToShoppingCartInclusiveTaxTest(){
        //given empty cart, item name, unit and price
        ShoppingCart shoppingCart = new ShoppingCart();
        shoppingCart.setItem("Dove");
        shoppingCart.setUnit(5);

        shoppingCarts.add(shoppingCart);
        double totalCartPrice = shoppingCartService.calCulateShoppingCartPrice(shoppingCarts);
        Assert.assertEquals(224.94,totalCartPrice,0.00);
        shoppingCarts.clear();
    }

    @Test
    public void addMoreProductsToShoppingCartInclusiveTaxTest(){
        //given empty cart, item name, unit and price
        ShoppingCart shoppingCart = new ShoppingCart();
        shoppingCart.setItem("Dove");
        shoppingCart.setUnit(8);

        shoppingCarts.add(shoppingCart);
        double totalCartPrice = shoppingCartService.calCulateShoppingCartPrice(shoppingCarts);
        Assert.assertEquals(359.91,totalCartPrice,0.00);
        shoppingCarts.clear();
    }

    @Test
    public void addMultiProductsToShoppingCartInclusiveTaxTest(){
        //given cart, item name, unit and price
        ShoppingCart doveShoppingCart = new ShoppingCart();
        doveShoppingCart.setItem("Dove");
        doveShoppingCart.setUnit(2);
        shoppingCarts.add(doveShoppingCart);

        //given cart, item name, unit and price
        ShoppingCart deoShoppingCart = new ShoppingCart();
        deoShoppingCart.setItem("Axe Deo");
        deoShoppingCart.setUnit(2);
        shoppingCarts.add(deoShoppingCart);

        double totalCartPrice = shoppingCartService.calCulateShoppingCartPrice(shoppingCarts);
        Assert.assertEquals(314.96,totalCartPrice,0.00);
        shoppingCarts.clear();
    }

}
