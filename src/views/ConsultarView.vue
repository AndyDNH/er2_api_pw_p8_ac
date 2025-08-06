<template>
  <TablaEstudiante @cedula="enviarHijo($event)" />
  <FormularioEstudiante ref="formulario" />
</template>

<script>
import TablaEstudiante from "@/components/TablaEstudiante.vue";
import FormularioEstudiante from "@/components/FormularioEstudiante.vue";
export default {
    components:{
        TablaEstudiante,
        FormularioEstudiante
    },
    methods:{
      enviarHijo(dato){
        this.$refs.formulario.recibeDesdePadre(dato)
      }
    }
    
}
</script>

<style>

</style>