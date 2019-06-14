package com.jainn.shopping;

import java.util.ArrayList;
import java.util.List;

public class ShoppingCart {

    private List<Product> productList = new ArrayList<Product>();
    double totalCartValue;
    private IOffer offer;

    public int getProductCount() {
        return productList.size();
    }

    public void addProduct(Product product) {
        if(offer != null){
            offer.applyOffer(product);
        }
        productList.add(product);
    }

    public double getTotalCartValue() {
        if (productList.size() > 0) {
            for (Product product : productList) {
                totalCartValue = totalCartValue + product.getTotalPrice();
            }
        }
        return totalCartValue;
    }

    public void setOffer(IOffer offer) {
        this.offer = offer;
    }
}
