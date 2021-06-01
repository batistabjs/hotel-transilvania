<template>
  <v-card>
    <v-card
      class="mx-auto"
      max-width="800"
    >
      <v-card-title>

      <v-text-field
          v-model="search"
          append-icon="mdi-magnify"
          label="Buscar"
          single-line
          hide-details
      ></v-text-field>

      </v-card-title>

      <v-simple-table>

      <template v-slot:top>
          <v-container fluid>

          <span>Filtrar por: </span>
            <v-row>
              <v-col>
              <v-radio-group
              v-model="select"
              row
              >
              <v-radio
                  label="Nome"
                  value="nome"
              ></v-radio>
              <v-radio
                  label="Documento"
                  value="documento"
              ></v-radio>
              <v-radio
                  label="Telefone"
                  value="telefone"
              ></v-radio>
              </v-radio-group>
              </v-col>
              
              <v-col>
                <Form/>
              </v-col>

            </v-row>

          </v-container>

      </template>

      <template v-slot:default>
        <thead>
          <tr>
            <th class="text-left">
              Nome
            </th>
            <th class="text-left">
              Documento
            </th>
              <th class="text-left">
              Telefone
            </th>
          </tr>
        </thead>
        <tbody>
          <tr
            v-for="item in guests"
            :key="item.documento"
          >
            <td>{{ item.nome }}</td>
            <td>{{ item.documento }}</td>
            <td>{{ item.telefone }}</td>
          </tr>
        </tbody>
      </template>
    </v-simple-table>
    </v-card>
  </v-card>
</template>

<script>
  import Form from './Form'

  export default {
    components:{
      Form
    },
    data () {
      return {
      }
    },
    computed:{
        search:{
            get(){
                return this.$store.state.search;
            },
            set(value){
              this.$store.commit('guests/setSearch', value);
              this.$store.dispatch('guests/searchGuests');
            }
        },
        select:{
            get(){
                return this.$store.state.guests.select;
            },
            set(value){
              this.$store.commit('guests/setSelect', value)
              this.$store.dispatch('guests/searchGuests');
            }
        },
        guests(){
            return this.$store.state.guests.guests
        }
    },
    created(){
      this.$store.dispatch('guests/loadGuests');
    }
  }
</script>