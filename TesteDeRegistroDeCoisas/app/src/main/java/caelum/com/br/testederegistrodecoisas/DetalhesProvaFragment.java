package caelum.com.br.testederegistrodecoisas;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.Serializable;

import modelo.Prova;

/**
 * Created by adm on 07/10/2015.
 */


public class DetalhesProvaFragment extends Fragment{

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View layout = inflater.inflate(R.layout.provas_detalhe, container, false);
//
//        Bundle b = getArguments();
//        if(b != null){
//            Toast.makeText(getActivity(), "prova: "+ b.getSerializable("prova").toString(), Toast.LENGTH_SHORT).show();
//        }


//        if(getArguments() != null){
//            Prova prova = (Prova) getArguments().getSerializable("prova");
//            TextView materia = (TextView) layout.findViewById(R.id.detalhe_prova_materia);
//            materia.setText(prova.getMateria());
//            TextView data = (TextView) layout.findViewById(R.id.detalhe_prova_data);
//            data.setText(prova.getData());
//            ListView topicos = (ListView) layout.findViewById(R.id.detalhe_prova_topicos);
//
//            ArrayAdapter arrayAdapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1, prova.getTopicos());
//            topicos.setAdapter(arrayAdapter);
//
//
//
//        }

        return layout;
    }
}

