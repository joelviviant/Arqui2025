package com.example.demo.controller;

import com.example.demo.model.Person;
import com.example.demo.repository.PersonRepository;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/persons")
@Tag(name = "PersonController", description = "REST API for managing persons")
public class PersonController {

    private final PersonRepository repository;

    @Autowired
    public PersonController(PersonRepository repository) {
        this.repository = repository;
    }

    @Operation(summary = "Get all persons")
    @GetMapping
    public List<Person> getAllPersons() {
        return repository.findAll();
    }

    @Operation(summary = "Get persons by name or surname")
    @GetMapping("/search")
    public List<Person> searchPersons(
            @RequestParam(required = false) String name,
            @RequestParam(required = false) String surname
    ) {
        if (name != null) {
            return repository.findAllByName(name);
        } else if (surname != null) {
            return repository.findAllBySurname(surname);
        } else {
            return repository.findAll();
        }
    }

    @Operation(summary = "Get person by ID")
    @GetMapping("/{id}")
    public Optional<Person> getPersonById(@PathVariable Long id) {
        return repository.findById(id);
    }

    @Operation(summary = "Create a new person")
    @PostMapping
    public Person createPerson(@RequestBody Person person) {
        return repository.save(person);
    }

    @Operation(summary = "Update or create a person by ID")
    @PutMapping("/{id}")
    public Person updatePerson(@RequestBody Person newPerson, @PathVariable Long id) {
        return repository.findById(id)
                .map(person -> {
                    person.setName(newPerson.getName());
                    person.setSurname(newPerson.getSurname());
                    return repository.save(person);
                })
                .orElseGet(() -> {
                    newPerson.setDni(id.intValue());
                    return repository.save(newPerson);
                });
    }

    @Operation(summary = "Delete person by ID")
    @DeleteMapping("/{id}")
    public void deletePerson(@PathVariable Long id) {
        repository.deleteById(id);
    }
}
