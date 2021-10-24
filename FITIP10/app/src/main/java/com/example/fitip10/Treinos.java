package com.example.fitip10;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.FirebaseFirestore;

public class Treinos extends AppCompatActivity {
    private String usario_key = FirebaseAuth.getInstance().getUid();
    private EditText series;
    private EditText peso;
    private EditText repeticoes;
    private Spinner treino;
    private String nomeProfessor;
    private Button cadastrarTreino;


    FirebaseFirestore db = FirebaseFirestore.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_treinos);



        series = findViewById(R.id.series_treino);
        repeticoes = findViewById(R.id.repeticoes_treino);
        treino= findViewById(R.id.spinner_treino);
        peso= findViewById(R.id.Peso_treino);


    }
















}