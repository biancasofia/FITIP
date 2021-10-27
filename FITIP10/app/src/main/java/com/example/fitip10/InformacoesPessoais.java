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
                String registrarenderecoacademia ="Brasilia,305 Asa Sul";
                String horariosFuncionamento= "Essa academia funciona de segunda a sexta de 5h as 22h e sabado de 6h as 13h";
                String aulas ="Aulas de dança todas as quartas de 19h as 20h";


                //    if(!TextUtils.isEmpty(registarnome)|| !TextUtils.isEmpty(registarsobrenome) ||
                //     !TextUtils.isEmpty(registrartelefone) || !TextUtils.isEmpty(registarendereco)){


                Map<String, Object> docData = new HashMap<>();
                Map<String, Object> nestedData = new HashMap<>();
                Map<String, Object> DiaSemana = new HashMap<>();
                Map<String, Object> InfTreino = new HashMap<>();
                Map<String, Object> InfAcad = new HashMap<>();



                nestedData.put("Nome", registarnome);
                nestedData.put("Sobrenome", registarsobrenome);
                nestedData.put("Telefone", registrartelefone);
                nestedData.put("Endereco", registarendereco);
                InfAcad.put("enderecoacad", registrarenderecoacademia);
                InfAcad.put("horariosacad", horariosFuncionamento);
                InfAcad.put("aulas", aulas);



                DiaSemana.put ("Treino", "nulo");
                DiaSemana.put ("SerieRepeticoes", "nulo");
                DiaSemana.put ("Exercicio", "nul0");
                DiaSemana.put ("Peso", "nulo");



                InfTreino.put("Segunda",DiaSemana);
                InfTreino.put("Terca",DiaSemana);
                InfTreino.put("Quarta",DiaSemana);
                InfTreino.put("Quinta",DiaSemana);
                InfTreino.put("Sexta",DiaSemana);
                InfTreino.put("Sabado",DiaSemana);

                InfTreino.put("Segunda2",DiaSemana);
                InfTreino.put("Terca2",DiaSemana);
                InfTreino.put("Quarta2",DiaSemana);
                InfTreino.put("Quinta2",DiaSemana);
                InfTreino.put("Sexta2",DiaSemana);
                InfTreino.put("Sabado2",DiaSemana);

                InfTreino.put("Segunda3",DiaSemana);
                InfTreino.put("Terca3",DiaSemana);
                InfTreino.put("Quarta3",DiaSemana);
                InfTreino.put("Quinta3",DiaSemana);
                InfTreino.put("Sexta3",DiaSemana);
                InfTreino.put("Sabado3",DiaSemana);


                InfTreino.put("Segunda4",DiaSemana);
                InfTreino.put("Terca4",DiaSemana);
                InfTreino.put("Quarta4",DiaSemana);
                InfTreino.put("Quinta4",DiaSemana);
                InfTreino.put("Sexta4",DiaSemana);
                InfTreino.put("Sabado4",DiaSemana);

                InfTreino.put("Segunda5",DiaSemana);
                InfTreino.put("Terca5",DiaSemana);
                InfTreino.put("Quarta5",DiaSemana);
                InfTreino.put("Quinta5",DiaSemana);
                InfTreino.put("Sexta5",DiaSemana);
                InfTreino.put("Sabado5",DiaSemana);

                InfTreino.put("Segunda6",DiaSemana);
                InfTreino.put("Terca6",DiaSemana);
                InfTreino.put("Quarta6",DiaSemana);
                InfTreino.put("Quinta6",DiaSemana);
                InfTreino.put("Sexta6",DiaSemana);
                InfTreino.put("Sabado6",DiaSemana);



                docData.put("InfoPessoais", nestedData);
                docData.put("Treinos", InfTreino);
                docData.put("InfoAcad", InfAcad);

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






















