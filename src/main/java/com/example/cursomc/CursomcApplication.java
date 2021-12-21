package com.example.cursomc;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
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
import com.example.cursomc.domin.ItemPedido;
import com.example.cursomc.domin.Pagamento;
import com.example.cursomc.domin.PagamentoBoleto;
import com.example.cursomc.domin.PagamentoCartao;
import com.example.cursomc.domin.Pedido;
import com.example.cursomc.domin.Produto;
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

@SpringBootApplication
public class CursomcApplication implements CommandLineRunner {

	
	public static void main(String[] args) {
		SpringApplication.run(CursomcApplication.class, args);
	}
	
	
	
	

	public void run(String... args) throws Exception {
				
		
		
		
	}

}
