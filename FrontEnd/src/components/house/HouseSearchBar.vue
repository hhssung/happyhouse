<template>
  <b-container class="bv-example-row mt-4">
    <!-- <b-col class="sm-3">
      <b-form-input
        v-model.trim="dongCode"
        placeholder="동코드 입력...(예 : 11110)"
        @keypress.enter="sendKeyword"
      ></b-form-input>
    </b-col>
    <b-col class="sm-3" align="left">
      <b-button variant="outline-primary" @click="sendKeyword">검색</b-button>
    </b-col> -->
    <b-row class="mb-3">
      <b-col>시/도 선택:</b-col>
      <b-col>구/군 선택:</b-col>
      <b-col>년/월 선택:</b-col>
      <b-col>출력 개수 선택:</b-col>
    </b-row>
    <b-row class="mb-3">
      <b-col
        ><b-form-select
          v-model="sidoCode"
          :options="sidos"
          @change="gugunList"
        ></b-form-select
      ></b-col>
      <b-col>
        <b-form-select
          v-model="gugunCode"
          :options="guguns"
          @change="searchApt(1)"
        ></b-form-select
      ></b-col>
      <b-col
        ><b-form-datepicker
          id="example-datepicker"
          @context="onContext"
          class="mb-2"
          locale="kor"
        ></b-form-datepicker
      ></b-col>
      <b-col>
        <b-form-select
          v-model="pageOptions"
          :options="numOfRows"
          @change="searchApt(1)"
        ></b-form-select>
      </b-col>
    </b-row>
  </b-container>
</template>

<script>
import { mapState, mapActions, mapMutations } from "vuex";
import { eventBus } from "@/views/House.vue";

/*
  namespaced: true를 사용했기 때문에 선언해줍니다.
  index.js 에서 modules 객체의 '키' 이름입니다.

  modules: {
    키: 값
    memberStore: memberStore,
    houseStore: houseStore
  }  
*/
const houseStore = "houseStore";

export default {
  name: "HouseSearchBar",
  data() {
    return {
      sidoCode: null,
      gugunCode: null,
      pageOptions: 10,
      yyyymm: null,
      dd: null,
    };
  },
  created() {
    // this.$store.dispatch("getSido");
    // this.sidoList();
    console.log("created");
    this.CLEAR_SIDO_LIST();
    this.CLEAR_HOUSE_LIST();
    this.CLEAR_DETAIL_HOUSE();
    this.CLEAR_SORT_ORDER();
    this.getSido();
    // 이벤트 버스 등록
    eventBus.$on("changePage", this.searchApt);
  },
  beforeDestroy() {
    // 이벤트 버스 지우기
    eventBus.$off("changePage");
  },
  computed: {
    ...mapState(houseStore, ["sidos", "guguns", "numOfRows"]),
    // sidos() {
    //   return this.$store.state.sidos;
    // },
  },
  methods: {
    ...mapActions(houseStore, ["getSido", "getGugun", "getHouseList"]),
    ...mapMutations(houseStore, [
      "CLEAR_SIDO_LIST",
      "CLEAR_GUGUN_LIST",
      "CLEAR_HOUSE_LIST",
      "CLEAR_DETAIL_HOUSE",
      "CLEAR_SORT_ORDER",
    ]),
    // sidoList() {
    //   this.getSido();
    // },
    gugunList() {
      // console.log(this.sidoCode);
      this.CLEAR_GUGUN_LIST();
      this.gugunCode = null;
      if (this.sidoCode) this.getGugun(this.sidoCode);
    },
    onContext(ctx) {
      var str = ctx.selectedYMD;
      var strings = str.split("-");
      // 여러 번 API 호출 막기
      if (this.yyyymm == strings[0] + strings[1]) return;
      this.yyyymm = strings[0] + strings[1];
      this.dd = strings[2];
      this.searchApt(1);
    },
    searchApt(page) {
      const params = {
        gugunCode: this.gugunCode,
        pageNo: page,
        numOfRows: this.pageOptions,
        date: this.yyyymm,
      };
      console.log("searchApt call");
      if (this.yyyymm !== "undefined" && this.gugunCode) {
        this.getHouseList(params);
        this.CLEAR_SORT_ORDER();
      }
    },
  },
};
</script>

<style></style>
