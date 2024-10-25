package selects_alunos;

import android.content.Context;
import android.graphics.Color;
import android.os.AsyncTask;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class AlunoObterTurma extends AsyncTask<Integer, Void, String> {

    private Context context;
    private TableLayout tableLayout;

    public AlunoObterTurma(Context context, TableLayout tableLayout) {
        this.context = context;
        this.tableLayout = tableLayout;
    }

    @Override
    protected String doInBackground(Integer... params) {
        int idAluno = params[0];
        StringBuilder result = new StringBuilder();
        try {
            URL url = new URL("http://10.0.2.2/sisescola_web_android/aluno_obterturma.php?id_aluno=" + idAluno);
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
            int text_size = 16;
            int padding = 10;

            JSONArray jsonArray = new JSONArray(result);

            // Clear the table before adding new data
            tableLayout.removeAllViews();

            // Create table headers
            TableRow headerRow = new TableRow(context);
            headerRow.setBackgroundColor(Color.parseColor("#023047"));

            String[] headers = {"Aluno", "Email", "Classe"};

            for (String header : headers) {
                TextView headerView = new TextView(context);
                headerView.setText(header);
                headerView.setTextColor(Color.parseColor("#FFFFFF"));
                headerView.setTextSize(text_size); // Set font size for header
                headerView.setPadding(padding, padding, padding, padding); // Add padding to header
                headerRow.addView(headerView);
            }
            tableLayout.addView(headerRow);

            // Add rows to the table
            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject jsonObject = jsonArray.getJSONObject(i);

                TableRow row = new TableRow(context);

                TextView nomeView = new TextView(context);
                nomeView.setText(jsonObject.getString("aluno_nome"));
                nomeView.setTextSize(text_size); // Set font size for name
                nomeView.setPadding(padding, padding, padding, padding); // Add padding to name
                row.addView(nomeView);

                TextView emailView = new TextView(context);
                emailView.setText(jsonObject.getString("aluno_email"));
                emailView.setTextSize(text_size); // Set font size for name
                emailView.setPadding(padding, padding, padding, padding); // Add padding to name
                row.addView(emailView);

                TextView classeView = new TextView(context);
                classeView.setText(jsonObject.getString("turma_classe"));
                classeView.setTextSize(text_size); // Set font size for name
                classeView.setPadding(padding, padding, padding, padding); // Add padding to name
                row.addView(classeView);

                tableLayout.addView(row);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}