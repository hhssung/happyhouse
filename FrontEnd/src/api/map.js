import { apiInstance } from "./index.js";

const api = apiInstance();

function yososuList(success, fail) {
  api.get(`/map/yososu`).then(success).catch(fail);
}

export { yososuList };
