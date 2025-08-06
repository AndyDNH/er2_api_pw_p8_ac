package com.uce.edu.service.mapper;

import com.uce.edu.repository.model.Estudiante;
import com.uce.edu.service.to.EstudianteTo;

public class EstudianteMapper {

    public static EstudianteTo toTo(Estudiante estudiante){
        EstudianteTo esTo = new EstudianteTo();
        esTo.setApellido(estudiante.getApellido());
        esTo.setCedula(estudiante.getCedula());
        esTo.setFechaNacimiento(estudiante.getFechaNacimiento());
        esTo.setGenero(estudiante.getGenero());
        esTo.setNombre(estudiante.getNombre());

        return esTo;
    }

    public static Estudiante toEntity(EstudianteTo sto ){
        Estudiante estudiante = new Estudiante();
        estudiante.setApellido(sto.getApellido());
        estudiante.setCedula(sto.getCedula());
        estudiante.setFechaNacimiento(sto.getFechaNacimiento());
        estudiante.setGenero(sto.getGenero());
        estudiante.setNombre(sto.getNombre());

        return estudiante;
    }

}
