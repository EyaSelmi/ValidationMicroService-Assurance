package com.esprit.secondapp.services;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import com.esprit.secondapp.entities.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.esprit.secondapp.repository.ClientRepository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ClientService implements IClientService {

	private static final Logger logger = LoggerFactory.getLogger(ClientService.class);

	@Autowired
	private ClientRepository clientRepository;

	@Override
	public Client addClient(Client client) {
		clientRepository.save(client);
		return client;
	}

	@Override
	@Transactional
	public Client updateClient(String id, Map<String, Object> updates) {
		Optional<Client> optionalClient = clientRepository.findById(id);
		if (!optionalClient.isPresent()) {
			logger.error("Client with id {} not found", id);
			return null;
		}

		Client existingClient = optionalClient.get();

		for (Map.Entry<String, Object> entry : updates.entrySet()) {
			String key = entry.getKey();
			Object value = entry.getValue();
			try {
				Field field = existingClient.getClass().getDeclaredField(key);
				field.setAccessible(true);
				field.set(existingClient, value);
			} catch (NoSuchFieldException | IllegalAccessException e) {
				logger.error("Error updating field {} in Client: {}", key, e.getMessage());
			}
		}
		return clientRepository.save(existingClient);
	}

	@Override
	public List<Client> getAllClient() {
		return clientRepository.findAll();
	}

	@Override
	public Client getClientById(String id) {
		return clientRepository.findById(id).orElse(null);
	}

	@Override
	public void deleteClientById(String id) {
		clientRepository.deleteById(id);
	}
}
