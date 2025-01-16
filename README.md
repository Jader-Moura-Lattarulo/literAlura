literAlura

literAlura é uma aplicação de console desenvolvida em Java como parte do desafio do curso Alura Latam / Oracle Java Back-End, integrante do programa ONE. O objetivo é criar uma biblioteca digital que consome a API Gutendex para obter informações sobre livros e autores, permitindo ao usuário buscar e armazenar dados de livros, como título, autor e idioma, em um banco de dados PostgreSQL.

Funcionalidades

Integração com API: Consome a API Gutendex para obter informações detalhadas sobre livros.

Armazenamento de Dados: Utiliza JPA e PostgreSQL para armazenar informações dos livros no banco de dados.

Busca de Livros: Permite ao usuário buscar livros por título, gênero, idioma e autor.

Listagem de Autores: Exibe uma lista de autores cadastrados no sistema.

Estatísticas: Fornece estatísticas, como os 10 livros mais baixados armazenados no banco de dados.

Tecnologias Utilizadas

Java: Linguagem principal utilizada no desenvolvimento.

Spring Boot: Framework para simplificar a configuração e o desenvolvimento da aplicação.

JPA/Hibernate: Para mapeamento objeto-relacional e operações com o banco de dados.

PostgreSQL: Banco de dados utilizado para armazenar as informações dos livros.

Gutendex API: Fonte de dados para informações sobre livros e autores.

Pré-requisitos

Java 17 ou superior instalado.

PostgreSQL configurado e em execução.

IDE de sua preferência (recomenda-se IntelliJ IDEA ou Eclipse).

Configuração do Ambiente

Clonar o Repositório:

git clone https://github.com/Jader-Moura-Lattarulo/literAlura.git

Configurar o Banco de Dados:

Crie um banco de dados PostgreSQL chamado literAlura.

Atualize as configurações de conexão no arquivo application.properties localizado em src/main/resources/ com suas credenciais do PostgreSQL:

spring.datasource.url=jdbc:postgresql://localhost:5432/literAlura
spring.datasource.username=seu_usuario
spring.datasource.password=sua_senha
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true

Executar a Aplicação:

Abra o projeto em sua IDE.

Execute a classe principal LiterAluraApplication localizada em src/main/java/com/literalura/LiterAluraApplication.java.

Utilização

Ao iniciar a aplicação, um menu será exibido com as seguintes opções:

Buscar e adicionar um livro pelo título.

Listar todos os livros cadastrados.

Listar todos os autores cadastrados.

Buscar livros por gênero.

Buscar livros por idioma.

Exibir os 10 livros mais baixados.

Exibir estatísticas do banco de dados.

Sair.

Selecione a opção desejada digitando o número correspondente e pressionando Enter.

Contribuições

Contribuições são bem-vindas! Sinta-se à vontade para abrir issues ou enviar pull requests com melhorias ou correções.

Licença

Este projeto está licenciado sob a Licença MIT. Consulte o arquivo LICENSE para mais detalhes.

Autor

Desenvolvido por Jader Moura Lattarulo.
