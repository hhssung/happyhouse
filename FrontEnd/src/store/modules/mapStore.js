import { yososuList } from "@/api/map.js";

const mapStore = {
  namespaced: true,
  state: {
    yososuInfo: null,
  },
  getters: {},
  mutations: {
    SET_YOSOSU_INFO: (state, yososu) => {
      console.log(yososu);
      state.yososuInfo = yososu;
    },
  },
  actions: {
    getYososuList: ({ commit }) => {
      yososuList(
        ({ data }) => {
          //   console.log(response.data.response.body.items.item);
          commit("SET_YOSOSU_INFO", data);
        },
        (error) => {
          console.log(error);
        }
      );
    },
  },
};

export default mapStore;
