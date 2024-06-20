package io.github.welton.domain.entity;

public class Cliente {

    private Integer Id;
    private String nome;

    public Cliente() {
    }

    public Cliente(Integer id, String nome) {
        Id = id;
        this.nome = nome;
    }

    public Cliente(String nome) {
        this.nome = nome;
    }

    public Integer getId() {
        return Id;
    }

    public void setId(Integer id) {
        Id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "Id=" + Id +
                ", nome='" + nome + '\'' +
                '}';
    }
}
