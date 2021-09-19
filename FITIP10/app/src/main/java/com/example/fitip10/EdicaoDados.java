package com.example.fitip10;

import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;

public class EdicaoDados extends AppCompatActivity {


    private String usario_key = FirebaseAuth.getInstance().getUid();
    private Button botaosalvar;
    private FirebaseFirestore db = FirebaseFirestore.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edicao_dados);

        EditText editaNome = findViewById(R.id.edit_nome_editP);
        EditText editaSobrenome = findViewById(R.id.edit_sobrenome_edit);
        EditText editaTelefone = findViewById(R.id.edit_telefone_edit);
        EditText editaEndereco = findViewById(R.id.edit_endereco_edit);


        botaosalvar = findViewById(R.id.button_editarInfo);
        db.collection("users").document(usario_key)
                .addSnapshotListener(this, new EventListener<DocumentSnapshot>() {
                    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN_MR1)
                    @Override
                    public void onEvent(DocumentSnapshot documentSnapshot, @Nullable FirebaseFirestoreException error) {

                        String dbNome = documentSnapshot.getString("Pessoais.Nome");
                        String dbSobrenome = documentSnapshot.getString("Pessoais.Sobrenome");
                        String dbCPF = documentSnapshot.getString("Pessoais.CPF");
                        String dbAniversario = documentSnapshot.getString("Pessoais.Aniversario");
                        String dbEndereco = documentSnapshot.getString("Pessoais.Endereco");

                        editaNome.setText(dbNome);
                        editaSobrenome.setText(dbSobrenome);
                        editaTelefone.setText(dbAniversario);
                        editaEndereco.setText(dbEndereco);

                    }

                });
        botaosalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String telaNome = editaNome.getText().toString().trim();
                String telaSobrenome = editaSobrenome.getText().toString().trim();
                String telefone = editaTelefone.getText().toString().trim();
                String telaEndereco = editaEndereco.getText().toString().trim();

                if(!(telaNome.isEmpty())){
                    db.collection("users").document(usario_key)
                            .update("InfoPessoais.Nome", telaNome);

                }
                if(!(telaSobrenome.isEmpty())){
                    db.collection("users").document(usario_key)
                            .update("InfoPessoais.Sobrenome", telaSobrenome);

                }
                if(!(telefone.isEmpty())){
                    db.collection("users").document(usario_key)
                            .update("InfoPessoais.Telefone", telefone);

                }
                if(!(telaEndereco.isEmpty())){
                    db.collection("users").document(usario_key)
                            .update("InfoPessoais.Endereco", telaEndereco);

                }
                toHome();



            }

        });




    }
    private void toHome(){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        finish();
    }



}