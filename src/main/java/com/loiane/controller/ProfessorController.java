package com.loiane.controller;

import com.loiane.dto.ProfessorDTO;
import com.loiane.model.Professor;
import com.loiane.repository.ProfesorRepository;
import com.loiane.service.ProfessorService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.List;

@Validated
@RestController
@RequestMapping("/api/professores")
public class ProfessorController {

    @Autowired
    private ProfessorService professorService;
    @Autowired
    private ProfesorRepository profesorRepository;

    @GetMapping
    public @ResponseBody List<ProfessorDTO> list() {
        return professorService.list();
    }

    @GetMapping("/{id}")
    public ProfessorDTO findById(@PathVariable @NotNull @Positive Long id) {
        return professorService.findById(id);
    }

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public ProfessorDTO create(@RequestBody @Valid @NotNull ProfessorDTO professor) {
        return professorService.create(professor);
    }

    @PutMapping("/{idProfessor}")
    public ProfessorDTO update(@PathVariable @NotNull @Positive Long idProfessor,
                            @RequestBody @Valid @NotNull ProfessorDTO professor) {
        return professorService.update(idProfessor, professor);
    }



    @DeleteMapping("/{id}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    public void delete(@PathVariable @NotNull @Positive Long id) {
        professorService.delete(id);
    }


}
