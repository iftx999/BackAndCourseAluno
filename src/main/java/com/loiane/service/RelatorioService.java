package com.loiane.service;

import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;

import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.List;
import java.util.Locale;
import java.util.Map;

public class RelatorioService {

    private JasperPrint genReport(List<?> objs, Map<String, Object> params, String filePath) throws FileNotFoundException, JRException {
        InputStream reportInputStream = getClass().getResourceAsStream(filePath);
        JasperDesign jasperDesign = JRXmlLoader.load(reportInputStream);

        JasperReport jasperReport = JasperCompileManager.compileReport(jasperDesign);

        params.put("REPORT_LOCALE", new Locale("pt", "BR"));

        JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(objs);
        JasperPrint print = JasperFillManager.fillReport(jasperReport, params, dataSource);

        return print;
    }
}
