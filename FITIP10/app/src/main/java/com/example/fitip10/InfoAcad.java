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

public class InfoAcad extends AppCompatActivity {
        TextView endereco;
        TextView horarios;
        TextView aulas;
    FirebaseFirestore db = FirebaseFirestore.getInstance();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info_acad);
    }

    @Override
    protected void onStart() {
        String emailUser= FirebaseAuth.getInstance().getCurrentUser().getEmail();
        endereco= findViewById(R.id.textEnderecoAcad);
        horarios= findViewById(R.id.texthorarioacad);
        aulas= findViewById(R.id.textaulascad);
        String usuarioId = FirebaseAuth.getInstance().getCurrentUser().getUid();

        DocumentReference document = db.collection("users").document(usuarioId);
        document.addSnapshotListener(new EventListener<DocumentSnapshot>() {
            @Override
            public void onEvent(@Nullable DocumentSnapshot documentSnapshot, @Nullable FirebaseFirestoreException error) {
                if(documentSnapshot!=null){
                    endereco.setText(documentSnapshot.getString("InfoAcad.enderecoacad"));
                    horarios.setText(documentSnapshot.getString("InfoAcad.horariosacad"));
                    aulas.setText(documentSnapshot.getString("InfoAcad.aulas"));


                }

            }
        });

        super.onStart();
    }




}