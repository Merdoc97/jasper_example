package com.jasper.example.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 *
 * Created by artyov.igor on 17.07.2016.
 */
@Configuration
@ImportResource({"classpath:jasper.xml","classpath:dbconfig.xml","classpath:serviceBeans.xml"})
@EnableJpaRepositories("com.jasper.example.repository")
@ComponentScan({"com.jasper.example"})
@EnableWebMvc
public class Config extends WebMvcConfigurerAdapter {

}
