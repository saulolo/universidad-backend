package edu.universidad.universidadbackend.controller;

import edu.universidad.universidadbackend.services.Interfaces.ICarreraService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/carreras")
public class CarreraController {

    private final ICarreraService carreraService;

    public CarreraController(ICarreraService carreraService) {
        this.carreraService = carreraService;
    }
}
