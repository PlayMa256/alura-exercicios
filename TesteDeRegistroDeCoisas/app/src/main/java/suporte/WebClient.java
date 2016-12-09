package suporte;

import org.w3c.dom.Entity;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;

/**
 * Created by adm on 05/10/2015.
 */
//classe que vai enviar para o servidor
public class WebClient {
    private URL url;
    public WebClient(String url) throws MalformedURLException {
        this.url = new URL(url);
    }
    public String post(String json) throws IOException {
//
//        HttpURLConnection connection = (HttpURLConnection)url.openConnection();
//        connection.setRequestProperty("Content-type", "application/json;charset=UTF-8");
//        connection.setRequestMethod("POST");
//        connection.setReadTimeout(10000);
//        Writer writer = new OutputStreamWriter(connection.getOutputStream());
//        writer.write(json);
//        writer.flush();
//        writer.close();
//        String resposta = connection.getResponseMessage();



//        URLConnection  urlConn = url.openConnection();
//        urlConn.setDoInput(true);
//        urlConn.setRequestProperty("Content-Type", "application/json");
//        urlConn.connect();
//
//        DataOutputStream dataOutputStream = new DataOutputStream(urlConn.getOutputStream());
//        byte[] data = json.getBytes("UTF-8");
//        dataOutputStream.write(data);
//        dataOutputStream.flush();
//        dataOutputStream.close();
//


        return json;
    }
}
