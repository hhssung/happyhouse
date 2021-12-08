<template>
  <b-row class="mb-1">
    <b-col style="text-align: left">
      <b-form @submit="onSubmit" @reset="onReset">
        <b-form-group
          id="userid-group"
          label="작성자:"
          label-for="userid"
          description="작성자를 입력하세요."
        >
          <b-form-input
            id="userid"
            :disabled="isUserid"
            v-model="article.q_userid"
            type="text"
            required
            placeholder="작성자 입력..."
          ></b-form-input>
        </b-form-group>

        <b-form-group
          id="subject-group"
          label="제목:"
          label-for="subject"
          description="제목을 입력하세요."
        >
          <b-form-input
            id="subject"
            v-model="article.q_title"
            type="text"
            required
            placeholder="제목 입력..."
          ></b-form-input>
        </b-form-group>

        <b-form-group id="content-group" label="내용:" label-for="content">
          <b-form-textarea
            id="content"
            v-model="article.q_content"
            placeholder="내용 입력..."
            rows="10"
            max-rows="15"
          ></b-form-textarea>
        </b-form-group>
        <b-form-group id="content-group" label="공개여부" label-for="content">
          <b-form-checkbox
            id="checkbox-1"
            v-model="article.open_status"
            name="openYN"
            value="true"
            unchecked-value="false"
          >
            공개여부
          </b-form-checkbox>
        </b-form-group>
        <b-button
          type="submit"
          variant="primary"
          class="m-1"
          v-if="this.type === 'register'"
          >글작성</b-button
        >
        <b-button type="submit" variant="primary" class="m-1" v-else
          >글수정</b-button
        >
        <b-button type="reset" variant="danger" class="m-1">초기화</b-button>
      </b-form>
    </b-col>
  </b-row>
</template>

<script>
import { writeArticle, getArticle, modifyArticle } from "@/api/qna";
export default {
  name: "QnaWriteForm",
  data() {
    return {
      article: {
        q_no: 0,
        q_userid: "",
        q_title: "",
        q_content: "",
      },
      state: "test",
      isUserid: false,
    };
  },
  props: {
    type: { type: String },
  },
  created() {
    if (this.type === "modify") {
      // http.get(`/qna/${this.$route.params.q_no}`).then(({ data }) => {
      //   this.article = data;
      // });
      getArticle(
        this.$route.params.q_no,
        ({ data }) => {
          this.article = data;
        },
        (error) => {
          console.log(error);
        }
      );
      this.isUserid = true;
    }
  },
  methods: {
    onSubmit(event) {
      event.preventDefault();

      let err = true;
      let msg = "";
      !this.article.q_userid &&
        ((msg = "작성자 입력해주세요"),
        (err = false),
        this.$refs.userid.focus());
      err &&
        !this.article.q_title &&
        ((msg = "제목 입력해주세요"),
        (err = false),
        this.$refs.subject.focus());
      err &&
        !this.article.q_content &&
        ((msg = "내용 입력해주세요"),
        (err = false),
        this.$refs.content.focus());

      if (!err) alert(msg);
      else
        this.type === "register" ? this.registArticle() : this.updateArticle();
    },
    onReset(event) {
      event.preventDefault();
      this.article.q_no = 0;
      this.article.q_title = "";
      this.article.q_content = "";
      this.$router.push({ name: "QnaList" });
    },
    registArticle() {
      // http
      //   .post(`/qna`, {
      //     q_userid: this.article.q_userid,
      //     q_title: this.article.q_title,
      //     q_content: this.article.q_content,
      //   })
      //   .then(({ data }) => {
      //     let msg = "등록 처리시 문제가 발생했습니다.";
      //     if (data === "success") {
      //       msg = "등록이 완료되었습니다.";
      //     }
      //     alert(msg);
      //     this.moveList();
      //   });
      writeArticle(
        {
          q_userid: this.article.q_userid,
          q_title: this.article.q_title,
          q_content: this.article.q_content,
          open_status: this.open_status,
        },
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
        }
      );
    },
    updateArticle() {
      modifyArticle(
        {
          q_no: this.article.q_no,
          q_userid: this.article.q_userid,
          q_title: this.article.q_title,
          q_content: this.article.q_content,
          open_status: this.open_status,
        },
        ({ data }) => {
          let msg = "수정 처리시 문제가 발생했습니다.";
          if (data === "success") {
            msg = "수정이 완료되었습니다.";
          }
          alert(msg);
          this.$router.push({ name: "QnaList" });
        },
        (error) => {
          console.log(error);
        }
      );
    },
    moveList() {
      this.$router.push({ name: "QnaList" });
    },
  },
};
</script>

<style></style>
