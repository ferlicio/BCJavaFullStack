package com.soulcode.Servicos.Repositories;

import com.soulcode.Servicos.Models.Chamado;
import com.soulcode.Servicos.Models.Pagamento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface PagamentoRepository extends JpaRepository<Pagamento,Integer> {


    // List<Pagamento> findByChamado(Optional<Chamado> chamado);
    @Query(value = "SELECT * FROM pagamento WHERE status =:status",nativeQuery = true )
    List<Pagamento> findByStatus(String status);

    @Query(value= "SELECT * FROM pagamento WHERE data_entrada BETWEEN :valor1 AND :valor2", nativeQuery = true)
    List<Pagamento> findByIntervaloValor(Double valor1, Double valor2);

    @Query(value = "SELECT * FROM pagamento WHERE formaPagamento =:formaPagamento",nativeQuery = true )
    List<Pagamento> findByFormaPagamento(String formaPagamento);

    //List<List> orcamentoComServicoCliente();

}
