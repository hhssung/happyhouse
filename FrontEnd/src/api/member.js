import { apiInstance } from "./index.js";

const api = apiInstance();

async function login(user, success, fail) {
  await api.post(`/user/login`, JSON.stringify(user)).then(success).catch(fail);
}

async function findById(userid, success, fail) {
  api.defaults.headers["access-token"] = sessionStorage.getItem("access-token");
  await api.get(`/user/info/${userid}`).then(success).catch(fail);
}

function join(user, success, fail) {
  api.post(`/user/join`, JSON.stringify(user)).then(success).catch(fail);
}
// function logout(success, fail)
function allUsers(success, fail) {
  api.get(`/admin/allUser`).then(success).catch(fail);
}

function deleteUser(userid, success, fail) {
  api.delete(`/admin/deleteUser/${userid}`).then(success).catch(fail);
}

export { login, findById, join, allUsers, deleteUser };
