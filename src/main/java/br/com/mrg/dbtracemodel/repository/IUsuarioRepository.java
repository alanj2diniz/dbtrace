package br.com.mrg.dbtracemodel.repository;

import br.com.mrg.dbtracemodel.entity.Usuario;

public interface IUsuarioRepository extends IDefaultRepository<Usuario> {
    
    public boolean isUsuarioDisponivel(String login); 
    
}