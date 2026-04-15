package com.manejo_excepciones.excepciones_manejo.utils;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

@Component
@PropertySource("classpath:data.properties")
public class ConfigUtils {

    @Value("${urlJsonStringData}")
    private String url;

    public String getUrl(){return url;}

    public WebClient getWebClient(){return WebClient.create(url);}

}
