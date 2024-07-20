package com.esprit.secondapp.repository;

import com.esprit.secondapp.entities.Client;
import org.springframework.data.mongodb.repository.MongoRepository;


public interface ClientRepository extends MongoRepository<Client, String>{

}
