package com.example.cursomc.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.cursomc.domin.Categoria;
import com.example.cursomc.repositories.CategoriaRepository;

@Service
public class CategoriaSerivice {
	
	@Autowired
	private CategoriaRepository rep;
	
	public Optional<Categoria> buscar(Integer id) {
		Optional<Categoria> obj = rep.findById(id);
		return obj;
	}
}
