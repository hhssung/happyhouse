<template>
  <b-tr class="m-0">
    <b-td>{{ userid }}</b-td>
    <b-td>{{ username }}</b-td>
    <b-td>{{ email }}</b-td>
    <b-td>{{ joindate | timeForToday }}</b-td>
    <b-td
      ><b-button variant="danger" @click="deleteTest">삭제하기</b-button></b-td
    >
  </b-tr>
</template>

<script>
import { deleteUser } from "@/api/member";
export default {
  props: {
    userid: String,
    username: String,
    email: String,
    joindate: String,
  },
  methods: {
    deleteTest() {
      deleteUser(
        this.$props.userid,
        (response) => {
          if (response) {
            this.$router.go();
          }
        },
        (error) => {
          console.log(error);
        }
      );
    },
  },
  filters: {
    timeForToday(value) {
      const today = new Date();
      const timeValue = new Date(value);
      const betweenTime = Math.floor(
        (today.getTime() - timeValue.getTime()) / 1000 / 60
      );
      if (betweenTime < 1) return "방금전";
      if (betweenTime < 60) {
        return `${betweenTime}분전`;
      }
      const betweenTimeHour = Math.floor(betweenTime / 60);
      if (betweenTimeHour < 24) {
        return `${betweenTimeHour}시간전`;
      }
      const betweenTimeDay = Math.floor(betweenTime / 60 / 24);
      if (betweenTimeDay < 365) {
        return `${betweenTimeDay}일전`;
      }
      return `${Math.floor(betweenTimeDay / 365)}년전`;
    },
  },
};
</script>

<style scoped>
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
