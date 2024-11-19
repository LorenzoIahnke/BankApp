package com.example.bancoapp;

import android.widget.Toast;

import java.util.List;

public class Conta {
    protected int id;
    protected float deposito;
    protected float saque;
    protected float saldo;
    private List<String> extrato;


    public void depositar(float valor) {
        if (valor > 0) {
            saldo += valor;
            extrato.add("Depósito de R$" + valor + " - Saldo: R$" + saldo);
        }
    }

    public boolean sacar(float valor) {
        if (valor > 0 && valor <= saldo) {
        saldo -= valor;
        extrato.add("Saque de R$" + valor + " - Saldo: R$" + saldo);
        return  true;
        }else{
            return false;
        }
    }

}

