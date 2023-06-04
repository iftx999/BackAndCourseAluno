package com.loiane.controller;

import com.loiane.dto.AlunoDTO;
import com.loiane.repository.AlunoRepository;
import com.loiane.service.AlunoService;
import com.loiane.service.RelatorioService;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperPrint;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.io.OutputStream;
import java.util.List;

@Validated
@RestController
@RequestMapping("/api/aluno")
public class AlunoController {
    @Autowired
    private  AlunoService alunoService;

    @Autowired
    private AlunoRepository alunoRepository;

    @Autowired
    private  RelatorioService relatorioService;

    public AlunoController(AlunoService alunoService) {
        this.alunoService = alunoService;
    }

    @GetMapping
    public @ResponseBody List<AlunoDTO> list() {
        return alunoService.list();
    }

    @GetMapping("/{id}")
    public AlunoDTO findById(@PathVariable @NotNull @Positive Long id) {
        return alunoService.findById(id);
    }

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public AlunoDTO create(@RequestBody @Valid @NotNull AlunoDTO aluno) {
        return alunoService.create(aluno);
    }

    @PutMapping("/{id}")
    public AlunoDTO update(@PathVariable @NotNull @Positive Long id,
                           @RequestBody @Valid @NotNull AlunoDTO aluno) {
        return alunoService.update(id, aluno);
    }


    @RequestMapping(value = "/relAluno/{idAluno}", method = RequestMethod.GET)
    public void PrintRelAluno(@PathVariable Long idAluno, HttpServletResponse response) throws Exception {
        JasperPrint jprint = null;

        response.setContentType("application/pdf");
        response.setHeader("Content-Disposition", "attachment; filename=\"Aluno.pdf\"");

        OutputStream out = response.getOutputStream();
        out.flush();
        jprint = relatorioService.genRelAluno(idAluno);

        JasperExportManager.exportReportToPdfStream(jprint, out);
    }

    @GetMapping("/totalAluno")
    public Long getTotalAlunos() {
        return alunoRepository.count();
    }


    @DeleteMapping("/{id}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    public void delete(@PathVariable @NotNull @Positive Long id) {
        alunoService.delete(id);
    }
}


