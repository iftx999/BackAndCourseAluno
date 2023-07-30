package com.loiane.model;


import com.fasterxml.jackson.annotation.JsonProperty;import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

@Data
@Entity
@Table(name = "Setor")
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

    public String getSetorName() {
        return setorName;
    }

    public void setSetorName(String setorName) {
        this.setorName = setorName;
    }

    public Setor(Long id) {
        this.idSetor = id;
    }

    public Setor() {

    }
}
