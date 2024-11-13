package com.example.bancoapp;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RepositorioConta extends SQLiteOpenHelper{
    public RepositorioConta (@Nullable Context context){
        super(context, "conta", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String sql = "create table conta" + "(id integer not null primary key," +
                "deposito float," + "saque float," + "saldo float)";
        sqLiteDatabase.execSQL(sql);
        Log.i("conta", "Tabela conta criada com sucesso");
    }

    public void adicionarValores(Conta conta){
        String sql = "insert into conta values (null,'" + conta.deposito + "'," + conta.saque +
                "'," + conta.saldo + ")";
        Log.i("conta", "SQL insert conta: " + sql);
        super.getWritableDatabase().execSQL(sql);
    }

    public List<Conta> listarConta(){
        ArrayList<Conta> lista = new ArrayList<>();
        String sql = "select * from conta";
        Cursor cursor = getWritableDatabase().rawQuery(sql, null);
        cursor.moveToFirst();
        for (int i = 0; i < cursor.getCount(); i++){
            Conta conta = new Conta();
            conta.id = cursor.getInt(0);
            conta.deposito = cursor.getFloat(1);
            conta.saque = cursor.getFloat(2);
            conta.saldo = cursor.getFloat(3);
            lista.add(conta);
            cursor.moveToNext();
        }
        cursor.close();
        return lista;
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
