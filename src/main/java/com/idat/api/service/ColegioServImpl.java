package com.idat.api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.idat.api.model.Colegio;
import com.idat.api.repository.ColegioRepository;

@Service
public class ColegioServImpl implements ColegioServ{
	
	@Autowired
	private ColegioRepository repository;

    @Override
    public void guardar(Colegio item) {
        repository.save(item);
        
    }

    @Override
    public void editar(Colegio item) {
        repository.saveAndFlush(item);
        
    }

    @Override
    public void eliminar(int id) {
        repository.deleteById(id);
        
    }

    @Override
    public Colegio obtener(int id) {
        
        return repository.findById(id).orElse(null);
    }

    @Override
    public List<Colegio> listar() {
        
        return repository.findAll();
    }
    
}
