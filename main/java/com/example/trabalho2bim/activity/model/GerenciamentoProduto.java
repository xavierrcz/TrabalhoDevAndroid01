package com.example.trabalho2bim.activity.model;

public class GerenciamentoProduto {

    private CadastroProduto cadastroProduto;
    private double valorUnit;
    private int quantidade;

    public GerenciamentoProduto() {
    }

    public CadastroProduto getCadastroProduto() {
        return cadastroProduto;
    }

    public void setCadastroProduto(CadastroProduto cadastroProduto) {
        this.cadastroProduto = cadastroProduto;
    }

    public double getValorUnit() {
        return valorUnit;
    }

    public void setValorUnit(double valorUnit) {
        this.valorUnit = valorUnit;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }
}
