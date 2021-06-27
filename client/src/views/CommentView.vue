<template>
  <v-dialog
    v-model="isOpen"
    fullscreen
    hide-overlay
    transition="dialog-bottom-transition"
  >
    <v-toolbar dark color="primary">
      <v-btn icon dark @click="closeDialog">
        <v-icon>mdi-arrow-left</v-icon>
      </v-btn>
      <v-toolbar-title>뒤로가기</v-toolbar-title>
      <v-spacer></v-spacer>
    </v-toolbar>

    <v-card id="view">
      <v-row class="pa-5 pb-0 ">
        <v-textarea
          label="댓글을 입력하세요"
          auto-grow
          outlined
          rows="1"
          row-height="5"
        ></v-textarea>
        <v-btn class="mx-1 " height="55" depressed color="primary">작성</v-btn>
      </v-row>
      <v-divider />

      <!-- <comment
        v-for="(comment, index) in getCommentList"
        :key="index"
        :postId="postId"
        :commentId="comment.id"
        :nickName="comment.userNickName"
        :content="comment.content"
        :date="comment.modifyDate"
        :isLike="comment.isLike"
        :isWriter="comment.isWriter"
        class="my-1"
      /> -->
    </v-card>
  </v-dialog>
</template>

<script>
import Comment from "../components/Comment.vue";

export default {
  components: { Comment },
  name: "CommentView",
  props: ["open"],
  data() {
    return {};
  },
  mounted() {},

  created() {},

  destroyed() {},

  computed: {
    isOpen: {
      get() {
        return this.open;
      },
      set() {},
    },
  },

  methods: {
    closeDialog() {
      this.isOpen = false;
      this.$emit("close", true);
    },
  },
};
</script>
