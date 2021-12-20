package com.example.cursomc.resources;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.cursomc.domin.Categoria;
import com.example.cursomc.domin.Produto;
import com.example.cursomc.dto.CategoriaDTO;
import com.example.cursomc.dto.ProdutoDTO;
import com.example.cursomc.resources.utils.URL;
import com.example.cursomc.service.ProdutoService;

@RestController
@RequestMapping(value="/produtos")
public class ProdutooResource {

	@Autowired 
	private ProdutoService service;
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public ResponseEntity<Produto> find(@PathVariable Integer id) {
		
		Produto obj = service.buscar(id);
		return ResponseEntity.ok().body(obj);
			
		
	}
	
	@RequestMapping( method=RequestMethod.GET)
	public ResponseEntity<Page<ProdutoDTO>> findPage(
		@RequestParam(value="nome", defaultValue = "") String nome,
		@RequestParam(value="categorias", defaultValue = "") String categoria,
		@RequestParam(value="page", defaultValue = "0") Integer page, 
		@RequestParam(value="linespage", defaultValue = "24") Integer linesPage, 
		@RequestParam(value="order", defaultValue = "nome") String orderBy, 
		@RequestParam(value="direction", defaultValue = "ASC") String direction) {
		
		String nomeDecoder = URL.decodeParam(nome);
		List<Integer> ids = URL.decodeIntList(categoria);
		Page<Produto> lista = service.search(nomeDecoder, ids, page, linesPage, orderBy, direction);
		Page<ProdutoDTO> listaDTO = lista.map(obj -> new ProdutoDTO(obj));
		return ResponseEntity.ok().body(listaDTO);	
	}
}
