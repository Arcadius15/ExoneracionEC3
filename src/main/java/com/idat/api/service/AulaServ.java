package com.idat.api.service;

import java.util.List;

import com.idat.api.model.Aula;

public interface AulaServ {
    public void guardar(Aula item);
    public void editar(Aula item);
    public void eliminar(int id);
    public Aula obtener(int id);
    public List<Aula> listar();

}
