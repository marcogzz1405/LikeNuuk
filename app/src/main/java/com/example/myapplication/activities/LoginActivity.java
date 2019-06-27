package com.example.myapplication.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;

import com.example.myapplication.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {

    private static final String TAG = LoginActivity.class.getSimpleName();

    @BindView(R.id.editEmail) EditText editTextEmail;
    @BindView(R.id.editPass) EditText editTextPass;
    @BindView(R.id.btnLogin) Button btnLogin;
    @BindView(R.id.progressLogin) ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        ButterKnife.bind(this);

        btnLogin.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btnLogin:
                login();
                break;
        }
    }

    public void dialogMessage(String message){
        final AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Error");
        builder.setMessage(message);
        builder.setCancelable(false);
        builder.setPositiveButton("CONTINUAR", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        builder.show();
    }

    public void login(){
        final String email = editTextEmail.getText().toString();
        String password = editTextPass.getText().toString();
        if (email == null || email.equals("")) {
            dialogMessage("Ingrese su correo.");
        } else if (password == null || password.equals("")) {
            dialogMessage("Ingrese su contraseña");
        } else if (!isOnline()) {
            dialogMessage("No hay acceso a internet. Revisa tu conexión.");
        } else {
            Intent mainIntent = new Intent(LoginActivity.this, MainActivity.class);
            startActivity(mainIntent);
            finish();
        }
    }

    /* INTERNET SERVICE */
    private boolean isOnline() {
        ConnectivityManager cm = (ConnectivityManager) getSystemService(LoginActivity.CONNECTIVITY_SERVICE);
        NetworkInfo netInfo = cm.getActiveNetworkInfo();
        return netInfo != null && netInfo.isConnectedOrConnecting();
    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }
}
