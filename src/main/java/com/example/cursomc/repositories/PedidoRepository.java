package com.example.cursomc.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.cursomc.domin.Pedido;

@Repository
public interface PedidoRepository extends JpaRepository<Pedido, Integer>  {

}
