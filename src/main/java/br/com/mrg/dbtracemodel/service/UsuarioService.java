package br.com.mrg.dbtracemodel.service;

import br.com.mrg.dbtracemodel.entity.Usuario;
import br.com.mrg.dbtracemodel.exception.NomeIndisponivelException;
import br.com.mrg.dbtracemodel.repository.IUsuarioRepository;
import javax.ejb.EJB;
import javax.ejb.Local;
import javax.ejb.Stateless;

@Stateless(name = "UsuarioService")
@Local(IUsuarioService.class)
public class UsuarioService implements IUsuarioService {

    @EJB
    private IUsuarioRepository usuarioRepository;
    

    @Override
    public void criar(Usuario usuario) throws NomeIndisponivelException {
        if(!usuarioRepository.isUsuarioDisponivel(usuario.getNome())) {
            throw new NomeIndisponivelException();
        }
        this.usuarioRepository.create(usuario);
    }    
    
}