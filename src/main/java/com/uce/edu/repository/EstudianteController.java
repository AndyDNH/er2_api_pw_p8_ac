package com.uce.edu.repository;

import java.util.List;
import java.util.stream.Collectors;

import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.parameters.RequestBody;

import com.uce.edu.service.IEstudianteService;
import com.uce.edu.service.mapper.EstudianteMapper;
import com.uce.edu.service.to.EstudianteTo;

import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class EstudianteController {

    @Inject
    private IEstudianteService estudianteService;

    @GET
    @Path("")
    @Operation(
        summary = "Devuelve los estudiantes",
        description = "Devuelve una lista con todos los estudiantes"
    )
    public Response consultarTodosEstu(){
        List<EstudianteTo> estudiantes =  estudianteService.consultarTodos()
        .stream().map(EstudianteMapper::toTo).collect(Collectors.toList());

        return Response.status(200).entity(estudiantes).build();
    }

    @GET
    @Path("/{id}")
    @Operation(
        summary = "Consulta por cedula",
        description = "Devuelve un estudiante consultado por cedula"
    )
    public Response consultarPorCedula(@PathParam("id")Integer id){
        EstudianteTo estudiante =  EstudianteMapper.toTo(estudianteService.consultarPorCedula(id));
        
        return Response.status(200).entity(estudiante).build();
    }

    @POST
    @Path("")
    public Response guardaEstudiante(@RequestBody EstudianteTo eTo){
        estudianteService.guardarEstudiante(EstudianteMapper.toEntity(eTo));
        
        return Response.status(200).build();
    }


}
