package com.uce.edu.repository;

import java.util.List;

import com.uce.edu.repository.model.Estudiante;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;


@Transactional
@ApplicationScoped
public class EstudianteRepoImpl implements IEstudianteRepo{

    @PersistenceContext
    private EntityManager entityManager;
    
    @Override
    public List<Estudiante> consultarTodos() {
        TypedQuery<Estudiante> typedQuery = entityManager.createQuery("SELECT e FROM Estudiante e",Estudiante.class);
        return typedQuery.getResultList();
    }

    @Override
    public Estudiante consultarPorCedula(Integer cedula) {
        return entityManager.find(Estudiante.class, cedula);
    }

    @Override
    public void insertarEstudiante(Estudiante estudiante) {
        entityManager.persist(estudiante);
    }

}
