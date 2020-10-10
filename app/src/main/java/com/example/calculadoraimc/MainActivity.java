package com.example.calculadoraimc;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.v("Ciclo de Vida", getLocalClassName()+".onCreate() chamado." );
        setContentView(R.layout.activity_main);
    }

    public void clickRelatorio(View view){
        EditText edtNome = (EditText) findViewById(R.id.editTextNome);
        EditText edtIdade = (EditText) findViewById(R.id.editTextIdade);
        EditText edtAltura = (EditText) findViewById(R.id.editTextAltura);
        EditText edtPeso = (EditText) findViewById(R.id.editTextPeso);

        String nome = edtNome.getText().toString();
        String idade = edtIdade.getText().toString();
        String peso = edtPeso.getText().toString();
        String altura = edtAltura.getText().toString();
        if(nome.length() == 0 || idade.length() == 0 || peso.length() == 0 || altura.length() == 0)
            Toast.makeText(getBaseContext(),"Faltando informação", Toast.LENGTH_LONG).show();
        else {
            Intent it = new Intent(getBaseContext(),resultadoAct.class);

            it.putExtra("nome", edtNome.getText().toString());
            it.putExtra("idade", Integer.parseInt(idade));
            it.putExtra("peso", Double.parseDouble(peso));
            it.putExtra("altura", Double.parseDouble(altura));

            startActivity(it);
        }
    }

    @Override
    protected void onStart(){
        super.onStart();
        Log.v("Ciclo de Vida", getLocalClassName()+".onStart() chamado." );
    }
    @Override
    protected void onPause(){
        super.onPause();
        Log.v("Ciclo de Vida", getLocalClassName()+".onPause() chamado." );
    }
    @Override
    protected void onRestart(){
        super.onRestart();
        Log.v("Ciclo de Vida", getLocalClassName()+".onRestart() chamado." );
    }
    @Override
    protected void onResume(){
        super.onResume();
        Log.v("Ciclo de Vida", getLocalClassName()+".onResume() chamado." );
    }
    @Override
    protected void onStop(){
        super.onStop();
        Log.v("Ciclo de Vida", getLocalClassName()+".onStop() chamado." );
    }

    @Override
    protected void onDestroy(){
        super.onDestroy();
        Log.v("Ciclo de Vida", getLocalClassName()+".onDestroy() chamado." );
    }
}