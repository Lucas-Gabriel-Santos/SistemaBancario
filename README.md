# Simulação de Sistema Bancário
Laboratorio 2: Simulação de sistema bancário - Projeto de Programação Orientada a Objetos, 
desenvolvido em Java para a disciplina de Linguagem de Programação II.

## 📝 Conceitos de Programação que ele exercita
- Abstração: Uso de classe base abstrata para definir atributos e métodos.
- Herança: Criação de subclasses específicas (ContaCorrente e ContaPoupanca) que herdam da classe pai (Conta).
- Polimorfismo: Manipulação de diferentes objetos através de uma lista única (ArrayList<Conta>) e comportamento dinâmico de métodos.
- Interfaces: Definição de contratos de comportamento para funcionalidades específicas, como a tributação.
- Classes Abstratas: Implementação de métodos obrigatórios que forçam as subclasses a definir suas próprias lógicas.
- Estruturas de Dados: Uso de coleções dinâmicas para armazenamento e gerenciamento de objetos.
- Controle de Fluxo: Aplicação de laços de repetição e estruturas de seleção para criação de menus interativos.
- Entrada e Saída (I/O): Interação com o usuário via console (Scanner).
- Encapsulamento: Organização de atributos e métodos protegidos dentro das classes.

## 💻 Funcionalidades
- Criar Conta
- Realizar Depósito
- Realizar Saque
- Realizar Transferência
- Listar Contas
- Calcular Total de Tributos
- Sair

## ⚒️ Tecnologias
- Java 25
- Intellij IDE
  
## 📁 Estrutura
```text
src/
    ├── interfaces/
    │   └── ITributavel.java
    ├── main/
    │   └── Main.java
    ├── model/
    │   ├── Conta.java
    │   ├── ContaCorrente.java
    │   └── ContaPoupanca.java
```
