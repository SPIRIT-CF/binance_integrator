/*
package com.crypto.binance_integrator.config;

import com.crypto.binance_integrator.provider.SettingsProvider;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class DataSource {

    private final SettingsProvider settingsProvider;

    @Bean
    public javax.sql.DataSource dataSource() {
        DriverManagerDataSource source = new DriverManagerDataSource();
        source.setDriverClassName(settingsProvider.getDataDriver());
        source.setUrl(settingsProvider.getDataUrl());
        source.setUsername(settingsProvider.getDataUsername());
        source.setPassword(settingsProvider.getDataPassword());
        return source;
    }

*/
/*    @Bean
    public NamedParameterJdbcTemplate namedParameterJdbcTemplate(){
        NamedParameterJdbcTemplate namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(this.dataSource());
        return namedParameterJdbcTemplate;
    }*//*

}
*/
