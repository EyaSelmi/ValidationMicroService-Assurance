package com.esprit.firstapp.entities;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ClientDTO {
	
	
	private String id;

	private String name;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public ClientDTO(String id, String name) {
		this.id = id;
		this.name = name;
	}
	public ClientDTO() {

	}

}
