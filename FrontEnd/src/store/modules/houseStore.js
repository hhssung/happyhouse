import { sidoList, gugunList, houseList } from "@/api/house.js";
import { sortFunctions } from "@/store/modules/houseStore_sort.js";

const houseStore = {
  namespaced: true,
  state: {
    sidos: [{ value: null, text: "선택하세요" }],
    guguns: [{ value: null, text: "선택하세요" }],
    numOfRows: [
      { value: 10, text: "10개" },
      { value: 25, text: "25개" },
      { value: 50, text: "50개" },
    ],
    houses: [],
    house: null,
    rows: 1,
    sort_order: [0, 0, 0, 0, 0, 0],
  },

  getters: {},

  mutations: {
    SET_SIDO_LIST: (state, sidos) => {
      sidos.forEach((sido) => {
        state.sidos.push({ value: sido.sidoCode, text: sido.sidoName });
      });
    },
    SET_GUGUN_LIST: (state, guguns) => {
      guguns.forEach((gugun) => {
        state.guguns.push({ value: gugun.gugunCode, text: gugun.gugunName });
      });
    },
    CLEAR_SIDO_LIST: (state) => {
      state.sidos = [{ value: null, text: "선택하세요" }];
    },
    CLEAR_GUGUN_LIST: (state) => {
      state.guguns = [{ value: null, text: "선택하세요" }];
    },
    SET_HOUSE_LIST: (state, houses) => {
      console.log(houses);
      state.houses = houses;
    },
    CLEAR_HOUSE_LIST: (state) => {
      state.houses = [];
    },
    SET_DETAIL_HOUSE: (state, house) => {
      state.house = house;
    },
    CLEAR_DETAIL_HOUSE: (state) => {
      state.house = null;
    },
    CLEAR_SORT_ORDER: (state) => {
      state.sort_order = [0, 0, 0, 0, 0, 0];
    },
    SET_ROWS: (state, houses) => {
      if (houses && houses.length != 0) {
        state.rows = houses[0].totalPages;
      } else {
        state.rows = 1;
      }
    },
    SORT: (state, idx) => {
      var asc;
      var desc;
      switch (idx) {
        case 0:
          asc = sortFunctions.sortByAptCodeAsc;
          desc = sortFunctions.sortByAptCodeDesc;
          break;
        case 1:
          asc = sortFunctions.sortByAptNameAsc;
          desc = sortFunctions.sortByAptNameDesc;
          break;
        case 2:
          asc = sortFunctions.sortByDongNameAsc;
          desc = sortFunctions.sortByDongNameDesc;
          break;
        case 3:
          asc = sortFunctions.sortByNumOfFloorsAsc;
          desc = sortFunctions.sortByNumOfFloorsDesc;
          break;
        case 4:
          asc = sortFunctions.sortByRecentPriceAsc;
          desc = sortFunctions.sortByRecentPriceDesc;
          break;
        default:
          asc = sortFunctions.sortByAreaAsc;
          desc = sortFunctions.sortByAreaDesc;
          break;
      }
      if (state.sort_order[idx] == 0) {
        state.houses = state.houses.sort(asc);
        state.sort_order[idx] = 1;
      } else {
        state.houses = state.houses.sort(desc);
        state.sort_order[idx] = 0;
      }
    },
  },

  actions: {
    getSido: ({ commit }) => {
      sidoList(
        ({ data }) => {
          // console.log(data);
          commit("SET_SIDO_LIST", data);
        },
        (error) => {
          console.log(error);
        }
      );
    },
    getGugun: ({ commit }, sidoCode) => {
      const params = {
        sido: sidoCode,
      };
      gugunList(
        params,
        ({ data }) => {
          // console.log(commit, response);
          commit("SET_GUGUN_LIST", data);
        },
        (error) => {
          console.log(error);
        }
      );
    },
    getHouseList: ({ commit }, params) => {
      houseList(
        params,
        ({ data }) => {
          //   console.log(response.data.response.body.items.item);
          commit("SET_HOUSE_LIST", data);
          commit("SET_ROWS", data);
        },
        (error) => {
          console.log(error);
        }
      );
    },
    detailHouse: ({ commit }, house) => {
      // 나중에 house.일련번호를 이용하여 API 호출
      commit("SET_DETAIL_HOUSE", house);
    },
  },
};

export default houseStore;
