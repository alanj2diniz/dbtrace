package br.com.mrg.dbtracemodel.repository;

import br.com.mrg.dbtracemodel.entity.Usuario;
import javax.ejb.Local;
import javax.ejb.Stateless;

@Stateless(name = "UsuarioRepository")
@Local(IUsuarioRepository.class)
public class UsuarioRepository extends DefaultRepository<Usuario> implements IUsuarioRepository {
    
}