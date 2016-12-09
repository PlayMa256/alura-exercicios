package converter;

import org.json.JSONException;
import org.json.JSONStringer;

import java.util.List;

import modelo.Aluno;

/**
 * Created by adm on 05/10/2015.
 */
public class AlunoConverter {
    public String toJSON(List<Aluno> alunos){
        JSONStringer jsonStringer = new JSONStringer();
        try {
            jsonStringer.object().key("list").array();
            jsonStringer.object().key("aluno").array();
            for (Aluno aluno :
                    alunos) {
                jsonStringer.object();
                jsonStringer.key("nome").value(aluno.getNome());
                jsonStringer.key("nota").value(aluno.getNota());
                jsonStringer.endObject();
            }
            jsonStringer.endArray();
            jsonStringer.endObject();
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jsonStringer.toString();
    }
}
