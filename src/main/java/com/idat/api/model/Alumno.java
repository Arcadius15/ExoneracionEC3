package com.idat.api.model;

import java.time.LocalDate;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
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
@Table(name = "alumno")
public class Alumno {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idAlumno;
    private String nombre;
    private String apellido;
    private LocalDate fechaNacimiento;
    
    @ManyToMany(mappedBy = "alumnosAulas")
    private Set<Aula> aulas;

    @ManyToOne
    @JoinColumn(name = "id_colegio",foreignKey = @ForeignKey(foreignKeyDefinition = "foreign key(id_colegio) references colegio(id_colegio)"))
    private Colegio colegio;

}
