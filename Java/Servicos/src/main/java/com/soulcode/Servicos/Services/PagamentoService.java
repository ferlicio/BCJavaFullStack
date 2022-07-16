package com.soulcode.Servicos.Services;

import com.soulcode.Servicos.Models.Chamado;
import com.soulcode.Servicos.Models.Pagamento;
import com.soulcode.Servicos.Repositories.PagamentoRepository;
import com.soulcode.Servicos.Repositories.ChamadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PagamentoService {

    @Autowired
    PagamentoRepository pagamentoRepository;

    @Autowired
    ChamadoRepository chamadoRepository;

    // findAll (método da Spring Data) - busca todos os registros
    public List<Pagamento> mostrarTodosPagamentos(){
        return pagamentoRepository.findAll();	}

    // findById - busca um registro pela sua chave primária
    public Pagamento mostrarUmPagamento(Integer idPagamento) {
        Optional<Pagamento> pagamento = pagamentoRepository.findById(idPagamento);
        return pagamento.orElseThrow();
    }

    //public List<Pagamento> buscarPagamentosPeloChamado(Integer idChamado){
    //    Optional<Chamado> chamado = chamadoRepository.findById(idChamado);
    //   return pagamentoRepository.findByChamado(chamado);
    //}

    //public List<List> orcamentoComServicoCliente() {
    //    return pagamentoRepository.orcamentoComServicoCliente();
    //}
}
