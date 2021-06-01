<template>
  <v-card>
    <v-toolbar
      color="rgb(0,153,153)"
      dark
      flat
    >
      <template v-slot:extension>
        <v-tabs
          v-model="tabs"
          centered
        >
          <v-tab >
            Hóspedes
          </v-tab>
          <v-tab >
            Checkins
          </v-tab>
        </v-tabs>
      </template>
    </v-toolbar>

    <v-tabs-items v-model="tabs">
      <v-tab-item>
        <guests/>
      </v-tab-item>
      <v-tab-item>
        <checkins/>
      </v-tab-item>
    </v-tabs-items>
  </v-card>
</template>

<script>
import Guests from './Guests/';
import Checkins from './Checkins';

  export default {
    name: "Tabs",
    components: {
      Guests,
      Checkins
    },
    data () {
      return {
        tabs: null,
      }
    },
  }
</script>