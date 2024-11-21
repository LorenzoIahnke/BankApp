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

        if (valorDeposito.isEmpty()) {
            Toast.makeText(this, "Digite um valor!", Toast.LENGTH_SHORT).show();
            return;
        }

        try {
            float deposito = Float.parseFloat(valorDeposito);
            if (deposito <= 0) {
                Toast.makeText(this, "Valor inválido!", Toast.LENGTH_SHORT).show();
                return;
            }

            // Carregar conta do banco
            Conta conta = repositorioConta.carregarConta();
            conta.depositar(deposito); // Usa a lógica encapsulada
            repositorioConta.adicionarValores(conta);

            Toast.makeText(this, "Depósito de R$" + valorDeposito + " realizado com sucesso!", Toast.LENGTH_SHORT).show();
            editTextDeposito.setText("");
            finish();
        } catch (NumberFormatException e) {
            Toast.makeText(this, "Digite um valor válido!", Toast.LENGTH_SHORT).show();
        }
    }
}
