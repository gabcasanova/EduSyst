package com.edusyst.edusyst;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

public class LoginResponsavel extends AppCompatActivity {

    private EditText etCpfResp, etEmailResp, etSenhaResp;
    private Button btEntrarResp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_login_responsavel);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // Toolbar
        Toolbar tb_login = findViewById(R.id.tb_login_resp);
        setSupportActionBar(tb_login);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);

            tb_login.getNavigationIcon().setTint(ContextCompat.getColor(this, R.color.white)); // Mudar cor do botão de voltar
        }

        // Status bar.
        getWindow().setStatusBarColor(ContextCompat.getColor(this, R.color.azulEscuro)); // Mudar a cor do fundo
        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_STABLE | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN);

        // Carregar botões.
        etCpfResp = findViewById(R.id.et_cpfResp);
        etEmailResp = findViewById(R.id.et_emailResp);
        etSenhaResp = findViewById(R.id.et_senhaResp);
        btEntrarResp = findViewById(R.id.bt_entrarResp);

        // Botão login.
        btEntrarResp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                login();
            }
        });
    }

    private void login() {
        String cpf = etCpfResp.getText().toString().trim();
        String email = etEmailResp.getText().toString().trim();
        String senha = etSenhaResp.getText().toString().trim();

        // Checar se não tem campos vazios.
        if (cpf.isEmpty() || email.isEmpty() || senha.isEmpty()) {
            Toast.makeText(this, "Por favor, preencha todos os campos", Toast.LENGTH_SHORT).show();
            return;
        }

        new LoginResponsavel.LoginTask().execute(cpf, email, senha);
    }

    private class LoginTask extends AsyncTask<String, Void, String> {
        @Override
        protected String doInBackground(String... params) {
            String cpf = params[0];
            String email = params[1];
            String senha = params[2];
            String result = "";

            try {
                // Mensagem de debug.
                Log.d("LoginTask", "Attempting to connect to server with CPF: " + cpf);

                // Criar URL e conectar.
                URL url = new URL("http://10.0.2.2/sisescola_web_android/login_resp.php");
                HttpURLConnection conn = (HttpURLConnection) url.openConnection();
                conn.setRequestMethod("POST");
                conn.setDoOutput(true);
                conn.setDoInput(true);

                // Enviar data POST
                OutputStream os = conn.getOutputStream();
                BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(os, "UTF-8"));
                String postData = "cpf=" + URLEncoder.encode(cpf, "UTF-8") +
                        "&email=" + URLEncoder.encode(email, "UTF-8") +
                        "&senha=" + URLEncoder.encode(senha, "UTF-8");
                writer.write(postData);
                writer.flush();
                writer.close();
                os.close();

                // Ler resposta
                BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
                StringBuilder sb = new StringBuilder();
                String line;
                while ((line = reader.readLine()) != null) {
                    sb.append(line).append("\n");
                }
                reader.close();
                result = sb.toString();
                conn.disconnect();

                // Loggar resposta para debugar.
                Log.d("LoginTask", "Server response: " + result);

            } catch (Exception e) {
                e.printStackTrace();
            }
            return result;
        }

        @Override
        protected void onPostExecute(String result) {
            try {
                JSONObject jsonObject = new JSONObject(result);
                String status = jsonObject.getString("status");
                if ("success".equals(status)) {
                    String nome = jsonObject.getString("nome");
                    Toast.makeText(LoginResponsavel.this, "Usuário encontrado: " + nome, Toast.LENGTH_LONG).show();

                    // Enviar ID do responsável para próxima atividade.
                    String id_responsavel = jsonObject.getString("id_responsavel");
                    Intent i = new Intent(LoginResponsavel.this, AmbienteRespPrincipal.class);
                    i.putExtra("id_responsavel", id_responsavel);

                    // Mudar de atividade.
                    startActivity(i);
                } else {
                    String message = jsonObject.getString("message");
                    Toast.makeText(LoginResponsavel.this, message, Toast.LENGTH_LONG).show();
                }
            } catch (JSONException e) {
                e.printStackTrace();
                Toast.makeText(LoginResponsavel.this, "Erro ao processar resposta do servidor", Toast.LENGTH_LONG).show();
            }
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            onBackPressed(); // Go back to the previous activity
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}