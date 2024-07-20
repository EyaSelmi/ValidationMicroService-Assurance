package com.esprit.firstapp.controllers;

import java.util.List;
import java.util.Map;

import com.esprit.firstapp.entities.Assurance;
import com.esprit.firstapp.entities.AssuranceWithClientDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.esprit.firstapp.services.IAssuranceService;

@RestController
@RequestMapping("/api/Assurance")

public class AssuranceController {

	@Autowired
	private IAssuranceService assuranceService;

	@GetMapping("/assurances")
	public List<AssuranceWithClientDTO> getAllAssurances() {
		return assuranceService.getAllAssurance();

	}

	@PostMapping("/save")
	public AssuranceWithClientDTO save(@RequestBody AssuranceWithClientDTO assurance) {
		return assuranceService.addAssurance(assurance);

	}

	@DeleteMapping("/delete/{id}")
	public void supprimer(@PathVariable("id") Long id) {
		assuranceService.deleteAssuranceById(id);

	}

	@GetMapping("/getbyid/{id}")
	public AssuranceWithClientDTO GetById(@PathVariable("id") Long id) {
		return assuranceService.getAssuranceById(id);
	}

	@PatchMapping("/update/{id}")
	public Assurance patchUpdateStock(@PathVariable Long id, @RequestBody Map<String, Object> updates) {
		return assuranceService.updateAssurance(id, updates);

	}

}
