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

public class AlunoObterBol extends AsyncTask<Integer, Void, String> {

    private Context context;
    private TableLayout tableLayout;

    public AlunoObterBol(Context context, TableLayout tableLayout) {
        this.context = context;
        this.tableLayout = tableLayout;
    }

    @Override
    protected String doInBackground(Integer... params) {
        int idAluno = params[0];
        StringBuilder result = new StringBuilder();
        try {
            URL url = new URL("http://10.0.2.2/sisescola_web_android/aluno_obterbol.php?id_aluno=" + idAluno);
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

            String[] headers = {"Matéria", "Professor", "Turma", "1 B", "2 B", "3 B", "4 B"};

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

                TextView materiaView = new TextView(context);
                materiaView.setText(jsonObject.getString("materia_nome"));
                materiaView.setTextSize(text_size); // Set font size for name
                materiaView.setPadding(padding, padding, padding, padding); // Add padding to name
                row.addView(materiaView);

                TextView professorView = new TextView(context);
                professorView.setText(jsonObject.getString("professor_nome"));
                professorView.setTextSize(text_size); // Set font size for name
                professorView.setPadding(padding, padding, padding, padding); // Add padding to name
                row.addView(professorView);

                TextView turmaView = new TextView(context);
                turmaView.setText(jsonObject.getString("turma_classe"));
                turmaView.setTextSize(text_size); // Set font size for name
                turmaView.setPadding(padding, padding, padding, padding); // Add padding to name
                row.addView(turmaView);

                TextView primeiraEtapaView = new TextView(context);
                primeiraEtapaView.setText(jsonObject.getString("primeira_etapa"));
                primeiraEtapaView.setTextSize(text_size); // Set font size for name
                primeiraEtapaView.setPadding(padding, padding, padding, padding); // Add padding to name
                row.addView(primeiraEtapaView);

                TextView segundaEtapaView = new TextView(context);
                segundaEtapaView.setText(jsonObject.getString("segunda_etapa"));
                segundaEtapaView.setTextSize(text_size); // Set font size for name
                segundaEtapaView.setPadding(padding, padding, padding, padding); // Add padding to name
                row.addView(segundaEtapaView);

                TextView terceiraEtapaView = new TextView(context);
                terceiraEtapaView.setText(jsonObject.getString("terceira_etapa"));
                terceiraEtapaView.setTextSize(text_size); // Set font size for name
                terceiraEtapaView.setPadding(padding, padding, padding, padding); // Add padding to name
                row.addView(terceiraEtapaView);

                TextView quartaEtapaView = new TextView(context);
                quartaEtapaView.setText(jsonObject.getString("quarta_etapa"));
                quartaEtapaView.setTextSize(text_size); // Set font size for name
                quartaEtapaView.setPadding(padding, padding, padding, padding); // Add padding to name
                row.addView(quartaEtapaView);

                tableLayout.addView(row);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}