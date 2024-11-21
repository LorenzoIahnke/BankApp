package com.example.bancoapp;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.List;

public class ExtratoActivity extends AppCompatActivity {
    private RepositorioConta repositorioConta;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_extrato);
        repositorioConta = new RepositorioConta(this);

        ListView listViewExtrato = findViewById(R.id.listViewExtrato);
        List<String> extrato = repositorioConta.gerarExtrato();
        ArrayAdapter<String> adapter = new ArrayAdapter<>(
                this,
                android.R.layout.simple_list_item_1,
                extrato
        );
        listViewExtrato.setAdapter(adapter);
    }
}
