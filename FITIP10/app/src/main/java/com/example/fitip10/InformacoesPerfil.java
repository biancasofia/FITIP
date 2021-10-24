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

public class InformacoesPerfil extends AppCompatActivity {

    FirebaseFirestore db = FirebaseFirestore.getInstance();
    String usuarioId;
    TextView nomeUsuario;
    TextView sobrenome;
    TextView telefone;
    TextView endereco;
    TextView email;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_informacoes_perfil);
    }
    @Override
    protected void onStart() {
        String emailUser= FirebaseAuth.getInstance().getCurrentUser().getEmail();
        nomeUsuario=findViewById(R.id.textnome);
        sobrenome= findViewById(R.id.textsobrenome);
        telefone=findViewById(R.id.texttelefone);
        endereco= findViewById(R.id.textendereco);
        email = findViewById(R.id.textemail);
        usuarioId = FirebaseAuth.getInstance().getCurrentUser().getUid();
        DocumentReference document = db.collection("users").document(usuarioId);
        document.addSnapshotListener(new EventListener<DocumentSnapshot>() {
            @Override
            public void onEvent(@Nullable DocumentSnapshot documentSnapshot, @Nullable FirebaseFirestoreException error) {
                    if(documentSnapshot!=null){
                        nomeUsuario.setText(documentSnapshot.getString("InfoPessoais.Nome"));
                        sobrenome.setText(documentSnapshot.getString("InfoPessoais.Sobrenome"));
                        telefone.setText(documentSnapshot.getString("InfoPessoais.Telefone"));
                        endereco.setText(documentSnapshot.getString("InfoPessoais.Endereco"));
                        email.setText(emailUser);
                    }

            }
        });

        super.onStart();
    }



}