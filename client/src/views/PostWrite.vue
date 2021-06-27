<template>
  <v-dialog
    v-model="isOpen"
    fullscreen
    hide-overlay
    transition="dialog-bottom-transition"
  >
    <v-card>
      <v-toolbar dark color="primary">
        <v-btn icon dark @click="closeDialog">
          <v-icon>mdi-close</v-icon>
        </v-btn>
        <v-toolbar-title>게시물 작성</v-toolbar-title>
        <v-spacer></v-spacer>
      </v-toolbar>

      <div class="px-2 pt-4 d-inline-flex align-center">
        <v-avatar size="36px">
          <img src="@/assets/no_profile.gif" alt="John" />
        </v-avatar>
        <div class="mx-2 text--primary font-weight-bold">
          dddd
        </div>
      </div>

      <v-row class="pa-5 py-3 pb-0 ">
        <v-textarea
          label="게시물 내용을 입력하세요"
          auto-grow
          outlined
          rows="10"
          row-height="32"
          v-model="content"
        ></v-textarea>
      </v-row>
      <v-btn block class="mx-1 " height="55" depressed color="primary"
        >작성</v-btn
      >
      <v-divider />
    </v-card>
  </v-dialog>
</template>

<script>
export default {
  name: "PostWirter",
  props: ["open"],
  data() {
    return {
      content: "dddd",
    };
  },

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
      console.log("closeDialog");
    },
  },
};
</script>
