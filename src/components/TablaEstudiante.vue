<template>
  <div class="container-general">
    <button @click="consultarEstudiantes()">Consultar</button>
    <div class="container-tabla">
        <table border="1">
            <thead>
                <tr>
                    <th>Cedula</th>
                    <th>Nombre</th>
                    <th>Acccion</th>
                </tr>
            </thead>
            <tbody>
                <tr v-for="estudiante in estudiantes" :key="estudiante.id">
                    <td>{{ estudiante.cedula }}</td>
                    <td>{{ estudiante.nombre }}</td>
                    <td>
                        <button @click="enviarPadre(estudiante)">
                            Acción
                        </button>
                    </td>
                </tr>
            </tbody>
        </table>
    </div>
  </div>
</template>

<script>
import { obtenerEstudiantesFachada } from "@/clients/EstudianteClient";
export default {

    data(){
        return{
            estudiantes:[]
        }
    },
    methods:{
        async consultarEstudiantes(){
            this.estudiantes = await obtenerEstudiantesFachada();
        },
        enviarPadre(cedula){
            this.$emit("cedula", cedula)
        }
    }

}
</script>

<style>

.container-tabla{
    margin-top: 10px;
    margin-bottom: 25px;
    display: flex;
    flex-direction: column;
    align-items: center;
    justify-content: center;

}

table{
    border-collapse: collapse;
    border: 1px solid black;
    
}

.container-tabla td,th{
    padding: 10px 30px;

}

.container-tabla th{
    padding: 10px 30px;
    background: #2980b9;
    color: aliceblue;
}
h2{
    color: rgb(24, 153, 12);
}

</style>