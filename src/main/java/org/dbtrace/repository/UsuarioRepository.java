package org.dbtrace.repository;

import org.dbtrace.entity.Usuario;
import javax.ejb.Local;
import javax.ejb.Stateless;
import org.hibernate.criterion.Restrictions;

@Stateless(name = "UsuarioRepository")
@Local(IUsuarioRepository.class)
public class UsuarioRepository extends DefaultRepository<Usuario> implements IUsuarioRepository {

    @Override
    public boolean isUsuarioDisponivel(String login) {
        return null != createCriteria().add(Restrictions.eq("login", login)).uniqueResult();
    }
    
}