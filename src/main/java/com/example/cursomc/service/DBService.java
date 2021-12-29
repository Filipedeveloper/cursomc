package com.example.cursomc.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.cursomc.domin.Categoria;
import com.example.cursomc.domin.Cidade;
import com.example.cursomc.domin.Cliente;
import com.example.cursomc.domin.Endereco;
import com.example.cursomc.domin.Estado;
import com.example.cursomc.domin.ItemPedido;
import com.example.cursomc.domin.Pagamento;
import com.example.cursomc.domin.PagamentoBoleto;
import com.example.cursomc.domin.PagamentoCartao;
import com.example.cursomc.domin.Pedido;
import com.example.cursomc.domin.Produto;
import com.example.cursomc.domin.enums.Perfil;
import com.example.cursomc.domin.enums.TipoCliente;
import com.example.cursomc.domin.enums.TipoEstadoPagamento;
import com.example.cursomc.repositories.CategoriaRepository;
import com.example.cursomc.repositories.CidadeRepository;
import com.example.cursomc.repositories.ClienteRepository;
import com.example.cursomc.repositories.EnderecoRepository;
import com.example.cursomc.repositories.EstadoRepository;
import com.example.cursomc.repositories.ItemPedidoRepository;
import com.example.cursomc.repositories.PagamentoRepository;
import com.example.cursomc.repositories.PedidoRepository;
import com.example.cursomc.repositories.ProdutoRepository;

@Service
public class DBService {
	
	@Autowired
	private BCryptPasswordEncoder pe;	

	@Autowired
	private CategoriaRepository categoriaRepository;
	
	@Autowired
	private ProdutoRepository produtoRepository;
	
	@Autowired
	private CidadeRepository cidadeRepository;
	
	@Autowired
	private EstadoRepository estadoRepository;
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	@Autowired
	private EnderecoRepository enderecoRepository;
	
	@Autowired
	private PedidoRepository pedidoRepository;
	
	@Autowired
	private PagamentoRepository pagamentoRepository;
	
	@Autowired
	private ItemPedidoRepository itemPedidoRepository;

	public void instantiateTestDatabase() throws ParseException {
		
		// TODO Auto-generated method stub
				//Teste
				Categoria cat1 = new Categoria(null, "INFORMÁTICA");
				Categoria cat2 = new Categoria(null, "ESCRITÓRIO");
				Categoria cat3 = new Categoria(null, "CAMA MESA E BANHO");
				Categoria cat4 = new Categoria(null, "ELETRÔNICOS");
				Categoria cat5 = new Categoria(null, "JARDINAGEM");
				Categoria cat6 = new Categoria(null, "DECORAÇÃO");
				Categoria cat7 = new Categoria(null, "PERFUMARIA");
				
				Produto p1 = new Produto(null, "COMPUTADOR", 2000.00);
				Produto p2 = new Produto(null, "IMPRESSORA", 800.00);
				Produto p3 = new Produto(null, "MOUSE", 80.00);
				Produto p4 = new Produto(null, "MESA DE ESCRITÓRIO", 300.00);
				Produto p5 = new Produto(null, "TOALHA", 50.00);
				Produto p6 = new Produto(null, "COLCHA", 200.00);
				Produto p7 = new Produto(null, "TV true color", 1200.00);
				Produto p8 = new Produto(null, "ROÇADEIRA", 100.00);
				Produto p9 = new Produto(null, "ABAJOUR", 100.00);
				Produto p10 = new Produto(null, "PENDENTE", 180.00);
				Produto p11 = new Produto(null, "SHAMPOO", 90.00);
				
				Estado est1 = new Estado(null, "MINAS GERAIS");
				Estado est2 = new Estado(null, "SÃO PAULO");
				
				Cidade c1 = new Cidade(null, "UBERLÂNDIA", est1);
				Cidade c2 = new Cidade(null, "SÃO PAULO", est2);
				Cidade c3 = new Cidade(null, "CAMPINAS", est2);
				
				Cliente cli1 = new Cliente(null, "MARIA SILVANA", "MARIA@GMAIL.COM", "32232322278", TipoCliente.PESSOAFISICA, pe.encode("123"));
				Cliente cli2 = new Cliente(null, "ANA COSTA", "ANA@GMAIL.COM", "31628382740", TipoCliente.PESSOAFISICA, pe.encode("123"));
				cli2.addPerfil(Perfil.ADMIN);
				
				cli1.getTelefones().addAll(Arrays.asList("33337575", "61988885555"));
				cli2.getTelefones().addAll(Arrays.asList("33337575", "61988885555"));
				
				Endereco e1 = new Endereco(null, "RUA FLORES ", "300", "APTO 303", "JARDIM", "38220834", cli1, c1);
				Endereco e2 = new Endereco(null, "AVENIDA MATOS ", "105", "SALA 800", "CENTRO", "38251458", cli1, c2);
				Endereco e3 = new Endereco(null, "AVENIDA GLORIANO ", "206", null, "CENTRO", "38251458", cli1, c2);
				
				SimpleDateFormat sds = new SimpleDateFormat("dd/MM/yyyy HH:mm");
				Pedido ped1 = new Pedido(null, sds.parse("30/09/2017 10:32"),  cli1, e1);
				Pedido ped2 = new Pedido(null, sds.parse("10/10/2017 10:32"),  cli2, e2);
				
				Pagamento pgto1 = new PagamentoCartao(null, TipoEstadoPagamento.QUITADO, ped1, 6);
				ped1.setPagamento(pgto1);
				
				Pagamento pgto2 = new PagamentoBoleto(null, TipoEstadoPagamento.PENDETE, ped2, sds.parse("20/10/2017 00:00"), null);
				ped2.setPagamento(pgto2);
				
				ItemPedido ip1 = new ItemPedido(ped1, p1, 0.00, 1, 2000.00);
				ItemPedido ip2 = new ItemPedido(ped1, p3, 0.00, 2, 80.00);
				ItemPedido ip3 = new ItemPedido(ped2, p2, 100.00, 1, 800.00);
				
				
				
				cat1.getProdutos().addAll(Arrays.asList(p1,p2,p3));
				cat2.getProdutos().addAll(Arrays.asList(p2, p4));
				cat3.getProdutos().addAll(Arrays.asList(p5, p6));
				cat4.getProdutos().addAll(Arrays.asList(p1, p2, p3, p7));
				cat5.getProdutos().addAll(Arrays.asList(p8));
				cat6.getProdutos().addAll(Arrays.asList(p9, p10));
				cat7.getProdutos().addAll(Arrays.asList(p11));
				
				p1.getCategorias().addAll(Arrays.asList(cat1, cat4));
				p2.getCategorias().addAll(Arrays.asList(cat1, cat2, cat4));
				p3.getCategorias().addAll(Arrays.asList(cat2));
				p4.getCategorias().addAll(Arrays.asList(cat1, cat4));
				p5.getCategorias().addAll(Arrays.asList(cat3));
				p6.getCategorias().addAll(Arrays.asList(cat3));
				p7.getCategorias().addAll(Arrays.asList(cat4));
				p8.getCategorias().addAll(Arrays.asList(cat5));
				p9.getCategorias().addAll(Arrays.asList(cat6));
				p10.getCategorias().addAll(Arrays.asList(cat6));
				p11.getCategorias().addAll(Arrays.asList(cat7));
				
				est1.getCidades().addAll(Arrays.asList(c1));
				est2.getCidades().addAll(Arrays.asList(c2,c3));
				
				cli1.getEnderecos().addAll(Arrays.asList(e1,e2));
				
				cli1.getPedidos().addAll(Arrays.asList(ped1, ped2));
				
				ped1.getItens().addAll(Arrays.asList(ip1,ip2));
				ped2.getItens().addAll(Arrays.asList(ip3));
				
				p1.getItens().addAll(Arrays.asList(ip1));
				p2.getItens().addAll(Arrays.asList(ip3));
				p3.getItens().addAll(Arrays.asList(ip2));
				
				
				
				
				categoriaRepository.saveAll((Arrays.asList(cat1,cat2,cat3,cat4,cat5,cat6,cat7)));
				produtoRepository.saveAll((Arrays.asList(p1,p2,p3,p4,p5,p6,p7,p8,p9,p10,p11)));
				

				estadoRepository.save(est1);
				estadoRepository.save(est2);
				
				cidadeRepository.save(c1);
				cidadeRepository.save(c2);
				cidadeRepository.save(c3);
				
				clienteRepository.save(cli1);
				clienteRepository.save(cli2);
				
				enderecoRepository.save(e1);
				enderecoRepository.save(e2);
				enderecoRepository.save(e3);
				
				pedidoRepository.save(ped1);
				pedidoRepository.save(ped2);
				
				pagamentoRepository.save(pgto1);
				pagamentoRepository.save(pgto2);
				
				itemPedidoRepository.saveAll(Arrays.asList(ip1,ip2,ip3));

		
		
	}
}
