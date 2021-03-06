package com.idat.api.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "colegio")
public class Colegio {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idColegio;
    private String nombre;
    private String tipo;

    @OneToMany(mappedBy = "colegio")
    private List<Aula> aulas;

    @OneToMany(mappedBy = "colegio")
    private List<Alumno> alumnos;
}
