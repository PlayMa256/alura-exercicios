package caelum.com.br.testederegistrodecoisas.adapter;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import caelum.com.br.testederegistrodecoisas.ListagemAlunosActivity;
import caelum.com.br.testederegistrodecoisas.R;
import modelo.Aluno;

/**
 * Created by adm on 05/10/2015.
 */
public class AlunoAdapter extends BaseAdapter{
    private List<Aluno> alunos;
    private ListagemAlunosActivity activity;

    public AlunoAdapter(List<Aluno> alunos, ListagemAlunosActivity listagemAlunosActivity) {
        this.alunos = alunos;
        this.activity = listagemAlunosActivity;
    }

    @Override
    public int getCount() {
        return alunos.size();
    }

    @Override
    public Object getItem(int position) {
        return alunos.get(position);
    }

    @Override
    public long getItemId(int position) {
        return alunos.get(position).getID();

    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        Aluno aluno = alunos.get(position);
        LayoutInflater inflater = this.activity.getLayoutInflater();
        View linha = inflater.inflate(R.layout.item, null);

        if(position %2 == 0){
            linha.setBackgroundColor(activity.getResources().getColor(R.color.linha_par));
        }else{
            linha.setBackgroundColor(activity.getResources().getColor(R.color.linha_impar));
        }

        TextView nome = (TextView) linha.findViewById(R.id.nome);
        nome.setText(aluno.getNome());

        ImageView foto = (ImageView) linha.findViewById(R.id.foto);
        if(aluno.getCaminhoFoto() != null) {
            Bitmap imagem = BitmapFactory.decodeFile(aluno.getCaminhoFoto());
            Bitmap scaledBitmap = Bitmap.createScaledBitmap(imagem, 100, 100, true);
            foto.setImageBitmap(scaledBitmap);
        }else{
            foto.setImageResource(R.drawable.ic_no_image);
        }
        return linha;
    }
}
