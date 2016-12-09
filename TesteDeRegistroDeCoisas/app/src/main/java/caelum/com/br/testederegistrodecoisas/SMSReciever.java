package caelum.com.br.testederegistrodecoisas;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.telephony.SmsMessage;
import android.widget.Toast;

import DAO.AlunoDAO;

/**
 * Created by adm on 05/10/2015.
 */

//classe que irá ficar "ouvindo" sms chegar
public class SMSReciever extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
//        //pegar ultimo sms
//        //com o metodo get vc pega apenas as mensagens
//        Object[] mensagens = (Object[]) intent.getExtras().get("pdus");
//        //ultima mensagem que chegou
//        byte[] mensagem = (byte[]) mensagens[0];
//
//        //classe que representa um sms de fato
//        SmsMessage sms = SmsMessage.createFromPdu(mensagem);
//        String telefone = sms.getOriginatingAddress();
//
//        boolean smsEhDeAluno = new AlunoDAO(context).ehAluno(telefone);
//        if(smsEhDeAluno){
//            MediaPlayer musica = MediaPlayer.create(context, R.raw.msg);
//            musica.start();
//        }

    }
}
