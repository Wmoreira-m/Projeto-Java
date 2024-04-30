package br.com.contas.model;

import javax.swing.*;

public class ContaPoupanca extends ContaBancaria{

    // Atributo para um limite de saque.
    private double limiteSaque = 3000;


    //Construtor padrão que foi puxado da classe pai (Conta Bancária).
    public ContaPoupanca(String agencia, String numeroConta, String nomeTitular, double saldo){
        super(agencia, numeroConta, nomeTitular, saldo);
    }


    //Método Saldo Atual que foi herdado da classe pai (Conta Bancária).
    @Override
    public void saldoAtual() {
        super.saldoAtual();
    }


    //Método Depósitar que foi herdado da classe pai (Conta Bancária).
    @Override
    public double depositar(double valor) {
        return super.depositar(valor);
    }


    //Método Sacar que foi herdado da classe pai (Conta Bancária) e acrescentado o limite de saque com o atributo "limiteSaque".
    @Override
    public double sacar(double valor) {
        if (valor > limiteSaque) {
            JOptionPane.showMessageDialog(null,"Limite de saque atingido, tente novamente.");
        }else {
            return super.sacar(valor);
        }
        return valor;
    }

    // Método transferir para ser transferido um valor para a Conta Corrente.
    public double transferir(double valor, ContaCorrente contaCorrente) {
        if (valor > 0 && valor <= getSaldo()) {
            // Deduz o valor transferido do saldo da conta de origem (conta poupança)
            double novoSaldo = getSaldo() - valor;
            setSaldo(novoSaldo); // Atualiza o saldo da conta poupança

            // Adiciona o valor transferido ao saldo da conta de destino (conta corrente)
            double novoSaldoContaCorrente = contaCorrente.getSaldo() + valor;
            contaCorrente.setSaldo(novoSaldoContaCorrente); // Atualiza o saldo da conta corrente
        }
        return valor;
    }
}

