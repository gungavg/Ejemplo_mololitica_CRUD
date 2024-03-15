package com.course.escuela.estudiantes.entidad;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table (name="estudiante")
public class Estudiante {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(name="nombre_estudiante")
	private String nombre;
	@Column (name = "grado_escolar")
	private int grado;
	@Column
	private String grupo;
	
	public Estudiante() {
		
	}
	public Estudiante(String nombre, int grado, String grupo) {
		super();
		this.nombre = nombre;
		this.grado = grado;
		this.grupo = grupo;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public int getGrado() {
		return grado;
	}
	public void setGrado(int grado) {
		this.grado = grado;
	}
	public String getGrupo() {
		return grupo;
	}
	public void setGrupo(String grupo) {
		this.grupo = grupo;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	@Override
	public String toString() {
		return "Estudiante [id=" + id + ", nombre=" + nombre + ", grado=" + grado + ", grupo=" + grupo + "]";
	}
	
	

}
