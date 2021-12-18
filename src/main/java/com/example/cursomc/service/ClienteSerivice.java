package com.example.cursomc.service;

import java.util.List;
import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.example.cursomc.domin.Cliente;
import com.example.cursomc.domin.Cliente;
import com.example.cursomc.dto.ClienteDTO;
import com.example.cursomc.exceptions.DataIntegrityException;
import com.example.cursomc.exceptions.ObjectNotFoundException;
import com.example.cursomc.repositories.ClienteRepository;
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
	
	public List<Cliente> findAll() {
		return rep.findAll();
	}
	
	public Page<Cliente> findPage(Integer page, Integer linesPage, String orderBy, String direction){
		PageRequest pageRequest = PageRequest.of(page, linesPage, Direction.valueOf(direction) ,orderBy);
		return rep.findAll(pageRequest);
	}
	
	
	
	public Cliente insert(Cliente obj) {
		obj.setId(null);
		return rep.save(obj);
	}
	
	public Cliente update(Cliente obj) {
		//buscar(obj.getId());
		Cliente newObj = buscar(obj.getId());
		updateData(newObj, obj);
		return rep.save(newObj);
	}
	
	public void delete(Integer id) {
		//buscar(obj.getId());
		try {
			rep.deleteById(id);	
		}
		catch(DataIntegrityViolationException e) {
			throw new DataIntegrityException("Não é possível excluir porque há entidades relacionadas");
		}
		
		
	}
	
	public Cliente fromDTO(ClienteDTO objDTO) {
		return new Cliente(objDTO.getId(), objDTO.getNome(), objDTO.getEmail(), null, null);
	}
	
	private void updateData(Cliente newObj, Cliente obj) {
		newObj.setNome(obj.getNome());
		newObj.setEmail(obj.getEmail());
	}
}
