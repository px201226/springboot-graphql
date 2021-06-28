import Vue from 'vue'
import App from './App.vue'
import router from './router'
import store from './store'
import VueApollo from 'vue-apollo'
import { ApolloClient } from 'apollo-client'
import { createHttpLink } from 'apollo-link-http'
import { InMemoryCache } from 'apollo-cache-inmemory'
import Vuetify from 'vuetify'
import 'vuetify/dist/vuetify.min.css'
import '@mdi/font/css/materialdesignicons.css' 
import 'material-design-icons-iconfont/dist/material-design-icons.css'

// HTTP connection to the API
const httpLink = createHttpLink({
  // You should use an absolute URL here
  uri: 'http://localhost:8080/graphql',
})

// Cache implementation
const cache = new InMemoryCache()

// Create the apollo client
const apolloClient = new ApolloClient({
  link: httpLink,
  cache,
})

Vue.use(VueApollo)
Vue.use(Vuetify);
Vue.config.productionTip = false
Vue.prototype.$log = console.log

const apolloProvider = new VueApollo({
  defaultClient: apolloClient,
})

new Vue({
  vuetify : new Vuetify({
    icons: { iconfont: 'md', },
  }),
  router,
  store,
  apolloProvider,
  render: (h) => h(App),
}).$mount('#app')
