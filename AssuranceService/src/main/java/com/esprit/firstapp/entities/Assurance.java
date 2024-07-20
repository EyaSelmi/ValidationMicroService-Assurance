package com.esprit.firstapp.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@Builder
public class Assurance {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String name;
	private int matricule;
	private String id_client;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getMatricule() {
		return matricule;
	}
	public void setMatricule(int size) {
		this.matricule = matricule;
	}
	public String getId_cliente() {
		return id_client;
	}
	public void setId_client(String id_client) {
		this.id_client = id_client;
	}
	public Assurance(Long id, String name, int matricule, String id_client) {
		this.id = id;
		this.name = name;
		this.matricule = matricule;
		this.id_client = id_client;
	}
	public Assurance() {
	}
	
	

}
