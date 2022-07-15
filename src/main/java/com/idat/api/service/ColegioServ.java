package com.idat.api.service;

import java.util.List;

import com.idat.api.model.Colegio;

public interface ColegioServ {
    public void guardar(Colegio item);
    public void editar(Colegio item);
    public void eliminar(int id);
    public Colegio obtener(int id);
    public List<Colegio> listar();

}
