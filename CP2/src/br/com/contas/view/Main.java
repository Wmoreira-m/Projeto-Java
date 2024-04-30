package br.com.contas.view;

import br.com.contas.model.ContaCorrente;
import br.com.contas.model.ContaInvestimento;
import br.com.contas.model.ContaPoupanca;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {

            //Campos para preenchimento de dados e armazenamento das variáveis preenchidas.
            String numeroConta;
            String numeroAgencia;
            String nome;

            //Verifica se o número da conta contém apenas números para continuar o código.
            do {
            numeroConta = JOptionPane.showInputDialog(null, "Digite o número da conta");
                if (!numeroConta.matches("\\d+")) {
                JOptionPane.showMessageDialog(null, "Número da conta deve conter apenas números. Por favor, tente novamente.");
            }
            } while (!numeroConta.matches("\\d+"));


            //Verifica se o número da agência contém apenas números para continuar o código.
            do {
            numeroAgencia = JOptionPane.showInputDialog(null, "Digite o número da agência");
            // Verifica se o número da agência contém números
                if (!numeroAgencia.matches("\\d+")) {
                JOptionPane.showMessageDialog(null, "Número da agência não pode conter números. Por favor, tente novamente.");
            }
            } while (!numeroAgencia.matches("\\d+"));


            //Verifica se o nome do titular da conta contém apenas letras para continuar o código.
            do {
                nome = JOptionPane.showInputDialog(null, "Digite o nome do titular da conta").toUpperCase();
                if (nome.length() <=3 || nome.matches(".*\\d+.*")){
                JOptionPane.showMessageDialog(null,"Nome do titular deve ter pelo menos mais de 3 letras. Por favor tente novamente.");
            }
            }while (nome.length() <=3 || nome.matches(".*\\d+.*"));


            //Instanciando os Objetos de conta junto das variáveis preenchidas e usando o construtor padrão herdado na classe pai.
            ContaPoupanca contaPoupanca = new ContaPoupanca(numeroConta, numeroAgencia, nome, 0);
            ContaCorrente contaCorrente = new ContaCorrente(numeroConta, numeroAgencia, nome, 0);
            ContaInvestimento contaInvestimento = new ContaInvestimento(numeroConta, numeroAgencia, nome, 0);


        // Variávei indicando true para a estrutura de repetição "while" já começar rodando.
        boolean rodando = true;

        //While com todos os menus e métodos.
        while (rodando){
           String menu = JOptionPane.showInputDialog(null, "OLÁ " + nome + "\nDigite a opção de conta que deseja acessar!\n 1 - Conta Corrente\n 2 - Conta Poupança \n 3 - Investimentos \n 4 - Sair");
            switch (menu){
                case "1":
                    String contas = JOptionPane.showInputDialog(null, "Digite o numero da opção de sua escolha\n 1 - Verificar saldo atual\n 2- Sacar\n 3 - Depositar\n 4 - Transferência para Conta Poupança");
                    switch (contas) {
                        case "1":

                            contaCorrente.saldoAtual();
                            break;

                        case "2":
                            JOptionPane.showMessageDialog(null,"AVISO\nEm conta corrente temos uma taxa de 5% para saques acima de R$600");
                            double valorSaque = Double.parseDouble(JOptionPane.showInputDialog(null, "Digite o valor que deseja sacar"));
                            contaCorrente.sacar(valorSaque);
                            break;

                        case "3":
                            double valorDeposito = Double.parseDouble(JOptionPane.showInputDialog(null,"Digite o valor que deseja depositar"));
                            contaCorrente.depositar(valorDeposito);
                            break;

                        case "4":
                            double valorTransferencia = Double.parseDouble(JOptionPane.showInputDialog(null, "Digite o valor que deseja transferir para Conta Poupança"));

                            if (valorTransferencia > 0 && valorTransferencia <= contaCorrente.getSaldo()) {
                                contaCorrente.transferir(valorTransferencia, contaPoupanca);
                                JOptionPane.showMessageDialog(null, "Transferência realizada com sucesso!");
                            } else {
                                JOptionPane.showMessageDialog(null, "Saldo insuficiente para realizar a transferência.");
                            }
                            contaCorrente.saldoAtual();
                            break;

                        default:
                            JOptionPane.showMessageDialog(null, "Opção inválida, tente novamente.");
                    }
                    break;
                case "2":

                    String contas2 = JOptionPane.showInputDialog(null, "Digite o numero da opção de sua escolha\n 1 - Verificar saldo atual\n 2 - Sacar\n 3 - Depositar\n 4 - Transferência para Conta Corrente");

                    switch (contas2){

                        case "1":
                            contaPoupanca.saldoAtual();
                            break;
                        case "2":

                            JOptionPane.showMessageDialog(null,"AVISO\nEm conta poupança temos um limite de saque no valor de R$3000 reais.");
                            double valorSaque = Double.parseDouble(JOptionPane.showInputDialog(null, "Digite o valor que deseja sacar"));
                            contaPoupanca.sacar(valorSaque);
                            break;

                        case "3":
                            double valorDeposito = Double.parseDouble(JOptionPane.showInputDialog(null,"Digite o valor que deseja depositar"));
                            contaPoupanca.depositar(valorDeposito);
                            break;

                        case "4":
                            double valorTransferencia = Double.parseDouble(JOptionPane.showInputDialog(null, "Digite o valor que deseja transferir para Conta Corrente"));

                            if (valorTransferencia > 0 && valorTransferencia <= contaPoupanca.getSaldo()) {
                                contaPoupanca.transferir(valorTransferencia, contaCorrente);
                                JOptionPane.showMessageDialog(null, "Transferência realizada com sucesso!");
                            } else {
                                JOptionPane.showMessageDialog(null, "Saldo insuficiente para realizar a transferência.");
                            }
                            contaPoupanca.saldoAtual();
                            break;

                        default:
                            JOptionPane.showMessageDialog(null, "Opção inválida, tente novamente.");
                    }
                    break;

                case "3":
                    String investimentos = JOptionPane.showInputDialog(null,"Digite o modelo de investimento que deseja\n 1 - Investimento conservador\n 2 - Investimento moderado \n 3 - Investimento agressivo\n 4 - Saldo investido");

                    switch (investimentos){

                        case "1":
                            String contas3 = JOptionPane.showInputDialog(null,"Digite a opção de conta que deseja retirar para fazer seu investimento\n 1 - Conta Corrente\n 2 - Conta Poupança");

                            switch (contas3){

                                case "1":
                                    double valor = Double.parseDouble(JOptionPane.showInputDialog(null, "Digite o valor que deseja retirar de Conta Corrente para o investimento"));

                                    if(valor <= contaCorrente.getSaldo()) {
                                        contaInvestimento.investirConservador(valor);
                                        double novoSaldo = contaCorrente.getSaldo() - valor;
                                        contaCorrente.setSaldo(novoSaldo);
                                    }
                                    else{
                                        JOptionPane.showMessageDialog(null, "Saldo de Conta Corrente insuficiente para realizar o investimento");
                                    }
                                    break;

                                case "2":
                                    double valor2 = Double.parseDouble(JOptionPane.showInputDialog(null, "Digite o valor que deseja retirar de Conta Poupança para o investimento"));

                                    if(valor2 <= contaPoupanca.getSaldo()) {
                                        contaInvestimento.investirConservador(valor2);
                                        double novoSaldo = contaPoupanca.getSaldo() - valor2;
                                        contaPoupanca.setSaldo(novoSaldo);
                                    }
                                    else{
                                        JOptionPane.showMessageDialog(null, "Saldo de Conta Poupança insuficiente para realizar o investimento");
                                    }
                                    break;

                                default:
                                    JOptionPane.showMessageDialog(null, "Opção inválida, tente novamente.");
                            }
                            break;

                        case "2":
                            String contas4 = JOptionPane.showInputDialog(null,"Digite a opção de conta que deseja retirar para fazer seu investimento\n 1 - Conta Corrente\n 2 - Conta Poupança");

                            switch (contas4){

                                case "1":
                                    double valor = Double.parseDouble(JOptionPane.showInputDialog(null, "Digite o valor que deseja retirar de Conta Corrente para o investimento"));

                                    if(valor <= contaCorrente.getSaldo()) {
                                        contaInvestimento.investirModerado(valor);
                                        double novoSaldo = contaCorrente.getSaldo() - valor;
                                        contaCorrente.setSaldo(novoSaldo);
                                    }
                                    else{
                                        JOptionPane.showMessageDialog(null, "Saldo de Conta Corrente insuficiente para realizar o investimento");
                                    }
                                    break;

                                case "2":
                                    double valor2 = Double.parseDouble(JOptionPane.showInputDialog(null, "Digite o valor que deseja retirar de Conta Poupança para o investimento"));

                                    if(valor2 <= contaPoupanca.getSaldo()) {
                                        contaInvestimento.investirModerado(valor2);
                                        double novoSaldo = contaPoupanca.getSaldo() - valor2;
                                        contaPoupanca.setSaldo(novoSaldo);
                                    }
                                    else{
                                        JOptionPane.showMessageDialog(null, "Saldo de Conta Poupança insuficiente para realizar o investimento");
                                    }
                                    break;
                                default:
                                    JOptionPane.showMessageDialog(null, "Opção inválida, tente novamente.");
                            }
                            break;

                        case "3":
                            String contas5 = JOptionPane.showInputDialog(null,"Digite a opção de conta que deseja retirar para fazer seu investimento\n 1 - Conta Corrente\n 2 - Conta Poupança");

                            switch (contas5){

                                case "1":
                                    double valor = Double.parseDouble(JOptionPane.showInputDialog(null, "Digite o valor que deseja retirar de Conta Corrente para o investimento"));

                                    if(valor <= contaCorrente.getSaldo()) {
                                        contaInvestimento.investirAgressivo(valor);
                                        double novoSaldo = contaCorrente.getSaldo() - valor;
                                        contaCorrente.setSaldo(novoSaldo);
                                    }
                                    else{
                                        JOptionPane.showMessageDialog(null, "Saldo de Conta Corrente insuficiente para realizar o investimento");
                                    }
                                    break;

                                case "2":
                                    double valor2 = Double.parseDouble(JOptionPane.showInputDialog(null, "Digite o valor que deseja retirar de Conta Poupança para o investimento"));

                                    if(valor2 <= contaPoupanca.getSaldo()) {
                                        contaInvestimento.investirAgressivo(valor2);
                                        double novoSaldo = contaPoupanca.getSaldo() - valor2;
                                        contaPoupanca.setSaldo(novoSaldo);
                                    }
                                    else{
                                        JOptionPane.showMessageDialog(null, "Saldo de Conta Poupança insuficiente para realizar o investimento");
                                    }
                                    break;
                                default:
                                    JOptionPane.showMessageDialog(null, "Opção inválida, tente novamente.");
                            }
                            break;

                        case "4":
                            contaInvestimento.saldoAtual();

                        default:
                            JOptionPane.showMessageDialog(null, "Opção inválida, tente novamente.");
                    }
                    break;

                case "4":
                    rodando = false;
                    JOptionPane.showMessageDialog(null,"Até logo " + nome + "...");
                    break;

                default:
                    JOptionPane.showMessageDialog(null, "Opção inválida, tente novamente.");
                    break;
            }
        }
    }
}