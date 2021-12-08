import { apiInstance } from "./index.js";

const api = apiInstance();

function listArticle(param, success, fail) {
  api.get(`/qna/adminquestion`, { params: param }).then(success).catch(fail);
}

function adminListArticle(success, fail) {
  api.get(`/qna/question`).then(success).catch(fail);
}

function writeArticle(article, success, fail) {
  api.post(`/qna/question`, JSON.stringify(article)).then(success).catch(fail);
}

function getArticle(articleno, success, fail) {
  api.get(`/qna/question/${articleno}`).then(success).catch(fail);
}

function modifyArticle(article, success, fail) {
  api.put(`/qna/question`, JSON.stringify(article)).then(success).catch(fail);
}

function deleteArticle(articleno, success, fail) {
  api.delete(`/qna/question/${articleno}`).then(success).catch(fail);
}
function writeAnswer(articleno, article, success, fail) {
  api
    .post(`/qna/answer/${articleno}`, JSON.stringify(article))
    .then(success)
    .catch(fail);
}
export {
  listArticle,
  writeAnswer,
  writeArticle,
  getArticle,
  modifyArticle,
  deleteArticle,
  adminListArticle,
};
