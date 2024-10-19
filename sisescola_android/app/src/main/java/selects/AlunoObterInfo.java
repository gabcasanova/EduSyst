package selects;

import android.os.AsyncTask;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class AlunoObterInfo extends AsyncTask<Integer, Void, String> {

    private TextView tv_alunoInfo;

    public AlunoObterInfo(TextView tv_alunoInfo) {
        this.tv_alunoInfo = tv_alunoInfo;
    }

    @Override
    protected String doInBackground(Integer... params) {
        int idAluno = params[0];
        StringBuilder result = new StringBuilder();
        try {
            URL url = new URL("http://10.0.2.2/sisescola_web_android/aluno_obterinfo.php?id_aluno=" + idAluno);
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
            JSONArray jsonArray = new JSONArray(result);
            if (jsonArray.length() > 0) {
                JSONObject jsonObject = jsonArray.getJSONObject(0);
                String info = "Nome: " + jsonObject.getString("Nome") + "\n" +
                        "CPF: " + jsonObject.getString("CPF") + "\n" +
                        "Email: " + jsonObject.getString("Email") + "\n" +
                        "Data Nasc: " + jsonObject.getString("Data_Nasc") + "\n" +
                        "Endereço: " + jsonObject.getString("Endereco") + "\n" +
                        "Telefone: " + jsonObject.getString("Telefone") + "\n" +
                        "Gênero: " + jsonObject.getString("Genero")
                        ;

                tv_alunoInfo.setText(info);
            } else {
                tv_alunoInfo.setText("Nenhuma Informação Encontrada.");
            }
        } catch (Exception e) {
            e.printStackTrace();
            tv_alunoInfo.setText("Erro interpretando informações.");
        }
    }
}
