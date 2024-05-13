package br.com.fiap;

import javax.swing.*;

public class ContaEspecial extends ContaBancaria {
    private float limite;


    public ContaEspecial(String cliente, int numConta, float saldo, float limite) {
        super(cliente, numConta, saldo);
        this.setLimite(limite);
    }

    public float getLimite() {
        return limite;
    }

    public void setLimite(float limite) {
        this.limite = limite;
    }

    public float sacar (float valor){
        float novoSaldo = super.getSaldo();
        if (valor <= (super.getSaldo() + limite)) {
            novoSaldo = super.getSaldo() - valor;
        } else {
            JOptionPane.showMessageDialog(null, "Valor superior ao seu limite atual");
        }
        super.setSaldo(novoSaldo);
        return super.getSaldo();
    }
}
