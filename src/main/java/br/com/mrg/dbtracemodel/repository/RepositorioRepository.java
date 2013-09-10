package br.com.mrg.dbtracemodel.repository;

import br.com.mrg.dbtracemodel.entity.Repositorio;
import javax.ejb.Local;
import javax.ejb.Stateless;

@Stateless(name = "RepositorioRepository")
@Local(IRepositorioRepository.class)
public class RepositorioRepository extends DefaultRepository<Repositorio> implements IRepositorioRepository {
    
}