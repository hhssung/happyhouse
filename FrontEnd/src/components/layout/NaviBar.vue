<template>
  <div>
    <b-navbar toggleable="lg" type="dark" variant="dark">
      <b-navbar-brand href="#">
        <router-link to="/">
          <img
            src="@/assets/ssafy_logo.png"
            class="d-inline-block align-middle"
            width="90px"
            alt="Kitten"
          />
        </router-link>
      </b-navbar-brand>

      <b-navbar-toggle target="nav-collapse"></b-navbar-toggle>

      <b-collapse id="nav-collapse" is-nav>
        <b-navbar-nav>
          <b-nav-item href="#"
            ><b-button class="buttoncolor" variant="link" @click="goHome"
              ><b-icon icon="house" font-scale="1"></b-icon> HOME</b-button
            >
          </b-nav-item>
          <b-nav-item href="#"
            ><b-button class="buttoncolor" variant="link" @click="goBoard"
              ><b-icon icon="journal" font-scale="1"></b-icon> Board</b-button
            >
          </b-nav-item>
          <b-nav-item href="#"
            ><b-button class="buttoncolor" variant="link" @click="goInstargram"
              ><b-icon icon="instagram" font-scale="1"></b-icon>
              instagram</b-button
            >
          </b-nav-item>
          <b-nav-item href="#"
            ><b-button class="buttoncolor" variant="link" @click="goHouse"
              ><b-icon icon="house-fill" font-scale="1"></b-icon>
              아파트정보</b-button
            >
          </b-nav-item>
          <b-nav-item href="#"
            ><b-button class="buttoncolor" variant="link" @click="goQnA"
              ><b-icon icon="question-circle-fill" font-scale="1"></b-icon>
              QnA</b-button
            >
          </b-nav-item>
          <b-nav-item href="#"
            ><b-button class="buttoncolor" variant="link" @click="goMap"
              ><b-icon icon="map-fill" font-scale="1"></b-icon> 요소수</b-button
            >
          </b-nav-item>
          <b-nav-item href="#"
            ><b-button class="buttoncolor" variant="link" @click="goAdmin"
              >관리자페이지</b-button
            ></b-nav-item
          >
        </b-navbar-nav>

        <b-navbar-nav class="ml-auto" v-if="userInfo">
          <b-nav-item class="align-self-center"
            ><b-avatar
              variant="primary"
              v-text="userInfo ? userInfo.userid.charAt(0).toUpperCase() : ''"
            ></b-avatar
            >{{ userInfo.username }}({{ userInfo.userid }})님
            환영합니다.</b-nav-item
          >
          <b-nav-item class="align-self-center"
            ><router-link
              :to="{ name: 'MyPage' }"
              class="link align-self-center"
              >내정보보기</router-link
            ></b-nav-item
          >
          <b-nav-item
            class="link align-self-center"
            @click.prevent="onClickLogout"
            >로그아웃</b-nav-item
          >
        </b-navbar-nav>
        <b-navbar-nav class="ml-auto" v-else>
          <b-nav-item-dropdown right>
            <template #button-content>
              <b-icon icon="people" font-scale="2"></b-icon>
            </template>
            <b-dropdown-item href="#"
              ><router-link :to="{ name: 'SignUp' }" class="link"
                ><b-icon icon="person-circle"></b-icon> 회원가입</router-link
              ></b-dropdown-item
            >
            <b-dropdown-item href="#">
              <router-link :to="{ name: 'SignIn' }" class="link"
                ><b-icon icon="key"></b-icon> 로그인</router-link
              ></b-dropdown-item
            >
          </b-nav-item-dropdown>
        </b-navbar-nav>
      </b-collapse>
    </b-navbar>
  </div>
</template>

<script>
import { mapState, mapMutations } from "vuex";
const memberStore = "memberStore";

export default {
  name: "NaviBar",
  computed: {
    ...mapState(memberStore, ["isLogin", "userInfo"]),
  },
  methods: {
    ...mapMutations(memberStore, ["SET_IS_LOGIN", "SET_USER_INFO"]),
    onClickLogout() {
      this.SET_IS_LOGIN(false);
      this.SET_USER_INFO(null);
      sessionStorage.removeItem("access-token");
      if (this.$route.path != "/") this.$router.push({ name: "Home" });
    },
    goHome() {
      this.$router.push({ name: "Home" });
    },
    goBoard() {
      this.$router.push({ name: "Board" });
    },
    goInstargram() {
      this.$router.push({ name: "Instargram" });
    },
    goHouse() {
      this.$router.push({ name: "House" });
    },
    goQnA() {
      this.$router.push({ name: "QnA" });
    },
    goAdmin() {
      this.$router.push({ name: "admin" });
    },
    goMap() {
      this.$router.push({ name: "Map" });
    },
  },
};
</script>

<style scoped>
.buttoncolor {
  color: rgb(96, 167, 207);
}
</style>
