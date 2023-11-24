package com.example.trabalho2bim.activity.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;


import com.example.trabalho2bim.activity.dao.GenericDao;
import com.example.trabalho2bim.activity.helper.SQLiteDataHelper;
import com.example.trabalho2bim.activity.model.CadastroProduto;


import java.util.ArrayList;
public class CadastroProdutoDao implements GenericDao<CadastroProduto> {
    //Variavel para abrir a conexão com BD
    private SQLiteOpenHelper openHelper;

    //Base de Dados
    private SQLiteDatabase bd;

    //Nome da tabela
    private String nomeTabela = "CADASTROALUNO";

    //Nome das colunas da tabela
    private String[]colunas = {"DESCRICAO", "NOME","VALORUNITARIO"};

    private Context context;

    private static CadastroProdutoDao instancia;

    public static CadastroProdutoDao getInstancia(Context context){
        if(instancia == null){
            return instancia = new CadastroProdutoDao(context);
        }else{
            return instancia;
        }
    }

    private CadastroProdutoDao(Context context) {
        this.context = context;

        //Abrir uma conexão da BD
        openHelper = new SQLiteDataHelper(this.context, "UNIPAR_BD",
                null, 1);
        //Carrega a BD e da permissão para escrever na tabela
        bd = openHelper.getWritableDatabase();
    }

    @Override
    public long insert(CadastroProduto obj) {
        try{
            ContentValues valores = new ContentValues();
            valores.put(colunas[0], obj.getDescricao());
            valores.put(colunas[1], obj.getCodigo());

            return bd.insert(nomeTabela, null, valores);

        }catch (SQLException ex){
            Log.e("ERRO", "CadastroProdutoDao.insert(): "+ex.getMessage());
        }
        return 0;
    }

    @Override
    public long update(CadastroProduto obj) {
        try{
            ContentValues valores = new ContentValues();
            valores.put(colunas[1], obj.getDescricao());
            valores.put(colunas[2], obj.getQuantidade());
            valores.put(colunas[3]), obj.getVlunit();

            String[]identificador = {String.valueOf(obj.getCodigo())};
            return bd.update(nomeTabela, valores,
                    colunas[0]+" = ?", identificador);


        }catch (SQLException ex){
            Log.e("ERRO", "CadastroProdutoDao.update(): "+ex.getMessage());
        }
        return 0;
    }

    @Override
    public long delete(CadastroProduto obj) {
        try{

            String[]identificador = {String.valueOf(obj.getCodigo())};
            return bd.delete(nomeTabela, colunas[0]+" = ?",
                    identificador);

        }catch (SQLException ex){
            Log.e("ERRO", "CadastroProdutoDao.delete(): "+ex.getMessage());
        }
        return 0;
    }

    @Override
    public ArrayList<CadastroProduto> getAll() {
        ArrayList<CadastroProduto> lista = new ArrayList<>();
        try{
            Cursor cursor = bd.query(nomeTabela, colunas,
                    null, null, null,
                    null, colunas[0]);

            //Verifica se é possível retornar o ponteiro para
            // a primeira posição do cursor
            if(cursor.moveToFirst()){
                do{
                    CadastroProduto cadastroProduto = new CadastroProduto();
                    cadastroProduto.setDescricao((cursor.getString(0));
                    cadastroProduto.setQuantidade(cursor.getInt(1));
                    cadastroProduto.setVlunit(cursor.getDouble(2));

                    lista.add(cadastroProduto);

                }while (cursor.moveToNext());
            }
        }catch (SQLException ex){
            Log.e("ERRO", "CadastroProdutoDao.getAll(): "+ex.getMessage());
        }
        return lista;
    }

    @Override
    public CadastroProduto getById(int id) {
        try{
            String[]identificador = {String.valueOf(id)};
            Cursor cursor = bd.query(nomeTabela, colunas,
                    colunas[0]+" = "+id, null,
                    null, null, null);

            //Verifica se é possível retornar o ponteiro para
            // a primeira posição do cursor
            if(cursor.moveToFirst()){
                CadastroProduto cadastroProduto = new CadastroProduto();
                cadastroProduto.setCodigo(cursor.getInt(0));
                cadastroProduto.setDescricao(cursor.getString(1));

                return cadastroProduto;
            }

        }catch (SQLException ex){
            Log.e("ERRO", "AlunoDao.getById(): "+ex.getMessage());
        }

        return null;
    }
}
