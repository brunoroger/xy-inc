# xy-inc

Web Service para Cadastro de Produtos.

Este Web Service possui três camadas:
- REST (Representational State Transfer): Responsável por receber as requisições http e entregar uma resposta;
- Service: Responsável por gerenciar dados e regras de negócio;
- DAO (Data Access Object): Responsável por acessar e salvar dados no banco de dados.

Cada camada possui uma interface e uma classe de implementação genérica. Esses objetos contém uma estrutura de métodos para realizar um crud de um recurso do sistema. Cada classe responsável por um recurso implementa e estende a classe abstrata passando como argumento por exemplo a classe entidade e o tipo de chave primária. Sendo assim fica mais dinâmico fazer novos cruds, e por conta de estar dividido em três camadas fica mais prático de migrar de tecnologia.

## Testes

Este Web Service possui uma classe de testes do crud de produtos. O Mesmo testa o cadastro e suas validações.
A Tecnologia utilizada é o Junit 5.

### Especificação do teste

- Para rodar a rotina de testes a base precisa estar zerada.

## Instruções para rodar o projeto

* Navegar até o diretório `xy-inc/src/main/resources/META-INF/persistence.xml` e alterar as credenciais do banco de dados MYSQL;
* Importar o projeto Maven no eclipse;
* Iniciar o servidor tomcat e acessar o endereço `http://localhost:8080/xy-inc/api/products`.