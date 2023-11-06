package br.com.maranoart.rest;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import br.com.maranoart.model.entity.Cliente;
import br.com.maranoart.model.entity.ServicoPrestado;
import br.com.maranoart.model.repository.ClienteRepository;
import br.com.maranoart.model.repository.ServicoPrestadoRepository;
import br.com.maranoart.util.BigDecimalConverter;

@RestController
@RequestMapping("/api/servicos-prestados")
public class ServicoPrestadoController {
	
	private final ClienteRepository clienteRepository;
	private final ServicoPrestadoRepository repository;
	private final BigDecimalConverter bigDecimalConverter;
	
	public ServicoPrestadoController(ClienteRepository clienteRepository, ServicoPrestadoRepository repository, BigDecimalConverter bigDecimalConverter) {
		this.clienteRepository = clienteRepository;
		this.repository = repository;
		this.bigDecimalConverter = bigDecimalConverter;
	}

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public ServicoPrestado salvar(@RequestBody ServicoPrestadoDTO dto) {
		LocalDate data = LocalDate.parse(dto.getData(), DateTimeFormatter.ofPattern("dd/MM/yyyy"));
		Integer idCliente = dto.getIdCliente();
		
		Cliente cliente = clienteRepository.findById(idCliente)
					.orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "O Cliente não existe!"));
		
		
		
		ServicoPrestado servicoPrestado = new ServicoPrestado();
		servicoPrestado.setDescricao(dto.getDescricao());
		servicoPrestado.setData(data);
		servicoPrestado.setCliente(cliente);
		servicoPrestado.setValor(bigDecimalConverter.converter(dto.getPreco()));
		return repository.save(servicoPrestado);
	}
	
	@GetMapping
	public List<ServicoPrestado> pesquisar(
		@RequestParam(value = "nome", required = false, defaultValue = "") String nome,
		@RequestParam(value = "mes", required = false ) Integer mes){
		
			return repository.findByNomeClienteAndMes("%" + nome + "%",  mes);
			
		
		}
}

