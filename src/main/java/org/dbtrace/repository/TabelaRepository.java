package org.dbtrace.repository;

import org.dbtrace.entity.Tabela;
import javax.ejb.Local;
import javax.ejb.Stateless;

@Stateless(name = "TabelaRepository")
@Local(ITabelaRepository.class)
public class TabelaRepository extends DefaultRepository<Tabela> implements ITabelaRepository {
    
}