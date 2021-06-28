<template>
  <v-container class="fill-height fill-width jusity-center" fluid="fluid">
    <v-layout
      row="row"
      justify-center="justify-center"
      align-center="align-center"
    >
      <v-flex xs12="xs12">
        <h1 class="text-center">로그인</h1>
        <v-form class="pa-3" ref="form">
          <v-text-field
            outlined="outlined"
            label="이름"
            prepend-icon="mdi-email"
            required="required"
            type="email"
            v-model="loginInput.name"
          ></v-text-field>

          <v-text-field
            outlined="outlined"
            prepend-icon="mdi-lock"
            label="패스워드"
            required="required"
            type="password"
            v-model="loginInput.password"
          ></v-text-field>

          <v-btn
            block="block"
            color="primary"
            class="my-3 pa-7"
            outlined="outlined"
            @click="login"
          >
            <v-icon left="left">mdi-login</v-icon>
            로그인
          </v-btn>

          <v-btn
            depressed="depressed"
            block="block"
            class="mt-3 text--right pa-7"
            color="primary"
            @click="onRegisterClick"
          >
            회원가입
          </v-btn>
        </v-form>
      </v-flex>
    </v-layout>
  </v-container>
</template>

<script>
import gql from "graphql-tag";
import pjson from "../../package.json";

export default {
  name: "Login",
  data() {
    return {
      loginInput: {
        name: "name1",
        password: "asas",
      },
      nextPath: this.$route.query.next ? this.$route.query.next : "/",
    };
  },
  mounted() {},
  destroyed() {},
  apollo: {},

  computed: {},
  components: {},
  methods: {
    async login() {
      await this.$apollo
        .mutate({
          mutation: gql`
            mutation($name: String!, $password: String!) {
              login(name: $name, password: $password)
            }
          `,
          variables: {
            name: this.loginInput.name,
            password: this.loginInput.password,
          },
        })
        .then((result) => {
          sessionStorage.setItem("accessKey", result.data.login);
          this.$router.push("/");
        })
        .catch((error) => {
          alert(error);
        });
    },

    onRegisterClick() {
      this.$router.push("/register");
    },
  },
};
</script>

<style scoped="scoped">
@media (min-width: 700px) {
  .login {
    width: 360px !important;
  }
}

.login {
  width: 80%;
  background-color: white;
  border-radius: 8px;
  border: white 1px solid;
  padding: 40px;
}
</style>
