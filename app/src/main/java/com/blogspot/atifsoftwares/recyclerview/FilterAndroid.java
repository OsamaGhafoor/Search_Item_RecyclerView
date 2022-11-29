package com.blogspot.atifsoftwares.recyclerview;

import android.widget.Filter;

import java.util.ArrayList;
import java.util.List;

public class FilterAndroid extends Filter {

    private AdapterAndroid adapter;
    private List<ModelAndroid> filterList;

    public FilterAndroid(ArrayList<ModelAndroid> filterList, AdapterAndroid adapter) {
        this.adapter = adapter;
        this.filterList = filterList;
    }

    //FILTERING OCURS
    @Override
    protected FilterResults performFiltering(CharSequence constraint) {
        FilterResults results = new FilterResults();
        //CHECK CONSTRAINT VALIDITY
        if (constraint != null && constraint.length() > 0) {
            //CHANGE TO UPPER
            constraint = constraint.toString().toUpperCase();
            //STORE OUR FILTERED PLAYERS
            ArrayList<ModelAndroid> filteredModels = new ArrayList<>();
            for (int i = 0; i < filterList.size(); i++) {
                //CHECK
                if (filterList.get(i).getVersionName().toUpperCase().contains(constraint) ||
                        filterList.get(i).getApiLevel().toUpperCase().contains(constraint)
                ) {
                    //ADD PLAYER TO FILTERED PLAYERS
                    filteredModels.add(filterList.get(i));
                }
            }
            results.count = filteredModels.size();
            results.values = filteredModels;
        } else {
            results.count = filterList.size();
            results.values = filterList;
        }
        return results;
    }

    @Override
    protected void publishResults(CharSequence constraint, FilterResults results) {
        adapter.androidArrayList = (ArrayList<ModelAndroid>) results.values;
        //REFRESH
        adapter.notifyDataSetChanged();
    }
}