package com.jasper.example.service.interfaces;

import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by artyov.igor on 17.07.2016.
 */
public interface JasperService {

    ModelAndView getReport(String reportBeanName, JRBeanCollectionDataSource data);
    ModelAndView getReportByQuery(String reportBeanName);
}
