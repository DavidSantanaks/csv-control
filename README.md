# Controle CSV

Este projeto foi desenvolvido como parte de um teste na empresa Multi Portal.

## Tecnologias Utilizadas

- Java 17
- Thymeleaf
- Spring Security
- Flyway
- JPA
- OpenCSV
- Docker

## Configuração do Ambiente

Com este projeto em sua máquina, você pode executá-lo via Docker, utilizando uma imagem do PostgreSQL, ou diretamente com o PGAdmin.

### Inicialização do Docker

1. Dentro da pasta do projeto, abra um terminal (CMD, PowerShell ou Terminal).
2. Execute o comando `docker-compose up -d`.
   Este comando iniciará o PostgreSQL dentro de um contêiner Docker.

### Configurações do Banco de Dados

No arquivo `application.properties`, localizado na pasta `src/main/resources`, você pode alterar as configurações de porta para acessar o banco de dados via Docker ou localmente com o PGAdmin.

