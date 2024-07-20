package com.esprit.firstapp.services;

import java.util.List;
import java.util.Map;

import com.esprit.firstapp.entities.Assurance;
import com.esprit.firstapp.entities.AssuranceWithClientDTO;

public interface IAssuranceService {

	AssuranceWithClientDTO addAssurance(AssuranceWithClientDTO assurance);

	Assurance updateAssurance(Long id, Map<String, Object> assurance);

	List<AssuranceWithClientDTO> getAllAssurance();

	AssuranceWithClientDTO getAssuranceById(Long id);

	void deleteAssuranceById(Long id);

}
