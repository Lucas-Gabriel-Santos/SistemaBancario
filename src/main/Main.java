package main;

import model.Conta;
import model.ContaCorrente;
import model.ContaPoupanca;
import interfaces.ITributavel;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    private static ArrayList<Conta> ListarContas = new ArrayList<>();
    private static  int ProximoNumero = 101;
    private static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        int opcao = 0;
        while (opcao != 7) {
            System.out.println("\n--- BANCO DIGITAL IMD ---");
            System.out.println("1. Criar Conta");
            System.out.println("2. Realizar Depósito");
            System.out.println("3. Realizar Saque");
            System.out.println("4. Realizar Transferência");
            System.out.println("5. Listar Contas");
            System.out.println("6. Calcular Total de Tributos");
            System.out.println("7. Sair");

            System.out.print("Escolha uma das opção: ");
            opcao = input.nextInt();
            input.nextLine();

            switch (opcao) {
                case 1: criarConta(); break;
                case 2: realizarDeposito(); break;
                case 3: realizarSaque(); break;
                case 4: realizarTransferencia(); break;
                case 5: listarContas(); break;
                case 6: calcularTributos(); break;
                case 7: System.out.println("Encerrando..."); break;
                default: System.out.println("Opção inválida!");
            }
        }
    }

    private static void criarConta() {
        System.out.print("Nome do cliente: ");
        String nome = input.nextLine();
        System.out.println("Tipo da Conta: 1-Corrente | 2-Poupança");
        int tipo = input.nextInt();

        Conta novaConta;
        if (tipo == 1) {
            novaConta = new ContaCorrente(ProximoNumero++, nome);
        } else {
            novaConta = new ContaPoupanca(ProximoNumero++, nome);
        }
        ListarContas.add(novaConta);
        System.out.println("Conta criada com sucesso! Número: " + novaConta.getNumero());
    }

    private static void realizarDeposito() {
        System.out.print("Número da conta: ");
        int num = input.nextInt();
        System.out.print("Valor: ");
        double valor = input.nextDouble();

        for (Conta c : ListarContas) {
            if (c.getNumero() == num) {
                c.depositar(valor);
                System.out.println("Depósito realizado!");
                return;
            }
        }
        System.out.println("Conta não encontrada.");
    }

    private static void realizarSaque() {
        System.out.print("Número da conta: ");
        int num = input.nextInt();
        System.out.print("Valor: ");
        double valor = input.nextDouble();

        for (Conta c : ListarContas) {
            if (c.getNumero() == num) {
                if (c.sacar(valor)) {
                    System.out.println("Saque realizado com sucesso!");
                } else {
                    System.out.println("Saldo insuficiente (considere as taxas se for Corrente).");
                }
                return;
            }
        }
    }

    private static void realizarTransferencia() {
        System.out.print("Conta de origem: ");
        int ori = input.nextInt();
        System.out.print("Conta de destino: ");
        int des = input.nextInt();
        System.out.print("Valor: ");
        double valor = input.nextDouble();

        Conta contaOrigem = null, contaDestino = null;
        for (Conta c : ListarContas) {
            if (c.getNumero() == ori) contaOrigem = c;
            if (c.getNumero() == des) contaDestino = c;
        }

        if (contaOrigem != null && contaDestino != null) {
            if (contaOrigem.transferir(valor, contaDestino)) {
                System.out.println("Transferência concluída!");
            } else {
                System.out.println("Falha na transferência: saldo insuficiente.");
            }
        } else {
            System.out.println("Uma ou ambas as contas não foram encontradas.");
        }
    }

    private static void listarContas() {
        System.out.println("\n--- LISTA DE CONTAS ---");
        for (Conta c : ListarContas) {
            System.out.println("Nº: " + c.getNumero() + " | Cliente: " + c.getCliente() +
                    " | Saldo: R$ " + String.format("%.2f", c.getSaldo()) +
                    " | Tipo: " + c.getTipo());
        }
    }

    private static void calcularTributos() {
        double totalTributos = 0;
        for (Conta conta : ListarContas) {
            if (conta instanceof ITributavel) {
                ITributavel tributavel = (ITributavel) conta;
                totalTributos += tributavel.calculaTributos();
            }
        }
        System.out.println("Total de tributos a recolher: R$ " + String.format("%.2f", totalTributos));
    }

}
