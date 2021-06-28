/* ## BoardList.vue 내용 */
<template>
  <div class="pa-3">
    <v-col class="text-right">
      <v-row>
        <v-btn block color="primary" @click="openPostWrite">게시글 작성</v-btn>
        <post-write :open="getIsOpenPostWrite" @close="closePostWrite" />
      </v-row>

      <v-row>
        <v-col>
          <div id="posts">
      <post-item
        v-for="(post, index) in posts"
        :key="index"
        :id="post.id"
        :nickName="post.user.name"
        :content="post.title"
        :date="post.createDateTime"
        :likes="post.likes"
        :isLike="post.isLike"
        :comments="post.comments.length"
        :isWriter="post.isWriter"
        class="my-3"
      >
      </post-item>
    </div>

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
    posts: gql`
      query {
        posts {
          id
          title
          createDateTime
          user{
            name
          }
          comments{
            id
          }
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
