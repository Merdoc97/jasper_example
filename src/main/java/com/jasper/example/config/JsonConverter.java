package com.jasper.example.config;

/**
 *
 * Created by artyov.igor on 17.07.2016.
 */

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.hibernate4.Hibernate4Module;

/**
 * @see for more details https://github.com/FasterXML/jackson-datatype-hibernate
 * hibernate JSON module for lazy init
 */
public class JsonConverter extends ObjectMapper {
    public JsonConverter() {
        registerModule(new Hibernate4Module());
    }
}
