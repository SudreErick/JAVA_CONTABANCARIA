package br.com.fiap;

public class ContaPoupanca extends ContaBancaria {
    private int diaDeRendimento;

    public ContaPoupanca(String cliente, int numConta, float saldo, int diaDeRendimento) {
        super(cliente, numConta, saldo);
        this.setDiaDeRendimento(diaDeRendimento);
    }

    public int getDiaDeRendimento() {
        return diaDeRendimento;
    }

    public void setDiaDeRendimento(int diaDeRendimento) {
        this.diaDeRendimento = diaDeRendimento;
    }

    public float novoSaldo(float rendimento){
        float novoSaldo = super.getSaldo() * (1 + rendimento/100);
        super.setSaldo(novoSaldo);
        return super.getSaldo();
    }
}
