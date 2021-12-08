<template>
  <b-container class="bv-example-row mt-3 text-center">
    <h3 class="underline-orange">
      <b-icon icon="house-fill"></b-icon> House Service
    </h3>
    <b-row>
      <b-col>
        <house-search-bar></house-search-bar>
      </b-col>
    </b-row>
    <b-row>
      <house-nav-bar></house-nav-bar>
    </b-row>
    <b-row>
      <house-list />
    </b-row>
    <b-row>
      <house-page-nav-bar></house-page-nav-bar>
    </b-row>
  </b-container>
</template>
<script>
import HouseSearchBar from "@/components/house/HouseSearchBar.vue";
import HouseList from "@/components/house/HouseList.vue";
import HouseNavBar from "@/components/house/HouseNavBar.vue";
import HousePageNavBar from "@/components/house/HousePageNavBar.vue";
import Vue from "vue";

export default {
  name: "House",
  components: {
    HouseSearchBar,
    HouseList,
    HouseNavBar,
    HousePageNavBar,
  },
};

export const eventBus = new Vue({
  methods: {},
});
</script>
<style scoped>
.underline-orange {
  display: inline-block;
  background: linear-gradient(
    180deg,
    rgba(255, 255, 255, 0) 70%,
    rgba(231, 149, 27, 0.3) 30%
  );
}
</style>
