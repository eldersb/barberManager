# barberManager

Projeto de construção de um gerenciador de atendimentos de uma barbearia utilizando Spring Boot(Em construção). 
Nesse projeto, fiz um sistema básico para testar o poder da ferramenta Thymeleaf, onde as requisições são feitas via formulário e enviadas para o banco de dados.

## Tecnologias Utilizadas
* HTML, CSS
* Bootstrap
* Java, Spring Boot
* Thymeleaf
* MySQL

## Testando o projeto em sua máquina
```
- Para rodar o projeto, é necessário ter previamente instalado um servidor para rodar o banco de dados, no meu caso utilizei o XAMPP.
- Clone o projeto na sua máquina, que ele ira criar o banco de dados e as tabelas iniciais, ja populando a tabela "Barbeiros"
- Dentro de sua configuração application.properties:

spring.application.name=barberManager

spring.datasource.url=jdbc:mariadb://localhost/barbermanager?createDatabaseIfNotExist=true
spring.datasource.username=root
spring.datasource.password=
spring.datasource.driver-class-name=org.mariadb.jdbc.Driver

# Configurações opcionais
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MariaDBDialect

```

## Imagens modelo do projeto

![barberManager](https://github.com/user-attachments/assets/2616c10a-5c8f-43f2-a83b-00952f84ae18)

![barberManager2](https://github.com/user-attachments/assets/4c3dd3ed-d2e2-4c39-8f01-e4f6be5a5bbc)
