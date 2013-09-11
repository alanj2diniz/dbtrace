package br.com.mrg.dbtracemodel.service;

import br.com.mrg.dbtracemodel.entity.Usuario;
import br.com.mrg.dbtracemodel.exception.NomeIndisponivelException;

public interface IUsuarioService {
    
    public void criar(Usuario usuario) throws NomeIndisponivelException;
    
}