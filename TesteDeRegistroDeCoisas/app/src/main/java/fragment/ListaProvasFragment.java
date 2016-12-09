package fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.Arrays;
import java.util.List;
import android.support.v4.*;

import caelum.com.br.testederegistrodecoisas.ProvasActivity;
import caelum.com.br.testederegistrodecoisas.R;
import modelo.Prova;

/**
 * Created by adm on 07/10/2015.
 */
public class ListaProvasFragment extends Fragment {
    private ListView listview_provas;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        //o container é o pai desta view;
        View layout = inflater.inflate(R.layout.provas_lista, container, false);
        listview_provas = (ListView) layout.findViewById(R.id.lista_provas);

        Prova prova1 = new Prova("17-03-2014", "Matemática");
        prova1.setTopicos(Arrays.asList("Algebra linear", "Calculo", "Geometria", "whatever"));

        Prova prova2 = new Prova("18-12-2014", "Portugues");
        prova2.setTopicos(Arrays.asList("Ortografia", "Redacao"));

        List<Prova> provas = Arrays.asList(prova1, prova2);

        ArrayAdapter arrayAdapter = new ArrayAdapter(getActivity(), android.R.layout.simple_list_item_1, provas);
        listview_provas.setAdapter(arrayAdapter);

//        this.listview_provas.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> adapter, View view, int posicao, long id) {
//                Prova prova_selecionada = (Prova) adapter.getItemAtPosition(posicao);
//                ProvasActivity activity = (ProvasActivity) getActivity();
////                activity.SelecionaProva(prova_selecionada);
//
//            }
//        });

        return layout;


    }
}
