# 📌 Sistema de Chamados – Spring Boot

API REST desenvolvida com Java e Spring Boot para gerenciar usuários e chamados, aplicando regras de negócio comuns em sistemas reais. O projeto inclui validação, relacionamentos, filtros e operações completas de CRUD.

## 🚀 Tecnologias

> Java 17

1. Spring Boot:
  1. Spring Web
  2. Lombok
  3. Spring Dev Tools
  4. Spring Data JPA
  5. Bean Validation
2. PostgreSQL

## 🔧 Funcionalidades

> [Usuários]

```
GET /users <- listar todos os usuários
```

```
GET /users/{:id} <- Pegar usuário pelo id
```

```
POST /users <- Criar usuário
```

```
PUT /users/{:id} <- Editar usuário
```

```
DELETE /users/{:id} <- Deletar usuário

Impede exclusão caso seja solicitante/responsável de algum chamado
```

> [Tickets]

```
POST /tickets <- Cria um ticket
```

```
GET /tickets/{:id} <- Pega um ticket pelo Id
```

```
GET /tickets/status/{:status} <- Pega o status do ticket
```

```
GET /tickets/applicant/{:id} <- Pega o criador do ticket
```

```
GET /tickets/responsible/{:id} <- Dados para quem vai o ticket
```

# 📦 Como rodar

Você precisará ter o docker instalado na sua maquina.

<a href="https://docs.docker.com/desktop/setup/install/windows-install/">Instale para Windows</a>
&
<a href="https://docs.docker.com/desktop/setup/install/linux/">Instale para Linux</a>

```
# Build da imagem
docker build -t System-Tickets .
```
após buildar
```
docker run -p 8080:8080 System-Tickets
```

# 📄 Sobre

Projeto criado para treino e portfólio, seguindo boas práticas de backend e lógica aplicada no mercado.

para ajudar no projeto de uma olhada no <a href="/CONTRIBUTING.md">CONTRIBUTING.md</a>