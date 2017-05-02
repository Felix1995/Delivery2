package com.example.felix.delivery;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;

public class SteakActivity extends Activity{
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.products_steak);
    }
}
