package com.example.fitip10;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;

public class InformacoesPerfilProfessor extends AppCompatActivity {

    FirebaseFirestore db = FirebaseFirestore.getInstance();
    String usuarioId;
    TextView nomeUsuario;
    TextView sobrenome;

    TextView cofef;
    TextView email;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_informacoes_perfil_professor);
    }

    @Override
    protected void onStart() {
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
    }



}