package DAO;

import android.content.Context;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by adm on 01/10/2015.
 */
public class DAOHelper extends SQLiteOpenHelper {

    private static final String DATABASE = "teste";
    private static final int VERSAO = 1;

    public DAOHelper(Context context) {
        super(context, DATABASE, null, VERSAO);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql1 = "CREATE table ...";
        String Sql2 = "create table2....";
        db.execSQL(sql1);
        db.execSQL(Sql2);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
