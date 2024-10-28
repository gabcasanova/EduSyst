package selects_professores;

import android.os.AsyncTask;
import android.widget.TextView;

import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class ProfObterNome extends AsyncTask<Integer, Void, String> {

    private TextView tv_profNome;

    public ProfObterNome(TextView tv_profInfo) {
        this.tv_profNome = tv_profInfo;
    }

    @Override
    protected String doInBackground(Integer... params) {
        int idProfessor = params[0];
        StringBuilder result = new StringBuilder();
        try {
            URL url = new URL("http://10.0.2.2/sisescola_web_android/prof_obternome.php?id_professor=" + idProfessor);
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
            String nome = jsonObject.getString("nome"); // Extract 'Nome' from JSON

            tv_profNome.setText(nome);
        } catch (Exception e) {
            e.printStackTrace();
            tv_profNome.setText("Erro interpretando informações.");
        }
    }
}
