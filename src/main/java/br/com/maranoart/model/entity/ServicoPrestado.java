package br.com.maranoart.model.entity;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ServicoPrestado {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    //@NotEmpty(message = "{campo.descricao.obrigatorio}")
    @Column(nullable = false, length = 150)
    private String descricao;

    //@NotEmpty(message = "{campo.cliente.obrigatorio}")
    @ManyToOne
    @JoinColumn(name = "id_cliente")
    private Cliente cliente;

    //@NotEmpty(message = "{campo.preco.obrigatorio}")
    @Column
    private BigDecimal valor;
    
    //@NotEmpty(message = "{campo.data.obrigatorio}")
    @Column
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate data;

}
