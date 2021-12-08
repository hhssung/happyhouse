<template>
  <b-container>
    <b-col>
      <b-alert show><h3>회원관리</h3></b-alert>
    </b-col>
    <b-row>
      <b-table-simple>
        <b-thead head-variant="dark">
          <b-tr>
            <b-th>유저 아이디</b-th>
            <b-th>유저 이름</b-th>
            <b-th>이메일</b-th>
            <b-th>가입날짜</b-th>
            <b-th>비고</b-th>
          </b-tr>
        </b-thead>
        <tbody>
          <memberRow
            v-for="(article, index) in articles"
            :key="index"
            v-bind="article"
          />
        </tbody>
      </b-table-simple>
    </b-row>
  </b-container>
</template>

<script>
import { allUsers } from "@/api/member";
import memberRow from "@/components/admin/child/memberRow.vue";
export default {
  data() {
    return {
      articles: [],
    };
  },
  components: {
    memberRow,
  },
  created() {
    allUsers(
      (response) => {
        this.articles = response.data;
        console.log(this.articles);
      },
      (error) => {
        console.log(error);
      }
    );
  },
};
</script>

<style></style>
