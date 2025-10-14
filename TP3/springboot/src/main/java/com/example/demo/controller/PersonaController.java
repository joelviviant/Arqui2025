package com.example.demo.controller;

import com.example.demo.model.Persona;
import com.example.demo.repository.PersonaRepository;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/personas")
public class PersonaController {

    private final PersonaRepository repository;

    public PersonaController(PersonaRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public List<Persona> getAll() {
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public Persona getById(@PathVariable Long id) {
        return repository.findById(id).orElse(null);
    }

    @PostMapping
    public Persona create(@RequestBody Persona persona) {
        return repository.save(persona);
    }

    @PutMapping("/{id}")
    public Persona update(@PathVariable Long id, @RequestBody Persona persona) {
        return repository.findById(id)
                .map(p -> {
                    p.setNombre(persona.getNombre());
                    p.setApellido(persona.getApellido());
                    p.setEdad(persona.getEdad());
                    p.setEmail(persona.getEmail());
                    return repository.save(p);
                })
                .orElseGet(() -> {
                    persona.setId(id);
                    return repository.save(persona);
                });
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        repository.deleteById(id);
    }
}