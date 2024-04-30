package br.com.contas.model;

import javax.swing.*;

public class ContaBancaria {

    //Atributos de Conta Bancária que serão herdados nas classes filhas (Conta Corrente e Conta Poupança).
    private String agencia;
    private String numeroConta;
    private String nomeTitular;
    private double saldo;


    //Construtor padrão com todos os atributos para iniciar o acesso das contas.
    public ContaBancaria(String agencia, String numeroConta, String nomeTitular, double saldo) {
        this.agencia = agencia;
        this.numeroConta = numeroConta;
        this.nomeTitular = nomeTitular;
        this.saldo = saldo;
    }


    //Método depositar para que o seja feito um depósito em qualquer tipo de conta.
    public double depositar(double valor){
        saldo += valor;
        JOptionPane.showMessageDialog(null, "Deposito de R$ " + valor + " realizado com sucesso \nSeu saldo atual é de R$ " + saldo + " reais.");
        return saldo;
    }

    //Método sacar para que possa ser feito um saque em qualquer tipo de conta.
    public double sacar(double valor){
        if (valor >= 0 && valor <= saldo){
            saldo -= valor;
            JOptionPane.showMessageDialog(null, nomeTitular + " seu saque de " + valor + " foi realizado com sucesso!");
            saldoAtual();
        }
        else{
            JOptionPane.showMessageDialog(null, "Saldo insuficiente para efetuar o saque.");
            saldoAtual();
        }
        return saldo;
    }


    //Método Saldo Atual para que possa ser visto o saldo atual de cada conta.
    public void saldoAtual(){
        JOptionPane.showMessageDialog(null, "Seu saldo atual é de " + saldo + " reais.");
    }


    //Geters e Seters
    public String getAgencia() {
        return agencia;
    }

    public void setAgencia(String agencia) {
        this.agencia = agencia;
    }

    public String getNumeroConta() {
        return numeroConta;
    }

    public void setNumeroConta(String numeroConta) {
        this.numeroConta = numeroConta;
    }

    public String getNomeTitular() {
        return nomeTitular;
    }

    public void setNomeTitular(String nomeTitular) {
        this.nomeTitular = nomeTitular;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }
}
