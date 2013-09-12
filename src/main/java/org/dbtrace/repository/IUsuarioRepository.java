package org.dbtrace.repository;

import org.dbtrace.entity.Usuario;

public interface IUsuarioRepository extends IDefaultRepository<Usuario> {
    
    public boolean isUsuarioDisponivel(String login); 
    
}