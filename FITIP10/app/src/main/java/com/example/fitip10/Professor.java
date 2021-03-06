package com.example.fitip10;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;

public class Professor extends AppCompatActivity {
    private FirebaseAuth mAuth;

    FirebaseFirestore db = FirebaseFirestore.getInstance();
    String usuarioId;
    TextView nomeUsuario;
    TextView sobrenome;

    TextView cofef;
    TextView email;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_professor);
        mAuth = FirebaseAuth.getInstance();

    }

    protected void onStart(){
        String emailUser= FirebaseAuth.getInstance().getCurrentUser().getEmail();
        nomeUsuario=findViewById(R.id.textnomeprof);
        sobrenome= findViewById(R.id.textsobrenomeprof);
        cofef = findViewById(R.id.textcofef);
        email = findViewById(R.id.textemailprof);
        usuarioId = FirebaseAuth.getInstance().getCurrentUser().getUid();
        DocumentReference document = db.collection("professor").document(usuarioId);
        document.addSnapshotListener(new EventListener<DocumentSnapshot>() {
            @Override
            public void onEvent(@Nullable DocumentSnapshot documentSnapshot, @Nullable FirebaseFirestoreException error) {
                if(documentSnapshot!=null){
                    nomeUsuario.setText(documentSnapshot.getString("InfoPessoais.Nome"));
                    sobrenome.setText(documentSnapshot.getString("InfoPessoais.Sobrenome"));
                    cofef.setText(documentSnapshot.getString("InfoPessoais.COFEF"));
                    email.setText(emailUser);
                }

            }
        });
        super.onStart();
        FirebaseUser currentuser = FirebaseAuth.getInstance().getCurrentUser();

        if(currentuser == null){
            Intent intent = new Intent(Professor.this, LoginProfessor.class);
            startActivity(intent);
            finish();
        }
    }

    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.menuprofessor,menu);
        return super.onCreateOptionsMenu(menu);
    }


    public boolean onOptionsItemSelected(@NonNull MenuItem item) {


        if(  item.getItemId()==R.id.cadastro_treino){
            Intent intent = new Intent(this, Treinos.class);
            startActivity(intent);
        }
        if(item.getItemId()==R.id.sair_professor){

            mAuth.signOut();

            Intent intent = new Intent(Professor.this, LoginProfessor.class);
            startActivity(intent);
            finish();

        }

        if(  item.getItemId()==R.id.perfil_professor){
            Intent intent = new Intent(this,  Professor.class);
            startActivity(intent);
        }
        return super.onOptionsItemSelected(item);
    }




    }