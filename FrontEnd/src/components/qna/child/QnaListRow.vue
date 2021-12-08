<template>
  <b-tr class="m-0">
    <b-td>{{ q_no }}</b-td>
    <b-th class="text-left" v-if="open_status == 1">
      <router-link :to="{ name: 'QnaView', params: { q_no: q_no } }">
        {{ q_title }}<strong v-if="answer_status == 1">[답변완료]</strong>
      </router-link>
    </b-th>
    <b-th v-else>비밀글 입니다</b-th>
    <b-td>{{ hit }}</b-td>
    <b-td>{{ q_userid }}</b-td>
    <b-td>{{ q_regtime }}</b-td>
  </b-tr>
</template>

<script>
// import moment from "moment";

export default {
  name: "QnaListRow",
  props: {
    q_no: Number,
    q_userid: String,
    q_title: String,
    hit: Number,
    q_regtime: String,
    open_status: Boolean,
    answer_status: Boolean,
  },
  computed: {
    // changeDateFormat() {
    //   return moment(new Date(this.regtime)).format("YY.MM.DD hh:mm:ss");
    // },
  },
};
</script>

<style scoped>
.tdClass {
  width: 50px;
  text-align: center;
}
.tdSubject {
  width: 300px;
  text-align: left;
}
.m-0 {
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
