package com.loiane.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Data;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.validator.constraints.Length;

@Data
@Entity
@Table(name = "Aluno")
public class Aluno {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @JsonProperty("idAluno")
    private Long idAluno;

    @NotNull
    @Length(max = 16)
    @Column(length = 11, nullable = false)
    private String cpf;

    @Column(scale=2)
    private Integer idade;

    @NotNull
    @Length(max = 100)
    @Column(length = 100, nullable = false)
    private String nome;

    @NotNull
    @Length(max = 100)
    @Column(length = 100, nullable = false)
    private String responsavel;

    @NotNull
    @Length(max = 100)
    @Column(length = 100, nullable = false)
    private String contato;

    @ManyToOne
    @JoinColumn(name = "idCourse")
    private Course idcourse;


    public Long getIdAluno() {
        return idAluno;
    }

    public void setIdAluno(Long idAluno) {
        this.idAluno = idAluno;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Integer getIdade() {
        return idade;
    }

    public void setIdade(Integer idade) {
        this.idade = idade;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getResponsavel() {
        return responsavel;
    }

    public void setResponsavel(String responsavel) {
        this.responsavel = responsavel;
    }

    public String getContato() {
        return contato;
    }

    public void setContato(String contato) {
        this.contato = contato;
    }

    public Course getIdcourse() {
        return idcourse;
    }

    public void setIdcourse(Course idcourse) {
        this.idcourse = idcourse;
    }
}
