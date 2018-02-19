package com.vasiqimarket.www;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Asus on 12/18/2017.
 */

public class ProductMenuAdapter extends ArrayAdapter{


    public int resourceId;
    public Activity context;
    public ArrayList<productMenuListItem> object;



    public ProductMenuAdapter (Activity context, int resource, ArrayList objects) {
        super(context, resource, objects);
        this.resourceId=resource;
        this.context=context;
        this.object=objects;

    }
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View view=convertView;
        view=this.context.getLayoutInflater().inflate(this.resourceId,null);
        TextView txtTitle = (TextView)view.findViewById(R.id.productTitleItem);
        productMenuListItem productMenuListItem=object.get(position);
        txtTitle.setText(productMenuListItem.title);
        return view;
    }
}