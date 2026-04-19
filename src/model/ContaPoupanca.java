package model;

public class ContaPoupanca extends Conta{

    public ContaPoupanca(int numero, String cliente) {
        super(numero, cliente);
    }

    @Override
    public boolean sacar(double valor){
        if(this.saldo >= valor){
            this.saldo -= valor;
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
    public String getTipo() {
        return "Poupança";
    }
}
