<template>
<v-row justify="center">
    <v-dialog
      v-model="dialog"
      persistent
      max-width="600px"
    >
      <template v-slot:activator="{ on, attrs }">
        <v-btn
          color="rgb(0,153,153)"
          dark
          v-bind="attrs"
          v-on="on"
        >
          Adicionar checkin
        </v-btn>
      </template>
      <v-card>
        <v-card-title>
          <span class="headline">Adicione um checkin</span>
        </v-card-title>
        <v-card-text>
          <v-container>
            <v-row>
              <v-col cols="12">
                <v-autocomplete
                  v-model="guest"
                  :items="guests"
                  label="Hóspede"
                ></v-autocomplete>
                <DateTime label="Data de entrada" v-model="dataEntrada"> </DateTime>

                <DateTime label="Data de saída" v-model="dataSaida"> </DateTime>
                
                <v-container fluid>
                  
                  <template>
                    <v-checkbox
                      v-model="adicionalVeiculo"
                      label="O hóspede possui veículo"
                      color="success"
                      hide-details
                    ></v-checkbox>
                  </template>
                </v-container>
              </v-col>
            </v-row>
          </v-container>
        </v-card-text>
        <v-card-actions>
          <v-spacer></v-spacer>
          <v-btn
            color="blue darken-1"
            text
            @click="dialog = false"
          >
            Fechar
          </v-btn>
          <v-btn
            color="blue darken-1"
            text
            @click="dialog = false; $store.dispatch('checkins/saveCheckin')"
          >
            Salvar
          </v-btn>
        </v-card-actions>
      </v-card>
    </v-dialog>
  </v-row>
</template>

<script>
  import { validationMixin } from 'vuelidate'
  import { required } from 'vuelidate/lib/validators'
  import  DateTime from "../DatetimePicker";

  export default {
    components:{
      DateTime
    },
    mixins: [validationMixin],

    validations: {
      dataEntrada: { required },
      dataSaida: { required },
      adicionalVeiculo: { required },
    },

    data: () => ({
      dialog: false,
      items: ['foo', 'bar', 'fizz', 'buzz'],
      values: ['foo', 'bar'],
      success: false 
    }),
    computed: {
      guest:{
        get(){
          return ''
        },
        set(value){
          this.$store.commit('checkins/setHospedeByName', value)
        }
      },
      guests:{
        get(){
          return this.$store.getters['checkins/getGuestsNames']
        }
      },
      dataEntrada:{
        get(){
          return this.$store.state.checkins.form.dataEntrada
        },
        set(value){
          this.$store.commit('checkins/updateFormDataEntrada', value)
        }
      },
      dataSaida:{
        get(){
          return this.$store.state.checkins.form.dataSaida
        },
        set(value){
          this.$store.commit('checkins/updateFormDataSaida', value)
        }
      },
      adicionalVeiculo:{
        get(){
          return this.$store.state.checkins.form.adicionalVeiculo
        },
        set(value){
          this.$store.commit('checkins/updateFormAdicionalVeiculo', value)
        }
      },
      dataEntradaErrors () {
        const errors = []
        if (!this.$v.dataEntrada.$dirty) return errors
        !this.$v.dataEntrada.required && errors.push('dataEntrada is required.')
        return errors
      },
      dataSaidaErrors () {
        const errors = []
        if (!this.$v.dataSaida.$dirty) return errors
        !this.$v.dataSaida.required && errors.push('dataSaida is required')
        return errors
      },
      adicionalVeiculoErrors () {
        const errors = []
        if (!this.$v.adicionalVeiculo.$dirty) return errors
        !this.$v.adicionalVeiculo.required && errors.push('adicionalVeiculo is required')
        return errors
      },
    },

    methods: {
      submit () {
        this.$v.$touch()
      },
      clear () {
        this.$v.$reset()
        this.dataEntrada = ''
        this.dataSaida = ''
        this.adicionalVeiculo = ''
      },
    },
  }
</script>