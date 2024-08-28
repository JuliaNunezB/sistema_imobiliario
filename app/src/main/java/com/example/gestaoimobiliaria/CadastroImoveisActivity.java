package com.example.gestaoimobiliaria;

import dao.ImovelDAO;
import model.Imovel;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;

public class CadastroImoveisActivity extends AppCompatActivity {

    private EditText etEndereco, etPreco, etTipo, etDescricao;
    private CheckBox cbDisponivel;  // Adicionando o CheckBox para disponibilidade
    private Button btnSalvarImovel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_imoveis);

        etEndereco = findViewById(R.id.et_endereco);
        etPreco = findViewById(R.id.et_preco);
        etTipo = findViewById(R.id.et_tipo);
        etDescricao = findViewById(R.id.et_descricao);
        cbDisponivel = findViewById(R.id.cb_disponivel);  // Ligando o CheckBox da interface
        btnSalvarImovel = findViewById(R.id.btn_salvar_imovel);

        btnSalvarImovel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                salvarImovel();
            }
        });
    }

    private void salvarImovel() {
        String endereco = etEndereco.getText().toString();
        double preco = Double.parseDouble(etPreco.getText().toString());
        String tipo = etTipo.getText().toString();
        String descricao = etDescricao.getText().toString();
        boolean disponivel = cbDisponivel.isChecked();  // Capturando o estado do CheckBox

        // Criando o objeto Imovel com o estado de disponibilidade
        Imovel imovel = new Imovel(endereco, preco, tipo, descricao, disponivel);
        ImovelDAO imovelDAO = new ImovelDAO(this);
        imovelDAO.inserirImovel(imovel);

        finish(); // Fecha a Activity após salvar
    }
}
