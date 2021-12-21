package com.example.cursomc.service;

import java.util.Date;
import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.cursomc.domin.ItemPedido;
import com.example.cursomc.domin.PagamentoBoleto;
import com.example.cursomc.domin.Pedido;
import com.example.cursomc.domin.enums.TipoEstadoPagamento;
import com.example.cursomc.exceptions.ObjectNotFoundException;
import com.example.cursomc.repositories.ItemPedidoRepository;
import com.example.cursomc.repositories.PagamentoRepository;
import com.example.cursomc.repositories.PedidoRepository;
import com.example.cursomc.repositories.ProdutoRepository;

@Service
public class PedidoSerivice {
	
	@Autowired
	private PedidoRepository rep;
	
	@Autowired
	private PagamentoRepository pagamentoRepository;
	
	@Autowired
	private ProdutoRepository produtoRepository;
	
	@Autowired
	private ItemPedidoRepository itemPedidoRepository;
	
	public Pedido buscar(Integer id) {
		Optional<Pedido> obj = rep.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! id: " + id + ", Tipo: " + Pedido.class.getName(), null));
	}
	
	public Pedido insert(Pedido obj) {
		obj.setId(null);
		obj.setInstante(new Date());
		obj.getPagamento().setEstado(TipoEstadoPagamento.PENDETE);
		obj.getPagamento().setPedido(obj);
		if(obj.getPagamento() instanceof PagamentoBoleto ) {
			PagamentoBoleto pgto = (PagamentoBoleto) obj.getPagamento();
			BoletoService.preeencherPagamentoComBoleto(pgto, obj.getInstante());
		}
		obj = rep.save(obj);
		pagamentoRepository.save(obj.getPagamento());
		
		for(ItemPedido item : obj.getItens()) {
			item.setDesconto(0.0);
			item.setPreco(produtoRepository.findById(item.getProduto().getId()).get().getPreco());
			item.setPedido(obj);
		}
		
		itemPedidoRepository.saveAll(obj.getItens());
		return obj;
		
	}
}
