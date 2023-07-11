package com.loiane;

import com.loiane.model.Aluno;
import com.loiane.model.Course;
import com.loiane.model.Professor;
import com.loiane.repository.AlunoRepository;
import com.loiane.repository.CourseRepository;

import com.loiane.repository.ProfesorRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Date;

@SpringBootApplication
public class CrudSpringApplication {

	public static void main(String[] args) {
		SpringApplication.run(CrudSpringApplication.class, args);
	}

	@Bean
	CommandLineRunner initDatabase(CourseRepository courseRepository) {
		return args -> {
			courseRepository.deleteAll();

			Course c = new Course();
			c.setName("Angular com Spring");
			c.setCategory("Front-end");

			courseRepository.save(c);
		};
	}

	@Bean
	CommandLineRunner initDatabase2(ProfesorRepository profesorRepository) {
		return args -> {
			profesorRepository.deleteAll();

			Professor p = new Professor();
			p.setNameProf("Serafim");
			Date nascimento = new Date(); // ou utilize LocalDate.now() se estiver usando Java 8 ou superior
			p.setNascimento(nascimento);			p.setEndereco("Rua Boa morte ");
			p.setEmail("matheus@gmail.com");
			p.setTelefone("19988048209");

			profesorRepository.save(p);
		};
	}


}