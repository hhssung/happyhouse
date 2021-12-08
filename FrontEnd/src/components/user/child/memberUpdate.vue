<template>
  <b-container>
    <b-row class="m-0">
      <b-col cols="2"></b-col>
      <b-col cols="2" align-self="end">아이디</b-col
      ><b-col cols="4" align-self="start">{{ userInfo.userid }}</b-col>
      <b-col cols="2"></b-col>
    </b-row>
    <b-row class="m-1">
      <b-col cols="2"></b-col>
      <b-col cols="2" align-self="end">이름</b-col
      ><b-col cols="4" align-self="start">{{
      userInfo.username
      }}</b-col>
      <b-col cols="2"></b-col>
    </b-row>
    <b-row class="m-2">
      <b-col cols="2"></b-col>
      <b-col cols="2" align-self="end">이메일</b-col
      ><b-col cols="4" align-self="start">{{ userInfo.email }}</b-col>
      <b-col cols="2"></b-col>
    </b-row>
    <b-row class="m-3">
      <b-col cols="2"></b-col>
      <b-col cols="2" align-self="end">가입일</b-col
      ><b-col cols="4" align-self="start">{{
      userInfo.joindate
      }}</b-col>
      <b-col cols="2"></b-col>
    </b-row>
  </b-container>
</template>

<script>
export default {

}
</script>

<style>

</style>