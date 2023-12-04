package com.example.glistenglowgifts.recycleView;

import android.content.Context;
import android.content.SharedPreferences;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.preference.PreferenceManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.glistenglowgifts.CartManager;
import com.example.glistenglowgifts.R;
import com.ramotion.foldingcell.FoldingCell;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

public class CustomRecyclerViewAdapter extends RecyclerView.Adapter {
    private List<Term> myTerms;

    // context to access SharedPreferences
    private Context context;


    public CustomRecyclerViewAdapter(Context context, List<Term> myTerms) {
        this.context = context;
        this.myTerms = myTerms;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view =
                LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_row, parent, false);
        CustomViewHolder viewHolder = new CustomViewHolder(view);
        return viewHolder;
        }

//        private FoldingCell foldingCell;
//        private TextView recycle_textView;
//        private TextView description;
//        private ImageView recycle_imageView;




    @Override
    public void onBindViewHolder(final RecyclerView.ViewHolder holder, int position) {
        final Term term = myTerms.get(position);
        final CustomViewHolder holder1 = (CustomViewHolder) holder;
        holder1.name.setText((term.getName()));
        holder1.image.setImageResource(term.getImage());
        holder1.currency.setText(term.getCurrency());
        holder1.price.setText(String.valueOf(term.getPrice()));
        holder1.description.setText(term.getDescription());
        holder1.cartButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Add term to cart
                CartManager.getInstance().addItemToCart(term);

            }
        });

        double convertedPrice = term.getConvertedPrice();
        // Convert price if necessary
        //holder1.price.setText(String.format("%s %.2f", term.getCurrency(), convertedPrice));

//    foldingCell = holder.itemView.findViewById(R.id.folding_cell);
//     recycle_imageView = holder.itemView.findViewById(R.id.recycle_textView);
//     description = holder.itemView.findViewById(R.id.description);
//     recycle_imageView = holder.itemView.findViewById(R.id.recycle_imageView);

//     foldingCell.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                foldingCell.toggle(false);
//            }
//        });
    }

    @Override
    public int getItemCount() {
        return (myTerms != null ? myTerms.size() : 0);
    }

    class CustomViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        protected TextView name;
        protected ImageView image;
        protected TextView currency;
        protected TextView price;
        protected TextView description;
        protected ImageButton cartButton;
        protected ImageButton delete;
        protected ImageView cartImage;
        protected TextView cartPrice;
        protected TextView cartName;

        public CustomViewHolder(View view) {
            super(view);
            this.name = view.findViewById(R.id.recycle_textView);
            this.image = view.findViewById(R.id.recycle_imageView);
            this.currency = view.findViewById(R.id.currency_view);
            this.price = view.findViewById(R.id.price_view);
            this.description = view.findViewById(R.id.description);
            this.cartButton = view.findViewById(R.id.cart_button);
            this.delete = view.findViewById(R.id.delete_btn);
            this.cartImage = view.findViewById(R.id.cart_image_view);
            this.cartPrice = view.findViewById(R.id.cart_name);

            view.setOnClickListener(this);
        }

        public void onClick(View view) {
           int position = getAdapterPosition();
           if (position != RecyclerView.NO_POSITION) {
               Term term = myTerms.get(position);
           }
        }
    }

    // Handle currency change
    public void notifyCurrencyChanged() {
        // Conversion Logic
        convertPricesToSelectedCurrency();

        // Refresh the views with new prices
        notifyDataSetChanged();
    }

    private void convertPricesToSelectedCurrency() {
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(context);
        String selectedCurrency = prefs.getString("currency_preference", "USD");

        for (Term term : myTerms) {
            double convertedPrice = convertPrice(term.getPrice(), selectedCurrency);
            term.setConvertedPrice(convertedPrice);
        }
    }

    private double convertPrice(double price, String currency) {
        // Implement your conversion logic here
        // This is a placeholder; you'll need actual conversion rates
        double conversionRate = getConversionRate(currency);
        return price / conversionRate;
    }

    private double getConversionRate(String currency) {
        // Return a conversion rate based on currency
        switch (currency) {
            case "USD":
                return 1.35; // Conversion rate from CD to USD
            case "CD":
            default:
                return 1.0; // No conversion needed (already in CD)
        }
    }
}
