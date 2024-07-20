package com.esprit.firstapp.services;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.esprit.firstapp.entities.Assurance;
import com.esprit.firstapp.entities.AssuranceWithClientDTO;
import com.esprit.firstapp.entities.ClientDTO;
import com.esprit.firstapp.mappers.AssuranceMappers;
import com.esprit.firstapp.repository.AssuranceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;



@Service
public class AssuranceService implements IAssuranceService {
	@Autowired
	private Client client;

	@Autowired
	private AssuranceRepository assuranceRepository;

	@Override
	public AssuranceWithClientDTO addAssurance(AssuranceWithClientDTO assuranceDto) {
		assuranceRepository.save(AssuranceMappers.mapToEntity(assuranceDto));
		return assuranceDto;

	}

	@Override
	public List<AssuranceWithClientDTO> getAllAssurance() {

		return assuranceRepository.findAll().stream().map(assurance -> AssuranceMappers.mapToDto(assurance))
				.collect(Collectors.toList());
	}

	@Override
	public AssuranceWithClientDTO getAssuranceById(Long id) {
		Assurance assurance = assuranceRepository.findById(id).get();

		//OpenFeign
		ClientDTO clientdto = client.getById(assurance.getId_cliente());

		//RestTemplate
		//ClientDto clientdto =getById(assurance.getId_cliente());
		return AssuranceMappers.mapToDto(assurance, clientdto);
	}


	@Override
	public Assurance updateAssurance(Long id, Map<String, Object> assurance) {
		Assurance existingAssurance = assuranceRepository.findById(id).get();

		if (existingAssurance == null) {

			return null;
		}

		for (Map.Entry<String, Object> entry : assurance.entrySet()) {
			String key = entry.getKey();
			Object value = entry.getValue();
			try {
				Field field = existingAssurance.getClass().getDeclaredField(key);
				field.setAccessible(true);
				field.set(existingAssurance, value);
			} catch (NoSuchFieldException | IllegalAccessException e) {
				e.printStackTrace();
			}
		}
		return assuranceRepository.save(existingAssurance);
	}

	@Override
	public void deleteAssuranceById(Long id) {
		assuranceRepository.deleteById(id);

	}

	public ClientDTO getById(String id) {
		String url = "http://localhost:8090/api/getbyid/" + id;
		RestTemplate restTemplate = new RestTemplate();
		return restTemplate.getForObject(url, ClientDTO.class);
	}

}
