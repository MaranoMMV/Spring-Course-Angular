package br.com.maranoart.rest;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ServicoPrestadoDTO {

	
	
	private String descricao;
	private String preco;
	private String data;
	private Integer idCliente;
	
}
