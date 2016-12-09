package DAO;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

import modelo.Aluno;

/**
 * Created by adm on 30/09/2015.
 */
public class AlunoDAOcomHelper{
    private static final String DATABASE = "NomedoBanco";
    //alterar caso queira editar, ele chamara o onupgrade
    private static final int VERSAO = 1;
    private static final String TABELA = "Alunos";
    private List<Aluno> lista;

    DAOHelper helper;

    public AlunoDAOcomHelper(DAOHelper helper) {
        this.helper = helper;
    }
    //context é utilizado quando precisa-se de um recurso do aparelho


    //so será executado se a tabela nao existir.

    public void insere(Aluno aluno) {
        //pacote para conseguir inserir tudo de uma vez
        ContentValues cv = new ContentValues();
        cv.put("nome", aluno.getNome());
        cv.put("telefone", aluno.getTelefone());
        cv.put("endereco", aluno.getEndereco());
        cv.put("site", aluno.getSite());
        cv.put("nota", aluno.getNota());
        cv.put("caminhoFoto", aluno.getCaminhoFoto());

        //obtendo acesso ao banco
        helper.getWritableDatabase().insert(TABELA, null, cv);

    }


    public List<Aluno> getLista() {
        ArrayList<Aluno> alunos = new ArrayList<>();
        String sql = "SELECT * FROM " + TABELA + ";";
        //quando retorna-se resultados, nao da pra saber quantos elementos tem la dentro.
        // mas so sabe se está vazio ou nao.
        Cursor c = helper.getReadableDatabase().rawQuery(sql, null);
        while (c.moveToNext()){
            Aluno aluno = new Aluno(c.getString(c.getColumnIndex("nome")), c.getString(c.getColumnIndex("endereco")), c.getString(c.getColumnIndex("site")), c.getString(c.getColumnIndex("telefone")), c.getDouble(c.getColumnIndex("nota")));
            aluno.setID(c.getLong(c.getColumnIndex("id")));
            alunos.add(aluno);
        }
        return alunos;
    }
}
