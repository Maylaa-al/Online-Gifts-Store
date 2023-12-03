package com.example.glistenglowgifts.recycleView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.glistenglowgifts.R;
import com.ramotion.foldingcell.FoldingCell;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class CustomRecyclerViewAdapter extends RecyclerView.Adapter {
    private ArrayList<Term> myTerms;


    public CustomRecyclerViewAdapter(ArrayList<Term> myTerms) {
        this.myTerms = myTerms;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view =
                LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_row, parent, false);
        CustomViewHolder viewHolder = new CustomViewHolder(view);
        return viewHolder;
        }

        private FoldingCell foldingCell;
        private TextView recycle_textView;
        private TextView description;
        private ImageView recycle_imageView;




    @Override
    public void onBindViewHolder(final RecyclerView.ViewHolder holder, int position) {
    final Term term = myTerms.get(position);
    final CustomViewHolder holder1 = (CustomViewHolder) holder;
    holder1.name.setText((term.getName()));
//    holder1.description.setText((term.getDescription()));
    holder1.image.setImageResource(term.getImage());


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
        protected TextView description;

        public CustomViewHolder(View view) {
            super(view);
            this.name = view.findViewById(R.id.recycle_textView);
            this.image = view.findViewById(R.id.recycle_imageView);
            this.description = view.findViewById(R.id.description);
            view.setOnClickListener(this);
        }

        public void onClick(View view) {
           int position = getAdapterPosition();
           if (position != RecyclerView.NO_POSITION) {
               Term term = myTerms.get(position);
           }
        }
    }


}
