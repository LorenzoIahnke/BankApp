package com.example.bancoapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class DashboardActivity extends AppCompatActivity {
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);
        textView = findViewById(R.id.textViewSaldo);
        atualizarSaldo();
    }

    private void atualizarSaldo() {
        RepositorioConta repositorioConta = new RepositorioConta(this);
        float saldoAtual = repositorioConta.obterSaldoAtual();

        TextView textViewSaldo = findViewById(R.id.textViewSaldo);
        textViewSaldo.setText("Saldo: R$" + String.format("%.2f", saldoAtual));
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
