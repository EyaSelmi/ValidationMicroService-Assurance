package com.esprit.firstapp.services;

import com.esprit.firstapp.entities.ClientDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@FeignClient(name = "client", url = "http://localhost:8090")
public interface Client {

	@GetMapping("/client/getbyid/{id}")
	ClientDTO getById(@PathVariable("id") String id);



}
