package br.com.mrg.dbtracemodel.service;

import br.com.mrg.dbtracemodel.entity.Usuario;
import org.dbtrace.exceptions.NomeIndisponivelException;
import org.dbtrace.exceptions.SenhaNaoConfereException;

public interface IUsuarioService {
        
    void criar(Usuario usuario) throws NomeIndisponivelException,SenhaNaoConfereException ;
    
    void atualizar(Usuario usuario, String confirmarSenha) throws SenhaNaoConfereException ;
    
    void apagar(Usuario usuario);
    
}