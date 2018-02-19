package com.vasiqimarket.www;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Asus on 12/16/2017.
 */

public class buymenuAdapter extends ArrayAdapter {

    public int resourceId;
    public Activity context;
    public ArrayList<bayMenuListItem> object;



    public buymenuAdapter(Activity context, int resource, ArrayList objects) {
        super(context, resource, objects);
        this.resourceId=resource;
        this.context=context;
        this.object=objects;

    }
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View view=convertView;
        view=this.context.getLayoutInflater().inflate(this.resourceId,null);
        ImageView img=(ImageView)view.findViewById(R.id.imgMenuList);
        TextView txtTitle = (TextView)view.findViewById(R.id.txtTitleMenuList);
        bayMenuListItem bayMenuListItem=object.get(position);
        txtTitle.setText(bayMenuListItem.title);
        img.setImageResource(bayMenuListItem.img);
        return view;
    }
}
