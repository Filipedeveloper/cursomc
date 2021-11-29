package com.example.cursomc.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.cursomc.domin.Pagamento;

@Repository
public interface PagamentoRepository extends JpaRepository<Pagamento, Integer>  {

}
