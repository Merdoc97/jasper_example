package com.jasper.example.service.interfaces;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;
import java.sql.SQLException;

/**
 * Created by artyov.igor on 17.07.2016.
 */

public interface JasperService {

    ModelAndView getReport(String reportBeanName, JRBeanCollectionDataSource data);


    ModelAndView getReportByQuery(String reportBeanName);

    byte[] getAsFile(String reportJrxmlName) throws IOException, JRException, SQLException;

    byte[] getAsFileWithoutQuery(String reportJrxmlName, JRBeanCollectionDataSource data) throws IOException, JRException, SQLException;
}
