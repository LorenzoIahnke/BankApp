package com.example.bancoapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;


public class DashboardContaActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard_conta);

    }

    public void depositar(View view) {
        Intent intent = new Intent(this, DepositarActivity.class);
        startActivity(intent);
    }

    public void sacar(View view) {
        Intent intent = new Intent(this, SacarActivity.class);
        startActivity(intent);
    }

    public void verExtrato(View view) {
        Intent intent = new Intent(this, ExtratoActivity.class);
        startActivity(intent);
    }
}