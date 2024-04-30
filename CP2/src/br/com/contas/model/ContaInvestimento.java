package br.com.contas.model;

import javax.swing.*;

public class ContaInvestimento extends ContaBancaria{

    //Atributos da conta investimento
    private double conservador;
    private double moderado;
    private double agressivo;


    //Construtor padrão que foi puxado da classe pai (Conta Bancária).
    public ContaInvestimento(String agencia, String numeroConta, String nomeTitular, double saldo) {
        super(agencia, numeroConta, nomeTitular, saldo);
    }


    //Método Saldo Atual que foi herdado da classe pai (Conta Bancária).
    @Override
    public void saldoAtual() {
        super.saldoAtual();
    }


    //Método investir conservador para ser feito o investimento com o saldo de uma das contas (Corrente/Poupança)
    public double investirConservador(double valor){
        double novoSaldoInvestido = getSaldo() + valor;
        setSaldo(novoSaldoInvestido);
        JOptionPane.showMessageDialog(null,"Seu investimento no valor de " + valor + " foi realizado com sucesso");
        return novoSaldoInvestido;
    }


    //Método investir moderado para ser feito o investimento com o saldo de uma das contas (Corrente/Poupança)
    public double investirModerado(double valor){
        double novoSaldoInvestido = getSaldo() + valor;
        setSaldo(novoSaldoInvestido);
        JOptionPane.showMessageDialog(null,"Seu investimento no valor de " + valor + " foi realizado com sucesso");
        return novoSaldoInvestido;
    }


    //Método investir agressivo para ser feito o investimento com o saldo de uma das contas (Corrente/Poupança)
    public double investirAgressivo(double valor){
        double novoSaldoInvestido = getSaldo() + valor;
        setSaldo(novoSaldoInvestido);
        JOptionPane.showMessageDialog(null,"Seu investimento no valor de " + valor + " foi realizado com sucesso");
        return novoSaldoInvestido;
    }
}


