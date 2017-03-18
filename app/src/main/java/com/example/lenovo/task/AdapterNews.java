package com.example.lenovo.task;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.squareup.picasso.Picasso;

import com.example.lenovo.task.DataProcess.DataEncap;

import java.util.ArrayList;

/**
 * Created by Lenovo on 3/18/2017.
 */

public class AdapterNews extends RecyclerView.Adapter<AdapterNews.ViewHolder> implements View.OnClickListener  {

    ArrayList<DataEncap> arrayList;
    Context context;
    MainActivity mainActivity;

    DataEncap encap = new DataEncap();

    public AdapterNews(ArrayList<DataEncap> arrayList, Context context, MainActivity mainActivity) {
        this.arrayList = arrayList;
        this.context = context;
        this.mainActivity = mainActivity;
    }

    @Override
    public AdapterNews.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View layout = LayoutInflater.from(parent.getContext()).inflate(R.layout.items, parent, false);

        ViewHolder viewHolder = new ViewHolder(layout);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(AdapterNews.ViewHolder holder, int position) {
        encap = arrayList.get(position);


        holder.cardView.setTag(position);

        holder.textPrice.setTextSize(25);
        holder.textPrice.setBackgroundColor(Color.parseColor("#ffffff"));

        holder.textPrice.setText(String.valueOf(encap.getPrice()) + " $ ");


        holder.textDesc.setText(String.valueOf(encap.getProductDescription()));
        holder.textDesc.setBackgroundColor(Color.parseColor("#ffffff"));
        Picasso.with(context).load(encap.getImage()).into(holder.imageNews);



    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    @Override
    public void onClick(View v) {

    }

    class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        CardView cardView;
        ImageView imageNews;
        TextView textPrice;
        TextView textDesc;


        public ViewHolder(View layout) {
            super(layout);

            cardView = (CardView) layout.findViewById(R.id.list_row_container);
            imageNews = (ImageView) layout.findViewById(R.id.news_image);
            textPrice= (TextView) layout.findViewById(R.id.title_news);
            textDesc = (TextView) layout.findViewById(R.id.desc_news);

            cardView.setOnClickListener(this);

        }

        @Override
        public void onClick(View view) {

            int position = (int) view.getTag();

            encap = arrayList.get(position);

            Intent intent = new Intent(mainActivity, Details.class);


            intent.putExtra("productDescription", encap.getProductDescription());
            intent.putExtra("image", encap.getImage());
            intent.putExtra("price" , encap.getPrice());
            mainActivity.startActivity(intent);

        }

    }



}
