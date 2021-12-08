<template>
  <b-tr class="m-0">
    <b-td>{{ q_no }}</b-td>
    <b-td>{{ q_title }}</b-td>
    <b-td>{{ q_userid }}</b-td>
    <b-td>{{ q_regtime }}</b-td>
    <b-td><b-button @click="showModal">답변하기</b-button></b-td>
    <b-modal v-model="modalShow" title="답변하기" @ok="test">
      <b-list-group>
        <b-list-group-item>
          글번호:
          {{ q_no }}</b-list-group-item
        >
        <b-list-group-item>제목: {{ q_title }}</b-list-group-item>
        <b-list-group-item>내용: {{ q_content }}</b-list-group-item>
        <b-list-group-item
          >답변내용 :
          <b-form-textarea
            id="textarea"
            v-model="answer_context"
            placeholder="답변내용 입력하기..."
            rows="3"
            max-rows="6"
          ></b-form-textarea
        ></b-list-group-item>
      </b-list-group>
    </b-modal>
  </b-tr>
</template>

<script>
import { writeAnswer } from "@/api/qna";
//import modal from "@/components/admin/child/modal";
export default {
  name: "testrow",
  props: {
    q_no: Number,
    q_userid: String,
    q_title: String,
    q_content: String,
    hit: Number,
    q_regtime: String,
    open_status: Boolean,
    answer_status: Boolean,
  },
  data() {
    return {
      modalShow: false,
      answer_context: "",
    };
  },
  created() {},
  methods: {
    sendAnswer() {
      this.q_no,
        ({ data }) => {
          let msg = "등록처리 오류";
          if (data === "success") {
            msg = "등록이 완료되었습니다";
          }
          alert(msg);
          this.moveList();
        },
        (error) => {
          console.log(error);
        };
    },
    showModal() {
      this.modalShow = !this.modalShow;
    },
    test() {
      writeAnswer(
        this.$props.q_no,
        {
          q_no: this.$props.q_no,
          a_userid: "ssafy",
          a_content: this.answer_context,
        },
        ({ data }) => {
          let msg = "등록처리 오류";
          if (data === "success") {
            msg = "등록이 완료되었습니다";
          }
          alert(msg);
        },
        (error) => {
          console.log(error);
        }
      );
    },
  },
};
</script>

<style scoped>
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
