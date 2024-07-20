package com.esprit.firstapp.mappers;

import com.esprit.firstapp.entities.Assurance;
import com.esprit.firstapp.entities.AssuranceWithClientDTO;
import com.esprit.firstapp.entities.ClientDTO;

public class AssuranceMappers {

	public static AssuranceWithClientDTO mapToDto(Assurance assurance) {

		AssuranceWithClientDTO assuranceDTO = AssuranceWithClientDTO.builder().id(assurance.getId()).name(assurance.getName())
				.matricule(assurance.getMatricule()).id_assurance(assurance.getId_cliente()).build();
		return assuranceDTO;
	}

	public static AssuranceWithClientDTO mapToDto(Assurance assurance, ClientDTO clientDTO) {

		AssuranceWithClientDTO assuranceDTO = AssuranceWithClientDTO.builder().id(assurance.getId()).name(assurance.getName())
				.matricule(assurance.getMatricule()).id_assurance(assurance.getId_cliente()).clientDTO(clientDTO).build();

		return assuranceDTO;
	}

	public static Assurance mapToEntity(AssuranceWithClientDTO assuranceDTO) {
		Assurance assurance = Assurance.builder().id(assuranceDTO.getId()).name(assuranceDTO.getName()).matricule(assuranceDTO.getMatricule())
				.id_client(assuranceDTO.getClientDTO().getId()).build();
		return assurance;

	}

}
