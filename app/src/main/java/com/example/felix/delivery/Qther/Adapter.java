package com.example.felix.delivery.Qther;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.felix.delivery.R;

import java.util.ArrayList;

/**
 * Created by gladi on 02.05.2017.
 */

public class Adapter extends ArrayAdapter<Product> {

    ArrayList<Product> products;
    Context context;
    int resourse;

    public Adapter(Context context, int resource, ArrayList<Product> products) {
        super(context, resource, products);
        this.products = products;
        this.context = context;
        this.resourse = resource;
    }


    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null){
            LayoutInflater layoutInflater = (LayoutInflater) getContext()
                    .getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
            convertView = layoutInflater.inflate(R.layout.row_s, null,true);
        }
        Product product = getItem(position);


        ImageView imageView = (ImageView) convertView.findViewById(R.id.Image_l);
//        Picasso.with(context).load(product.getImage()).into(imageView);
        imageView.setImageBitmap(product.getImage());

        TextView textName = (TextView) convertView.findViewById(R.id.Text_mod);
        textName.setText(product.getName());

        TextView textPrice = (TextView) convertView.findViewById(R.id.Text_power);
        textPrice.setText(product.getPrise());

        TextView textStat = (TextView) convertView.findViewById(R.id.Text_Stat);
        textStat.setText(product.getDom());

        return convertView;
    }

}
