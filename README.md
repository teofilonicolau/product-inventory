# AgilStore - Gerenciamento de Produtos

## Descrição
A AgilStore é uma pequena loja de eletrônicos que expandiu seu catálogo para incluir diversos itens, como smartphones, laptops e acessórios. Com o aumento da diversidade de produtos, surgiu a necessidade de otimizar o controle do inventário, garantindo a disponibilidade e a eficiência no gerenciamento de estoques.

## Requisitos Funcionais
- **Adicionar Produto**: Permitir que o usuário adicione um novo produto ao inventário.
- **Listar Produtos**: Exibir todos os produtos cadastrados no inventário.
- **Atualizar Produto**: Atualizar informações de um produto existente pelo seu ID.
- **Excluir Produto**: Remover um produto do inventário pelo ID.
- **Buscar Produto**: Buscar detalhes de um produto pelo ID ou nome.
- **Filtrar Produtos**: Permitir filtragem por categoria e ordenação por nome, quantidade e preço.
- **Persistência de Dados**: Armazenamento em arquivo JSON.

## Tecnologias Utilizadas
- Java
- Spring Boot
- Spring Data JPA
- PostgreSQL
- Docker
- Lombok
- Bean Validation
- Jackson (para persistência em JSON)

## Pré-requisitos
- [Docker](https://www.docker.com/products/docker-desktop) instalado e configurado.
- [PostgreSQL](https://www.postgresql.org/download/) (caso não utilize Docker, faça o dowload na sua máquina).
- [Java JDK 17](https://www.oracle.com/java/technologies/javase-jdk17-downloads.html) ou superior.
- [Maven](https://maven.apache.org/download.cgi).

## Como Rodar a Aplicação Localmente

### Passo 1: Clonar o Repositório
Clone o repositório do projeto para sua máquina local:
```bash
git clone https://github.com/teofilonicolau/product-inventory.git
cd product-inventory
```
###  Passo 2: Configurar o Banco de Dados (Docker):
 - Se estiver usando Docker, inicie o container do PostgreSQL com Docker Compose:
 ```bash
  docker-compose up -d
```
### Passo 3: Configurar o Banco de Dados (sem Docker)
Se não estiver usando Docker, configure seu PostgreSQL local e crie um banco de dados com as seguintes credenciais:

- Nome do Banco de Dados: productdb
- Usuário: postgres
- Senha: password
### Passo 4: Configurar o Aplicativo
Configure as propriedades do aplicativo em src/main/resources/application.properties:

```bash
  spring.datasource.url=jdbc:postgresql://localhost:5432/productdb
  spring.datasource.username=postgres
  spring.datasource.password=password
  spring.jpa.hibernate.ddl-auto=update
  spring.jpa.show-sql=true
  spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.PostgreSQLDialect

``` 
### Passo 5: Compilar e Executar a Aplicação
Compile e execute a aplicação utilizando Maven:

 ```bash
  ./mvnw clean install
  ./mvnw spring-boot:run

 ```
### Passo 6: Testar a Aplicação
A aplicação estará rodando em http://localhost:8080. Utilizei ferramentas como Postman para testar os endpoints da API.

## Endpoints da API
  Adicionar Produto
  - URL: POST  / http://localhost:8080/api/products
    
    ```json
  {
     "name": "Smartphone",
     "category": "Electronics",
     "quantity": 10,
     "price": 599.99
   }

  ```
## Listar Todos os Produtos
URL: GET /api/products
Buscar Produto por ID
URL: GET /api/products/{id}
Buscar Produto por Nome
URL: GET /api/products/search?name={name}
Filtrar Produtos por Categoria
URL: GET /api/products/filter/category?category={category}
Ordenar Produtos
URL: GET /api/products/sort?sortBy={sortBy}&order={order}
Atualizar Produto
URL: PUT /api/products/{id}
Body:
json
Copiar código
{
    "name": "Smartphone Updated",
    "category": "Electronics",
    "quantity": 15,
    "price": 579.99
}
Excluir Produto
URL: DELETE /api/products/{id}
Autor
Teofilo Nicolau
Copiar código






 





