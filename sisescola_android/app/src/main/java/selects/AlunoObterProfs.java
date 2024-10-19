package selects;

import android.content.Context;
import android.graphics.Color;
import android.os.AsyncTask;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import com.edusyst.edusyst.R;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class AlunoObterProfs extends AsyncTask<Integer, Void, String> {

    private Context context;
    private TableLayout tableLayout;

    public AlunoObterProfs(Context context, TableLayout tableLayout) {
        this.context = context;
        this.tableLayout = tableLayout;
    }

    @Override
    protected String doInBackground(Integer... params) {
        int idAluno = params[0];
        StringBuilder result = new StringBuilder();
        try {
            URL url = new URL("http://10.0.2.2/sisescola_web_android/aluno_obterprofessores.php?id_aluno=" + idAluno);
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

            String[] headers = {"Nome", "Email", "Matéria"};

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
                nameView.setText(jsonObject.getString("professor_nome"));
                nameView.setTextSize(text_size); // Set font size for name
                nameView.setPadding(padding, padding, padding, padding); // Add padding to name
                row.addView(nameView);

                TextView emailView = new TextView(context);
                emailView.setText(jsonObject.getString("professor_email"));
                emailView.setTextSize(text_size); // Set font size for email
                emailView.setPadding(padding, padding, padding, padding); // Add padding to email
                row.addView(emailView);

                TextView materiaView = new TextView(context);
                materiaView.setText(jsonObject.getString("materia_nome"));
                materiaView.setTextSize(text_size); // Set font size for materia
                materiaView.setPadding(padding, padding, padding, padding); // Add padding to materia
                row.addView(materiaView);

                tableLayout.addView(row);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
