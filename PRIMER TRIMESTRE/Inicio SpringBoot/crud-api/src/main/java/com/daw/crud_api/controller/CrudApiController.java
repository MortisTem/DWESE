package com.daw.crud_api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.GetMapping;

import com.daw.crud_api.model.Cliente;
import com.daw.crud_api.repository.ClienteRepository;

@RestController // Las respuestas se devuelven como JSON
@RequestMapping("/crudapi") // Prefijo común de todas las URL
public class CrudApiController {

    @Autowired 
    ClienteRepository repoCli;

    @GetMapping
    public String index() {
        Cliente cliente = new Cliente(1L, "Pedro", "Jimenez", "pepe@gmail.com", "564356464", null)

        Cliente clienteGuardado = repoCli.save(cliente);

        clienteGuardado.setApellidos("Gonzales Savedra");

        repoCli.save(clienteGuardado);

        return new String("Página Principal");
    }

}