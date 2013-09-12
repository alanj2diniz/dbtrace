package org.dbtrace.repository;

import org.dbtrace.entity.Modulo;
import javax.ejb.Local;
import javax.ejb.Stateless;

@Stateless(name = "ModuloRepository")
@Local(IModuloRepository.class)
public class ModuloRepository extends DefaultRepository<Modulo> implements IModuloRepository {
    
}