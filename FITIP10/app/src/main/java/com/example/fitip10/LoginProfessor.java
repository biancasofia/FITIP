package com.example.fitip10;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

import org.jetbrains.annotations.NotNull;

public class LoginProfessor extends AppCompatActivity {
    private EditText edt_email_login;
    private EditText edt_senha_login;
    private CheckBox ckb_mostrar_senha;
    private ProgressBar loginProgressBar;
    private Button btn_login;

    private FirebaseAuth mAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_professor);

        mAuth = FirebaseAuth.getInstance();
        edt_email_login = findViewById(R.id.edit_email_professor);
        edt_senha_login = findViewById(R.id.edit_senha_professor);
        loginProgressBar = findViewById(R.id.progressBar_login_professor);
        btn_login = findViewById(R.id.button_login_professor);






        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String loginEmail = edt_email_login.getText().toString();
                String loginSenha = edt_senha_login.getText().toString();

                if(!TextUtils.isEmpty(loginEmail) || !TextUtils.isEmpty(loginSenha)){
                    loginProgressBar.setVisibility(View.VISIBLE);
                    mAuth.signInWithEmailAndPassword(loginEmail,loginSenha)
                            .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                                @Override
                                public void onComplete(@NonNull @NotNull Task<AuthResult> task) {
                                    if(task.isSuccessful()){
                                        abrirTelaPrincipal();
                                    }else{
                                        String error = task.getException().getMessage();
                                        Toast.makeText(LoginProfessor.this, ""+error, Toast.LENGTH_SHORT).show();
                                        loginProgressBar.setVisibility(View.INVISIBLE);
                                    }
                                }
                            });
                }
            }
        });













    }
   private void abrirTelaPrincipal(){
       Intent intent = new Intent(LoginProfessor.this, Professor.class);
       startActivity(intent);
       finish();


   }
}