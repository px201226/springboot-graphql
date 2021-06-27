<template>
  <v-app-bar app color="primary" dark>
    <div class="d-flex align-center">
      <v-list-item> GraphQL 게시판 </v-list-item>
    </div>

    <v-spacer></v-spacer>

    <div v-if="!isLogin">
       <v-btn target="_blank" text>
        로그아웃
      </v-btn>
    </div>
    
    <div v-if="!isLogin">
      <v-btn target="_blank" text >
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

  created() {},
  computed: {
    isLogin() {
      return this.$store.getters.GET_IS_LOGIN;
    },
  },
  methods: {

   
  },
};
</script>
