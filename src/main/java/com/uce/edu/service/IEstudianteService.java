package com.uce.edu.service;

import java.util.List;

import com.uce.edu.repository.model.Estudiante;

public interface IEstudianteService {

    public List<Estudiante> consultarTodos();

    public Estudiante consultarPorCedula(Integer cedula);

    public void guardarEstudiante(Estudiante estudiante);

}
