package com.example.fitip10;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class MainActivity extends AppCompatActivity {

    private FirebaseAuth mAuth;
    private Button btn_logout;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mAuth = FirebaseAuth.getInstance();





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


    public boolean onOptionsItemSelected(@NonNull MenuItem item) {


        if(  item.getItemId()==R.id.navigation_edit){
            Intent intent = new Intent(this, EdicaoDados.class);
            startActivity(intent);


        }


        if(  item.getItemId()==R.id.navigation_chat){
            //   Intent intent = new Intent(this, ActivityCadastroVacina.class);
            // startActivity(intent);
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