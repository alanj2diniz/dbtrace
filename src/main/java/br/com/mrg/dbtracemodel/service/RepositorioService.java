package br.com.mrg.dbtracemodel.service;

import javax.ejb.Remote;
import javax.ejb.Stateless;

@Stateless(name = "RepositorioService")
@Remote(IRepositorioService.class)
public class RepositorioService implements IRepositorioService {
    
}