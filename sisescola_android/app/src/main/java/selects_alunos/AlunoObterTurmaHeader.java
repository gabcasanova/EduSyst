package selects_alunos;

import android.os.AsyncTask;
import android.widget.TextView;

import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class AlunoObterTurmaHeader extends AsyncTask<Integer, Void, String> {

    private TextView tv_alunoNome;

    public AlunoObterTurmaHeader(TextView tv_alunoInfo) {
        this.tv_alunoNome = tv_alunoInfo;
    }

    @Override
    protected String doInBackground(Integer... params) {
        int idAluno = params[0];
        StringBuilder result = new StringBuilder();
        try {
            URL url = new URL("http://10.0.2.2/sisescola_web_android/aluno_obterturmaheader.php?id_aluno=" + idAluno);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");

            BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            String line;
            while ((line = reader.readLine()) != null) {
                result.append(line);
            }
            reader.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result.toString();
    }

    @Override
    protected void onPostExecute(String result) {
        try {
            // Parse result as JSON object
            JSONObject jsonObject = new JSONObject(result);
            String classe = jsonObject.getString("classe");
            String etapa = jsonObject.getString("etapa");

            tv_alunoNome.setText("Turma: " + classe + "\n" + "Etapa: " + etapa);
        } catch (Exception e) {
            e.printStackTrace();
            tv_alunoNome.setText("Erro interpretando informações.");
        }
    }
}
