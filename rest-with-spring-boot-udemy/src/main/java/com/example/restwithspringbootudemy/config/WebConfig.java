package com.example.restwithspringbootudemy.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.servlet.config.annotation.ContentNegotiationConfigurer;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@EnableWebMvc
public class WebConfig implements WebMvcConfigurer {

    /* Habilitar métodos para cors */

    public void addCorsMapping(CorsRegistry registry)
    {
        registry.addMapping("/**")
        .allowedMethods("GET", "POST", "PUT", "PATCH", "DELETE",
                "OPTIONS", "HEAD", "TRACE", "CONNECT");
    }

    @Override
    public void configureContentNegotiation(ContentNegotiationConfigurer configurer)
    {
        /*configurer.favorParameter(false).parameterName("mediaType")
                .ignoreAcceptHeader(false)
                .defaultContentType(MediaType.APPLICATION_JSON)
                .mediaType("json", MediaType.APPLICATION_JSON)
                .mediaType("xml", MediaType.APPLICATION_XML);*/

        configurer.favorPathExtension(false)
                .favorParameter(true)
                .parameterName("mediaType")
                .ignoreAcceptHeader(true)
                .useRegisteredExtensionsOnly(true)
                .defaultContentType(MediaType.APPLICATION_JSON)
                .mediaType("json", MediaType.APPLICATION_JSON)
                .mediaType("xml", MediaType.APPLICATION_XML);
    }
}
