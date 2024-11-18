package com.example.bancoapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class DashboardPixActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard_pix);

    }

    public void cadastrarRemoverChaves(View view) {
        Intent intent = new Intent(this, CadastroChavesActivity.class);
        startActivity(intent);
    }

    public void listarChaves(View view) {
        Intent intent = new Intent(this, ListagemChavesActivity.class);
        startActivity(intent);
    }

    public void transacaoPix(View view) {
        Intent intent = new Intent(this, EnviarPixActivity.class);
        startActivity(intent);
    }


}