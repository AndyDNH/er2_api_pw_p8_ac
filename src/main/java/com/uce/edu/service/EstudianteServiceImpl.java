package com.uce.edu.service;

import java.util.List;

import com.uce.edu.repository.IEstudianteRepo;
import com.uce.edu.repository.model.Estudiante;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

@ApplicationScoped
public class EstudianteServiceImpl implements IEstudianteService {

    @Inject
    private IEstudianteRepo estudianteRepo;
    
    @Override
    public List<Estudiante> consultarTodos() {
        return estudianteRepo.consultarTodos();
    }

    @Override
    public Estudiante consultarPorCedula(Integer cedula) {
        return estudianteRepo.consultarPorCedula(cedula);
    }

    @Override
    public void guardarEstudiante(Estudiante estudiante) {
        estudianteRepo.insertarEstudiante(estudiante);
    }

}
