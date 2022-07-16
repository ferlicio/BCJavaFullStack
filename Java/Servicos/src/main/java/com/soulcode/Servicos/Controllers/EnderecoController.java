package com.soulcode.Servicos.Controllers;

import com.soulcode.Servicos.Models.Endereco;
import com.soulcode.Servicos.Services.EnderecoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("servicos")
public class EnderecoController {

    @Autowired
    EnderecoService enderecoService;

    @GetMapping("/enderecos")
    public List<Endereco> mostrarTodosEnderecos() {
        List<Endereco> enderecos = enderecoService.mostrarTodosEnderecos();
        return enderecos;
    }

    @GetMapping("/enderecos/{idEndereco}")
    public ResponseEntity<Endereco> mostrarUmEnderecoPeloId(@PathVariable Integer idEndereco) {
        Endereco endereco = enderecoService.mostrarUmEnderecoPeloId(idEndereco);
        return ResponseEntity.ok().body(endereco);
    }

    @GetMapping("/enderecos/rua/{rua}")
    public ResponseEntity<Endereco> mostrarUmEnderecoPelaRua(@PathVariable String rua) {
        Endereco endereco = enderecoService.mostrarUmEnderecoPelaRua(rua);
        return ResponseEntity.ok().body(endereco);
    }

    @GetMapping("/enderecos/bairro{bairro}")
    public ResponseEntity<Endereco> mostrarUmEnderecoPeloBairro(@PathVariable String bairro){
        Endereco endereco = enderecoService.mostrarUmEnderecoPeloBairro(bairro);
        return ResponseEntity.ok().body(endereco);
    }
    @GetMapping("/enderecos/cidade/{cidade}")
    public ResponseEntity<Endereco> mostrarUmEnderecoPelaCidade(@PathVariable String cidade){
        Endereco endereco = enderecoService.mostrarUmEnderecoPelaCidade(cidade);
        return ResponseEntity.ok().body(endereco);
    }
    @GetMapping("/enderecos/uf/{uf}")
    public ResponseEntity<Endereco> mostrarUmEnderecoPeloUf(@PathVariable String uf){
        Endereco endereco = enderecoService.mostrarUmEnderecoPeloUf(uf);
        return ResponseEntity.ok().body(endereco);
    }

    @PostMapping("/enderecos/{idCliente}")
    public ResponseEntity<Endereco> inserirEndereco(@PathVariable Integer idCliente, @RequestBody Endereco endereco){
        try{ //é necessario por poder retornar uma exceção
            endereco = enderecoService.inserirEndereco(idCliente,endereco);
            URI novaUri = ServletUriComponentsBuilder.fromCurrentRequest().path("id")
                    .buildAndExpand(endereco.getIdEndereco()).toUri();
            return ResponseEntity.created(novaUri).body(endereco);
        } catch(Exception e) {
            return ResponseEntity.badRequest().build(); //retorna erro 400
        }
    }

    @PutMapping("/enderecos/{idEndereco}")
    public ResponseEntity<Endereco> editarEndereco(@PathVariable Integer idEndereco,
                                                         @RequestBody Endereco endereco){
        endereco.setIdEndereco(idEndereco);
        enderecoService.editarEndereco(endereco);
        return ResponseEntity.ok().body(endereco);
    }

}


