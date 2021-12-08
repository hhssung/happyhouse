<template>
  <b-container class="bv-example-row mt-3">
    <b-row>
      <b-col>
        <b-alert variant="secondary" show><h3>회원가입</h3></b-alert>
      </b-col>
    </b-row>
    <b-form @submit="onSubmit">
      <b-form-group
        label-cols="4"
        label-cols-lg="2"
        label="ID"
        label-for="idField"
        ><b-form-input
          id="idField"
          ref="userid"
          v-model="article.userid"
        ></b-form-input>
      </b-form-group>
      <b-form-group
        label-cols="4"
        label-cols-lg="2"
        label="Name"
        label-for="nameField"
        ><b-form-input
          id="nameField"
          ref="username"
          v-model="article.username"
        ></b-form-input>
      </b-form-group>
      <b-form-group
        label-cols="4"
        label-cols-lg="2"
        label="PassWord"
        label-for="pwdField"
        ><b-form-input
          id="pwdField"
          ref="userpwd"
          v-model="article.userpwd"
        ></b-form-input>
      </b-form-group>
      <b-form-group
        label-cols="4"
        label-cols-lg="2"
        label="E-mail"
        label-for="emailField"
        ><b-form-input
          id="emailField"
          ref="email"
          v-model="article.email"
        ></b-form-input>
      </b-form-group>
      <b-button type="submit" variant="primary" class="m-1">회원가입</b-button>
      <b-button type="button" variant="primary" class="m-1" @click="moveList"
        >돌아가기</b-button
      >
    </b-form>
  </b-container>
</template>

<script>
import { join } from "@/api/member.js";
export default {
  name: "MemberJoin",
  data() {
    return {
      article: {
        userid: "",
        username: "",
        userpwd: "",
        email: "",
        joindate: "",
      },
      type: "",
    };
  },
  methods: {
    onSubmit(event) {
      event.preventDefault();

      let err = true;
      let msg = "";
      if (!err) alert(msg);

      join(
        this.article,
        () => {
          alert("회원가입을 축하드립니다!");
          this.moveList();
        },
        (error) => {
          console.log(error);
        }
      );
    },
    moveList() {
      this.$router.push({ name: "Home" });
    },
  },
};
</script>

<style></style>
