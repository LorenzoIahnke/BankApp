package com.example.bancoapp;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class RepositorioChavePix extends SQLiteOpenHelper {
    public RepositorioChavePix (@Nullable Context context){
        super(context, "chave",null,1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String sql = "create table chave" + "(id integer not null primary key," +
                "tipoChave String," + "chave int," + "transacao float)";
        sqLiteDatabase.execSQL(sql);
        Log.i("chave", "Tabela chave criada com sucesso!");
    }
    public void adicionarChave(ChavePix chavePix){
        String sql = "insert into chave values (null,'" + chavePix.tipoChave + "'," +
                chavePix.chave + "'," + chavePix.transacao + ")";
        Log.i("chave", "SQL insert chave: " + sql);
        super.getWritableDatabase().execSQL(sql);
    }
    public List<ChavePix> listarChave(){
        ArrayList<ChavePix> listaChave = new ArrayList<>();
        String sql = "select * from chave";
        Cursor cursor = getWritableDatabase().rawQuery(sql, null);
        cursor.moveToFirst();
        for (int i = 0; i < cursor.getCount(); i++){
            ChavePix chavePix = new ChavePix();
            chavePix.id = cursor.getInt(0);
            chavePix.tipoChave = cursor.getString(1);
            chavePix.chave = cursor.getInt(2);
            chavePix.transacao = cursor.getFloat(3);
            listaChave.add(chavePix);
            cursor.moveToNext();
        }
        cursor.close();
        return listaChave;
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
