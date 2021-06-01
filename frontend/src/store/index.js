import Vue from 'vue'
import Vuex from 'vuex'
import guests from './guests'
import checkins from './checkins'

Vue.use(Vuex);

const store = new Vuex.Store({
    modules:{
        guests,
        checkins
    }
  })

export default store;