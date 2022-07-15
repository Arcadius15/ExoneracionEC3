package com.idat.api.model;

import java.time.LocalDate;
import java.util.Set;

import javax.persistence.ForeignKey;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Alumno {
    private int idAlumno;
    private String nombre;
    private String apellido;
    private LocalDate fechaNacimiento;
    
    @ManyToMany
    private Set<Aula> aulas;

    @ManyToOne
    @JoinColumn(name = "id_colegio",foreignKey = @ForeignKey(foreignKeyDefinition = "foreign key(id_colegio) references colegio(id_colegio)"))
    private Colegio colegio;

}
