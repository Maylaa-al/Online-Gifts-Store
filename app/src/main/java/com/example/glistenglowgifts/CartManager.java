package com.example.glistenglowgifts;

import com.example.glistenglowgifts.recycleView.Term;

import java.util.ArrayList;
import java.util.List;

public class CartManager {
    private static CartManager instance;
    private List<Term> cartItems;

    private CartManager() {
        cartItems = new ArrayList<>();
    }

    public static synchronized CartManager getInstance() {
        if (instance == null) {
            instance = new CartManager();
        }
        return instance;
    }

    public void addItemToCart(Term item) {
        cartItems.add(item);
    }

    public List<Term> getCartItems() {
        return cartItems;
    }
}

