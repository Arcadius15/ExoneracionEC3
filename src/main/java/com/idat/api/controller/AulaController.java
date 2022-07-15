package com.idat.api.controller;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.idat.api.dto.AulaReq;
import com.idat.api.dto.AulaRes;
import com.idat.api.dto.MapperMS;
import com.idat.api.model.Aula;
import com.idat.api.service.AulaServ;

@RestController
@RequestMapping("/aula")
public class AulaController {

    @Autowired
    private AulaServ repository;

    @Autowired
    private MapperMS mapper;

    @GetMapping
    public ResponseEntity<List<AulaRes>> getAll() {
        try {
            List<AulaRes> items = repository.listar().stream().map(new Function<Aula,AulaRes>() {
                @Override
                public AulaRes apply(Aula t) {
                    return mapper.aulaToDto(t);
                }
            }).collect(Collectors.toList());

            if (items.isEmpty())
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);

            return new ResponseEntity<>(items, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("{id}")
    public ResponseEntity<AulaRes> getById(@PathVariable("id") int id) {
        Aula item = repository.obtener(id);

        if (item!=null) {
            return new ResponseEntity<>(mapper.aulaToDto(item), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<?> create(@RequestBody AulaReq item) {
        try {
            repository.guardar(mapper.dtoToAula(item));
            return new ResponseEntity<>(HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.EXPECTATION_FAILED);
        }
    }

    @PutMapping("{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody AulaReq item) {
        Aula eitem = repository.obtener(id);
        try {
            if (eitem!=null) {
                repository.editar(mapper.dtoToAula(item));
                return new ResponseEntity<>(HttpStatus.OK);
            }
            else
                throw new Exception();
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        
        }
    }

    @DeleteMapping("{id}")
    public ResponseEntity<HttpStatus> delete(@PathVariable("id") int id) {
        try {
            repository.eliminar(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
        }
    }
}

