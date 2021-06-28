<template>
  <v-app-bar app color="primary" dark>
    <div class="d-flex align-center">
      <v-list-item> GraphQL 게시판 </v-list-item>
    </div>

    <v-spacer></v-spacer>

    <div v-if="isLogin">
      <v-btn target="_blank" text @click="onLogoutClick">
        로그아웃
      </v-btn>
    </div>

    <div v-if="!isLogin">
      <v-btn target="_blank" text @click="onLoginClick">
        로그인
        <v-icon>mdi-login</v-icon>
      </v-btn>
    </div>
  </v-app-bar>
</template>

<script>
export default {
  name: "AppBar",
  components: {},
  data(){
    return {
      login: sessionStorage.getItem('accessKey')
    }
  },
  created() {
    console.log("create")
  },
  watch: {
    isLogin() {
      return this.login;
    },
  },
  methods: {
    onLoginClick() {
      this.$router.push("/login");
    },

    onLogoutClick() {
      sessionStorage.setItem('accesskey','');
      this.login = '';
    },
  },
};
</script>
