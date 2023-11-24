package com.example.trabalho2bim.activity.model;

public class Pedido {

    private CadastroProduto cadastroProduto;
    private int quantidade;
    private String descrição;
    private int qtdprodutos;
    private double valortotal;


    public Pedido() {
    }

    public CadastroProduto getCadastroProduto() {
        return cadastroProduto;
    }

    public void setCadastroProduto(CadastroProduto cadastroProduto) {
        this.cadastroProduto = cadastroProduto;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public String getDescrição() {
        return descrição;
    }

    public void setDescrição(String descrição) {
        this.descrição = descrição;
    }

    public int getQtdprodutos() {
        return qtdprodutos;
    }

    public void setQtdprodutos(int qtdprodutos) {
        this.qtdprodutos = qtdprodutos;
    }

    public double getValortotal() {
        return valortotal;
    }

    public void setValortotal(double valortotal) {
        this.valortotal = valortotal;
    }
}
