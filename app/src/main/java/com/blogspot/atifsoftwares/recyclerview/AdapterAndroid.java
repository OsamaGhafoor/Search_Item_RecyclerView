package com.blogspot.atifsoftwares.recyclerview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class AdapterAndroid extends RecyclerView.Adapter<AdapterAndroid.HolderAndroid> implements Filterable {

    private Context context;
    public ArrayList<ModelAndroid> androidArrayList, filterList;
    private FilterAndroid filter;

    AdapterAndroid(Context context, ArrayList<ModelAndroid> androidArrayList) {
        this.context = context;
        this.androidArrayList = androidArrayList;
        this.filterList = androidArrayList;
    }

    @NonNull
    @Override
    public HolderAndroid onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.row_android, parent, false);
        return new HolderAndroid(view);
    }

    @Override
    public void onBindViewHolder(@NonNull HolderAndroid holder, int position) {
        ModelAndroid modelAndroid = androidArrayList.get(position);

        final String versionName = modelAndroid.getVersionName();
        String apiLevel = modelAndroid.getApiLevel();
        String description = modelAndroid.getVersionDescription();
        int image = modelAndroid.getImage();

        holder.titleTv.setText(versionName);
        holder.apiLevelTv.setText(apiLevel);
        holder.descriptionTv.setText(description);
        holder.imageIv.setImageResource(image);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, "" + versionName, Toast.LENGTH_SHORT).show();
            }
        });

    }

    @Override
    public int getItemCount() {
        return androidArrayList.size();
    }

    @Override
    public Filter getFilter() {
        if (filter == null) {
            filter = new FilterAndroid(filterList, this);
        }
        return filter;
    }

    class HolderAndroid extends RecyclerView.ViewHolder {

        private ImageView imageIv;
        private TextView titleTv, apiLevelTv, descriptionTv;

        HolderAndroid(@NonNull View itemView) {
            super(itemView);

            imageIv = itemView.findViewById(R.id.imageIv);
            titleTv = itemView.findViewById(R.id.titleTv);
            apiLevelTv = itemView.findViewById(R.id.apiLevelTv);
            descriptionTv = itemView.findViewById(R.id.descriptionTv);

        }
    }
}
