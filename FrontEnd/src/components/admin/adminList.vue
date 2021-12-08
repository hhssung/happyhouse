<template>
  <b-container class="bv-example-row mt-3">
    <b-col>
      <b-alert show><h3>답변관리게시판</h3></b-alert>
    </b-col>
    <b-row>
      <b-col v-if="articles.length">
        <b-table-simple hover responsive>
          <b-thead head-variant="dark">
            <b-tr>
              <b-th>글번호</b-th>
              <b-th>제목</b-th>
              <b-th>작성자</b-th>
              <b-th>작성일</b-th>
              <b-th>답변하기</b-th>
            </b-tr>
          </b-thead>
          <tbody>
            <!-- 하위 component인 ListRow에 데이터 전달(props) -->
            <testrow
              v-for="(article, index) in articles"
              :key="index"
              v-bind="article"
            />
          </tbody>
        </b-table-simple>
      </b-col>
      <b-col v-else class="text-center">모든 답변이 완료되었습니다.</b-col>
    </b-row>
  </b-container>
</template>

<script>
import testrow from "@/components/admin/child/ListRow.vue";
import { adminListArticle } from "@/api/qna.js";
export default {
  name: "adminList",
  components: {
    testrow,
  },
  data() {
    return {
      articles: [],
    };
  },
  created() {
    adminListArticle(
      (response) => {
        this.articles = response.data;
        if (!this.articles.length) {
          console.log("test");
        }
      },
      (error) => {
        console.log(error);
      }
    );
  },
};
</script>

<style></style>
