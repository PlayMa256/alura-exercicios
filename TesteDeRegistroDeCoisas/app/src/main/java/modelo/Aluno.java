package modelo;

import java.io.Serializable;

/**
 * Created by adm on 30/09/2015.
 */
public class Aluno implements Serializable {
    private long ID;
    private String nome;
    private String endereco;
    private String site;
    private String telefone;
    private Double nota;
    private String caminhoFoto;

    public Aluno(String nome, String endereco, String site, String telefone, Double nota) {
        this.nome = nome;
        this.endereco = endereco;
        this.site = site;
        this.telefone = telefone;
        this.nota = nota;
        //this.caminhoFoto = caminhoFoto;
    }
    public Aluno(){

    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getSite() {
        return site;
    }

    public void setSite(String site) {
        this.site = site;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public Double getNota() {
        return nota;
    }

    public void setNota(Double nota) {
        this.nota = nota;
    }

    public String getCaminhoFoto() {
        return caminhoFoto;
    }

    public void setCaminhoFoto(String caminhoFoto) {
        this.caminhoFoto = caminhoFoto;
    }

    public long getID() {
        return ID;
    }

    public void setID(long ID) {
        this.ID = ID;
    }

    @Override
    public String toString(){
        return this.ID +" - "+  this.nome;
    }
}
