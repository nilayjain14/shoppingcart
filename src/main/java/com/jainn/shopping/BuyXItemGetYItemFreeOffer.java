package com.jainn.shopping;

public class BuyXItemGetYItemFreeOffer implements IOffer {

    private int XItem;
    private int YItem;

    public BuyXItemGetYItemFreeOffer(int xItem, int yItem) {
        XItem = xItem;
        YItem = yItem;
    }

    public void applyOffer(Product product) {
        if (product.getQuantity() >= XItem) {
            int freeProductQty = product.getQuantity() / (XItem + YItem);
            double unitPrice = product.getTotalPrice() / product.getQuantity();
            double discount = unitPrice * freeProductQty;
            product.setTotalPrice(product.getTotalPrice() - discount);
        }
    }
}
