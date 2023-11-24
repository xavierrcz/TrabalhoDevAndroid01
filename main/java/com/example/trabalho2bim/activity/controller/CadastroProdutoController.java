package com.example.trabalho2bim.activity.controller;

import android.content.Context;

import com.example.trabalho2bim.activity.dao.CadastroProdutoDao;
import com.example.trabalho2bim.activity.model.CadastroProduto;

import java.util.ArrayList;

public class CadastroProdutoController {

    private Context context;

    public CadastroProdutoController(Context context) {
        this.context = context;
    }

    public String salvarCadastroProduto(String descricao,int codigo, double vlunit,int quantidade ){
        try{
            //Validar se os campos estão vazios
            if(descricao.equals("") || descricao.isEmpty()){
                return "Informe a descri!";
            }
            if(vlunit.equals("") || vlunit.isEmpty()){
                return "Informe o valor unitario!";
            }
            if(quantidade.equals("") || quantidade.isEmpty()){
                return "Informe a quantidade!";
            }

            //Validar se já existe o aluno cadastrado
            CadastroProduto cadastroProduto = CadastroProdutoDao.getInstancia(context)
                    .getById(Integer.parseInt(codigo));

            if(cadastroProduto != null){
                return "O RA ("+codigo+") já está cadastrado!";
            }else{
                cadastroProduto = new CadastroProduto();
               cadastroProduto.setCodigo(codigo);
               cadastroProduto.setDescricao(descricao);
               cadastroProduto.setVlunit(vlunit);


                CadastroProdutoDao.getInstancia(context).insert(cadastroProduto);
            }
        }catch (Exception ex){
            return "Erro ao gravar Aluno.";
        }
        return null;
    }

    public ArrayList<CadastroProduto> retornarProdutos(){
        return CadastroProdutoDao.getInstancia(context).getAll();
    }
}
