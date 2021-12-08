<template>
  <b-row
    class="m-0 text-center justify-content-md-center"
    @click="selectHouse"
    @mouseover="colorChange(true)"
    @mouseout="colorChange(false)"
    :class="{ 'mouse-over-bgcolor': isColor }"
  >
    <!-- <b-col cols="2" class="text-center align-self-center">
      <b-img
        thumbnail
        src="https://picsum.photos/250/250/?image=58"
        alt="Image 1"
      ></b-img>
    </b-col> -->
    <b-col cols="2">{{ house.aptCode }}</b-col>
    <b-col cols="4">{{ house.aptName }}</b-col>
    <b-col cols="2">{{ house.dongName }}</b-col>
    <b-col cols="1">{{ house.numOfFloors }}</b-col>
    <b-col cols="2"
      >{{
        (parseFloat(house.recentPrice.replace(",", "")) / 10000.0).toFixed(1)
      }}억</b-col
    >
    <b-col cols="1">{{ Math.floor(house.area / 3.3) }}평</b-col>
    <b-modal v-model="modalShow"><house-detail></house-detail></b-modal>
  </b-row>
</template>

<script>
import { mapActions } from "vuex";
import HouseDetail from "@/components/house/house_components/HouseDetail.vue";

const houseStore = "houseStore";

export default {
  name: "HouseListRow",
  components: {
    HouseDetail,
  },
  data() {
    return {
      isColor: false,
      modalShow: false,
    };
  },
  props: {
    house: Object,
  },
  methods: {
    ...mapActions(houseStore, ["detailHouse"]),
    selectHouse() {
      // console.log("listRow : ", this.house);
      // this.$store.dispatch("getHouse", this.house);
      this.detailHouse(this.house);
      this.modalShow = !this.modalShow;
    },
    colorChange(flag) {
      this.isColor = flag;
    },
  },
};
</script>

<style scoped>
.apt {
  width: 50px;
}
.mouse-over-bgcolor {
  background-color: rgba(173, 216, 230, 0.425);
}
.m-0 {
  border: 1px solid rgba(0, 0, 0, 0.034);
  border-radius: 40px 80px;
  position: relative;
  animation: fadeInDown 1s;
}
@keyframes fadeInDown {
  0% {
    opacity: 0;
    transform: translate3d(0, -100%, 0);
  }
  to {
    opacity: 1;
    transform: translateZ(0);
  }
}
</style>
