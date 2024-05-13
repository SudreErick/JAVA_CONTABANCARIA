package br.com.fiap;

import javax.swing.*;
import java.time.LocalDate;

public class UsaConta {
    public static void main(String[] args) {
        String aux, escolha = "sim", cliente;
        int opcao, numConta, diaRend;
        float saldo, saque, deposito, limite;
        while (escolha.equalsIgnoreCase("sim")) {
            try {
                aux = JOptionPane.showInputDialog("Qual tipo de conta possui?" +
                        "\n(1)- Normal \n(2)- Poupança \n(3)- Especial");
                opcao = Integer.parseInt(aux);
                cliente = JOptionPane.showInputDialog("Digite seu nome: ");
                numConta = Integer.parseInt(JOptionPane.showInputDialog("Número da conta: "));
                saldo = Float.parseFloat(JOptionPane.showInputDialog("Saldo da conta: "));
                switch (opcao) {
                    case 1:
                        ContaBancaria cb = new ContaBancaria("erick", 11111, 10000);
                        cb.setCliente(cliente);
                        cb.setNumConta(numConta);
                        cb.setSaldo(saldo);
                        saque = Float.parseFloat(JOptionPane.showInputDialog("Saque: "));
                        JOptionPane.showMessageDialog(null, "Saldo atual: " + cb.sacar(saque));
                        deposito = Float.parseFloat(JOptionPane.showInputDialog("Deposito: "));
                        JOptionPane.showMessageDialog(null, "Saldo atual: " + cb.depositar(deposito));
                        JOptionPane.showMessageDialog(null, "Exibindo informações: "
                                + "\nNome: " + cb.getCliente()
                                + "\nNumero da conta: " + cb.getNumConta()
                                + "\nSaldo atual: " + cb.getSaldo());
                        break;

                    case 2:
                        diaRend = Integer.parseInt(JOptionPane.showInputDialog("Dia de rendimento: "));
                        ContaPoupanca cp = new ContaPoupanca("erick", 3223345, 10000, 1);
                        cp.setCliente(cliente);
                        cp.setNumConta(numConta);
                        cp.setSaldo(saldo);
                        cp.setDiaDeRendimento(diaRend);
                        saque = Float.parseFloat(JOptionPane.showInputDialog("Saque: "));
                        JOptionPane.showMessageDialog(null, "Saldo atual: " + cp.sacar(saque));
                        deposito = Float.parseFloat(JOptionPane.showInputDialog("Deposito: "));
                        JOptionPane.showMessageDialog(null, "Saldo atual: " + cp.depositar(deposito));
                        int dia = LocalDate.now().getDayOfMonth();
                        if (dia >= cp.getDiaDeRendimento()) {
                            float rend = Float.parseFloat(JOptionPane.showInputDialog("Qual a taxa de rendimento? "));
                            cp.novoSaldo(rend);
                        }
                        JOptionPane.showMessageDialog(null, "Exibindo informações: "
                                + "\nNome: " + cp.getCliente()
                                + "\nNumero da conta: " + cp.getNumConta()
                                + "\nSaldo atual: " + cp.getSaldo());
                        break;

                    case 3:
                        limite = Float.parseFloat(JOptionPane.showInputDialog("Limite: "));
                        ContaEspecial ce = new ContaEspecial("erick", 11111, 10000, 11000);
                        ce.setCliente(cliente);
                        ce.setNumConta(numConta);
                        ce.setSaldo(saldo);
                        ce.setLimite(limite);
                        saque = Float.parseFloat(JOptionPane.showInputDialog("Saque: "));
                        JOptionPane.showMessageDialog(null, "Saldo atual: " + ce.sacar(saque));
                        deposito = Float.parseFloat(JOptionPane.showInputDialog("Deposito: "));
                        JOptionPane.showMessageDialog(null, "Saldo atual: " + ce.depositar(deposito));
                        JOptionPane.showMessageDialog(null, "Exibindo informações: "
                                + "\nNome: " + ce.getCliente()
                                + "\nNumero da conta: " + ce.getNumConta()
                                + "\nSaldo atual: " + ce.getSaldo());
                        break;
                    default:
                        throw new Exception("Escolha incorreta!");
                }
                escolha = JOptionPane.showInputDialog("deseja continuar?");
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e.getMessage());
            }
        }
        JOptionPane.showMessageDialog(null, "Fim de programa. Volte sempre!");
    }
}
