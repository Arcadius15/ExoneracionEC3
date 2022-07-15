package com.idat.api.service;

import java.util.List;

import com.idat.api.model.Alumno;

public interface AlumnoServ {
    public void guardar(Alumno item);
    public void editar(Alumno item);
    public void eliminar(int id);
    public Alumno obtener(int id);
    public List<Alumno> listar();

}
