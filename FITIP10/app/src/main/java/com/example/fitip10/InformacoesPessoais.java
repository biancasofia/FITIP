package com.example.fitip10;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

public class InformacoesPessoais extends AppCompatActivity {
    private String usario_key = FirebaseAuth.getInstance().getUid();
    private Button salvarInformacoesPessoais;
    private  FirebaseFirestore db = FirebaseFirestore.getInstance();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_informacoes_pessoais);

        EditText nome = (EditText) findViewById(R.id.edit_nome_info);
        EditText sobrenome = (EditText) findViewById(R.id.edit_sobrenome_info2);
        EditText telefone = (EditText) findViewById(R.id.edit_telefone_info);
        EditText endereco = (EditText) findViewById(R.id.edit_endereco_info);


        salvarInformacoesPessoais = findViewById(R.id.button_info);

        salvarInformacoesPessoais.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String registarnome = nome.getText().toString().trim();
                String registarsobrenome = sobrenome.getText().toString().trim();
                String registrartelefone= telefone.getText().toString().trim();
                String registarendereco = endereco.getText().toString().trim();

                //    if(!TextUtils.isEmpty(registarnome)|| !TextUtils.isEmpty(registarsobrenome) ||
                //     !TextUtils.isEmpty(registrartelefone) || !TextUtils.isEmpty(registarendereco)){


                Map<String, Object> docData = new HashMap<>();
                Map<String, Object> nestedData = new HashMap<>();
                Map<String, Object> DiaSemana = new HashMap<>();
                Map<String, Object> InfTreino = new HashMap<>();

                nestedData.put("Nome", registarnome);
                nestedData.put("Sobrenome", registarsobrenome);
                nestedData.put("Telefone", registrartelefone);
                nestedData.put("Endereco", registarendereco);


                DiaSemana.put("Treino", "null");



                InfTreino.put("Segunda",DiaSemana);
                InfTreino.put("Terça",DiaSemana);
                InfTreino.put("Quarta",DiaSemana);
                InfTreino.put("Quinta",DiaSemana);
                InfTreino.put("Sexta",DiaSemana);
                InfTreino.put("Sabado",DiaSemana);


                docData.put("InfoPessoais", nestedData);
                docData.put("Treinos", InfTreino);

                db.collection("users").document(usario_key)
                        .set(docData)
                        .addOnSuccessListener(new OnSuccessListener<Void>() {
                            @Override
                            public void onSuccess(Void aVoid) {
                                toHome();
                                //Log.d(TAG, "DocumentSnapshot successfully written!");
                            }
                        })
                        .addOnFailureListener(new OnFailureListener() {
                            @Override
                            public void onFailure(@NonNull Exception e) {
                                //Log.w(TAG, "Error writing document", e);
                            }
                        });




                //   }

            }
        });

    }

    private void toHome(){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        finish();
    }
}






















