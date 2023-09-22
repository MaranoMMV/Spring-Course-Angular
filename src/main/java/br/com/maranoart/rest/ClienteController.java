package br.com.maranoart.rest;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import br.com.maranoart.model.entity.Cliente;
import br.com.maranoart.model.repository.ClienteRepository;

@RestController
@RequestMapping("/api/clientes")
public class ClienteController {
    
    private final ClienteRepository clienteRepository;

    @Autowired
    public ClienteController( ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public Cliente salvar(@RequestBody @Valid Cliente cliente){
        return clienteRepository.save(cliente);
    }

    @GetMapping("{id}")
    public Cliente getClienteById( @PathVariable Integer id){
        return clienteRepository.findById(id)
                                .orElseThrow(() -> 
                                    new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteClienteById( @PathVariable Integer id){
        clienteRepository.findById(id)
                        .map( cliente -> {
                            clienteRepository.delete(cliente);
                            return Void.TYPE;
                        })
                        .orElseThrow(() -> 
                            new ResponseStatusException(HttpStatus.NOT_FOUND, "Cliente não encontrado"));
    }

    // @GetMapping()
    // public List<Cliente> getClienteAll(Cliente cliente){
    //     return clienteRepository.findAll(cliente);
    // }

    @PutMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void atualizar(@PathVariable Integer id, @RequestBody Cliente clienteAtualizado){
        clienteRepository.findById(id)
                        .map( cliente -> {
                           cliente.setNome(clienteAtualizado.getNome());
                           cliente.setCpf(clienteAtualizado.getCpf());
                           return clienteRepository.save(clienteAtualizado);
                        })
                                .orElseThrow(() -> 
                                    new ResponseStatusException(HttpStatus.NOT_FOUND, "Cliente não encontrado"));
    }
}
