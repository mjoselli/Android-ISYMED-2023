package com.esigelec.myrecyclerview;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class ProductArrayAdapter extends RecyclerView.Adapter<ProductArrayAdapter.ViewHolder>{
    public interface ClickListener{
        void onItemClick(View view, int position);
        void onItemLongClick(View view, int position);
    }
    private ClickListener clickListener;
    public void setOnClickListener(ClickListener clickListener){
        this.clickListener = clickListener;
    }
    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView leftTextView;
        TextView rightTextView;
        public ViewHolder(View itemView){
            super(itemView);
            leftTextView = itemView.findViewById(R.id.leftTextView);
            rightTextView = itemView.findViewById(R.id.rightTextView);
            itemView.setOnClickListener(view -> {
                if(clickListener != null){
                    clickListener.onItemClick(view,getAdapterPosition());
                }
            });
            itemView.setOnLongClickListener(view -> {
                if(clickListener != null){
                    clickListener.onItemLongClick(view,getAdapterPosition());
                    return true;
                }
                return false;
            });
        }
    }

    int counter = 0;
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        View itemView = layoutInflater.inflate(R.layout.item_recyclerview,
                parent,false);
        ViewHolder viewHolder = new ViewHolder(itemView);
        counter++;
        Log.d("ViewHolder","created:"+counter);
        return viewHolder;
    }
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Product p = Singleton.getInstance().getProductList().get(position);
        holder.leftTextView.setText(p.name);
        holder.rightTextView.setText(""+p.quantity);
        Log.d("ViewHolder","bind:"+position);

    }

    @Override
    public int getItemCount() {
        return Singleton.getInstance().getProductList().size();
    }
}
