package com.example.fitip10;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

public class InformacoesPessoaisProfessor extends AppCompatActivity {
    private String usario_key = FirebaseAuth.getInstance().getUid();

    private  FirebaseFirestore db = FirebaseFirestore.getInstance();



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_informacoes_pessoais_professor);
        EditText nome = (EditText) findViewById(R.id.edit_nome_prof);
        EditText sobrenome = (EditText) findViewById(R.id.edit_sobrenome_prof);
        EditText cofef = (EditText) findViewById(R.id.edt_confef);
        Button salvarInformacoesPessoais = (Button) findViewById(R.id.button_salvar_professor) ;

        salvarInformacoesPessoais.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String registarnome = nome.getText().toString().trim();
                String registarsobrenome = sobrenome.getText().toString().trim();
                String registrarcofef= cofef.getText().toString().trim();


                //    if(!TextUtils.isEmpty(registarnome)|| !TextUtils.isEmpty(registarsobrenome) ||
                //     !TextUtils.isEmpty(registrarcofef) || !TextUtils.isEmpty(registarendereco)){


                Map<String, Object> docData = new HashMap<>();
                Map<String, Object> nestedData = new HashMap<>();


                nestedData.put("Nome", registarnome);
                nestedData.put("Sobrenome", registarsobrenome);
                nestedData.put("COFEF", registrarcofef);



                docData.put("InfoPessoais", nestedData);

                db.collection("professor").document(usario_key)
                        .set(docData)
                        .addOnSuccessListener(new OnSuccessListener<Void>() {
                            @Override
                            public void onSuccess(Void aVoid) {
                                Intent intent = new Intent(InformacoesPessoaisProfessor.this, Professor.class);
                                startActivity(intent);
                                finish();
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






}