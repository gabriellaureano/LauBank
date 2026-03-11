# 🏦 LauBank - API de Gestão Bancária

API REST para operações bancárias, focada em automação de saldo inicial, transferências entre contas e auditoria de transações.

Desenvolvida com **Java 17** e **Spring Boot**.

---

## 📍 Endpoints da API

**Base URL:** `/laubank`

| Categoria  | Método | Endpoint                    | Descrição                                           |
| ---------- | ------ | --------------------------- | --------------------------------------------------- |
| Usuário    | GET    | `/usuarios`                 | Lista todos os usuários cadastrados                 |
| Usuário    | POST   | `/usuarios`                 | Cadastra novo usuário (saldo inicial: **R$500.00**) |
| Financeiro | POST   | `/transacoes`               | Executa transferência entre contas                  |
| Auditoria  | GET    | `/transacoes`               | Lista o log global de todas as transações           |
| Auditoria  | GET    | `/usuarios/{id}/transacoes` | Histórico de transações de um usuário               |

---

## 🚀 Exemplos de Requisição

### 1️⃣ Cadastrar Usuário

**Endpoint**

POST /laubank/usuarios

O sistema inicializa automaticamente cada nova conta com **R$500,00**.

**JSON**

```json
{
  "nome": "Gabriel Silva",
  "email": "gabriel@gmail.com"
}
```

---

### 2️⃣ Realizar Transferência

**Endpoint**

POST /laubank/transacoes

**JSON**

```json
{
  "idOrigem": 1,
  "idDestino": 2,
  "valor": 100.00
}
```

---

## ⚠️ Tratamento de Erros (Bean Validation)

A API utiliza um **GlobalExceptionHandler** para retornar erros de validação de forma padronizada.

Caso os dados enviados sejam inválidos, a resposta seguirá este padrão:

```json
{
  "status": 400,
  "erro": "E-mail inválido",
  "ajuda": "Certifique-se de que o e-mail contém '@' e um domínio válido."
}
```

---

## 🧠 Lógica e Fundamentos

### Saldo Automatizado

Durante o cadastro, cada conta inicia com **R$500.00**, garantindo integridade financeira inicial.

### Bean Validation

Uso de anotações como:

* `@Valid`
* `@NotBlank`
* `@Email`

para garantir qualidade e validação dos dados recebidos.

### Arquitetura em Camadas

Separação clara entre:

```
Controller
Service
DTO
Repository
```

### Tratamento Global de Erros

Centralização das exceções usando **GlobalExceptionHandler**, garantindo respostas HTTP padronizadas.

---


## 👨‍💻 Autor

Desenvolvido por **Gabriel Laureano**
