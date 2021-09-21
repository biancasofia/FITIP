package com.example.fitip10;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
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

import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class Cadastro extends AppCompatActivity {

    private EditText edt_email_register;
    private EditText edt_senha_register;
    private EditText edt_confirmar_senha_register;
    private CheckBox ckb_mostrar_senha;
    private ProgressBar loginProgressBar_register;
    private Button btn_button_registrar;
    private Button btn_button_fazer_login;
    private Button btn_voltar_registrar;
    private FirebaseAuth mAuth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro);

        mAuth = FirebaseAuth.getInstance();

        edt_email_register = findViewById(R.id.edt_email_register);
        edt_senha_register = findViewById(R.id.edt_senha_register);
        edt_confirmar_senha_register = findViewById(R.id.edt_confirmar_senha_register);
        ckb_mostrar_senha = findViewById(R.id.ckb_mostrar_senha);
        btn_button_registrar = findViewById(R.id.btn_button_registrar);
        btn_button_fazer_login = findViewById(R.id.btn_button_fazer_login);
      //  btn_voltar_registrar = findViewById(R.id.btn_voltar_registrar);
        loginProgressBar_register = findViewById(R.id.loginProgressBar_register);

        ckb_mostrar_senha.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    edt_senha_register.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                    edt_confirmar_senha_register.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                }
                else{
                    edt_senha_register.setTransformationMethod(PasswordTransformationMethod.getInstance());
                    edt_confirmar_senha_register.setTransformationMethod((PasswordTransformationMethod.getInstance()));
                }
            }
        });

        btn_button_registrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String registerEmail = edt_email_register.getText().toString().trim();
                String senha = edt_senha_register.getText().toString().trim();
                String confirmarSenha = edt_confirmar_senha_register.getText().toString().trim();

                if(!TextUtils.isEmpty(registerEmail) || !TextUtils.isEmpty(senha) || !TextUtils.isEmpty(confirmarSenha)){
                    if(senha.equals(confirmarSenha)){
                        loginProgressBar_register.setVisibility(View.VISIBLE);

                        mAuth.createUserWithEmailAndPassword(registerEmail,senha).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if(task.isSuccessful()){
                                    abrirTelaInfo();
                                }
                                else{
                                    String error = task.getException().getMessage();
                                    Toast.makeText(Cadastro.this, ""+error, Toast.LENGTH_SHORT).show();
                                }
                                loginProgressBar_register.setVisibility(View.INVISIBLE);
                            }
                        });
                    }else{
                        Toast.makeText(Cadastro.this, "A senha deve ser a mesma em ambos os campos!", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });

        btn_button_fazer_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Cadastro.this, Login.class);
                startActivity(intent);
                finish();
            }
        });
        

    }

    private void abrirTelaPrincipal() {
        Intent intent = new Intent(Cadastro.this, MainActivity.class);
        startActivity(intent);
        finish();
    }
    private void abrirTelaInfo() {
        Intent intent = new Intent(Cadastro.this, InformacoesPessoais.class);
        startActivity(intent);
        finish();
    }
}
