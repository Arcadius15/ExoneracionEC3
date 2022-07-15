package com.idat.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.idat.api.model.Aula;

@Repository
public interface AulaRepository extends JpaRepository<Integer,Aula>{
    
}
