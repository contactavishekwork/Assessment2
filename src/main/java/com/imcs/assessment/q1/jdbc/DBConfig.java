/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.imcs.assessment.q1.jdbc;

import java.io.InputStream;
import java.util.Properties;
import javax.sql.DataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

/**
 *
 * @author Avishek
 */
@Configuration
public class DBConfig {

    @Bean
    public DataSource dataSource() {
        DriverManagerDataSource dataSource;
        Properties prop;
        InputStream stream;
        boolean error = true;

        try {
            dataSource = new DriverManagerDataSource();
            prop = new Properties();
            stream = getClass().getClassLoader().getResourceAsStream("credentials.properties");

            if (stream == null) {
                System.out.println("Credentials Not Present!!");
            }

            prop.load(stream);
            error = false;

            dataSource.setDriverClassName(prop.getProperty("driver.name"));
            dataSource.setUrl(prop.getProperty("connectionUrl"));
            dataSource.setUsername(prop.getProperty("userName"));
            dataSource.setPassword(prop.getProperty("password"));

            return dataSource;
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }
}
