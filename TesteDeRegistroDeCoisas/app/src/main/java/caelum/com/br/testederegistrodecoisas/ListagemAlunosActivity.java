package caelum.com.br.testederegistrodecoisas;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.List;

import DAO.AlunoDAO;
import caelum.com.br.testederegistrodecoisas.adapter.AlunoAdapter;
import fragment.MapaFragment;
import modelo.Aluno;

/**
 * Created by adm on 28/09/2015.
 */
public class ListagemAlunosActivity extends Activity {
    private Aluno aluno;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.listagem);
        ListView lv = (ListView) findViewById(R.id.lista);

        //registrando o menu de contexto para a view.
        registerForContextMenu(lv);

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> adapter, View view, int posicao, long id) {
                Aluno alunoParaSerAlterado = (Aluno) adapter.getItemAtPosition(posicao);
                //indo para a outra activity
                Intent irparaoformulario = new Intent(ListagemAlunosActivity.this, CadastraAlunoActivity.class);
                //enviando aluno para o formulario.
                //há a necessidade de implementar serialazible em aluno para que ele consiga ser passado como objeto serializable.
                irparaoformulario.putExtra(Extras.ALUNO_SELECIONADO, alunoParaSerAlterado);
                startActivity(irparaoformulario);
            }
        });

        lv.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
                //retornando aluno clicado
                aluno = (Aluno) adapterView.getItemAtPosition(i);

                //retorna falso, assim ele nao irá aparecer
                return false;
            }
        });

    }

    @Override
    protected void onResume() {
        super.onResume();
        carregaLista();
    }

    private void carregaLista() {
        ListView lv = (ListView) findViewById(R.id.lista);
        AlunoDAO dao = new AlunoDAO(ListagemAlunosActivity.this);
        List<Aluno> alunos = dao.getLista();
        ArrayAdapter<Aluno> adapter = new ArrayAdapter<Aluno>(this, android.R.layout.simple_list_item_1, alunos);
        lv.setAdapter(adapter);

//        AlunoAdapter adapter = new AlunoAdapter(alunos, this);
//        lv.setAdapter(adapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_lista_alunos, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.menu_novo:
                Intent irParaFormulario = new Intent(this, CadastraAlunoActivity.class);
                startActivity(irParaFormulario);
            break;
            case R.id.menu_mapa:
                Intent intent = new Intent(this, MapaFragment.class);
                startActivity(intent);
                return false;
            case R.id.menu_receber_provas:
                Intent irParaFragment = new Intent(this, ProvasActivity.class);
                startActivity(irParaFragment);
                return false;
            default:
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    //menu de contexto
    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        MenuItem ligar = menu.add("Ligar");
        MenuItem sms = menu.add("Enviar SMS");
        MenuItem mapa = menu.add("Achar no mapa");
        MenuItem site = menu.add("Navegar no site");
        MenuItem deletar = menu.add("Deletar");
        MenuItem email = menu.add("Enviar E-mail");


        //consigo fazer a chamada para intents tanto no click, como por fora, setando o intent
        Intent intentSms = new Intent(Intent.ACTION_VIEW);
        intentSms.setData(Uri.parse("sms:"+aluno.getTelefone()));
        intentSms.putExtra("sms_body", "Mensagem");
        sms.setIntent(intentSms);

        Intent intentMapa = new Intent(Intent.ACTION_VIEW);
        intentMapa.setData(Uri.parse("geo:0,0?z=14&q=" + aluno.getEndereco()));
        mapa.setIntent(intentMapa);

        Intent intentEmail = new Intent(Intent.ACTION_SEND);
        intentEmail.setType("message/rtc822");
        intentEmail.putExtra(Intent.EXTRA_EMAIL, new String[] {"email-do-aluno@yahoo.com.br"});
        intentEmail.putExtra(Intent.EXTRA_SUBJECT, "Testando subject do email");
        intentEmail.putExtra(Intent.EXTRA_TEXT, "Testando corpo do email");
        email.setIntent(intentEmail);

        site.setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                Intent AbriroSiteDoAluno = new Intent(Intent.ACTION_VIEW);
                Uri siteDoAluno = Uri.parse("http://"+aluno.getSite());
                AbriroSiteDoAluno.setData(siteDoAluno);
                startActivity(AbriroSiteDoAluno);
                return false;
            }
        });

        //ao clicar no menu de contexto que aparece com o clicklongo
        deletar.setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                AlunoDAO dao = new AlunoDAO(ListagemAlunosActivity.this);
                dao.deletar(aluno);
                dao.close();
                carregaLista();

                return false;
            }
        });
        ligar.setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                //chamando intent implicita para a tela de discagem
                Intent irparaTeladeDiscagem = new Intent(Intent.ACTION_VIEW);
                Uri telefoneDoAluno = Uri.parse("tel:"+ aluno.getTelefone());
                irparaTeladeDiscagem.setData(telefoneDoAluno);
                startActivity(irparaTeladeDiscagem);


                return false;
            }
        });


        super.onCreateContextMenu(menu, v, menuInfo);

    }

}
