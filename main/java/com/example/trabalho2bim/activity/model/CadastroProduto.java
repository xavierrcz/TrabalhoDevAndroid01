package com.example.trabalho2bim.activity.model;

public class CadastroProduto {

    private String descricao;
    private int codigo;
    private double vlunit;
    private int quantidade;

    public CadastroProduto() {
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public double getVlunit() {
        return vlunit;
    }

    public void setVlunit(double vlunit) {
        this.vlunit = vlunit;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }
}
