<template>
  <div class="container-general">
    <div class="container-form">
      <p type="Nombre">
        <input type="text" v-model="dato.nombre" disabled />
      </p>
      <p type="Apellido">
        <input type="text" v-model="dato.apellido" disabled />
      </p>
      <p type="Cedula">
        <input type="text" v-model="dato.cedula" disabled />
      </p>
      <p type="Fecha de Nacimiento">
        <input type="date" v-model="dato.fechaNacimiento" disabled />
      </p>
      <p type="Genero">
        <input type="text" v-model="dato.genero" disabled />
      </p>
    </div>
  </div>
</template>

<script>
export default {
  props: {
    
  },
  data() {
    return {
      dato: [],
    };
  },
  methods: {
    recibeDesdePadre(data) {
      this.dato = data;
      console.log(data);
      
    },
  },
};
</script>

<style>
</style>