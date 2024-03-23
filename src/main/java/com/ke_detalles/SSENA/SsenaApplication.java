// Importaciones necesarias para la aplicación Spring Boot
package com.ke_detalles.SSENA;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

// Clase principal de la aplicación Spring Boot
@SpringBootApplication
public class SsenaApplication {

    // Método principal que inicia la aplicación
    public static void main(String[] args) {
        // Llama al método run() de SpringApplication, pasando la clase SsenaApplication y los argumentos args
        SpringApplication.run(SsenaApplication.class, args);
    }

}