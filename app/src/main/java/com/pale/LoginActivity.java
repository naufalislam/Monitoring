package com.pale;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.pale.network.BaseApiService;
import com.pale.network.koneksi;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends AppCompatActivity {
    CardView btn_login;
    EditText edt_username, edt_password;

    ProgressDialog loading;
    Context mContext;
    BaseApiService mApiService;

    public final static String TAG_USERNAME = "username";
    public final static String TAG_PASSWORD = "password";

    SharedPreferences sharedpreferences;
    Boolean session = false;
    String username,password;

    public static final String my_shared_preferences = "my_shared_preferences";
    public static final String session_Status = "session_status";

    SessionManager sessionManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        btn_login = findViewById(R.id.btn_login);
        edt_username = findViewById(R.id.txt_username);
        edt_password = findViewById(R.id.txt_password);

        mContext = this;
        mApiService = koneksi.getAPIService();

        sessionManager = new SessionManager(getApplicationContext());

        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String usrnm = edt_username.getText().toString().trim();
                String pwd = edt_password.getText().toString().trim();

                if (TextUtils.isEmpty(usrnm)){
                    edt_username.setError("Tidak Boleh Kosong");
                }else if (TextUtils.isEmpty(pwd)){
                    edt_password.setError("Tidak Boleh Kosong");
                }else {
                    loading = ProgressDialog.show(mContext, null,
                            "Harap Tunggu ...", true,false);
                    requestLogin();
                }
            }
        });


    }

    private void requestLogin() {
        mApiService.submitLogin(edt_username.getText().toString(),
                edt_password.getText().toString())
                .enqueue(new Callback<ResponseBody>() {
                    @Override
                    public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                        if (response.isSuccessful()){
                            loading.dismiss();
                            //::::::::::::::::::::::::
                            //Dengan Metode JSON ARRAY
                            //::::::::::::::::::::::::
                            try {
                                //identifikasi JsonObject
                                JSONObject jsonRESULTS = new JSONObject(response.body().string());
                                //identifikasi JsonArray
                                JSONArray jsonArray = jsonRESULTS.getJSONArray("dataLogin");

                                if (jsonRESULTS.getString("pesan").equals("success")){
                                    Toast.makeText(mContext, "Login berhasil!",
                                            Toast.LENGTH_SHORT).show();


                                    // Memanggil Dashboards
                                    Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                                    sessionManager.createSession(edt_username.getText().toString());
                                    startActivity(intent);
                                    finish();
                                } else {
                                    Toast.makeText(mContext, "Username atau Password salah!", Toast.LENGTH_SHORT).show();
                                }
                            } catch (JSONException | IOException e) {
                                e.printStackTrace();
                                Toast.makeText(mContext, "Bermasalah!", Toast.LENGTH_SHORT).show();
                            }
                        } else {
                            loading.dismiss();
                        }
                    }
                    @Override
                    public void onFailure(Call<ResponseBody> call, Throwable t) {
                        Log.e("debug", "onFailure: ERROR > " + t.toString());
                        loading.dismiss();
                    }
                });
    }
}