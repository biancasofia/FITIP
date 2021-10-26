package com.example.fitip10;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;

import com.google.firebase.firestore.FirebaseFirestore;


public class Treinos extends AppCompatActivity {
    private String usario_key = FirebaseAuth.getInstance().getUid();
    private EditText exercicios;
    private EditText pesos;
    private EditText repeticoes;
    private Spinner dia;
    private EditText nomeTreino;
    private Button cadastrarTreino;



    FirebaseFirestore db = FirebaseFirestore.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_treinos);

        cadastrarTreino= findViewById(R.id.button_salvar_treino);
        exercicios = findViewById(R.id.exercicio_treino);
        repeticoes = findViewById(R.id.repeticoes_treino);
        dia= findViewById(R.id.spinner_dia);
        pesos= findViewById(R.id.Peso_treino);
        nomeTreino= findViewById(R.id.treino_nome);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.dias,  android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        dia.setAdapter(adapter);

        cadastrarTreino.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String exercicio = exercicios.getText().toString().trim();
                String repeticao =repeticoes.getText().toString().trim();
                String peso = pesos.getText().toString().trim();
                String treino =nomeTreino.getText().toString().trim();
                boolean segunda = (Boolean) (dia.getSelectedItemPosition() == 0);
                boolean terca= (Boolean) (dia.getSelectedItemPosition() == 1);
                boolean quarta= (Boolean) (dia.getSelectedItemPosition() == 2);
                boolean quinta = (Boolean) (dia.getSelectedItemPosition() == 3);
                boolean sexta = (Boolean) (dia.getSelectedItemPosition() == 4);
                boolean sabado = (Boolean) (dia.getSelectedItemPosition() == 5);
                boolean vazio = (Boolean) (dia.getSelectedItemPosition() == 6);
                //boolean camposVazio = (Boolean) (codigo.isEmpty() || loteVacina.isEmpty());


                if(treino.isEmpty()||peso.isEmpty()||repeticao.isEmpty()|| peso.isEmpty())  {
                    Toast.makeText(Treinos.this,
                            "Prencha todos os campos",
                            Toast.LENGTH_LONG).show();
                }

                else if (!treino.isEmpty()) {


                    // Verifica se tem campo vazio


                    // Vacina BCG
                    if (segunda) {
                        db.collection("users").document(usario_key)
                                .update("Treinos.Segunda.Exercicio", exercicio);
                        db.collection("users").document(usario_key)
                                .update("Treinos.Segunda.SerieRepeticoes", repeticao);
                        db.collection("users").document(usario_key)
                                .update("Treinos.Segunda.Peso",peso);
                        db.collection("users").document(usario_key)
                                .update("Treinos.Segunda.Treino",treino);

                        Toast.makeText(Treinos.this,
                                "Exercicio cadastrado com sucesso, cadastre o proximo",
                                Toast.LENGTH_LONG).show();

                    }
                    if (terca) {
                        db.collection("users").document(usario_key)
                                .update("Treinos.Terca.Exercicio", exercicio);
                        db.collection("users").document(usario_key)
                                .update("Treinos.Terca.SerieRepeticoes", repeticao);
                        db.collection("users").document(usario_key)
                                .update("Treinos.Terca.Peso",peso);
                        db.collection("users").document(usario_key)
                                .update("Treinos.Terca.Treino",treino);

                        Toast.makeText(Treinos.this,
                                "Exercicio cadastrado com sucesso, cadastre o proximo",
                                Toast.LENGTH_LONG).show();

                    }
                    if (quarta) {
                        db.collection("users").document(usario_key)
                                .update("Treinos.Quarta.Exercicio", exercicio);
                        db.collection("users").document(usario_key)
                                .update("Treinos.Quarta.SerieRepeticoes", repeticao);
                        db.collection("users").document(usario_key)
                                .update("Treinos.Quarta.Peso",peso);
                        db.collection("users").document(usario_key)
                                .update("Treinos.Quarta.Treino",treino);

                        Toast.makeText(Treinos.this,
                                "Exercicio cadastrado com sucesso, cadastre o proximo",
                                Toast.LENGTH_LONG).show();

                    }
                    if (quinta) {
                        db.collection("users").document(usario_key)
                                .update("Treinos.Quinta.Exercicio", exercicio);
                        db.collection("users").document(usario_key)
                                .update("Treinos.Quinta.SerieRepeticoes", repeticao);
                        db.collection("users").document(usario_key)
                                .update("Treinos.Quinta.Peso",peso);
                        db.collection("users").document(usario_key)
                                .update("Treinos.Quinta.Treino",treino);

                        Toast.makeText(Treinos.this,
                                "Exercicio cadastrado com sucesso, cadastre o proximo",
                                Toast.LENGTH_LONG).show();

                    }
                    if (sexta) {
                        db.collection("users").document(usario_key)
                                .update("Treinos.Sexta.Exercicio", exercicio);
                        db.collection("users").document(usario_key)
                                .update("Treinos.Sexta.SerieRepeticoes", repeticao);
                        db.collection("users").document(usario_key)
                                .update("Treinos.Sexta.Peso",peso);
                        db.collection("users").document(usario_key)
                                .update("Treinos.Sexta.Treino",treino);

                        Toast.makeText(Treinos.this,
                                "Exercicio cadastrado com sucesso, cadastre o proximo",
                                Toast.LENGTH_LONG).show();

                    }
                    if (sabado) {
                        db.collection("users").document(usario_key)
                                .update("Treinos.Sabado.Exercicio", exercicio);
                        db.collection("users").document(usario_key)
                                .update("Treinos.Sabado.SerieRepeticoes", repeticao);
                        db.collection("users").document(usario_key)
                                .update("Treinos.Sabado.Peso",peso);
                        db.collection("users").document(usario_key)
                                .update("Treinos.Sabado.Treino",treino);

                        Toast.makeText(Treinos.this,
                                "Exercicio cadastrado com sucesso, cadastre o proximo",
                                Toast.LENGTH_LONG).show();

                    }








                }

            }



        });


    }
















}