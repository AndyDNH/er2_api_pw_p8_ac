<template>
  <div class="container-general">
    <h1>Ingrese un Estudiante</h1>
    <div class="container-form">
      <p type="Nombre">
        <input type="text" v-model="nombre" />
      </p>
      <p type="Apellido">
        <input type="text" v-model="apellido" />
      </p>
      <p type="Cedula">
        <input type="text" v-model="cedula" />
      </p>
      <p type="Fecha de Nacimiento">
        <input type="date" v-model="fechaNacimiento" />
      </p>
      <p type="Genero">
        <select name="genero" v-model="genero">
          <option value="Masculino">Masculino</option>
          <option value="Femenino">Femenino</option>
        </select>
      </p>
    </div>
    <button @click="guardaEstudiante()">Guardar</button>
  </div>
  <h2 v-if="creado">Estudiante Creado exitosamente</h2>
</template>

<script>
import { guardarEstudianteFachada } from "@/clients/EstudianteClient";
export default {
  data() {
    return {
      nombre: null,
      apellido: null,
      cedula: null,
      fechaNacimiento: "",
      genero: null,
      creado:false,
    };
  },
  methods: {
    async guardaEstudiante() {
        console.log(this.fechaNacimiento);
      const estudianteBody = {
        nombre: this.nombre,
        apellido: this.apellido,
        cedula: this.cedula,
        fechaNacimiento: this.fechaNacimiento,
        genero: this.genero,
      };
      console.log(estudianteBody.fechaNacimiento);
      console.log(estudianteBody);
      
      await guardarEstudianteFachada(estudianteBody);
      this.creado=true;
      setTimeout(() => {
        this.creado = false;
        this.limpiarFormulario()
      }, 2000);
    },
    limpiarFormulario(){
        this.nombre = '',
        this.apellido = '',
        this.cedula = '',
        this.fechaNacimiento = '',
        this.genero = ''
    },
    
  },
};
</script>

<style>

.container-general{
    display: flex;
    flex-direction: column;
    align-items: center;
    justify-content: center;
    gap: 10px;
}

.container-form{
    height: 50%;
    padding: 25px 30px;
    box-shadow: 0px 1px 8px rgba(0, 0, 0, 0.158);
    margin-bottom: 10px ;
}

p{
    

}

p::before{
    content: attr(type);
    /* text-align: left; */
}

p[type]{
    display: flex;
    flex-direction: column;
    text-align: left;
    /* justify-content: center; */
}

button {
    border: none;
    font-size: 15px;
    padding: 1px 15px;
    background: #2980b9;
    border-radius: 7px;
}

</style>