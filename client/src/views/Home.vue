/* ## BoardList.vue 내용 */
<template>
  <div class="pa-3">
    <v-col class="text-right">
      <v-row>
        <v-btn block color="primary" @click="openPostWrite">게시글 작성</v-btn>
        <post-write :open="getIsOpenPostWrite" @close="closePostWrite" />
      </v-row>

      {{ findAllUser }}
      <v-row>
        <v-col>
          <post-item > </post-item>
        </v-col>
      </v-row>
    </v-col>
  </div>
</template>

<script>
import PostItem from "../components/PostItem.vue";
import PostWrite from "./PostWrite.vue";
import gql from "graphql-tag";
import pjson from "../../package.json";

export default {
  name: "Home",
  components: { PostItem, PostWrite },

  data() {
    return {
      isOpenPostWrite: false,
    };
  },
  apollo: {
    findAllUser: gql`
      query {
        findAllUser {
          name
        }
      }
    `,
  },
  created() {},

  computed: {
    getIsOpenPostWrite() {
      return this.isOpenPostWrite;
    },

  },

  methods: {
    openPostWrite() {
      this.isOpenPostWrite = true;
    },

    closePostWrite() {
      this.isOpenPostWrite = false;
    },


  },
};
</script>
