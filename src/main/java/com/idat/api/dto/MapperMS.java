package com.idat.api.dto;

import org.mapstruct.Mapper;

import com.idat.api.model.Alumno;
import com.idat.api.model.Aula;
import com.idat.api.model.Colegio;


@Mapper(componentModel = "spring")
public interface MapperMS {
    ColegioRes colegioToDTO(Colegio colegio);
    Colegio dtoToColegio(ColegioReq colegio);

    AulaRes aulaToDto(Aula aula);
    Aula dtoToAula(AulaReq aula);

    AlumnoRes alumnoToDto(Alumno alumno);
    Alumno dtoToAlumno(AlumnoReq alumno);
}
