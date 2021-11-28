package com.example.cursomc.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.cursomc.domin.Estado;

@Repository
public interface EstadoRepository extends JpaRepository<Estado, Integer>{

}
