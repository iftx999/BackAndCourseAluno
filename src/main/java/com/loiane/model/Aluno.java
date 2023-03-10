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
public class Aluno {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @JsonProperty("idAluno")
    private Long idAluno;

    @NotNull
    @Length(max = 9)
    @Column(length = 9, nullable = false)
    private String cpf;

    @Column(scale=2)
    private Integer idade;

    @NotNull
    @Length(max = 100)
    @Column(length = 100, nullable = false)
    private String nome;


}
