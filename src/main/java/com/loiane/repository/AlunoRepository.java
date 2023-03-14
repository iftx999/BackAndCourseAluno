package com.loiane.repository;

import com.loiane.model.Aluno;
import com.loiane.model.Interface.AlunoDAO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface AlunoRepository extends JpaRepository<Aluno, Long> {

    @Query(value = "select nome, cpf, idade from aluno where id_aluno = 1 ", nativeQuery = true)
    List<AlunoDAO> getRelAluno(@Param("id_aluno") Long Aluno);
}
