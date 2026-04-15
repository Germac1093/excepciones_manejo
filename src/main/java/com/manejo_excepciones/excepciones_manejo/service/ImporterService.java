package com.manejo_excepciones.excepciones_manejo.service;

import java.util.*;
import com.manejo_excepciones.excepciones_manejo.models.Product;

import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.manejo_excepciones.excepciones_manejo.repository.ProductRepository;
import com.manejo_excepciones.excepciones_manejo.utils.ConfigUtils;

import reactor.core.publisher.Mono;
import tools.jackson.databind.JsonNode;
import tools.jackson.databind.ObjectMapper;

@Service
public class ImporterService {


    ProductRepository repository;

    ObjectMapper objectMapper;

    private WebClient webClient;

    public ImporterService(ConfigUtils utils, ObjectMapper objectMapper, ProductRepository repository){
        this.webClient = utils.getWebClient();
        this.objectMapper = objectMapper;
        this.repository = repository;
    }

    public Mono<JsonNode> getRawJson(){

            return webClient.get()
                            .retrieve()
                            .bodyToMono(String.class)
                            .onErrorMap(e -> new RuntimeException("Error during the collection of data: " + e.getMessage()))
                            .map(
                                jsonString -> {
                                try{

                                    JsonNode root = objectMapper.readTree(jsonString);
                                    return root.path("data");

                                }catch(Exception e ){
                                    throw new RuntimeException("Error parsing json");
                                }
                            }
                        );

    
        }

    public Mono<List<Product>> getProducts(){
                
        return getRawJson().map(node -> {
            try{
                return Arrays.asList(objectMapper.treeToValue(node, Product[].class));
            }catch(Exception e){
                throw new RuntimeException("Error converting json to entity " + e.getMessage());
            }
        });
    }

    public void loadToDB(){
        this.getProducts().subscribe(products -> repository.saveAll(products));
    }
    
}