package com.manejo_excepciones.excepciones_manejo.controladores;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;

import com.manejo_excepciones.excepciones_manejo.models.Product;
import com.manejo_excepciones.excepciones_manejo.models.Usuario;
import com.manejo_excepciones.excepciones_manejo.repository.ProductRepository;
import com.manejo_excepciones.excepciones_manejo.service.ImporterService;

import tools.jackson.databind.JsonNode;
import tools.jackson.databind.ObjectMapper;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;



@RestController
@RequestMapping("api/import")
public class ImporterController {

    @Autowired
    ImporterService importerService;

    @GetMapping("/products")
    public ResponseEntity<Usuario> importPruducts(){

        importerService.loadToDB();

        return ResponseEntity.ok(new Usuario("Gerardo Macias", "Desarrollador"));
    }
    


}
