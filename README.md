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
![image](https://github.com/user-attachments/assets/29d2d99a-66f4-402e-8e15-d559f9e57e3a)

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
## Passo 6: Testar a Aplicação
A aplicação estará rodando em http://localhost:8080. Utilizei ferramentas como Postman para testar os endpoints da API.

### Passo 3: Executar Testes no Postman
- Para cada endpoint:

- Abra o Postman.

- Selecione o Método HTTP (GET, POST, PUT, DELETE).

- Insira a URL do Endpoint.

- Configure o Corpo da Requisição (Body), se necessário (para POST e PUT).

- Clique em Send para enviar a requisição.

- Verifique a Resposta na seção de resposta do Postman.

### Endpoints da API
  - Adicionar Produto (POST /api/products)
  - URL: http://localhost:8080/api/products
  - Método: POST:
    
   
     ```bash
    {
     "name": "Smartphone",
     "category": "Electronics",
     "quantity": 10,
     "price": 599.99
    }
    ```
     ![image](https://github.com/user-attachments/assets/a549ad6c-0884-45bb-85e1-eaf9fd404fd6)

    
  

###  Listar Todos os Produtos (GET /api/products)

- URL: http://localhost:8080/api/products
- Método: GET
- ![image](https://github.com/user-attachments/assets/8a8ec2e3-aec5-4592-9aa3-d66f9092f0c3)

  
### Buscar Produto por ID (GET /api/products/{id})
- URL: http://localhost:8080/api/products/1}
- Método: GET
- Nota: Substitua 1 pelo ID real do produto que você deseja buscar
- ![image](https://github.com/user-attachments/assets/f6142300-3976-429d-8895-cbcbac257357)


### Buscar Produto por Nome (GET /api/products/search)
- URL: http://localhost:8080/api/products/search?name=Smartphone
- Método: GET
- Query Params: name = Smartphone
- ![image](https://github.com/user-attachments/assets/3aba32ad-32f3-4b92-be23-9e47ce9aa6f8)

  
### Filtrar Produtos por Categoria (GET /api/products/filter/category)

- URL: http://localhost:8080/api/products/filter/category?category=Electronics
- Método: GET
- Query Params: category = Electronics
- ![image](https://github.com/user-attachments/assets/72ae9423-6120-4577-8962-3d4a70bfbcc5)


### Ordenar Produtos (GET /api/products/sort)
- URL: http://localhost:8080/api/products/sort?sortBy=price&order=asc

- Método: GET

- Query Params:

- sortBy = price

- order = asc
- ![image](https://github.com/user-attachments/assets/adce464c-353f-4d79-8fd7-7d83f6ae7f3f)
 

### Atualizar Produto (PUT /api/products/{id})
- URL: http://localhost:8080/api/products/1
- Método: PUT
- Body: Selecione raw e JSON, insira o seguinte JSON:
Body:
```json
  {
    "name": "Smartphone Updated",
    "category": "Electronics",
    "quantity": 15,
    "price": 579.99
}

  ```
![image](https://github.com/user-attachments/assets/e8f724e4-358b-469e-94db-495c5a54d0be)


### Excluir Produto (DELETE /api/products/{id})
- URL: http://localhost:8080/api/products/1

- Método: DELETE

- ![image](https://github.com/user-attachments/assets/9bb74452-880d-47a8-afef-3ea7afd2c524)


- Nota: Substitua 1 pelo ID real do produto que você deseja exclui
### Autor
- Teofilo Nicolau







 





