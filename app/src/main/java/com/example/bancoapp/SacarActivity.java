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

        if (valorSaque.isEmpty()) {
            Toast.makeText(this, "Digite um valor!", Toast.LENGTH_SHORT).show();
            return;
        }

        try {
            float saque = Float.parseFloat(valorSaque);
            if (saque <= 0) {
                Toast.makeText(this, "Valor inválido!", Toast.LENGTH_SHORT).show();
                return;
            }

            // Carregar conta do banco
            Conta conta = repositorioConta.carregarConta();
            if (conta.sacar(saque)) { // Usa a lógica encapsulada
                repositorioConta.adicionarValores(conta);
                Toast.makeText(this, "Saque de R$" + valorSaque + " realizado com sucesso!", Toast.LENGTH_SHORT).show();
                editTextSaque.setText("");
                finish();
            } else {
                Toast.makeText(this, "Saldo insuficiente!", Toast.LENGTH_SHORT).show();
            }
        } catch (NumberFormatException e) {
            Toast.makeText(this, "Digite um valor válido!", Toast.LENGTH_SHORT).show();
        }
    }
}
