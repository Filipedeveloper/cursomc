package com.example.cursomc.service;

import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.cursomc.domin.Categoria;
import com.example.cursomc.domin.Cliente;
import com.example.cursomc.exceptions.ObjectNotFoundException;
import com.example.cursomc.repositories.CategoriaRepository;
import com.example.cursomc.repositories.ClienteRepository;

@Service
public class ClienteSerivice {
	
	@Autowired
	private ClienteRepository rep;
	
	public Cliente buscar(Integer id) {
		Optional<Cliente> obj = rep.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! id: " + id + ", Tipo: " + Cliente.class.getName(), null));
	}
}
