package com.esprit.secondapp.controllers;

import java.util.List;
import java.util.Map;

import com.esprit.secondapp.entities.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.esprit.secondapp.services.IClientService;

@RestController
@RequestMapping("/client")
public class ClientController {

	@Autowired
	private IClientService iClientService;

	@GetMapping("/getAll")
	public ResponseEntity<List<Client>> getAllClients() {
		List<Client> clients = iClientService.getAllClient();
		return new ResponseEntity<>(clients, HttpStatus.OK);
	}

	@PostMapping("/save")
	public ResponseEntity<Client> save(@RequestBody Client client) {
		Client savedClient = iClientService.addClient(client);
		return new ResponseEntity<>(savedClient, HttpStatus.CREATED);
	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Void> deleteClient(@PathVariable("id") String id) {
		iClientService.deleteClientById(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}

	@GetMapping("/getbyid/{id}")
	public ResponseEntity<Client> getClientById(@PathVariable("id") String id) {
		Client client = iClientService.getClientById(id);
		if (client == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(client, HttpStatus.OK);
	}

	@PutMapping("/update/{id}")
	public Client updateClient(@PathVariable String id, @RequestBody Map<String, Object> updates) {
		return iClientService.updateClient(id, updates);
	}
}
