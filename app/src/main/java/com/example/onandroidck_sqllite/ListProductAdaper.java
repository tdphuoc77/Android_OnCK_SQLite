package com.example.onandroidck_sqllite;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ListProductAdaper extends RecyclerView.Adapter<ListProductAdaper.ProductViewHolder> {
    private Context context;
    private List<Product> array;
    private LayoutInflater inflater;

    public ListProductAdaper(Context context,List<Product> array){
        this.context = context;
        this.inflater = LayoutInflater.from(context);
        this.array = array;

    }

    @NonNull
    @Override
    public ProductViewHolder onCreateViewHolder(@NonNull  ViewGroup parent, int viewType) {
        View itemView= inflater.inflate(R.layout.item,parent,false);
        return new ProductViewHolder(itemView);
    }
    @Override
    public void onBindViewHolder(@NonNull ProductViewHolder holder, int position) {

        Product product=array.get(position);
        holder.txtID.setText(product.getId()+"");
        holder.txtType.setText(product.getType());
        holder.txtPrice.setText(product.getPrice()+"");
        holder.txtCountry.setText(product.getCountry());
        holder.btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent(v.getContext(), ProductDeleteActivity.class);
                Bundle bundle = new Bundle();
                bundle.putInt("id",product.getId());
                intent1.putExtra("BUNDLE1", bundle);
                context.startActivity(intent1);

            }
        });

        holder.btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), ProductUpdateActivity.class);
                Bundle bundle = new Bundle();
                bundle.putInt("id",product.getId());
                intent.putExtra("BUNDLE", bundle);
                context.startActivity(intent);

            }
        });
    }
    @Override
    public int getItemCount() {
        return array.size();
    }
    public  class ProductViewHolder extends RecyclerView.ViewHolder{
        private TextView txtType;
        private TextView txtPrice;
        private TextView txtID;
        private TextView txtCountry;
        private Button btnUpdate;
        private Button btnDelete;

        public ProductViewHolder(@NonNull View itemView){
            super(itemView);
            this.txtID = itemView.findViewById(R.id.txtID);
            this.txtType = itemView.findViewById(R.id.txtType);
            this.txtPrice = itemView.findViewById(R.id.txtPrice);
            this.txtCountry = itemView.findViewById(R.id.txtCountry);
            this.btnDelete=itemView.findViewById(R.id.btnDelete);
            this.btnUpdate=itemView.findViewById(R.id.btnUpdate);
        }
    }

}
