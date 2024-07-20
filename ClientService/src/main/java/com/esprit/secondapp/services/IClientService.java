package com.esprit.secondapp.services;

import java.util.List;
import java.util.Map;

import com.esprit.secondapp.entities.Client;

public interface IClientService {

	Client addClient(Client client);

	Client updateClient(String id, Map<String, Object> updates);

	List<Client> getAllClient();

	Client getClientById(String id);

	void deleteClientById(String id);

}
