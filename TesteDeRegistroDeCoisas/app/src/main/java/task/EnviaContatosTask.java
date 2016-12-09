package task;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.widget.Toast;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.List;

import DAO.AlunoDAO;
import converter.AlunoConverter;
import modelo.Aluno;
import suporte.WebClient;

/**
 * Created by adm on 07/10/2015.
 */
public class EnviaContatosTask extends AsyncTask<Object, Object, String> {
    private final Context ctx;
    ProgressDialog mensagem;
    public EnviaContatosTask(Context ctx) {
        this.ctx = ctx;
    }

    //colocar pra dizer que a task esta sendo executada
    //usada para falar com usuario
    @Override
    protected void onPreExecute() {

        mensagem = ProgressDialog.show(ctx, "Aguarde...", "Mensagem");

    }

    @Override
    protected String doInBackground(Object[] params) {
        AlunoDAO dao = new AlunoDAO(ctx);
        List<Aluno> lista = dao.getLista();
        dao.close();
        String Json = new AlunoConverter().toJSON(lista);
        String resultado = null;
        try {
            resultado = new WebClient("url").post(Json);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return resultado;
    }

    @Override
    protected void onPostExecute(String result) {
        //retorno da coisa;
        Toast.makeText(ctx, "retorno", Toast.LENGTH_SHORT).show();
        mensagem.dismiss();

    }
}
