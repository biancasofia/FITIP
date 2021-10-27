package com.example.fitip10;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;

import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;


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





                boolean segunda2 = (Boolean) (dia.getSelectedItemPosition() == 6);
                boolean terca2= (Boolean) (dia.getSelectedItemPosition() == 7);
                boolean quarta2= (Boolean) (dia.getSelectedItemPosition() == 8);
                boolean quinta2 = (Boolean) (dia.getSelectedItemPosition() == 9);
                boolean sexta2 = (Boolean) (dia.getSelectedItemPosition() == 10);
                boolean sabado2 = (Boolean) (dia.getSelectedItemPosition() ==11);


                boolean segunda3 = (Boolean) (dia.getSelectedItemPosition() == 12);
                boolean terca3= (Boolean) (dia.getSelectedItemPosition() == 13);
                boolean quarta3= (Boolean) (dia.getSelectedItemPosition() == 14);
                boolean quinta3 = (Boolean) (dia.getSelectedItemPosition() == 15);
                boolean sexta3= (Boolean) (dia.getSelectedItemPosition() == 16);
                boolean sabado3 = (Boolean) (dia.getSelectedItemPosition() == 17);


                boolean segunda4 = (Boolean) (dia.getSelectedItemPosition() == 18);
                boolean terca4= (Boolean) (dia.getSelectedItemPosition() == 19);
                boolean quarta4= (Boolean) (dia.getSelectedItemPosition() == 20);
                boolean quinta4 = (Boolean) (dia.getSelectedItemPosition() == 21);
                boolean sexta4= (Boolean) (dia.getSelectedItemPosition() == 22);
                boolean sabado4 = (Boolean) (dia.getSelectedItemPosition() == 23);


                boolean segunda5 = (Boolean) (dia.getSelectedItemPosition() == 24);
                boolean terca5= (Boolean) (dia.getSelectedItemPosition() == 25);
                boolean quarta5= (Boolean) (dia.getSelectedItemPosition() == 26);
                boolean quinta5 = (Boolean) (dia.getSelectedItemPosition() == 27);
                boolean sexta5= (Boolean) (dia.getSelectedItemPosition() == 28);
                boolean sabado5 = (Boolean) (dia.getSelectedItemPosition() == 29);

                boolean segunda6 = (Boolean) (dia.getSelectedItemPosition() == 30);
                boolean terca6= (Boolean) (dia.getSelectedItemPosition() == 31);
                boolean quarta6= (Boolean) (dia.getSelectedItemPosition() == 32);
                boolean quinta6 = (Boolean) (dia.getSelectedItemPosition() == 33);
                boolean sexta6 = (Boolean) (dia.getSelectedItemPosition() == 34);
                boolean sabado6= (Boolean) (dia.getSelectedItemPosition() == 35);






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
                    if (terca3) {

                        db.collection("users").document(usario_key)

                                .update("Treinos.Terca3.Exercicio", exercicio);

                        db.collection("users").document(usario_key)

                                .update("Treinos.Terca3.SerieRepeticoes", repeticao);

                        db.collection("users").document(usario_key)

                                .update("Treinos.Terca3.Peso",peso);

                        db.collection("users").document(usario_key)

                                .update("Treinos.Terca3.Treino",treino);

                        Toast.makeText(Treinos.this,

                                "Exercicio cadastrado com sucesso, cadastre o proximo",

                                Toast.LENGTH_LONG).show();

                    }
                    if (terca2) {
                        db.collection("users").document(usario_key)
                                .update("Treinos.Terca2.Exercicio", exercicio);
                        db.collection("users").document(usario_key)
                                .update("Treinos.Terca2.SerieRepeticoes", repeticao);
                        db.collection("users").document(usario_key)
                                .update("Treinos.Terca2.Peso",peso);
                        db.collection("users").document(usario_key)
                                .update("Treinos.Terca2.Treino",treino);

                        Toast.makeText(Treinos.this,
                                "Exercicio cadastrado com sucesso, cadastre o proximo",
                                Toast.LENGTH_LONG).show();

                    }
                    if (terca4){

                        db.collection("users").document(usario_key)

                                .update("Treinos.Terca4.Exercicio", exercicio);

                        db.collection("users").document(usario_key)

                                .update("Treinos.Terca4.SerieRepeticoes", repeticao);

                        db.collection("users").document(usario_key)

                                .update("Treinos.Terca4.Peso",peso);

                        db.collection("users").document(usario_key)

                                .update("Treinos.Terca4.Treino",treino);



                        Toast.makeText(Treinos.this,

                                "Exercicio cadastrado com sucesso, cadastre o proximo",

                                Toast.LENGTH_LONG).show();



                    }
if (terca5) {

                        db.collection("users").document(usario_key)

                                .update("Treinos.Terca5.Exercicio", exercicio);

                        db.collection("users").document(usario_key)

                                .update("Treinos.Terca5.SerieRepeticoes", repeticao);

                        db.collection("users").document(usario_key)

                                .update("Treinos.Terca5.Peso",peso);

                        db.collection("users").document(usario_key)

                                .update("Treinos.Terca5.Treino",treino);



                        Toast.makeText(Treinos.this,

                                "Exercicio cadastrado com sucesso, cadastre o proximo",

                                Toast.LENGTH_LONG).show();



                    }
                if (terca6) {

                        db.collection("users").document(usario_key)

                                .update("Treinos.Terca6.Exercicio", exercicio);

                        db.collection("users").document(usario_key)

                                .update("Treinos.Terca6.SerieRepeticoes", repeticao);

                        db.collection("users").document(usario_key)

                                .update("Treinos.Terca6.Peso",peso);

                        db.collection("users").document(usario_key)

                                .update("Treinos.Terca6.Treino",treino);



                        Toast.makeText(Treinos.this,

                                "Exercicio cadastrado com sucesso, cadastre o proximo",

                                Toast.LENGTH_LONG).show();



                    }



                    if (segunda2) {
                        db.collection("users").document(usario_key)
                                .update("Treinos.Segunda2.Exercicio", exercicio);
                        db.collection("users").document(usario_key)
                                .update("Treinos.Segunda2.SerieRepeticoes", repeticao);
                        db.collection("users").document(usario_key)
                                .update("Treinos.Segunda2.Peso",peso);
                        db.collection("users").document(usario_key)
                                .update("Treinos.Segunda2.Treino",treino);

                        Toast.makeText(Treinos.this,
                                "Exercicio cadastrado com sucesso, cadastre o proximo",
                                Toast.LENGTH_LONG).show();}

                        if (segunda3) {
                            db.collection("users").document(usario_key)
                                    .update("Treinos.Segunda3.Exercicio", exercicio);
                            db.collection("users").document(usario_key)
                                    .update("Treinos.Segunda3.SerieRepeticoes", repeticao);
                            db.collection("users").document(usario_key)
                                    .update("Treinos.Segunda3.Peso", peso);
                            db.collection("users").document(usario_key)
                                    .update("Treinos.Segunda3.Treino", treino);

                            Toast.makeText(Treinos.this,
                                    "Exercicio cadastrado com sucesso, cadastre o proximo",
                                    Toast.LENGTH_LONG).show();
                        }
                            if (segunda4) {
                                db.collection("users").document(usario_key)
                                        .update("Treinos.Segunda4.Exercicio", exercicio);
                                db.collection("users").document(usario_key)
                                        .update("Treinos.Segunda4.SerieRepeticoes", repeticao);
                                db.collection("users").document(usario_key)
                                        .update("Treinos.Segunda4.Peso", peso);
                                db.collection("users").document(usario_key)
                                        .update("Treinos.Segunda4.Treino", treino);

                                Toast.makeText(Treinos.this,
                                        "Exercicio cadastrado com sucesso, cadastre o proximo",
                                        Toast.LENGTH_LONG).show();

                            }

                            if (segunda5) {
                                db.collection("users").document(usario_key)
                                        .update("Treinos.Segunda5.Exercicio", exercicio);
                                db.collection("users").document(usario_key)
                                        .update("Treinos.Segunda5.SerieRepeticoes", repeticao);
                                db.collection("users").document(usario_key)
                                        .update("Treinos.Segunda5.Peso", peso);
                                db.collection("users").document(usario_key)
                                        .update("Treinos.Segunda5.Treino", treino);

                                Toast.makeText(Treinos.this,
                                        "Exercicio cadastrado com sucesso, cadastre o proximo",
                                        Toast.LENGTH_LONG).show();

                            }
                            if (segunda6) {
                                db.collection("users").document(usario_key)
                                        .update("Treinos.Segunda6.Exercicio", exercicio);
                                db.collection("users").document(usario_key)
                                        .update("Treinos.Segunda6.SerieRepeticoes", repeticao);
                                db.collection("users").document(usario_key)
                                        .update("Treinos.Segunda6.Peso", peso);
                                db.collection("users").document(usario_key)
                                        .update("Treinos.Segunda6.Treino", treino);

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

                    if (quarta2) {
                        db.collection("users").document(usario_key)
                                .update("Treinos.Quarta2.Exercicio", exercicio);
                        db.collection("users").document(usario_key)
                                .update("Treinos.Quarta2.SerieRepeticoes", repeticao);
                        db.collection("users").document(usario_key)
                                .update("Treinos.Quarta2.Peso",peso);
                        db.collection("users").document(usario_key)
                                .update("Treinos.Quarta2.Treino",treino);

                        Toast.makeText(Treinos.this,
                                "Exercicio cadastrado com sucesso, cadastre o proximo",
                                Toast.LENGTH_LONG).show();

                    }

                    if (quarta3) {
                        db.collection("users").document(usario_key)
                                .update("Treinos.Quarta3.Exercicio", exercicio);
                        db.collection("users").document(usario_key)
                                .update("Treinos.Quarta3.SerieRepeticoes", repeticao);
                        db.collection("users").document(usario_key)
                                .update("Treinos.Quarta3.Peso",peso);
                        db.collection("users").document(usario_key)
                                .update("Treinos.Quarta3.Treino",treino);

                        Toast.makeText(Treinos.this,
                                "Exercicio cadastrado com sucesso, cadastre o proximo",
                                Toast.LENGTH_LONG).show();

                    }

                    if (quarta4) {
                        db.collection("users").document(usario_key)
                                .update("Treinos.Quarta4.Exercicio", exercicio);
                        db.collection("users").document(usario_key)
                                .update("Treinos.Quarta4.SerieRepeticoes", repeticao);
                        db.collection("users").document(usario_key)
                                .update("Treinos.Quarta4.Peso",peso);
                        db.collection("users").document(usario_key)
                                .update("Treinos.Quarta4.Treino",treino);

                        Toast.makeText(Treinos.this,
                                "Exercicio cadastrado com sucesso, cadastre o proximo",
                                Toast.LENGTH_LONG).show();

                    }

                    if (quarta5) {
                        db.collection("users").document(usario_key)
                                .update("Treinos.Quarta5.Exercicio", exercicio);
                        db.collection("users").document(usario_key)
                                .update("Treinos.Quarta5.SerieRepeticoes", repeticao);
                        db.collection("users").document(usario_key)
                                .update("Treinos.Quarta5.Peso",peso);
                        db.collection("users").document(usario_key)
                                .update("Treinos.Quarta5.Treino",treino);

                        Toast.makeText(Treinos.this,
                                "Exercicio cadastrado com sucesso, cadastre o proximo",
                                Toast.LENGTH_LONG).show();

                    }
                    if (quarta6) {
                        db.collection("users").document(usario_key)
                                .update("Treinos.Quarta6.Exercicio", exercicio);
                        db.collection("users").document(usario_key)
                                .update("Treinos.Quarta6.SerieRepeticoes", repeticao);
                        db.collection("users").document(usario_key)
                                .update("Treinos.Quarta6.Peso",peso);
                        db.collection("users").document(usario_key)
                                .update("Treinos.Quarta6.Treino",treino);

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



                    if (quinta2) {
                        db.collection("users").document(usario_key)
                                .update("Treinos.Quinta2.Exercicio", exercicio);
                        db.collection("users").document(usario_key)
                                .update("Treinos.Quinta2.SerieRepeticoes", repeticao);
                        db.collection("users").document(usario_key)
                                .update("Treinos.Quinta2.Peso",peso);
                        db.collection("users").document(usario_key)
                                .update("Treinos.Quinta2.Treino",treino);

                        Toast.makeText(Treinos.this,
                                "Exercicio cadastrado com sucesso, cadastre o proximo",
                                Toast.LENGTH_LONG).show();

                    }



                    if (quinta3) {
                        db.collection("users").document(usario_key)
                                .update("Treinos.Quinta3.Exercicio", exercicio);
                        db.collection("users").document(usario_key)
                                .update("Treinos.Quinta3.SerieRepeticoes", repeticao);
                        db.collection("users").document(usario_key)
                                .update("Treinos.Quinta3.Peso",peso);
                        db.collection("users").document(usario_key)
                                .update("Treinos.Quinta3.Treino",treino);

                        Toast.makeText(Treinos.this,
                                "Exercicio cadastrado com sucesso, cadastre o proximo",
                                Toast.LENGTH_LONG).show();

                    }


                    if (quinta4) {
                        db.collection("users").document(usario_key)
                                .update("Treinos.Quinta4.Exercicio", exercicio);
                        db.collection("users").document(usario_key)
                                .update("Treinos.Quinta4.SerieRepeticoes", repeticao);
                        db.collection("users").document(usario_key)
                                .update("Treinos.Quinta4.Peso",peso);
                        db.collection("users").document(usario_key)
                                .update("Treinos.Quinta4.Treino",treino);

                        Toast.makeText(Treinos.this,
                                "Exercicio cadastrado com sucesso, cadastre o proximo",
                                Toast.LENGTH_LONG).show();

                    }

                    if (quinta5) {
                        db.collection("users").document(usario_key)
                                .update("Treinos.Quinta5.Exercicio", exercicio);
                        db.collection("users").document(usario_key)
                                .update("Treinos.Quinta5.SerieRepeticoes", repeticao);
                        db.collection("users").document(usario_key)
                                .update("Treinos.Quinta5.Peso",peso);
                        db.collection("users").document(usario_key)
                                .update("Treinos.Quinta5.Treino",treino);

                        Toast.makeText(Treinos.this,
                                "Exercicio cadastrado com sucesso, cadastre o proximo",
                                Toast.LENGTH_LONG).show();

                    }
                    if (quinta6) {
                        db.collection("users").document(usario_key)
                                .update("Treinos.Quinta6.Exercicio", exercicio);
                        db.collection("users").document(usario_key)
                                .update("Treinos.Quinta6.SerieRepeticoes", repeticao);
                        db.collection("users").document(usario_key)
                                .update("Treinos.Quinta6.Peso",peso);
                        db.collection("users").document(usario_key)
                                .update("Treinos.Quinta6.Treino",treino);

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
                    if (sexta2) {
                        db.collection("users").document(usario_key)
                                .update("Treinos.Sexta2.Exercicio", exercicio);
                        db.collection("users").document(usario_key)
                                .update("Treinos.Sexta2.SerieRepeticoes", repeticao);
                        db.collection("users").document(usario_key)
                                .update("Treinos.Sexta2.Peso",peso);
                        db.collection("users").document(usario_key)
                                .update("Treinos.Sexta2.Treino",treino);

                        Toast.makeText(Treinos.this,
                                "Exercicio cadastrado com sucesso, cadastre o proximo",
                                Toast.LENGTH_LONG).show();

                    }

                    if (sexta3) {
                        db.collection("users").document(usario_key)
                                .update("Treinos.Sexta3.Exercicio", exercicio);
                        db.collection("users").document(usario_key)
                                .update("Treinos.Sexta3.SerieRepeticoes", repeticao);
                        db.collection("users").document(usario_key)
                                .update("Treinos.Sexta3.Peso",peso);
                        db.collection("users").document(usario_key)
                                .update("Treinos.Sexta3.Treino",treino);

                        Toast.makeText(Treinos.this,
                                "Exercicio cadastrado com sucesso, cadastre o proximo",
                                Toast.LENGTH_LONG).show();

                    }
                    if (sexta4) {
                        db.collection("users").document(usario_key)
                                .update("Treinos.Sexta4.Exercicio", exercicio);
                        db.collection("users").document(usario_key)
                                .update("Treinos.Sexta4.SerieRepeticoes", repeticao);
                        db.collection("users").document(usario_key)
                                .update("Treinos.Sexta4.Peso",peso);
                        db.collection("users").document(usario_key)
                                .update("Treinos.Sexta4.Treino",treino);

                        Toast.makeText(Treinos.this,
                                "Exercicio cadastrado com sucesso, cadastre o proximo",
                                Toast.LENGTH_LONG).show();

                    }

                    if (sexta5) {
                        db.collection("users").document(usario_key)
                                .update("Treinos.Sexta5.Exercicio", exercicio);
                        db.collection("users").document(usario_key)
                                .update("Treinos.Sexta5.SerieRepeticoes", repeticao);
                        db.collection("users").document(usario_key)
                                .update("Treinos.Sexta5.Peso",peso);
                        db.collection("users").document(usario_key)
                                .update("Treinos.Sexta5.Treino",treino);

                        Toast.makeText(Treinos.this,
                                "Exercicio cadastrado com sucesso, cadastre o proximo",
                                Toast.LENGTH_LONG).show();

                    }

                    if (sexta6) {
                        db.collection("users").document(usario_key)
                                .update("Treinos.Sexta6.Exercicio", exercicio);
                        db.collection("users").document(usario_key)
                                .update("Treinos.Sexta6.SerieRepeticoes", repeticao);
                        db.collection("users").document(usario_key)
                                .update("Treinos.Sexta6.Peso",peso);
                        db.collection("users").document(usario_key)
                                .update("Treinos.Sexta6.Treino",treino);

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
                 if (sabado2) {

                        db.collection("users").document(usario_key)

                                .update("Treinos.Sabado2.Exercicio", exercicio);

                        db.collection("users").document(usario_key)

                                .update("Treinos.Sabado2.SerieRepeticoes", repeticao);

                        db.collection("users").document(usario_key)

                                .update("Treinos.Sabado2.Peso",peso);

                        db.collection("users").document(usario_key)

                                .update("Treinos.Sabado2.Treino",treino);



                        Toast.makeText(Treinos.this,

                                "Exercicio cadastrado com sucesso, cadastre o proximo",

                                Toast.LENGTH_LONG).show();



                    }
if (sabado3) {

                        db.collection("users").document(usario_key)

                                .update("Treinos.Sabado3.Exercicio", exercicio);

                        db.collection("users").document(usario_key)

                                .update("Treinos.Sabado3.SerieRepeticoes", repeticao);

                        db.collection("users").document(usario_key)

                                .update("Treinos.Sabado3.Peso",peso);

                        db.collection("users").document(usario_key)

                                .update("Treinos.Sabado3.Treino",treino);



                        Toast.makeText(Treinos.this,

                                "Exercicio cadastrado com sucesso, cadastre o proximo",

                                Toast.LENGTH_LONG).show();



                    }
 if (sabado4) {

                        db.collection("users").document(usario_key)

                                .update("Treinos.Sabado4.Exercicio", exercicio);

                        db.collection("users").document(usario_key)

                                .update("Treinos.Sabado4.SerieRepeticoes", repeticao);

                        db.collection("users").document(usario_key)

                                .update("Treinos.Sabado4.Peso",peso);

                        db.collection("users").document(usario_key)

                                .update("Treinos.Sabado4.Treino",treino);



                        Toast.makeText(Treinos.this,

                                "Exercicio cadastrado com sucesso, cadastre o proximo",

                                Toast.LENGTH_LONG).show();



                    }
if (sabado5) {

                        db.collection("users").document(usario_key)

                                .update("Treinos.Sabado5.Exercicio", exercicio);

                        db.collection("users").document(usario_key)

                                .update("Treinos.Sabado5.SerieRepeticoes", repeticao);

                        db.collection("users").document(usario_key)

                                .update("Treinos.Sabado5.Peso",peso);

                        db.collection("users").document(usario_key)

                                .update("Treinos.Sabado5.Treino",treino);



                        Toast.makeText(Treinos.this,

                                "Exercicio cadastrado com sucesso, cadastre o proximo",

                                Toast.LENGTH_LONG).show();



                    }
 if (sabado6) {

                        db.collection("users").document(usario_key)

                                .update("Treinos.Sabado6.Exercicio", exercicio);

                        db.collection("users").document(usario_key)

                                .update("Treinos.Sabado6.SerieRepeticoes", repeticao);

                        db.collection("users").document(usario_key)

                                .update("Treinos.Sabado6.Peso",peso);

                        db.collection("users").document(usario_key)

                                .update("Treinos.Sabado6.Treino",treino);



                        Toast.makeText(Treinos.this,

                                "Exercicio cadastrado com sucesso, cadastre o proximo",

                                Toast.LENGTH_LONG).show();



                    }








                }
            }



        });


    }
















}