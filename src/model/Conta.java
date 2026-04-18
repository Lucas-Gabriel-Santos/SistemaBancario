package model;

public abstract class Conta {
    protected int numero;
    protected String cliente;
    protected double saldo;

    //Construtor
    public Conta(int numero, String cliente) {
        this.numero = numero;
        this.cliente = cliente;
        this.saldo = 0.0;
    }

    //Getters e Setters
    public int getNumero() {
        return numero;
    }
    public String getCliente() {
        return cliente;
    }
    public double getSaldo() {
        return saldo;
    }


    //Metodos
    public void depositar(double valor){
        this.saldo += valor;
    }
    public abstract boolean sacar(double valor);
    public abstract boolean transferir(double valor, Conta conta);

}
