<template >
 <v-app id="app">
   
   <AppBar/>
    <v-content>
      <router-view />
    </v-content>
 </v-app>
</template>

<script>
import AppBar from "./components/AppBar.vue";

export default {
  name: 'App',
  components: {
    AppBar
  }
}
</script>

<style lang="scss">
#app {
  font-family: 'Avenir', Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2C3E50;
}
</style>
