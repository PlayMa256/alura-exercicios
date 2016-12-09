package caelum.com.br.cadastroalunos;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

/**
 * Created by adm on 28/09/2015.
 */
public class ListagemAlunosActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.listagem);
        ListView lv = (ListView) findViewById(R.id.lista);
        String[] Alunos = {"Marcelo", "teste"};
        ArrayAdapter<String> stringArrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_expandable_list_item_1, Alunos);
        lv.setAdapter(stringArrayAdapter);

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(ListagemAlunosActivity.this, "Item pressionado: " + i, Toast.LENGTH_LONG).show();
            }
        });

        lv.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(ListagemAlunosActivity.this, "Nome: "+adapterView.getItemAtPosition(i), Toast.LENGTH_SHORT).show();
                return false;
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_lista_alunos, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.novo:
                Intent irParaFormulario = new Intent(this, CadastraAlunoActivity.class);
                startActivity(irParaFormulario);

                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
