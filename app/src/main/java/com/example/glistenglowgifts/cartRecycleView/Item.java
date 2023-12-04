package com.example.glistenglowgifts.cartRecycleView;

import com.example.glistenglowgifts.recycleView.Term;

public class Item {
    private int cartItemImage;
    private String cartItemName;
    private int cartItemPrice;

    public int getCartItemImage() {
        return cartItemImage;
    }

    public String getCartItemName() {
        return cartItemName;
    }

    public int getCartItemPrice() {
        return cartItemPrice;
    }

    // A constructor that can accept the relevant data from a Term object.
    public Item(Term term) {
        this.cartItemImage = term.getImage();
        this.cartItemName = term.getName();
        this.cartItemPrice = (int) term.getPrice();
    }
}
