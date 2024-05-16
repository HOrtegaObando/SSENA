package com.ke_detalles.SSENA.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import com.ke_detalles.SSENA.entity.Compra;
import com.ke_detalles.SSENA.servicio.CompraService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class CompraController {
    
    @Autowired
    private CompraService compraService;
    
    @PostMapping("/compras")
    public ResponseEntity<Object> realizarCompra(@RequestBody CompraRequest compraRequest) {
        // Aquí podrías realizar alguna validación o lógica adicional antes de llamar al servicio de compra
        // Por ejemplo, podrías verificar si el producto y la cantidad son válidos
        
        // Llamar al servicio de compra para realizar la compra
        Compra compra = compraService.realizarCompra(compraRequest);
        
        // Devolver la respuesta al cliente
        return ResponseEntity.ok(compra);
    }

}