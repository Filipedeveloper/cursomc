package com.example.cursomc.service;

import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.cursomc.domin.Pedido;
import com.example.cursomc.exceptions.ObjectNotFoundException;
import com.example.cursomc.repositories.PedidoRepository;

@Service
public class PedidoSerivice {
	
	@Autowired
	private PedidoRepository rep;
	
	public Pedido buscar(Integer id) {
		Optional<Pedido> obj = rep.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! id: " + id + ", Tipo: " + Pedido.class.getName(), null));
	}
}
