package com.motta.android.domains;

public class Address {

    private final String cep;
    private final String logradouro;
    private final String complemento;
    private final String bairro;
    private final String cidade;
    private final String uf;

    public Address(String cep, String logradouro, String complemento, String bairro, String cidade, String uf) {
        this.cep = cep;
        this.logradouro = logradouro;
        this.complemento = complemento;
        this.bairro = bairro;
        this.cidade = cidade;
        this.uf = uf;
    }

    public String toText() {
        return String.format("%s, %s - %s, %s - %s",
                this.logradouro, this.complemento, this.bairro, this.cidade, this.uf);
    }

    @Override
    public String toString() {
        return toText();
    }

    public String getCep() {
        return cep;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public String getComplemento() {
        return complemento;
    }

    public String getBairro() {
        return bairro;
    }

    public String getCidade() {
        return cidade;
    }

    public String getUf() {
        return uf;
    }

}
