package com.example.calculadoraimc;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class resultadoAct extends AppCompatActivity {

    public void clickNewCalc(View view){
        Intent it = new Intent(getBaseContext(),MainActivity.class);
        it.addFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
        startActivity(it);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.v("Ciclo de Vida", getLocalClassName()+".onCreate() chamado." );
        setContentView(R.layout.activity_resultado);

        Intent it = getIntent();
        Log.d("DEBUG", it.getStringExtra("nome"));
        Log.d("DEBUG", Integer.toString(it.getIntExtra("idade",0)));
        Log.d("DEBUG", Double.toString(it.getDoubleExtra("peso",0)));
        Log.d("DEBUG",  Double.toString(it.getDoubleExtra("altura",0)));

        TextView txtN = (TextView) findViewById(R.id.textNome);
        TextView txtI = (TextView) findViewById(R.id.textIdade);
        TextView txtP = (TextView) findViewById(R.id.textPeso);
        TextView txtA = (TextView) findViewById(R.id.textAltura);
        TextView txtIM = (TextView) findViewById(R.id.textIMC);
        TextView txtC = (TextView) findViewById(R.id.textClassi);

        txtN.setText(it.getStringExtra("nome"));
        txtI.setText(Integer.toString(it.getIntExtra("idade",0)));
        txtP.setText(Double.toString(it.getDoubleExtra("peso",0)));
        txtA.setText(Double.toString(it.getDoubleExtra("altura",0)));

        //Calculo do IMC
        Double IMC = it.getDoubleExtra("peso",0)/(it.getDoubleExtra("altura",0)*it.getDoubleExtra("altura",0));

        txtIM.setText(String.format("%.2f", IMC));

        if(IMC < 18.5)
            txtC.setText("Abaixo do peso");
        else if(IMC >=18.5 && IMC <25)
            txtC.setText("Saudável");
        else if(IMC >=25 && IMC <30)
            txtC.setText("Sobrepeso");
        else if(IMC >=30 && IMC <35)
            txtC.setText("Obesidade Grau I");
        else if(IMC >=35 && IMC <40)
            txtC.setText("Obesidade Grau II (severa)");
        else if(IMC >=40)
            txtC.setText("Obesidade Grau III (mórbida)");
        else
            txtC.setText("Valores de peso e/ou altura incorretos");
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