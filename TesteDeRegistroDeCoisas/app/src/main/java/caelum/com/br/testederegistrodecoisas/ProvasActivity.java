package caelum.com.br.testederegistrodecoisas;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;
import android.widget.Toast;

import java.lang.reflect.Array;

import fragment.ListaProvasFragment;
import modelo.Prova;

/**
 * Created by adm on 07/10/2015.
 */
public class ProvasActivity extends FragmentActivity {

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.provas);

        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        if(isTablet()) {
            transaction.replace(R.id.provas_lista, new ListaProvasFragment());
            transaction.replace(R.id.provas_detalhe, new DetalhesProvaFragment());
        }else{
            transaction.replace(R.id.provas_view, new ListaProvasFragment());
        }
        transaction.commit();

    }
    private boolean isTablet(){
       return getResources().getBoolean(R.bool.isTablet);
    }


    public void SelecionaProva(Prova prova_selecionada) {
//        Bundle cabide = new Bundle();
//        cabide.putSerializable("prova", prova_selecionada);
//


//        FragmentTransaction tx = getSupportFragmentManager().beginTransaction();
//        if(isTablet()){
//            tx.replace(R.id.provas_detalhe, detalhesProvaFragment);
//        }else{
//            tx.replace(R.id.provas_view, detalhesProvaFragment);
//            tx.addToBackStack(null);
//        }
//
//        tx.commit();

    }
}
