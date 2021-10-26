package com.example.fitip10;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private FirebaseAuth mAuth;
    private Button btn_logout;
    private ListView exercicio;
    private ListView peso;
    private ListView serie;
    private ListView treino;
    private ListView dia;
    private String usario_key = FirebaseAuth.getInstance().getUid();
    private FirebaseFirestore db = FirebaseFirestore.getInstance();
    private List<String> exercicios;
    private List<String> series;
    private List<String> treinos;
    private List<String> pesos;
    private List<String> dias;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mAuth = FirebaseAuth.getInstance();
        exercicio= findViewById(R.id.listExercicio);
        peso= findViewById(R.id.listPeso);
        serie= findViewById(R.id.listSerie);
        treino= findViewById(R.id.listTreino);
        dia = findViewById(R.id.listDia);

 //mostra treinos
        db.collection("users").document(usario_key)
                .addSnapshotListener(new EventListener<DocumentSnapshot>() {
                    @Override
                    public void onEvent(@Nullable DocumentSnapshot snapshot, @Nullable FirebaseFirestoreException error) {

                        pesos = new ArrayList<>();
                        series = new ArrayList<>();
                        exercicios = new ArrayList<>();
                        treinos = new ArrayList<>();
                        dias= new ArrayList<>();



                        if (snapshot != null && snapshot.exists()) {



                                dias.add("Segunda");
                                pesos.add(snapshot.get("Treinos.Segunda.Peso").toString());
                                series.add(snapshot.get("Treinos.Segunda.SerieRepeticoes").toString());
                                treinos.add(snapshot.get("Treinos.Segunda.Treino").toString());
                                exercicios.add(snapshot.get("Treinos.Segunda.Exercicio").toString());


                                imprimeTela();
                            dias.add("Terca");
                            pesos.add(snapshot.get("Treinos.Terca.Peso").toString());
                            series.add(snapshot.get("Treinos.Terca.SerieRepeticoes").toString());
                            treinos.add(snapshot.get("Treinos.Terca.Treino").toString());
                            exercicios.add(snapshot.get("Treinos.Terca.Exercicio").toString());

                            imprimeTela();
                            dias.add("Quarta");
                            pesos.add(snapshot.get("Treinos.Quarta.Peso").toString());
                            series.add(snapshot.get("Treinos.Quarta.SerieRepeticoes").toString());
                            treinos.add(snapshot.get("Treinos.Quarta.Treino").toString());
                            exercicios.add(snapshot.get("Treinos.Quarta.Exercicio").toString());

                            imprimeTela();
                            dias.add("Quinta");
                            pesos.add(snapshot.get("Treinos.Quinta.Peso").toString());
                            series.add(snapshot.get("Treinos.Quinta.SerieRepeticoes").toString());
                            treinos.add(snapshot.get("Treinos.Quinta.Treino").toString());
                            exercicios.add(snapshot.get("Treinos.Quinta.Exercicio").toString());

                            imprimeTela();
                            dias.add("Sexta");
                            pesos.add(snapshot.get("Treinos.Sexta.Peso").toString());
                            series.add(snapshot.get("Treinos.Sexta.SerieRepeticoes").toString());
                            treinos.add(snapshot.get("Treinos.Sexta.Treino").toString());
                            exercicios.add(snapshot.get("Treinos.Sexta.Exercicio").toString());

                            imprimeTela();
                            dias.add("Sabado");
                            pesos.add(snapshot.get("Treinos.Sabado.Peso").toString());
                            series.add(snapshot.get("Treinos.Sabado.SerieRepeticoes").toString());
                            treinos.add(snapshot.get("Treinos.Sabado.Treino").toString());
                            exercicios.add(snapshot.get("Treinos.Sabado.Exercicio").toString());

                            imprimeTela();





                        }
                    }
                });





    }
    private void imprimeTela() {
        dia.setAdapter(new ArrayAdapter<>(
                MainActivity.this,
                android.R.layout.simple_list_item_1,
                dias

        ));
        treino.setAdapter(new ArrayAdapter<>(
                MainActivity.this,
                android.R.layout.simple_list_item_1,
                treinos
        ));
        exercicio.setAdapter(new ArrayAdapter<>(
                MainActivity.this,
                android.R.layout.simple_list_item_1,
                exercicios
        ));
        serie.setAdapter(new ArrayAdapter<>(
                MainActivity.this,
                android.R.layout.simple_list_item_1,
                series
        ));
        peso.setAdapter(new ArrayAdapter<>(
                MainActivity.this,
                android.R.layout.simple_list_item_1,
                pesos
        ));

    }
    protected void onStart(){
        super.onStart();
        FirebaseUser currentuser = FirebaseAuth.getInstance().getCurrentUser();

        if(currentuser == null){
            Intent intent = new Intent(MainActivity.this, Login.class);
            startActivity(intent);
            finish();
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.bottom_nav_menu,menu);
        return super.onCreateOptionsMenu(menu);
    }

//menu
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {


        if(  item.getItemId()==R.id.navigation_edit){
            Intent intent = new Intent(this, EdicaoDados.class);
            startActivity(intent);


        }


        if(  item.getItemId()==R.id.navigation_info_perfil){
            Intent intent = new Intent(this, InformacoesPerfil.class);
            startActivity(intent);
        }

        if(  item.getItemId()==R.id.navigation_cadastrarTreino){
            Intent intent = new Intent(this, Treinos.class);
            startActivity(intent);
        }
        if(item.getItemId()==R.id.navigation_info_acad){



            Intent intent = new Intent(MainActivity.this, InfoAcad.class);
            startActivity(intent);
            finish();

        }

        if(item.getItemId()==R.id.navigation_sair){

            mAuth.signOut();

            Intent intent = new Intent(MainActivity.this, Login.class);
            startActivity(intent);
            finish();

        }
        if(item.getItemId()==R.id.navigation_excluir){
            AlertDialog.Builder dialog= new AlertDialog.Builder(MainActivity.this);
            dialog.setTitle("Tem certeza?");
            dialog.setMessage("Ao excluir sua conta, perdera o acesso sobre a mesma");
            dialog.setPositiveButton("Exluir", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    FirebaseUser user= mAuth.getCurrentUser();
                    user.delete().addOnSuccessListener(new OnSuccessListener<Void>() {
                        @Override
                        public void onSuccess(Void aVoid) {
                            Toast.makeText(MainActivity.this, "Conta deletada", Toast.LENGTH_SHORT).show();
                            mAuth.signOut();
                            startActivity(new Intent(getApplicationContext(), Login.class));
                            finish();
                        }
                    }).addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception e) {
                            Toast.makeText(MainActivity.this, e.getMessage(), Toast.LENGTH_SHORT).show();
                        }
                    });

                }
            }).setNegativeButton("Cancelar", null).create().show();
        }

        return super.onOptionsItemSelected(item);
    }




}