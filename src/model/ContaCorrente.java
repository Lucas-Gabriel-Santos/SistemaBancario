package model;

import interfaces.ITributavel;

public class ContaCorrente extends Conta implements ITributavel {

    //Construtor
    public ContaCorrente(int numero, String cliente) {
        super(numero, cliente);
    }

    //Metodos
    @Override
    public boolean sacar(double valor){
        double ValorComTaxa = valor * 1.05;
        double ValorTotal = valor + ValorComTaxa;

        if(this.saldo >= ValorTotal){
            this.saldo -= ValorTotal;
            return true;
        }
        return false;
    }

    @Override
    public boolean transferir(double valor, Conta conta){
        if(this.sacar(valor)){
            conta.depositar(valor);
            return true;
        }
        return false;
    }

    @Override
    public double calculaTributos() {
        return this.saldo * 0.01;
    }

    @Override
    public String getTipo() {
        return "Corrente";
    }
}
