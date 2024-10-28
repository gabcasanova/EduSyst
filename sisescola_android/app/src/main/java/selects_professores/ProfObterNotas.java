package selects_professores;

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

public class ProfObterNotas extends AsyncTask<Integer, Void, String> {

    private Context context;
    private TableLayout tableLayout;

    public ProfObterNotas(Context context, TableLayout tableLayout) {
        this.context = context;
        this.tableLayout = tableLayout;
    }

    @Override
    protected String doInBackground(Integer... params) {
        int idProfessor = params[0];
        StringBuilder result = new StringBuilder();
        try {
            URL url = new URL("http://10.0.2.2/sisescola_web_android/prof_obternotas.php?id_professor=" + idProfessor);
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

            String[] headers = {"Matéria", "Alunos", "Turma", "1 B", "2 B", "3 B", "4 B"};

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

                TextView nameView = new TextView(context);
                nameView.setText(jsonObject.getString("nome_materia"));
                nameView.setTextSize(text_size);
                nameView.setPadding(padding, padding, padding, padding);
                row.addView(nameView);

                TextView alunoView = new TextView(context);
                alunoView.setText(jsonObject.getString("nome_aluno"));
                alunoView.setTextSize(text_size);
                alunoView.setPadding(padding, padding, padding, padding);
                row.addView(alunoView);

                TextView turmaView = new TextView(context);
                turmaView.setText(jsonObject.getString("turma_classe"));
                turmaView.setTextSize(text_size);
                turmaView.setPadding(padding, padding, padding, padding);
                row.addView(turmaView);

                TextView pri_bmView = new TextView(context);
                pri_bmView.setText(jsonObject.getString("pri_bm"));
                pri_bmView.setTextSize(text_size);
                pri_bmView.setPadding(padding, padding, padding, padding);
                row.addView(pri_bmView);

                TextView seg_bmView = new TextView(context);
                seg_bmView.setText(jsonObject.getString("seg_bm"));
                seg_bmView.setTextSize(text_size);
                seg_bmView.setPadding(padding, padding, padding, padding);
                row.addView(seg_bmView);

                TextView ter_bmView = new TextView(context);
                ter_bmView.setText(jsonObject.getString("ter_bm"));
                ter_bmView.setTextSize(text_size);
                ter_bmView.setPadding(padding, padding, padding, padding);
                row.addView(ter_bmView);

                TextView quar_bmView = new TextView(context);
                quar_bmView.setText(jsonObject.getString("quar_bm"));
                quar_bmView.setTextSize(text_size);
                quar_bmView.setPadding(padding, padding, padding, padding);
                row.addView(quar_bmView);

                tableLayout.addView(row);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
