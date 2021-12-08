<template>
  <div id="app">
      <navi-bar />
      <router-view />
  </div>
</template>

<script>
import NaviBar from "./components/layout/NaviBar.vue";
export default {
    name: "app",
    components: {
        NaviBar,
    },
}
</script>

<style>

</style>