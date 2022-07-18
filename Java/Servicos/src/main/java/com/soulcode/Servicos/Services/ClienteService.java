package com.soulcode.Servicos.Services;

import com.soulcode.Servicos.Models.Cliente;
import com.soulcode.Servicos.Repositories.ClienteRepository;
import com.soulcode.Servicos.Services.Exceptions.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteService {
    //aqui fazemos a injeção de depência
    @Autowired
    ClienteRepository clienteRepository;

    // findAll (método da Spring Data) - busca todos os registros
    @Cacheable("clientesCache") //só chama o método se o cache não existir
    public List<Cliente> mostrarTodosClientes(){
        return clienteRepository.findAll();
    }

    // findById - busca um cliente específico pelo seu id
    @Cacheable(value = "clientesCache", key = "#idCliente") //só chama o método se o cache não existir, se o cache existir, ele retorna o valor do cache
    public Cliente mostrarUmClientePeloId(Integer idCliente) {

        Optional<Cliente> cliente = clienteRepository.findById(idCliente);
        return cliente.orElseThrow(
                () -> new EntityNotFoundException("Funcionario não cadastrado: " + idCliente)
        );
    }

    @CachePut(value = "clienteCache", key = "#cliente.idCliente")
    public Cliente inserirCliente(Cliente cliente) {
        //por precaução vamos limpar o campo de id do cliente
        cliente.setIdCliente(null);
        return clienteRepository.save(cliente);

    }

    // editar um cliente já cadastrado
    @CachePut(value = "clientesCache", key = "#cliente.idCliente") //substitui o valor do cache segundo a key
    public Cliente editarCliente (Cliente cliente) {
        mostrarUmClientePeloId(cliente.getIdCliente());
        return clienteRepository.save(cliente);
    }

    // deleteById  - excluir um cliente pelo seu id
    @CacheEvict(value = "clientesCache", key = "#idCliente", allEntries = true) //remove o valor do cache segundo a key
    public void excluirCliente (Integer idCliente) {
        mostrarUmClientePeloId(idCliente);
        clienteRepository.deleteById(idCliente);
    }
}
