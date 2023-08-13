package com.loiane.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import org.hibernate.validator.constraints.Length;


@Data
@Entity
@Table(name = "Setors")
public class Setor {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @JsonProperty("idSetor")
    private Long idSetor;

    @NotNull
    @NotBlank
    @Length(min = 5, max = 100)
    @Column(length = 100, nullable = false)
    private String setorName;

    public Long getIdSetor() {
        return idSetor;
    }

    public void setIdSetor(Long idSetor) {
        this.idSetor = idSetor;
    }

    public Setor(Long idSetor) {
        this.idSetor = idSetor;
    }


    public Setor(){

     }

}
