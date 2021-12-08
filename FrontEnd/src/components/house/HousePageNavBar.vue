<template>
  <b-container
    v-if="houses && houses.length != 0"
    class="bv-example-row mt-4 mb-4"
  >
    <b-pagination
      v-model="currentPage"
      :total-rows="rows"
      :per-page="perPage"
      align="center"
    ></b-pagination>
  </b-container>
</template>

<script>
import { mapState } from "vuex";
import { eventBus } from "@/views/House.vue";

const houseStore = "houseStore";

export default {
  data() {
    return {
      perPage: 1,
    };
  },
  computed: {
    ...mapState(houseStore, ["houses", "rows"]),
    currentPage: {
      get() {
        return 1;
      },
      set(value) {
        eventBus.$emit("changePage", value);
        console.log(value);
      },
    },
  },
};
</script>

<style></style>
