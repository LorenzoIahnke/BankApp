package com.example.bancoapp;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class DepositarActivity extends AppCompatActivity {
    RepositorioConta repositorioConta;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_depositar);
        repositorioConta = new RepositorioConta(this);

    }

    public void depositar(View view) {
        EditText editTextDeposito = findViewById(R.id.editTextDeposito);
        String valorDeposito = editTextDeposito.getText().toString();
        Conta conta = new Conta();
        float deposito = Float.parseFloat(valorDeposito);
        conta.depositar(deposito);
        repositorioConta.adicionarValores(conta);
        Toast.makeText(this, "Depósito de R$" + valorDeposito +
                " cadastrado com sucesso!", Toast.LENGTH_SHORT).show();
        editTextDeposito.setText("");
    }
}