package com.soulcode.Servicos.Models;

public enum StatusPagamento {

    LANCADO("Lancado"),
    QUITADO("Quitado");

    private String descricao;

    StatusPagamento(String descricao) { this.descricao = descricao; }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}
