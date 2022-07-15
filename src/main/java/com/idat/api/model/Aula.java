package com.idat.api.model;

import java.util.Set;

import javax.persistence.JoinTable;
import javax.persistence.JoinColumn;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
@Table(name = "aula")
public class Aula {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idAula;
    private int aforo;

    @ManyToOne
    @JoinColumn(name = "id_colegio",foreignKey = @ForeignKey(foreignKeyDefinition = "foreign key(id_colegio) references colegio(id_colegio)"))
    private Colegio colegio;

    @ManyToMany
    @JoinTable(
            name = "alumnos_aulas", 
            joinColumns = @JoinColumn(name = "id_aula"), 
            inverseJoinColumns = @JoinColumn(name = "id_alumno"))
    private Set<Alumno> alumnosAulas;
    
}
