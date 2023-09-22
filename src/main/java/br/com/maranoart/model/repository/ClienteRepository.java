package br.com.maranoart.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.maranoart.model.entity.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Integer>{



}
