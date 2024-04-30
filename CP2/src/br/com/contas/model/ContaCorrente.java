package br.com.contas.model;

public class ContaCorrente extends ContaBancaria{

    //atributo tarifa para ser usado no saque.
    private double tarifa = 0.05;


    //Construtor padrão que foi puxado da classe pai (Conta Bancária).
    public ContaCorrente(String agencia, String numeroConta, String nomeTitular, double saldo){
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


    //Método Sacar que foi herdado da classe pai (Conta Bancária) e foi acrescentado o atributo "tarifa" para saques maiores que 600 reais.
    @Override
    public double sacar(double valor) {
        if (valor > 600) {
            valor = valor - (valor * tarifa);
            return super.sacar(valor);
        }else {
            return super.sacar(valor);
        }
    }


    // Método transferir para ser transferido um valor para a Conta Poupança.
    public double transferir(double valor, ContaPoupanca contaPoupanca) {
        if (valor > 0 && valor <= getSaldo()) {

            double novoSaldo = getSaldo() - valor;
            setSaldo(novoSaldo);

            double novoSaldoContaPoupanca = contaPoupanca.getSaldo() + valor;
            contaPoupanca.setSaldo(novoSaldoContaPoupanca);
        }
        return valor;
    }
}
