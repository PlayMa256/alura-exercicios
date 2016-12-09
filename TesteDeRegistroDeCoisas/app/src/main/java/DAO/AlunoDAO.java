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
public class AlunoDAO extends SQLiteOpenHelper{
    private static final String DATABASE = "NomedoBanco";
    //alterar caso queira editar, ele chamara o onupgrade
    private static final int VERSAO = 1;
    private static final String TABELA = "Alunos";
    private List<Aluno> lista;


    //context é utilizado quando precisa-se de um recurso do aparelho
    public AlunoDAO(Context context) {
        super(context, DATABASE, null, VERSAO);
    }

    //so será executado se a tabela nao existir.
    @Override
    public void onCreate(SQLiteDatabase database) {
        String sql = "CREATE TABLE " + TABELA + " (" +
                "id INTEGER PRIMARY KEY, " +
                "nome TEXT UNIQUE NOT NULL, " +
                "telefone TEXT, " +
                "endereco TEXT, " +
                "site TEXT, " +
                "nota REAL, " +
                "caminhoFoto TEXT" +
                ");";
        database.execSQL(sql);
    }

    //será executado de varias formas
    @Override
    public void onUpgrade(SQLiteDatabase database, int oldVersion, int newVersion) {
        String sql = "DROP TABLE IF EXISTS " + TABELA;
        database.execSQL(sql);
        onCreate(database);
    }

    private ContentValues toValues(Aluno aluno){
        //pacote para conseguir inserir tudo de uma vez
        ContentValues cv = new ContentValues();
        cv.put("nome", aluno.getNome());
        cv.put("telefone", aluno.getTelefone());
        cv.put("endereco", aluno.getEndereco());
        cv.put("site", aluno.getSite());
        cv.put("nota", aluno.getNota());
        cv.put("caminhoFoto", aluno.getCaminhoFoto());

        return cv;
    }
    public void insere(Aluno aluno) {
        ContentValues cv = this.toValues(aluno);
        //obtendo acesso ao banco
        getWritableDatabase().insert(TABELA, null, cv);

    }


    public List<Aluno> getLista() {
        ArrayList<Aluno> alunos = new ArrayList<>();
        String sql = "SELECT * FROM " + TABELA + ";";
        //quando retorna-se resultados, nao da pra saber quantos elementos tem la dentro.
        // mas so sabe se está vazio ou nao.
        Cursor c = getReadableDatabase().rawQuery(sql, null);
        while (c.moveToNext()){
            Aluno aluno = new Aluno(c.getString(c.getColumnIndex("nome")), c.getString(c.getColumnIndex("endereco")), c.getString(c.getColumnIndex("site")), c.getString(c.getColumnIndex("telefone")), c.getDouble(c.getColumnIndex("nota")));
            aluno.setCaminhoFoto(c.getString(c.getColumnIndex("caminhoFoto")));
            aluno.setID(c.getLong(c.getColumnIndex("id")));
            alunos.add(aluno);
        }
        return alunos;
    }

    public void deletar(Aluno aluno) {
        String[] args = {Long.toString(aluno.getID())};
        getWritableDatabase().delete(TABELA, "id=?", args);
    }

    public void atualizar(Aluno aluno) {
        ContentValues cv = new ContentValues();
        cv.put("nome", aluno.getNome());
        cv.put("telefone", aluno.getTelefone());
        cv.put("endereco", aluno.getEndereco());
        cv.put("site", aluno.getSite());
        cv.put("nota", aluno.getNota());
        cv.put("caminhoFoto", aluno.getCaminhoFoto());

        //obtendo acesso ao banco
        String[] args = {Long.toString(aluno.getID())};
        getWritableDatabase().update(TABELA, cv, "id=?", args);

    }

    public boolean ehAluno(String telefone) {
        String[] args = {telefone};
        Cursor cursor = getReadableDatabase().rawQuery("SELECT id FROM Alunos WHERE telefone = ?", args);
        if(cursor.moveToFirst()){
            return true;
        }
        return false;

    }
}
