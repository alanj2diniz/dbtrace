package org.dbtrace.repository;

import org.dbtrace.entity.Repositorio;
import javax.ejb.Local;
import javax.ejb.Stateless;

@Stateless(name = "RepositorioRepository")
@Local(IRepositorioRepository.class)
public class RepositorioRepository extends DefaultRepository<Repositorio> implements IRepositorioRepository {
    
}