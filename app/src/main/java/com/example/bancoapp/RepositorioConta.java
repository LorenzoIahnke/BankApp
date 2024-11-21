package com.example.bancoapp;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class RepositorioConta extends SQLiteOpenHelper {
    public RepositorioConta(@Nullable Context context) {
        super(context, "conta", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String sql = "CREATE TABLE conta (id INTEGER NOT NULL PRIMARY KEY," +
                "deposito FLOAT," + "saque FLOAT," + "saldo FLOAT)";
        sqLiteDatabase.execSQL(sql);
        Log.i("conta", "Tabela conta criada com sucesso");
    }

    public void adicionarValores(Conta conta) {
        String sql = "INSERT INTO conta (id, deposito, saque, saldo) VALUES (NULL, " +
                conta.deposito + ", " + conta.saque + ", " + conta.saldo + ")";
        getWritableDatabase().execSQL(sql);
    }

    public List<Conta> listarConta() {
        ArrayList<Conta> lista = new ArrayList<>();
        String sql = "SELECT * FROM conta";
        Cursor cursor = getWritableDatabase().rawQuery(sql, null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            Conta conta = new Conta();
            conta.id = cursor.getInt(0);
            conta.deposito = cursor.getFloat(1);
            conta.saque = cursor.getFloat(2);
            conta.saldo = cursor.getFloat(3);
            lista.add(conta);
            cursor.moveToNext();
        }
        cursor.close();
        Log.i("conta", "Contas listadas: " + lista.size());
        return lista;
    }

    public List<String> gerarExtrato() {
        List<String> extrato = new ArrayList<>();
        String sql = "SELECT deposito, saque, saldo FROM conta";
        Cursor cursor = getReadableDatabase().rawQuery(sql, null);

        if (cursor.moveToFirst()) {
            do {
                float deposito = cursor.getFloat(0);
                float saque = cursor.getFloat(1);
                float saldo = cursor.getFloat(2);

                if (deposito > 0) {
                    extrato.add("Depósito de R$" + String.format("%.2f", deposito) +
                            " - Saldo: R$" + String.format("%.2f", saldo));
                }
                if (saque > 0) {
                    extrato.add("Saque de R$" + String.format("%.2f", saque) +
                            " - Saldo: R$" + String.format("%.2f", saldo));
                }
            } while (cursor.moveToNext());
        }

        cursor.close();
        return extrato;
    }

    public float obterSaldoAtual() {
        float saldo = 0;
        String sql = "SELECT saldo FROM conta ORDER BY id DESC LIMIT 1";
        Cursor cursor = getReadableDatabase().rawQuery(sql, null);

        if (cursor.moveToFirst()) {
            saldo = cursor.getFloat(0);
        }

        cursor.close();
        return saldo;
    }

    public Conta carregarConta() {
        Conta conta = new Conta();
        String sql = "SELECT * FROM conta ORDER BY id DESC LIMIT 1";
        Cursor cursor = getReadableDatabase().rawQuery(sql, null);

        if (cursor.moveToFirst()) {
            conta.id = cursor.getInt(0);
            conta.deposito = cursor.getFloat(1);
            conta.saque = cursor.getFloat(2);
            conta.saldo = cursor.getFloat(3);
        }

        cursor.close();
        return conta;
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
    }
}
