package com.esprit.firstapp.entities;

import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
public class AssuranceWithClientDTO {
	private Long id;
	private String name;
	private int matricule;
	private String id_assurance;
	private ClientDTO clientDTO;
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
	public ClientDTO getClientDTO() {
		return clientDTO;
	}
	public void setClientDTO(ClientDTO clientDTO) {
		this.clientDTO = clientDTO;
	}
	public AssuranceWithClientDTO() {
		super();
	}

	
	

}
