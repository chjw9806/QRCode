package com.example.qrcode;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;



import java.util.ArrayList;
import java.util.List;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.CustomViewHolder>{

    private ArrayList<Menu> arrayList;
    private Context context;

    public CustomAdapter(ArrayList<Menu> arrayList, Context context) {
        this.arrayList = arrayList;
        this.context = context;
    }



       public CustomViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.orderlist_items, parent, false);
        CustomViewHolder holder = new CustomViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull CustomViewHolder holder, int position) {

        holder.tv_Drink.setText("주문음료 : "+arrayList.get(position).getDrink());
        holder.tv_OrderTime.setText("주문일시 : "+arrayList.get(position).getFormatDate());
        holder.tv_Details.setText("요청사항 : "+arrayList.get(position).getDetails());

    }
    
    @Override
    public int getItemCount() {
        return (arrayList != null ? arrayList.size() : 0);
    }


    public class CustomViewHolder extends RecyclerView.ViewHolder {

        TextView tv_Drink;
        TextView tv_OrderTime;
        TextView tv_Details;


        public CustomViewHolder(@NonNull View itemView) {
            super(itemView);


            this.tv_Drink = itemView.findViewById(R.id.tv_Drink);
            this.tv_OrderTime = itemView.findViewById(R.id.tv_OrderTime);
            this.tv_Details = itemView.findViewById(R.id.tv_Details);

        }
    }
}