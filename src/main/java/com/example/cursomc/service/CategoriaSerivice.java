package com.example.cursomc.service;

import java.util.List;
import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.example.cursomc.domin.Categoria;
import com.example.cursomc.exceptions.DataIntegrityException;
import com.example.cursomc.exceptions.ObjectNotFoundException;
import com.example.cursomc.repositories.CategoriaRepository;

@Service
public class CategoriaSerivice {
	
	@Autowired
	private CategoriaRepository rep;
	
	public Categoria buscar(Integer id) {
		Optional<Categoria> obj = rep.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! id: " + id + ", Tipo: " + Categoria.class.getName(), null));
	}
	
	public List<Categoria> findAll() {
		return rep.findAll();
	}
	
	
	
	public Categoria insert(Categoria obj) {
		obj.setId(null);
		return rep.save(obj);
	}
	
	public Categoria update(Categoria obj) {
		//buscar(obj.getId());
		return rep.save(obj);
	}
	
	public void delete(Integer id) {
		//buscar(obj.getId());
		try {
			rep.deleteById(id);	
		}
		catch(DataIntegrityViolationException e) {
			throw new DataIntegrityException("Não é possível excluir uma categoria que possuí produtos");
		}
		
		
	}
}
