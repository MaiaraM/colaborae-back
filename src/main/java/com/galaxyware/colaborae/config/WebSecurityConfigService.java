package com.galaxyware.colaborae.config;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;

public interface WebSecurityConfigService {

    void configure(HttpSecurity http) throws Exception;
}