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
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.FirebaseFirestore;

public class CadastroProfessor extends AppCompatActivity {

    private EditText edt_email_register_professor;
    private EditText edt_senha_register_professor;
    private EditText edt_confirmar_senha_register_professor;
    private EditText edt_cofef_register_professor;
    private CheckBox ckb_mostrar_senha;
    private ProgressBar loginProgressBar_register_professor;
    private Button btn_button_registrar_professor;
    private Button btn_button_fazer_login_professor;
    private Button btn_voltar_professor;
    private FirebaseAuth mAuth;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro_professor);

        mAuth = FirebaseAuth.getInstance();

        edt_email_register_professor = findViewById(R.id.edt_email_register_professor);
        edt_senha_register_professor = findViewById(R.id.edt_senha_register_professor);
        edt_confirmar_senha_register_professor = findViewById(R.id.edt_confirmar_senha_register_professor);
        ckb_mostrar_senha = findViewById(R.id.ckb_mostrar_senha);
        btn_button_registrar_professor = findViewById(R.id.btn_button_registrar_professor);
        btn_button_fazer_login_professor = findViewById(R.id.btn_button_fazer_login_professor);
        //btn_voltar_professor = findViewById(R.id.btn_voltar_professor);
        loginProgressBar_register_professor = findViewById(R.id.loginProgressBar_register_professor);

        ckb_mostrar_senha.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    edt_senha_register_professor.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                    edt_confirmar_senha_register_professor.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                }
                else{
                    edt_senha_register_professor.setTransformationMethod(PasswordTransformationMethod.getInstance());
                    edt_confirmar_senha_register_professor.setTransformationMethod((PasswordTransformationMethod.getInstance()));
                }
            }
        });

        btn_button_registrar_professor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String registerEmail = edt_email_register_professor.getText().toString().trim();
                String senha = edt_senha_register_professor.getText().toString().trim();
                String confirmarSenha = edt_confirmar_senha_register_professor.getText().toString().trim();


                if(!TextUtils.isEmpty(registerEmail) || !TextUtils.isEmpty(senha) || !TextUtils.isEmpty(confirmarSenha)){
                    if(senha.equals(confirmarSenha)){
                        loginProgressBar_register_professor.setVisibility(View.VISIBLE);

                        mAuth.createUserWithEmailAndPassword(registerEmail,senha).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if(task.isSuccessful()){
                                    abrirTelaInfoProfessor();
                                }
                                else{
                                    String error = task.getException().getMessage();
                                    Toast.makeText(CadastroProfessor.this, ""+error, Toast.LENGTH_SHORT).show();
                                }
                                loginProgressBar_register_professor.setVisibility(View.INVISIBLE);
                            }
                        });
                    }else{
                        Toast.makeText(CadastroProfessor.this, "A senha deve ser a mesma em ambos os campos!", Toast.LENGTH_SHORT).show();
                    }
                }
                //cadastro cofef no firebase





                //

            }
        });

        btn_button_fazer_login_professor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(CadastroProfessor.this, LoginProfessor.class);
                startActivity(intent);
                finish();
            }
        });

/*        btn_voltar_professor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(CadastroProfessor.this, Cadastro.class);
                startActivity(intent);
                finish();
            }
        });*/

    }

    private void abrirTelaProfessor() {
        Intent intent = new Intent(CadastroProfessor.this, Professor.class);
        startActivity(intent);
        finish();
    }
    private void abrirTelaInfoProfessor(){
        Intent intent = new Intent(CadastroProfessor.this, InformacoesPessoaisProfessor.class);
        startActivity(intent);
        finish();

    }

    private void abrirTelaInfo() {
        Intent intent = new Intent(CadastroProfessor.this, InformacoesPessoais.class);
        startActivity(intent);
        finish();
    }
}
