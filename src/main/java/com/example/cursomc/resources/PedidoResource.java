package com.example.cursomc.resources;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.cursomc.domin.Pedido;
import com.example.cursomc.service.PedidoSerivice;

@RestController
@RequestMapping(value="/pedidos")
public class PedidoResource {

	@Autowired 
	private PedidoSerivice service;
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public ResponseEntity<Pedido> find(@PathVariable Integer id) {
		
		Pedido obj = service.buscar(id);
		return ResponseEntity.ok().body(obj);
			
		
	}
}
