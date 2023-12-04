package com.example.glistenglowgifts;

import com.example.glistenglowgifts.cartRecycleView.Item;
import com.example.glistenglowgifts.recycleView.Term;

import java.util.ArrayList;
import java.util.List;

public class CartManager {
    private static CartManager instance;
    private List<Item> cartItems;

    private CartManager() {
        cartItems = new ArrayList<>();
    }

    public static synchronized CartManager getInstance() {
        if (instance == null) {
            instance = new CartManager();
        }
        return instance;
    }

    public void addItemToCart(Item item) {
        cartItems.add(item);
    }

    public List<Item> getCartItems() {
        return cartItems;
    }
}

