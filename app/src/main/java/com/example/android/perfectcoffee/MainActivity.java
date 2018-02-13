package com.example.android.perfectcoffee;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    public void show(View view)
    {
        Intent newview = new Intent(MainActivity.this, OrderActivity.class);
        startActivity(newview);
    }

}
