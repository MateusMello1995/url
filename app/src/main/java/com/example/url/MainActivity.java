package com.example.url;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //lista a ser exibida na tela
        ListView list = findViewById(R.id.list);

        //lista que será retornada da API
        ArrayList<Posts> retorno = null;

        try {
            retorno = new HttpRequisition().execute().get();
        }catch (Exception e){
            e.printStackTrace();
        }

        if(retorno != null){

            ArrayAdapter<Posts> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, retorno);
            list.setAdapter(adapter);
            Log.i("Erro", "A lista de retorno da API está vazia.");
        }
    }
}
