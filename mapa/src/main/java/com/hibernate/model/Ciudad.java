package com.hibernate.model;

import jakarta.persistence.*;

@Entity
@Table(name="ciudad")
public class Ciudad {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="codigo")
	private int codigo;
	
	@Column(name="nombre")
	private String nombre;
	
	@Column(name="numeroHabitantes")
	private int numeroHabitantes;
	
	public Ciudad() {
		super();
	}
	
	public Ciudad(String nombre, int numeroHabitantes) {
		super();
		this.nombre = nombre;
		this.numeroHabitantes = numeroHabitantes;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getNumeroHabitantes() {
		return numeroHabitantes;
	}

	public void setNumeroHabitantes(int numeroHabitantes) {
		this.numeroHabitantes = numeroHabitantes;
	}	
}