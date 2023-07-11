package com.loiane.repository;

import com.loiane.model.Course;
import com.loiane.model.Professor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProfesorRepository extends JpaRepository<Professor, Long> {
}
