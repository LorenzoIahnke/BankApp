package com.example.bancoapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class DashboardActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

    }

    public void moduloConta(View view) {
        Intent intent = new Intent(this, DashboardContaActivity.class);
        startActivity(intent);
    }

    public void moduloPix(View view) {
        Intent intent = new Intent(this, DashboardPixActivity.class);
        startActivity(intent);
    }

}