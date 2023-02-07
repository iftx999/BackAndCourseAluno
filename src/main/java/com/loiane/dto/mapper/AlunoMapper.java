package com.loiane.dto.mapper;

import com.loiane.dto.AlunoDTO;
import com.loiane.dto.AlunoDTO;
import com.loiane.model.Aluno;
import com.loiane.model.Course;
import org.springframework.stereotype.Component;

@Component
public class AlunoMapper {
    public AlunoDTO toDTO(Aluno aluno) {
        if (aluno == null) {
            return null;
        }
        return new AlunoDTO(aluno.getIdAluno(), aluno.getNome(), aluno.getIdade(), aluno.getCpf());
    }

    public Aluno toEntity(AlunoDTO alunoDTO) {

        if (alunoDTO == null) {
            return null;
        }

        Aluno aluno = new Aluno();
        if (alunoDTO.idAluno() != null) {
            aluno.setIdAluno(alunoDTO.idAluno());
        }
        aluno.setNome(alunoDTO.nome());
        aluno.setCpf(alunoDTO.cpf());
        aluno.setIdade(alunoDTO.idade());
        return aluno;
    }
}
