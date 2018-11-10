package com.iteso.tarea3carlosaromero;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import beans.ItemProduct;
import android.view.View;
import android.view.ViewGroup;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.support.v7.widget.CardView;
import android.widget.Button;
import java.util.ArrayList;

public class AdapterProduct extends RecyclerView.Adapter<AdapterProduct.ViewHolder>{

    ArrayList<ItemProduct> mDataSet;
    private Context context;

    public AdapterProduct(Context context, ArrayList<ItemProduct> myDataSet){

        this.mDataSet = myDataSet;
        this.context = context;
    }



    public static class ViewHolder extends RecyclerView.ViewHolder{
        public CardView mCardView;
        public TextView mProductTitle;
        public TextView mProductStore;
        public TextView mProductLocation;
        public TextView mProductPhone;
        public Button mDetail;
        public ImageView mProductImage;
        public ImageView mProductThumbnail;
        public RelativeLayout mEventLayout;

        public ViewHolder(View v){
            super (v);
            mEventLayout = (RelativeLayout) v.findViewById(R.id.item_product_layout);
            mDetail = (Button) v.findViewById(R.id.item_product_detail);
            mProductTitle = (TextView) v.findViewById(R.id.item_product_title);
            mProductStore = (TextView) v.findViewById(R.id.item_product_store);
            mProductLocation = (TextView) v.findViewById(R.id.item_product_location);
            mProductPhone = (TextView) v.findViewById(R.id.item_product_phone);
            mProductImage = (ImageView) v.findViewById(R.id.item_product_image);
            mProductThumbnail = (ImageView) v.findViewById(R.id.item_product_thumbnail);
            mCardView = (CardView) v.findViewById(R.id.card_view);
        }
    }

    public AdapterProduct.ViewHolder onCreateViewHolder (ViewGroup parent, int viewType){
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_product, parent, false);
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {
        holder.mProductTitle.setText(mDataSet.get(position).getTitle());
        holder.mProductStore.setText(mDataSet.get(position).getStore());
        holder.mProductLocation.setText(mDataSet.get(position).getLocalization());
        holder.mProductPhone.setText(mDataSet.get(position).getPhone());
        holder.mCardView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(context, mDataSet.get(position).toString(), Toast.LENGTH_LONG).show();
                }
            });
        holder.mProductPhone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel: " + mDataSet.get(position).getPhone()));
                context.startActivity(intent);
            }
        });
        switch (mDataSet.get(position).getImage()){
            case 0:
                holder.mProductImage.setImageResource(R.drawable.mac); break;
            case 1:
                holder.mProductImage.setImageResource(R.drawable.alienware); break;
        }
        Bitmap bitmap = ((BitmapDrawable)holder.mProductThumbnail.getDrawable()).getBitmap();
        holder.mProductThumbnail.setImageBitmap(bitmap);
    }

    public int getItemCount(){
        return mDataSet.size();
    }


}


