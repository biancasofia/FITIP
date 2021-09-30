package com.example.fitip10;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class Professor extends AppCompatActivity {
    private FirebaseAuth mAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_professor);
        mAuth = FirebaseAuth.getInstance();

    }

    protected void onStart(){
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
            Intent intent = new Intent(this, EdicaoDados.class);
            startActivity(intent);


        }

        return super.onOptionsItemSelected(item);
    }




    }