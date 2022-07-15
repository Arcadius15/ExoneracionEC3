package com.idat.api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.idat.api.model.Alumno;
import com.idat.api.repository.AlumnoRepository;

@Service
public class AlumnoServImpl implements AlumnoServ{

    @Autowired
    private AlumnoRepository repository;

    @Override
    public void guardar(Alumno item) {
        repository.save(item);
    }

    @Override
    public void editar(Alumno item) {
       repository.saveAndFlush(item);
    }

    @Override
    public void eliminar(int id) {
       repository.deleteById(id);
        
    }

    @Override
    public Alumno obtener(int id) {
        // TODO Auto-generated method stub
        return repository.findById(id).orElse(null);
    }

    @Override
    public List<Alumno> listar() {
        // TODO Auto-generated method stub
        return repository.findAll();
    }
    
}
