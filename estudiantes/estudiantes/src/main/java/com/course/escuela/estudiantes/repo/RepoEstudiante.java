package com.course.escuela.estudiantes.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.course.escuela.estudiantes.entidad.Estudiante;

public interface RepoEstudiante extends JpaRepository<Estudiante, Integer>{

}
