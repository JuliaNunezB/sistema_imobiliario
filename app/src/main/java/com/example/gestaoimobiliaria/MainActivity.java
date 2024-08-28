package com.example.gestaoimobiliaria;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Configurar os botões e listeners
        Button btnCadastroImoveis = findViewById(R.id.btn_cadastro_imoveis);
        Button btnListaImoveis = findViewById(R.id.btn_lista_imoveis);
        Button btnCadastroClientes = findViewById(R.id.btn_cadastro_clientes);
        Button btnListaClientes = findViewById(R.id.btn_lista_clientes);
        Button btnTransacoes = findViewById(R.id.btn_transacoes);

        btnCadastroImoveis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, CadastroImoveisActivity.class);
                startActivity(intent);
            }
        });

        /*btnListaImoveis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ListaImoveisActivity.class);
                startActivity(intent);
            }
        });

        btnCadastroClientes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, CadastroClientesActivity.class);
                startActivity(intent);
            }
        });

        btnListaClientes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ListaClientesActivity.class);
                startActivity(intent);
            }
        });

        btnTransacoes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, TransacoesActivity.class);
                startActivity(intent);
            }
        });*/
    }
}
