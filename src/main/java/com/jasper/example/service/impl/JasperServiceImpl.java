package com.jasper.example.service.impl;

import com.jasper.example.service.interfaces.JasperService;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by artyo on 17.07.2016.
 * simple service for reporter controller
 */
@Service
public class JasperServiceImpl implements JasperService {
    @Override
    public ModelAndView getReport(String reportBeanName, JRBeanCollectionDataSource data) {
        Map<String, Object> parameterMap = new HashMap<>();
        //important all reportDataKey should be reportData
        parameterMap.put("reportData", data);
        return new ModelAndView(reportBeanName,parameterMap);
    }

    @Override
    public ModelAndView getReportByQuery(String reportBeanName) {
        return new ModelAndView(reportBeanName);
    }
}
