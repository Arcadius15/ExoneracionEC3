package com.idat.api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.idat.api.model.Aula;
import com.idat.api.repository.AulaRepository;

@Service
public class AulaServImpl implements AulaServ{

    @Autowired
    private AulaRepository repository;

    @Override
    public void guardar(Aula item) {
        repository.save(item);
        
    }

    @Override
    public void editar(Aula item) {
        repository.saveAndFlush(item);
        
    }

    @Override
    public void eliminar(int id) {
        repository.deleteById(id);
        
    }

    @Override
    public Aula obtener(int id) {
        // TODO Auto-generated method stub
        return repository.findById(id).orElse(null);
    }

    @Override
    public List<Aula> listar() {
        // TODO Auto-generated method stub
        return repository.findAll();
    }
    
}
