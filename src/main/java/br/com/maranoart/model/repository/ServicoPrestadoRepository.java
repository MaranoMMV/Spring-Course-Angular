package br.com.maranoart.model.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import br.com.maranoart.model.entity.ServicoPrestado;

public interface ServicoPrestadoRepository extends JpaRepository<ServicoPrestado, Integer> {

	@Query(" select s from ServicoPrestado s join s.cliente c " +
				" where upper( c.nome ) LIKE upper( :nome ) AND MONTH(s.data) = :mes")
	List<ServicoPrestado> findByNomeClienteAndMes(@Param("nome") String nome,@Param("mes") Integer mes);

    
    
}
