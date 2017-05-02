package com.example.felix.delivery;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.support.annotation.Nullable;
import android.support.annotation.StringDef;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

/**
 * Created by FeliX on 24.04.2017.
 */

public class MenuBasket extends Activity{
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu_basket);
    }

    public void emailSend (View view){
        String address = "lox@mail.com";
        String subject = "Новый заказ! на сумму 0 рубасов(а славик тупой)";
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
