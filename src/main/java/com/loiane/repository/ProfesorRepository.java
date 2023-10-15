package com.loiane.repository;

import com.loiane.dto.ProfessorDTO;
import com.loiane.model.Professor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProfesorRepository extends JpaRepository<Professor, Long> {

    @Query(value = "select nome, salario from professor ", nativeQuery = true)
    List<ProfessorDTO> findAllBy();
}
