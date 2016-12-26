package com.jasper.example.controller;

import com.jasper.example.service.impl.AbstractService;
import com.jasper.example.service.interfaces.JasperService;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import org.apache.poi.util.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;

/**
 *
 * Created by artyov.igor on 17.07.2016.
 */
@Controller
public class ReportController {

    @Autowired
    @Qualifier("abstractUserService")
    private AbstractService userService;
    @Autowired
    private JasperService jasperService;
    @RequestMapping(value = "/report/pdf", method = RequestMethod.GET)
    public ModelAndView getPdfReport() {
        return jasperService.getReport("pdfReport",new JRBeanCollectionDataSource(userService.getAll()));
    }

    @RequestMapping(value = "/report/xls", method = RequestMethod.GET)
    public ModelAndView getXlsReport() {
        return jasperService.getReport("xlsReport",new JRBeanCollectionDataSource(userService.getAll()));
    }

    @RequestMapping(value = "/report/html", method = RequestMethod.GET)
    public ModelAndView getHtmlReport() {
        return jasperService.getReport("htmlReport",new JRBeanCollectionDataSource(userService.getAll()));
    }

    @RequestMapping(value = "/report/pdf/users",method = RequestMethod.GET)
    public ModelAndView getUsersByQuery(){
        return jasperService.getReportByQuery("userPdfQuery");
    }

    @RequestMapping(value = "/report/pdf/users/asfile",method = RequestMethod.GET)
    public ResponseEntity<byte[]> getUsersByQueryAsFile() throws IOException, JRException, SQLException {
        final HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.valueOf("application/pdf"));
        headers.setContentDispositionFormData("test.pdf", "test.pdf");
        return new ResponseEntity<>(jasperService.getAsFile("withoutJpa"),headers,HttpStatus.OK);
    }

    @RequestMapping(value = "/image.png",method = RequestMethod.GET)
    public ResponseEntity<byte[]> getImageView() throws IOException {
        InputStream io=Thread.currentThread().getContextClassLoader().getResourceAsStream("/images/noname.png");
        final HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.IMAGE_PNG);
        return new ResponseEntity<>(IOUtils.toByteArray(io), headers, HttpStatus.FOUND);
    }
    @RequestMapping(value = "/test.pdf",method = RequestMethod.GET)
    public ResponseEntity<byte[]> getPdf() throws IOException {
        InputStream io=Thread.currentThread().getContextClassLoader().getResourceAsStream("/pdfview/postgresql.pdf");
        final HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.valueOf("application/pdf"));
        return new ResponseEntity<>(IOUtils.toByteArray(io), headers, HttpStatus.FOUND);
    }


}
