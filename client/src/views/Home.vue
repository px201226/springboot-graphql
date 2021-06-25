<template>
<div>
   <v-row
    align="center"
    justify="space-around"
  >
    <v-btn depressed>
      Normal
    </v-btn>
    <v-btn
      depressed
      color="primary"
    >
      Primary
    </v-btn>
    <v-btn
      depressed
      color="error"
    >
      Error
    </v-btn>
    <v-btn
      depressed
      disabled
    >
      Disabled
    </v-btn>
  </v-row>
</div>
</template>

<script>
import gql from 'graphql-tag'
import pjson from '../../package.json'

export default {
  name: 'Home',
  data() {
    return {
      pjson,
    }
  },
  apollo: {
    // Simple query that will update the 'hello' vue property
    hello: gql`query {
      hello
    }`,
  },
  methods: {
    async addTag() {
      // Call to the graphql mutation
      const result = await this.$apollo.mutate({
        // Query
        mutation: gql`mutation ($label: String!) {
          addTag(label: $label) {
            id
            label
          }
        }`,
        // Parameters
        variables: {
          label: this.newTag,
        },
      })
    }
  }
}
</script>

<style lang="scss">
#Home {
  .logo {
    max-width: 400px;
    margin: 30px 0;
    background: #C32424;
  }
}
</style>
