package com.example.cursomc;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.cursomc.domin.Categoria;
import com.example.cursomc.domin.Cidade;
import com.example.cursomc.domin.Cliente;
import com.example.cursomc.domin.Endereco;
import com.example.cursomc.domin.Estado;
import com.example.cursomc.domin.Produto;
import com.example.cursomc.domin.enums.TipoCliente;
import com.example.cursomc.repositories.CategoriaRepository;
import com.example.cursomc.repositories.CidadeRepository;
import com.example.cursomc.repositories.ClienteRepository;
import com.example.cursomc.repositories.EnderecoRepository;
import com.example.cursomc.repositories.EstadoRepository;
import com.example.cursomc.repositories.ProdutoRepository;

@SpringBootApplication
public class CursomcApplication implements CommandLineRunner {

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
	
	public static void main(String[] args) {
		SpringApplication.run(CursomcApplication.class, args);
	}
	
	
	
	

	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		Categoria cat1 = new Categoria(null, "INFORMÁTICA");
		Categoria cat2 = new Categoria(null, "ESCRITÓRIO");
		
		Produto p1 = new Produto(null, "COMPUTADOR", 2000.00);
		Produto p2 = new Produto(null, "IMPRESSORA", 800.00);
		Produto p3 = new Produto(null, "MOUSE", 80.00);
		
		Estado est1 = new Estado(null, "MINAS GERAIS");
		Estado est2 = new Estado(null, "SÃO PAULO");
		
		Cidade c1 = new Cidade(null, "UBERLÂNDIA", est1);
		Cidade c2 = new Cidade(null, "SÃO PAULO", est2);
		Cidade c3 = new Cidade(null, "CAMPINAS", est2);
		
		Cliente cli1 = new Cliente(null, "MARIA SILVANA", "MARIA@GMAIL.COM", "32232322278", TipoCliente.PESSOAFISICA);
		cli1.getTelefones().addAll(Arrays.asList("33337575", "61988885555"));
		
		Endereco e1 = new Endereco(null, "RUA FLORES ", "300", "APTO 303", "JARDIM", "38220834", cli1, c1);
		Endereco e2 = new Endereco(null, "AVENIDA MATOS ", "105", "SALA 800", "CENTRO", "38251458", cli1, c2);
		
		
		
		cat1.getProdutos().addAll(Arrays.asList(p1,p2,p3));
		cat2.getProdutos().addAll(Arrays.asList(p2));
		
		p1.getCategorias().addAll(Arrays.asList(cat1));
		p2.getCategorias().addAll(Arrays.asList(cat1, cat2));
		p3.getCategorias().addAll(Arrays.asList(cat1));
		
		est1.getCidades().addAll(Arrays.asList(c1));
		est2.getCidades().addAll(Arrays.asList(c2,c3));
		
		cli1.getEnderecos().addAll(Arrays.asList(e1,e2));
		
		
		
		categoriaRepository.save(cat1);
		categoriaRepository.save(cat2);

		produtoRepository.save(p1);
		produtoRepository.save(p2);
		produtoRepository.save(p3);
		
		estadoRepository.save(est1);
		estadoRepository.save(est2);
		
		cidadeRepository.save(c1);
		cidadeRepository.save(c2);
		cidadeRepository.save(c3);
		
		clienteRepository.save(cli1);
		
		enderecoRepository.save(e1);
		enderecoRepository.save(e2);
		
		
	}

}
