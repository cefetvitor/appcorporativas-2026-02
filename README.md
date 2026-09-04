Projeto desenvolvido em Java utilizando Maven.

## Pré-requisitos

- Java JDK 17 ou superior
- Apache Maven 3.8 ou superior
- Git

Verifique as instalações:

```bash
java -version
mvn -version
git --version
```

## Instalação

Clone o repositório:

```bash
git clone <URL_DO_REPOSITORIO>
cd AppCorporativa
```

Compile o projeto e instale as dependências:

```bash
mvn clean install
```

## Execução

Para executar os testes:

```bash
mvn test
```

Para gerar o arquivo `.jar`:

```bash
mvn package
```

O arquivo gerado estará no diretório:

```text
target/
```

Caso o projeto possua uma classe principal configurada, execute com:

```bash
java -jar target/<nome-do-arquivo>.jar
```

## Estrutura do projeto

```text
src/
├── main/
│   └── java/       Código-fonte da aplicação
└── test/
    └── java/       Testes automatizados
```

## Tecnologias utilizadas

- Java
- Maven
- JDBC/DAO
- JUnit