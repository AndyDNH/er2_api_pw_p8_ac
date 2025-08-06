import axios from "axios";

const obtenerEstudiantes  = async() =>{
    const respuesta = axios.get(`http://localhost:8081/api/universidad/v1`).then(res => res.data);
    return respuesta;
}

export const obtenerEstudiantesFachada  = async() =>{
    return await obtenerEstudiantes();
}

const obtenerEstudiantesPorCedula  = async(id) =>{
    const respuesta = axios.get(`http://localhost:8081/api/universidad/v1/${id}`).then(res => res.data);
    return respuesta;
}

export const obtenerEstudiantesPorCedulaFachada  = async(id) =>{
    return await obtenerEstudiantesPorCedula();
}

const guardarEstudiante  = async(body) =>{
    axios.post(`http://localhost:8081/api/universidad/v1`,body).then(res => res.data);
}

export const guardarEstudianteFachada  = async(body) =>{
    await guardarEstudiante(body);
}
