package br.com.mrg.dbtracemodel.repository;

import br.com.mrg.dbtracemodel.entity.Tabela;
import javax.ejb.Local;
import javax.ejb.Stateless;

@Stateless(name = "TabelaRepository")
@Local(ITabelaRepository.class)
public class TabelaRepository extends DefaultRepository<Tabela> implements ITabelaRepository {
    
}