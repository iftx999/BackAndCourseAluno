package com.loiane.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Data;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.validator.constraints.Length;

@Data
@Entity
public class Aluno {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @JsonProperty("idAluno")
    private Long idAluno;


    @NotNull
    @Length(max = 10)
    @Column(length = 10, nullable = false)
    private String cpf;

    @NotNull
    @Length(max = 10)
    @Column(length = 10, nullable = false)
    private Integer idade;

    @NotNull
    @Length(max = 10)
    @Column(length = 10, nullable = false)
    private String nome;


}
