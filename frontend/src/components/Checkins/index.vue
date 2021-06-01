<template>
  <v-card>
    <v-card
      class="mx-auto"
      max-width="800"
    >
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
                    label="Todos"
                    value="searchall"
                ></v-radio>
                <v-radio
                    label="Ausentes"
                    value="serachold"
                ></v-radio>
                <v-radio
                    label="Presentes"
                    value="searchcurrent"
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
              Hóspede
            </th>
            <th class="text-left">
              Entrada
            </th>
              <th class="text-left">
              Saída
            </th>
          </tr>
        </thead>
        <tbody>
          <tr
            v-for="item in checkins"
            :key="item.documento"
          >
            <td>{{ $store.getters['checkins/getNameByDocumento'](item.hospede) }}</td>
            <td>{{ item.dataentrada }}</td>
            <td>{{ item.datasaida }}</td>
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
              this.$store.commit('checkins/setSearch', value);
            }
        },
        select:{
            get(){
                return this.$store.state.checkins.select;
            },
            set(value){
              this.$store.commit('checkins/setSelect', value)
              this.$store.dispatch('checkins/searchCheckins')
            }
        },
        checkins(){
            return this.$store.state.checkins.checkins
        }
    },
    created(){
      this.$store.dispatch('checkins/loadCheckins');
    }
  }
</script>