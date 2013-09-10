package br.com.mrg.dbtracemodel.service;

import javax.ejb.Remote;
import javax.ejb.Stateless;

@Stateless(name = "ModuloService")
@Remote(IModuloService.class)
public class ModuloService implements IModuloService {
    
}