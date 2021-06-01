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
          Adicionar hóspede
        </v-btn>
      </template>
      <v-card>
        <v-card-title>
          <span class="headline">Adicione um hóspede</span>
        </v-card-title>
        <v-card-text>
          <v-container>
            <v-row>
              <v-col cols="12">
                <v-text-field
                    v-model="nome"
                    :error-messages="nomeErrors"
                    label="Nome"
                    required
                    @input="$v.nome.$touch()"
                    @blur="$v.nome.$touch()"
                ></v-text-field>
              </v-col>
              <v-col cols="12">
                <v-text-field
                    v-model="documento"
                    :error-messages="documentoErrors"
                    label="Documento"
                    required
                    @input="$v.documento.$touch()"
                    @blur="$v.documento.$touch()"
                ></v-text-field>
              </v-col>
              <v-col cols="12">
                <v-text-field
                    v-model="telefone"
                    :error-messages="telefoneErrors"
                    label="Telefone"
                    required
                    @input="$v.telefone.$touch()"
                    @blur="$v.telefone.$touch()"
                ></v-text-field>
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
            Close
          </v-btn>
          <v-btn
            color="blue darken-1"
            text
            @click="dialog = false; $store.dispatch('guests/saveGuest')"
          >
            Save
          </v-btn>
        </v-card-actions>
      </v-card>
    </v-dialog>
  </v-row>
</template>

<script>
  import { validationMixin } from 'vuelidate'
  import { required } from 'vuelidate/lib/validators'

  export default {
    mixins: [validationMixin],

    validations: {
      nome: { required },
      documento: { required },
      telefone: { required },
    },

    data: () => ({dialog: false,}),
    computed: {
      nome:{
        get(){
          return this.$store.state.guests.form.nome
        },
        set(value){
          this.$store.commit('guests/updateFormName', value)
        }
      },
      documento:{
        get(){
          return this.$store.state.guests.form.documento
        },
        set(value){
          this.$store.commit('guests/updateFormDocument', value)
        }
      },
      telefone:{
        get(){
          return this.$store.state.guests.form.telefone
        },
        set(value){
          this.$store.commit('guests/updateFormPhone', value)
        }
      },
      nomeErrors () {
        const errors = []
        if (!this.$v.nome.$dirty) return errors
        !this.$v.nome.required && errors.push('Nome is required.')
        return errors
      },
      documentoErrors () {
        const errors = []
        if (!this.$v.documento.$dirty) return errors
        !this.$v.documento.required && errors.push('Documento is required')
        return errors
      },
        telefoneErrors () {
        const errors = []
        if (!this.$v.telefone.$dirty) return errors
        !this.$v.telefone.required && errors.push('Tefone is required')
        return errors
      },
    },

    methods: {
      submit () {
        this.$v.$touch()
      },
      clear () {
        this.$v.$reset()
        this.nome = ''
        this.documento = ''
        this.telefone = ''
      },
    },
  }
</script>