package com.example.fitip10;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

import org.jetbrains.annotations.NotNull;

public class Login extends AppCompatActivity {

    private EditText edt_email_login;
    private EditText edt_senha_login;
    private CheckBox ckb_mostrar_senha;
    private ProgressBar loginProgressBar;
    private Button btn_registrar;
    private Button btn_login;
    private Button btn_registrar_professor;
    private FirebaseAuth mAuth;
    private Button btn_esqueciSenha;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        mAuth = FirebaseAuth.getInstance();
        edt_email_login = findViewById(R.id.edt_email_login);
        edt_senha_login = findViewById(R.id.edt_senha_login);
        ckb_mostrar_senha = findViewById(R.id.ckb_mostrar_senha);
        loginProgressBar = findViewById(R.id.loginProgressBar);
        btn_login = findViewById(R.id.btn_login);
        btn_registrar = findViewById(R.id.btn_registrar);
        btn_registrar_professor = findViewById(R.id.btn_registrar_professor);
        btn_esqueciSenha= findViewById(R.id.senhaPerdida_button);

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
                                        Toast.makeText(Login.this, ""+error, Toast.LENGTH_SHORT).show();
                                        loginProgressBar.setVisibility(View.INVISIBLE);
                                    }
                                }
                            });
                }
            }
        });

        btn_registrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Login.this, Cadastro.class);
                startActivity(intent);
                finish();
            }
        });

        btn_esqueciSenha.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                recuperarSenha();
            }
        });


        btn_registrar_professor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Login.this, CadastroProfessor.class);
                startActivity(intent);
                finish();
            }
        });

        ckb_mostrar_senha.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    edt_senha_login.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                }else{
                    edt_senha_login.setTransformationMethod(PasswordTransformationMethod.getInstance());
                }
            }
        });
    }

    private void recuperarSenha(){

        String email= edt_email_login.getText().toString().trim();
        if(email.isEmpty()){
            Toast.makeText(getBaseContext(), "Insira seu E-mail para poder recuperar", Toast.LENGTH_LONG).show();
        }
        else{
            enviarEmail(email);
        }


    }
    private void enviarEmail(String email){
        mAuth.sendPasswordResetEmail(email).addOnSuccessListener(new OnSuccessListener<Void>() {
            @Override
            public void onSuccess(Void aVoid) {
                Toast.makeText(getBaseContext(), "Enviamos uma mensagem para o seu email com um link para redefinir senha", Toast.LENGTH_LONG).show();
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Toast.makeText(getBaseContext(), "Erro ao enviar Email, escreva um E-mail cadastrado", Toast.LENGTH_LONG).show();
            }
        });



    }

    private void abrirTelaPrincipal() {
        Intent intent = new Intent(Login.this, MainActivity.class);
        startActivity(intent);
        finish();
    }
}