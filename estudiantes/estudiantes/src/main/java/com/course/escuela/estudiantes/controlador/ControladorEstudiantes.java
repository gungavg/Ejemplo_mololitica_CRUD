package com.course.escuela.estudiantes.controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.course.escuela.estudiantes.entidad.Estudiante;
import com.course.escuela.estudiantes.repo.RepoEstudiante;

@RestController
public class ControladorEstudiantes {
	@Autowired
	RepoEstudiante repo;
	
	
	//Sentencia Get
	@GetMapping("/estudiantes")
	public List<Estudiante> getAllEstudiantes(){
		List<Estudiante> estudiante = repo.findAll();
		return estudiante;
	}
	
	//Sentencia get, para obtener por ID
	@GetMapping("/estudiantes/{id}")
	public Estudiante getEstudiante(@PathVariable int id) {
		Estudiante estudiante = repo.findById(id).get();
		return estudiante;
	}
	
	//Sentencia post, para la creacion del estudiante nuevo
	@PostMapping("/estudiantes/agregar")
	@ResponseStatus(code = HttpStatus.CREATED)
	public void createEstudiante(@RequestBody Estudiante estudiante) {
		repo.save(estudiante);
	}
	
	//sentencia para Editar
	@PutMapping("/estudiantes/editar/{id}")
	public Estudiante updateEstudiante( @PathVariable int id) {
		Estudiante estudiante = repo.findById(id).get();
		estudiante.setNombre("Juan");
		repo.save(estudiante);
		return estudiante;
	}
	// sentencia para eliminar
	@DeleteMapping("/estudiantes/eliminar/{id}")
	public void removeEstudiante(@PathVariable int id) {
		Estudiante estudiante =repo.findById(id).get();
		repo.delete(estudiante);
	}
}
