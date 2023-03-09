package com.loiane.service;

import com.loiane.model.Aluno;
import com.loiane.model.Interface.AlunoDAO;
import com.loiane.repository.AlunoRepository;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

public class RelatorioService {

    @Autowired
    private AlunoRepository alunoRepository ;

    private JasperPrint genReport(List<?> objs, Map<String, Object> params, String filePath) throws FileNotFoundException, JRException {
        InputStream reportInputStream = getClass().getResourceAsStream(filePath);
        JasperDesign jasperDesign = JRXmlLoader.load(reportInputStream);

        JasperReport jasperReport = JasperCompileManager.compileReport(jasperDesign);

        params.put("REPORT_LOCALE", new Locale("pt", "BR"));

        JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(objs);
        JasperPrint print = JasperFillManager.fillReport(jasperReport, params, dataSource);

        return print;
    }

    public JasperPrint genRelAluno(Long idAluno)throws FileNotFoundException, JRException {
        Aluno aluno = alunoRepository.findById(idAluno).orElse(null);
        List<AlunoDAO> relAluno = alunoRepository.getRelAluno(idAluno);

        Map<String, Object> params = new HashMap<>();
        params.put("DATE", new java.util.Date());
        params.put("EVENT_NAME", aluno.getNome());



        return genReport(relAluno, params, );
    }



}
