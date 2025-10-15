package com.example.integradorDemo.repository;

import com.example.integradorDemo.model.Persona;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonaRepository extends JpaRepository<Persona, Long> {
}