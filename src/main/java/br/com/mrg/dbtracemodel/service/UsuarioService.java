package br.com.mrg.dbtracemodel.service;

import javax.ejb.Remote;
import javax.ejb.Stateless;

@Stateless(name = "UsuarioService")
@Remote(IUsuarioService.class)
public class UsuarioService implements IUsuarioService {
    
}