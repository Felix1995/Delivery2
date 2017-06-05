package com.example.felix.delivery;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.felix.delivery.Qther.Adapter;
import com.example.felix.delivery.Qther.Product;

import java.util.ArrayList;

public class SushiActivity extends Activity {

    ListView list;
    ArrayList<Product> arrayList;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sushi_bar);

        list = (ListView)findViewById(R.id.ListV);  //
        arrayList = new ArrayList<>(); // массив имен для listviev

        String[] strings={
                "Ролл с огурцом",
                "Ролл с лососем",
                "Калифорния",
                "Филадельфия",
                "Жаренный ролл с лососем",
                "Жаренный ролл с креветками",
        };

        Bitmap[] bitmap= new Bitmap[6];
        bitmap[0]= BitmapFactory.decodeResource(getResources(),R.drawable.rolli1);
        bitmap[1]= BitmapFactory.decodeResource(getResources(),R.drawable.rolli2);
        bitmap[2]= BitmapFactory.decodeResource(getResources(),R.drawable.rolli3);
        bitmap[3]= BitmapFactory.decodeResource(getResources(),R.drawable.rolli4);
        bitmap[4]= BitmapFactory.decodeResource(getResources(),R.drawable.rolli5);
        bitmap[5]= BitmapFactory.decodeResource(getResources(),R.drawable.rolli6);

        for (int i=0; i<=5; i++){
            arrayList.add(new Product(
                    bitmap[i] ,
                    strings[i],
                    "Описание",
                    "Цена"
            ));
        }
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                Adapter adapter = new Adapter(
                        getApplicationContext(), R.layout.row_s,arrayList
                );
                list.setAdapter(adapter);  // устанавливает listviev список
            }
        });
            list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                }
            });
    }

}
