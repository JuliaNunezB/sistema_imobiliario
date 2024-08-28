package model;

import android.content.ContentValues;

public class Imovel {
    private int id;
    private String endereco;
    private double preco;
    private String tipo; // Exemplo: "Venda", "Aluguel"
    private String descricao;
    private boolean disponivel;

    // Construtor
    public Imovel(int id, String endereco, double preco, String tipo, String descricao, boolean disponivel) {
        this.id = id;
        this.endereco = endereco;
        this.preco = preco;
        this.tipo = tipo;
        this.descricao = descricao;
        this.disponivel = disponivel;
    }

    public Imovel(String endereco, double preco, String tipo, String descricao, boolean disponivel) {

        this.endereco = endereco;
        this.preco = preco;
        this.tipo = tipo;
        this.descricao = descricao;
        this.disponivel = disponivel;
    }

    // Getters e Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public boolean isDisponivel() {
        return disponivel;
    }

    public void setDisponivel(boolean disponivel) {
        this.disponivel = disponivel;
    }

    public ContentValues getContentValues() {
        ContentValues valores = new ContentValues();
        if(id>0){
            valores.put("id", id);
        }
        valores.put("endereco", endereco);
        valores.put("preco", preco);
        valores.put("tipo", tipo);
        valores.put("descricao", descricao);
        valores.put("disponivel", disponivel);
        return valores;
    }
}

