package com.jainn.service;

import com.jainn.model.ShoppingCart;

import java.util.ArrayList;

public class ShoppingCartService {

    private static final String DOVE = "Dove";

    private double getPerUnitPriceBasedOnItem(String itemName){
        if(itemName.equalsIgnoreCase(DOVE)){
            return 39.99;
        }else{
            return 99.99;
        }
    }

    public double calCulateShoppingCartPrice(ArrayList<ShoppingCart> shoppingCarts) {
        double totalCartValueExclusiveTax = 0.00;
        for(ShoppingCart shoppingCart : shoppingCarts){
            totalCartValueExclusiveTax = totalCartValueExclusiveTax + (shoppingCart.getUnit() * getPerUnitPriceBasedOnItem(shoppingCart.getItem()));
        }
        return computeCartValueUsingTax(totalCartValueExclusiveTax);
    }

    private double computeCartValueUsingTax(double totalCartValueExclusiveTax){
        double tax = (12.5/100) * totalCartValueExclusiveTax;
        return (double) Math.round((tax + totalCartValueExclusiveTax) * 100) / 100;
    }
}
