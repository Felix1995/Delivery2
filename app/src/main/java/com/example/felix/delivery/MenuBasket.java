package com.example.felix.delivery;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.support.annotation.Nullable;
import android.support.annotation.StringDef;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.felix.delivery.Qther.Product;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by FeliX on 24.04.2017.
 */

public class MenuBasket extends Activity{
    /** Список объектов {@link Product}, представляющие добавленные в корзину блюда */
    public static List<Product> addedProductList = new ArrayList<>();
    /** Итоговая цена всех заказанных блюд */
    public double totalPrice;

    /** Элемент GUI, реализующий функции отображения списка */
    private RecyclerView recyclerView;
    /** LayoutManager для отображения в виде списка */
    private RecyclerView.LayoutManager listLayoutManager;

    /** Адаптер для связывания {@link #recyclerView} c listLayoutManager */
    public MenuBasketAdapter rvAdapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu_basket);

        // Получение ссылки на recyclerView
        recyclerView = (RecyclerView) findViewById(R.id.basker_recycler_view);

        // Создать RecyclerView.Adapter для связывания элементов Product с RecyclerView
        rvAdapter = new MenuBasketAdapter(addedProductList);
        recyclerView.setAdapter(rvAdapter);

        /*
        Новый экзмепляр LayoutManager'а создается при возрате к этому фрагменту
        через BackStack во избежания исключения "LayoutManager is already attached
        to a RecyclerView”
         */
        listLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(listLayoutManager);
    }

    public void emailSend (View view){
        String address = "lox@mail.com";
        String subject = "Новый заказ! на сумму 0 рубасов(а славик тупой)"; // Орнул! by RareScrap
        String emailtext = "slavik saun";

        final Intent emailIntent = new Intent(android.content.Intent.ACTION_SEND);

        emailIntent.setType("plain/text");
        // Кому
        emailIntent.putExtra(android.content.Intent.EXTRA_EMAIL,
                address);
        // Зачем
        emailIntent.putExtra(android.content.Intent.EXTRA_SUBJECT,
                subject);
        // О чём
        emailIntent.putExtra(android.content.Intent.EXTRA_TEXT,
                emailtext);
        // С чем

        emailIntent.setType("text/video");
        // Поехали!
        MenuBasket.this.startActivity(Intent.createChooser(emailIntent,
                "Отправка письма..."));
    }
}
