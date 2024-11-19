package com.example.bancoapp;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class SacarActivity extends AppCompatActivity {
    RepositorioConta repositorioConta;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sacar);
        repositorioConta = new RepositorioConta(this);

    }

    public void sacar(View view) {
        EditText editTextSaque = findViewById(R.id.editTextSaque);
        String valorSaque = editTextSaque.getText().toString();
        Conta conta = new Conta();
        float saque = Float.parseFloat(valorSaque);
        conta.sacar(saque);
        repositorioConta.adicionarValores(conta);
        Toast.makeText(this, "Saque de R$" + valorSaque +
                " realizado com sucesso!", Toast.LENGTH_SHORT).show();
        editTextSaque.setText("");
    }
}