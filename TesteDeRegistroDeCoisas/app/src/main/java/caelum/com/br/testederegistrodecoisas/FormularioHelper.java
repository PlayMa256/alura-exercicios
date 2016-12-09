package caelum.com.br.testederegistrodecoisas;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Log;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.SeekBar;

import modelo.Aluno;

/**
 * Created by adm on 30/09/2015.
 */
public class FormularioHelper {
    private EditText campo_nome;
    private EditText campo_site;
    private EditText campo_endereco;
    private EditText campo_telefone;
    private SeekBar campo_nota;
    private ImageView foto;
    private Aluno aluno;

    public FormularioHelper(CadastraAlunoActivity activity) {
        campo_nome = (EditText) activity.findViewById(R.id.nome);
        campo_site = (EditText) activity.findViewById(R.id.site);
        campo_endereco = (EditText) activity.findViewById(R.id.endereco);
        campo_telefone = (EditText) activity.findViewById(R.id.telefone);
        campo_nota = (SeekBar) activity.findViewById(R.id.nota);
        foto = (ImageView) activity.findViewById(R.id.foto);
        aluno = new Aluno();
    }

    public Aluno pegaAlunoFormulario() {

        aluno.setNome(campo_nome.getText().toString().trim());
        aluno.setEndereco(campo_endereco.getText().toString().trim());
        aluno.setSite(campo_site.getText().toString().trim());
        aluno.setTelefone(campo_telefone.getText().toString().trim());
        aluno.setCaminhoFoto((String) foto.getTag());
        aluno.setNota((double) campo_nota.getProgress()*2);

        return aluno;
    }


    public ImageView getFoto() {
        return this.foto;
    }

    public void colocaAlunoFormulario(Aluno aluno) {
        this.aluno = aluno;

        campo_nome.setText(aluno.getNome());
        campo_telefone.setText(aluno.getTelefone());
        campo_endereco.setText(aluno.getEndereco());
        campo_site.setText(aluno.getSite());
        campo_nota.setProgress((int) ((double) aluno.getNota() / 2));

        if (aluno.getCaminhoFoto() != null) {
            carregaFoto(aluno.getCaminhoFoto());

        }else{
            Log.i("aplicativo", "CaminhoDaFoto está vazio");
        }

    }

    public void carregaFoto(String caminhoFoto) {

        Bitmap bm = BitmapFactory.decodeFile(caminhoFoto);
        foto.setScaleType(ImageView.ScaleType.FIT_XY);
        foto.setImageBitmap(bm);
        Log.i("aplicativo", this.aluno.getCaminhoFoto());
        foto.setTag(caminhoFoto);

    }
}
