package com.idat.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.idat.api.model.Alumno;

@Repository
public interface AlumnoRepository extends JpaRepository<Integer,Alumno>{
    
}
