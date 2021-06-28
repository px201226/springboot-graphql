<template>
  <v-card class="pa-2" contextmenu="" flat outlined>
    <v-row row class="my-1">
      <v-col class="flex-grow-0 flex-shrink-0">
        <v-avatar size="36px">
          <img src="@/assets/no_profile.gif" alt="John" />
        </v-avatar>
      </v-col>

      <v-col>
        <v-row>
          <div class="text--primary font-weight-bold">
            {{ nickName }}
          </div>
        </v-row>
        <v-row>
          <div class="font-weight-light">{{ date }}</div>
        </v-row>
      </v-col>
    </v-row>

<v-row>
    <div class="font-weight-regular mx-4 my-2">
      {{ content }}
    </div>
</v-row>

    <v-card-actions>
      <v-btn text color="" class="ml-auto" @click="openCommentView">
        댓글 {{ comments }}개
      </v-btn>
    </v-card-actions>
    <CommentView
      :open="getIsOpenPostView"
      :postid="getIsPostId"
      @close="closeCommentView"
    />
  </v-card>
</template>

<script>
import CommentView from "../views/CommentView.vue";

export default {
  name: "PostItem",
  components: { CommentView },
  props: [
    "id",
    "nickName",
    "date",
    "likes",
    "comments",
    "content",
    "isLike",
    "isWriter",
  ],

  data() {
    return {
      isOpenCommentView: false,
      like: this.isLike,
      mlikes: this.likes,
      expand: false,
      expand2: false,
    };
  },

  computed: {
    getIsPostId() {
      return this.id;
    },
    getIsOpenPostView() {
      return this.isOpenCommentView;
    },
  },

  methods: {
    openCommentView() {
      this.isOpenCommentView = true;
      console.log("ddddddddddddddd");
    },

    closeCommentView() {
      this.isOpenCommentView = false;
    },
  },
};
</script>
