package caelum.com.br.testederegistrodecoisas;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.Toast;

import java.io.File;
import java.io.Serializable;

import DAO.AlunoDAO;
import modelo.Aluno;

import static android.content.DialogInterface.*;

/**
 * Created by adm on 28/09/2015.
 */
public class CadastraAlunoActivity extends Activity {
    private FormularioHelper formHelper;
    private String caminhoArquivo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.formulario);
        final Button botao = (Button) findViewById(R.id.botao);
        formHelper = new FormularioHelper(CadastraAlunoActivity.this);

        //aluno que veio selecionado da listagem
        final Aluno alunoParaSerAlterado = (Aluno) getIntent().getSerializableExtra("alunoSelecionado");
        //verificar se veio algum aluno
        if(alunoParaSerAlterado != null){
            formHelper.colocaAlunoFormulario(alunoParaSerAlterado);
        }



        botao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //captura dos dados dos campos para poder fazer a persistencia dos dados em banco.
                Aluno aluno = formHelper.pegaAlunoFormulario();
                //salva os dados
                AlunoDAO dao = new AlunoDAO(CadastraAlunoActivity.this);

                if(alunoParaSerAlterado != null){
                    aluno.setID(alunoParaSerAlterado.getID());
                    botao.setText("Alterar");
                    //significa que quero atualizar os dados
                    dao.atualizar(aluno);
                }else {
                    //salvar os dados
                    dao.insere(aluno);
                }
                dao.close();
                finish();
            }
        });

        ImageView foto = formHelper.getFoto();
        foto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent irParaCamera = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                //criacao do diretorio e arquivo
                caminhoArquivo = getExternalFilesDir(null)+"/aluno"+System.currentTimeMillis()+".png";
                //criando o arquivo efetivamente
                File arquivo = new File(caminhoArquivo);
                //local pra onde a foto sera enviada depois que foto for aceita
                Uri localDaFoto = Uri.fromFile(arquivo);
                //a camera ira guardar nesse diretorio
                irParaCamera.putExtra(MediaStore.EXTRA_OUTPUT, localDaFoto);
                startActivityForResult(irParaCamera, 123);


            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        if (requestCode == 123) {
            if (resultCode == Activity.RESULT_OK) {
                Log.i("aplicativo", caminhoArquivo);
                formHelper.carregaFoto(this.caminhoArquivo);
            } else {
                this.caminhoArquivo = null;
            }
        }
    }
}
