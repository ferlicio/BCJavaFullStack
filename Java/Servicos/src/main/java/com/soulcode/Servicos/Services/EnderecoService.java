package com.soulcode.Servicos.Services;

import com.soulcode.Servicos.Models.Cliente;
import com.soulcode.Servicos.Models.Endereco;
import com.soulcode.Servicos.Repositories.ClienteRepository;
import com.soulcode.Servicos.Repositories.EnderecoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EnderecoService {

    @Autowired
    EnderecoRepository enderecoRepository;

    @Autowired
    ClienteRepository clienteRepository;

    @Cacheable("clientesCache")
    public List<Endereco> mostrarTodosEnderecos(){
        return enderecoRepository.findAll();
    }

    @Cacheable(value = "enderecoCache", key = "#idEndereco")
    public Endereco mostrarUmEnderecoPeloId(Integer idEndereco) {
        Optional<Endereco> endereco = enderecoRepository.findById(idEndereco);
        return endereco.orElseThrow();
    }

    @Cacheable(value = "enderecosCache", key = "#rua")
    public Endereco mostrarUmEnderecoPelaRua(String rua) {
        Optional<Endereco> endereco = enderecoRepository.findByRua(rua);
        return endereco.orElseThrow();
    }

    @Cacheable(value = "enderecosCache", key = "#bairro")
    public Endereco mostrarUmEnderecoPeloBairro(String bairro) {
        Optional<Endereco> endereco = enderecoRepository.findByBairro(bairro);
        return endereco.orElseThrow();
    }

    @Cacheable(value = "enderecosCache", key = "#cidade")
    public Endereco mostrarUmEnderecoPelaCidade(String cidade) {
        Optional<Endereco> endereco = enderecoRepository.findByCidade(cidade);
        return endereco.orElseThrow();
    }

    @Cacheable(value = "enderecosCache", key = "#uf")
    public Endereco mostrarUmEnderecoPeloUf(String uf) {
        Optional<Endereco> endereco = enderecoRepository.findByUf(uf);
        return endereco.orElseThrow();
    }

    @CachePut(value = "enderecoCache", key = "#endereco.idEndereco")
    public Endereco inserirEndereco(Integer idCliente, Endereco endereco) throws Exception {
        Optional<Cliente> cliente = clienteRepository.findById(idCliente); //pega o cliente referente ao id
        if (cliente.isPresent()){
        endereco.setIdEndereco(idCliente); // seta o id igual do cliente
        enderecoRepository.save(endereco); // salva o endereco
        cliente.get().setEndereco(endereco); // seta o endereco do cliente como o endereco
        clienteRepository.save(cliente.get()); // salva o cliente
        return endereco;
        } else {
            throw new Exception();
        }
    }

    @CachePut(value = "enderecoCache", key = "#endereco.idEndereco")
    public Endereco editarEndereco (Endereco endereco) {
        return enderecoRepository.save(endereco);
    }

    @CacheEvict(value = "enderecosCache", key = "#idEndereco", allEntries = true)
    public void excluirEndereco (Integer idEndereco) {
        enderecoRepository.deleteById(idEndereco);
    }

}
