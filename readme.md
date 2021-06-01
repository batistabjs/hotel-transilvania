
### Deploy funcional da aplicação disponível no link:
http://hotel-transilvania.surge.sh/

### Desenvolvimento:
Backend: Java 16 (open-jdk-16) com Spring Boot e Data JPA
Frontend: Vuejs com framework Material Design Vuetify
BD: PostgreSQL

### Para execução do Frontend:
Instalar o Vuejs
Após clonar o projeto, navegar até a pasta chamada frontend. Na raiz desta pasta, executar o comando:
```
npm run dev
```
### Para execução do backend:
Instalar o Java16 (foi escolhido só por ser o mais novo mesmo, nada demais)
Navegar até a raiz do projeto e executar via terminal o comando:
```
mvn spring-boot:run
```

### Observação:
O banco de dados está disponível conectado no heroku. Caso necessite localmente,
executar o script hotel.sql na raiz do projeto e alterar as configs do projeto Spring no arquivo
application.properties

### OBSERVAÇÕES:
@Getters e @Setters gerados com a extensão lombok
Spring Data JPA para trabalhar com os dados
Para agilizar, o banco de dados de teste está online no Heroku. Contudo, na raiz existe o arquivo chamado hotel.sql
caso haja interesse em executar localmente.
Obs: Pensei em usar o h2 Database para dados usar banco em memória, mas um dos requisitos era Postgres ou Mongo

### POSSÍVEIS MELHORIAS:
- [ ] Considerar a categoria "finais de semana" no cálculo;
- [ ] Implementar @ExceptionHandler Annotation para tratar os erros;
- [ ] Migrar o Vuejs para Angular, e deixar tudo em Typescript;
- [ ] Criar rotas de edição e delete de hóspedes e checkins;
- [ ] Criar paginação alterando o objeto da rota Getall para Page, e assim setar os valores "page" e "size";
- [ ] Criar paginação alterando o objeto da rota Getall para Page, e assim setar os valores "page" e "size";
- [ ] Adicionar Autentiação de usuário, habilitando no pom.xml a dependendia oauth2 e criação das rotas para validar o JWT;
- [ ] Criação de testes automatizados;
- [ ] Criação da documentação com o Swagger.




