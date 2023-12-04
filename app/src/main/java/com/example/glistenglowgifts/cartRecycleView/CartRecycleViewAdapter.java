package com.example.glistenglowgifts.cartRecycleView;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.glistenglowgifts.CartManager;
import com.example.glistenglowgifts.R;
import com.example.glistenglowgifts.recycleView.Term;

import java.util.List;

public class CartRecycleViewAdapter extends RecyclerView.Adapter<CartRecycleViewAdapter.CartViewHolder> {

    private List<Item> cartItems;
    private Context context;

    public CartRecycleViewAdapter(Context context, List<Item> cartItems) {
        this.context = context;
        this.cartItems = cartItems;
    }

    @NonNull
    @Override
    public CartViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.cart_recycle_row, parent, false);
        return new CartViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CartViewHolder holder, int position) {
        Item item = cartItems.get(position);
        final CartViewHolder holder2 = (CartViewHolder) holder;
        holder2.cartName.setText(item.getCartItemName());
        holder2.cartImage.setImageResource(item.getCartItemImage());
        holder2.cartPrice.setText(String.valueOf(item.getCartItemPrice()));
        holder2.delete.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                // Delete item from cart
            }
        });

    }

    @Override
    public int getItemCount() {
        return cartItems.size();
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
            int position = getAdapterPosition();
            if (position != RecyclerView.NO_POSITION) {
            }

        }
    }
}
