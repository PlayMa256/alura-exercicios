package fragment;
import android.support.v4.*;
import android.util.Log;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.List;

import DAO.AlunoDAO;
import caelum.com.br.testederegistrodecoisas.Localizador;
import modelo.Aluno;

/**
 * Created by adm on 07/10/2015.
 */


public class MapaFragment extends SupportMapFragment {

    @Override
    public void onResume() {
        super.onResume();

        Localizador coderUtil = new Localizador(getActivity());
        LatLng local = coderUtil.getCoordenada("Rua Vergueiro 3185 Vila Mariana");
        centralizaNo(local);

        AlunoDAO dao;
        dao = new AlunoDAO(getActivity());
        List<Aluno> alunos = dao.getLista();
        dao.close();

        for (Aluno aluno : alunos) {
            Localizador localizador = new Localizador(getActivity());

            LatLng coordenada = localizador.getCoordenada(aluno.getEndereco());

            if (coordenada != null) {
                MarkerOptions marcador = new MarkerOptions().position(coordenada)
                        .title(aluno.getNome()).snippet(aluno.getEndereco());

                getMap().addMarker(marcador);
            }
        }
    }

    private void centralizaNo(LatLng local) {
        GoogleMap mapa = this.getMap();
        mapa.moveCamera(CameraUpdateFactory.newLatLngZoom(local, 17));
    }
}

