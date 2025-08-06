package com.uce.edu.repository;

import java.util.List;

import com.uce.edu.repository.model.Estudiante;

public interface IEstudianteRepo {

    public List<Estudiante> consultarTodos();
    public Estudiante consultarPorCedula(Integer cedula);
    public void insertarEstudiante(Estudiante estudiante);

}
