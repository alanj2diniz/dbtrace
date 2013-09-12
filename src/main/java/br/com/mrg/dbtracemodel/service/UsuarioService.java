package br.com.mrg.dbtracemodel.service;

import br.com.mrg.dbtracemodel.entity.Usuario;
import org.dbtrace.exceptions.NomeIndisponivelException;
import org.dbtrace.exceptions.SenhaNaoConfereException;
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
    public void criar(Usuario usuario) throws NomeIndisponivelException, SenhaNaoConfereException {
        if(!usuarioRepository.isUsuarioDisponivel(usuario.getNome())) {
            throw new NomeIndisponivelException();
        } else if(!usuario.isConfirmaSenha()) {
            throw new SenhaNaoConfereException();
        } else {
            this.usuarioRepository.create(usuario);
        }
    } 

    @Override
    public void atualizar(Usuario usuario, String confirmarSenha) throws SenhaNaoConfereException {
        if(!usuario.isNovaSenhaValida()) {
            throw new SenhaNaoConfereException();
        } else {
            this.usuarioRepository.update(usuario);
        }
    }

    @Override
    public void apagar(Usuario usuario) {
        this.usuarioRepository.delete(this.usuarioRepository.getReference(usuario.getId()));
    }
    
}