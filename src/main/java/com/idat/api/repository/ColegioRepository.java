package com.idat.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.idat.api.model.Colegio;

@Repository
public interface ColegioRepository extends JpaRepository<Colegio,Integer>{
    
}
