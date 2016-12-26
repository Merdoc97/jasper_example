package com.jasper.example.service.impl;

import com.jasper.example.service.interfaces.JasperService;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import javax.sql.DataSource;
import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by artyo on 17.07.2016.
 * simple service for reporter controller
 */
@Service
public class JasperServiceImpl implements JasperService {

    @Autowired
    private DataSource dataSource;

    @Override
    public ModelAndView getReport(String reportBeanName, JRBeanCollectionDataSource data) {
        Map<String, Object> parameterMap = new HashMap<>();
        //important all reportDataKey should be reportData
        parameterMap.put("reportData", data);
        return new ModelAndView(reportBeanName, parameterMap);
    }

    @Override
    public ModelAndView getReportByQuery(String reportBeanName) {
        return new ModelAndView(reportBeanName);
    }


    @Override
    public byte[] getAsFile(String reportJrxmlName) throws IOException, JRException, SQLException {

        // get the JRXML template as a stream
        InputStream template = getClass()
                .getResourceAsStream("/reportview/" + reportJrxmlName + ".jrxml");
        // compile the report from the stream
        JasperReport report = JasperCompileManager.compileReport(template);
        // fill out the report into a print object, ready for export.
        HashMap<String, Object> map = new HashMap<>();
        JasperPrint print = JasperFillManager.fillReport(report, map, dataSource.getConnection());
        //return bytes from report
        return JasperExportManager.exportReportToPdf(print);
    }

    @Override
    public byte[] getAsFileWithoutQuery(String reportJrxmlName, JRBeanCollectionDataSource data) throws IOException, JRException, SQLException {

        // get the JRXML template as a stream
        InputStream template = getClass()
                .getResourceAsStream("/reportview/" + reportJrxmlName + ".jrxml");
        // compile the report from the stream
        JasperReport report = JasperCompileManager.compileReport(template);
        // fill out the report into a print object, ready for export.
        Map<String, Object> map = new HashMap<>();
        JasperPrint print = JasperFillManager.fillReport(report, map, data);
        //return bytes from report
        return JasperExportManager.exportReportToPdf(print);
    }
}
