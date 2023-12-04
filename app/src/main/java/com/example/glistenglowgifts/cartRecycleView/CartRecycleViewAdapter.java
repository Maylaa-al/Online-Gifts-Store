package com.example.glistenglowgifts.cartRecycleView;

import static java.lang.String.*;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.glistenglowgifts.R;

import java.util.List;

public class CartRecycleViewAdapter extends RecyclerView.Adapter<CartRecycleViewAdapter.CartViewHolder> {

    private List<Item> cartItems;
    private Context context;

    public CartRecycleViewAdapter(Context context, List<Item> cartItems) {
        this.context = context;
        this.cartItems = cartItems;
    }

    public void deleteItem(int position) {
        if (position >= 0 && position < cartItems.size()) {
            cartItems.remove(position);
            notifyItemRemoved(position);
            notifyItemRangeChanged(position, cartItems.size());
        }
    }

    @Override
    public int getItemViewType(int position) {
        return 0;

    }

    @NonNull
    @Override
    public CartViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.cart_recycle_row, parent, false);
        return new CartViewHolder(view);
        // Handle other cases or throw an exception
    }

    @SuppressLint("DefaultLocale")
    @Override
    public void onBindViewHolder(@NonNull CartViewHolder holder, int position) {
        if (position < cartItems.size()) {
            Item item = cartItems.get(position);
            CartViewHolder holder2 = (CartViewHolder) holder;
            holder2.cartName.setText(item.getCartItemName());
            holder2.cartImage.setImageResource(item.getCartItemImage());
            holder2.cartPrice.setText(valueOf(item.getCartItemPrice()));

            holder2.delete.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int currentPosition = holder2.getAdapterPosition();
                    if (currentPosition != RecyclerView.NO_POSITION) {
                        deleteItem(currentPosition);
                    }
                }
            });

        } else {
            // Handle footer
            if (!cartItems.isEmpty()) {
                double total = calculateTotal();
              //  holder.totalTextView.setText(format("%.2f", total));
               // holder.footerSection.setVisibility(View.VISIBLE);
            }
        }

//        holder2.delete.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                // Delete item from cart
//            }
//        });
    }


    @Override
    public int getItemCount() {
        if (cartItems.isEmpty()) {
//            return 0; // No items and no footer if the list is empty
            return cartItems.size();
        }
        return cartItems.size() + 1; // Items count plus one for the footer
    }

    private double calculateTotal() {
        double total = 0;
        for (Item item : cartItems) {
            total += item.getCartItemPrice();
        }
        return total;
    }

    // ViewHolder class for cart items
    static class CartViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        protected ImageButton delete;
        protected ImageView cartImage;
        protected TextView cartPrice;
        protected TextView cartName;


        CartViewHolder(View itemView) {
            super(itemView);
            // Initialize holder views
            this.delete = itemView.findViewById(R.id.delete_btn);
            this.cartImage = itemView.findViewById(R.id.cart_image_view);
            this.cartName = itemView.findViewById(R.id.cart_name);
            this.cartPrice = itemView.findViewById(R.id.cart_price);
            itemView.setOnClickListener(this);
        }


        @Override
        public void onClick(View v) {
            // Handle item click
            int position = getAdapterPosition();
            if (position != RecyclerView.NO_POSITION) {
                deleteItem(position);
            }
        }

        private void deleteItem(int position) {
            // Implemented in the adapter
        }

    }
}
