package com.example.cursomc.resources;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.example.cursomc.domin.Categoria;
import com.example.cursomc.service.CategoriaSerivice;

@RestController
@RequestMapping(value="/categorias")
public class CategoriaResource {

	@Autowired 
	private CategoriaSerivice service;
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public ResponseEntity<Categoria> find(@PathVariable Integer id) {
		
		Categoria obj = service.buscar(id);
		return ResponseEntity.ok().body(obj);	
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public ResponseEntity<Void> insert(@RequestBody Categoria obj){
		obj = service.insert(obj);
		//ADICIONA O ID DA INCERÇAO NA URI
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("{/id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
}
