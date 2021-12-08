<template>
  <b-container class="bv-example-row mt-3 text-center test">
    <b-row class="m-0 justify-content-md-center">
      <!-- 아파트 이름, 일련번호, 법정동, 층수, 거래 금액 -->
      <b-col
        class="test1"
        cols="2"
        @click="sort(0)"
        @mouseover="colorChange(true, 0)"
        @mouseout="colorChange(false, 0)"
        :class="{ 'mouse-over-bgcolor': isColor[0].flag }"
        >일련번호<b-icon icon="chevron-expand" aria-hidden="true"></b-icon
      ></b-col>
      <b-col
        class="test1"
        cols="4"
        @click="sort(1)"
        @mouseover="colorChange(true, 1)"
        @mouseout="colorChange(false, 1)"
        :class="{ 'mouse-over-bgcolor': isColor[1].flag }"
        >아파트 이름<b-icon icon="chevron-expand" aria-hidden="true"></b-icon
      ></b-col>
      <b-col
        class="test1"
        cols="2"
        @click="sort(2)"
        @mouseover="colorChange(true, 2)"
        @mouseout="colorChange(false, 2)"
        :class="{ 'mouse-over-bgcolor': isColor[2].flag }"
        >법정동<b-icon icon="chevron-expand" aria-hidden="true"></b-icon
      ></b-col>
      <b-col
        class="test1"
        cols="1"
        @click="sort(3)"
        @mouseover="colorChange(true, 3)"
        @mouseout="colorChange(false, 3)"
        :class="{ 'mouse-over-bgcolor': isColor[3].flag }"
        >층수<b-icon icon="chevron-expand" aria-hidden="true"></b-icon
      ></b-col>
      <b-col
        class="test1"
        cols="2"
        @click="sort(4)"
        @mouseover="colorChange(true, 4)"
        @mouseout="colorChange(false, 4)"
        :class="{ 'mouse-over-bgcolor': isColor[4].flag }"
        >거래 금액<b-icon icon="chevron-expand" aria-hidden="true"></b-icon
      ></b-col>
      <b-col
        class="test1"
        cols="1"
        @click="sort(5)"
        @mouseover="colorChange(true, 5)"
        @mouseout="colorChange(false, 5)"
        :class="{ 'mouse-over-bgcolor': isColor[5].flag }"
        >평수<b-icon icon="chevron-expand" aria-hidden="true"></b-icon
      ></b-col> </b-row
  ></b-container>
</template>

<script>
import { mapMutations } from "vuex";

const houseStore = "houseStore";

// 삽질한거 : https://ux.stories.pe.kr/193

export default {
  data() {
    return {
      isColor: [
        { flag: false },
        { flag: false },
        { flag: false },
        { flag: false },
        { flag: false },
        { flag: false },
      ],
      parseobj: false,
    };
  },
  methods: {
    ...mapMutations(houseStore, ["SORT"]),
    sort(idx) {
      this.SORT(idx);
    },
    colorChange(flag, idx) {
      this.isColor[idx].flag = flag;
    },
  },
};
</script>

<style scoped>
.test {
  border-top: 1px solid rgba(0, 0, 0, 0.178);
  border-bottom: 1px solid rgba(0, 0, 0, 0.178);
  padding: 20px;
}
.mouse-over-bgcolor {
  background-color: rgba(173, 216, 230, 0.425);
}
</style>
