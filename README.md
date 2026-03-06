# 🏦 LauBank - API de Gestão Bancária

![Java](https://img.shields.io/badge/java-%23ED8B00.svg?style=for-the-badge&logo=openjdk&logoColor=white)
![Spring Boot](https://img.shields.io/badge/spring--boot-%236DB33F.svg?style=for-the-badge&logo=springboot&logoColor=white)

API REST para operações bancárias, focada em automação de saldo inicial, transferências entre contas e auditoria de transações.

---

## 📍 Endpoints da API (Base: `/laubank`)

| Categoria | Método | Endpoint | Descrição |
| :--- | :---: | :--- | :--- |
| **Usuário** | `GET` | `/` | Lista todos os usuários cadastrados. |
| **Usuário** | `POST` | `/users` | Cadastra novo usuário (**Saldo inicial: 500.00**). |
| **Financeiro** | `POST` | `/` | Executa transferência entre contas. |
| **Auditoria** | `GET` | `/transacoes` | Lista o log global de todas as transações. |
| **Auditoria** | `GET` | `/transacoes/{id}` | Filtra o histórico de transações de um usuário. |

---

## 🚀 Exemplos de Requisição (JSON)

### 1. Cadastrar Usuário
**Endpoint:** `POST /laubank/users`  
> O saldo não é enviado no cadastro; o sistema inicializa automaticamente cada nova conta com **R$ 500,00**.

```json
{
  "nome": "Gabriel Silva",
  "email": "gabriel@gmail.com"
}

### 2. Realizar Transferência
**Endpoint:** `POST /laubank`

```json
{
  "idOrigem": 1,
  "idDestino": 2,
  "valor": 100.00
}

🧠 Lógica e Fundamentos
Saldo Automatizado: Lógica de negócio no cadastro para garantir integridade financeira inicial (Welcome Bonus).

Relacionamento JPA: Vinculação automática entre a transação realizada e os perfis de usuário envolvidos (@ManyToOne).

Arquitetura Clean: Separação clara entre as camadas de Controller, Service e Repository.

DTOs: Utilização de Records para tráfego de dados seguro e imutável.

🏗️ Roadmap de Desenvolvimento
[ ] Consumo de API Externa: Implementar OpenFeign para buscar endereços via ViaCEP.

[ ] Dockerização: Configurar ambiente PostgreSQL via Docker Compose.

[ ] Segurança: Adicionar validações de saldo insuficiente antes de processar transferências.

[ ] Tratamento de Exceções: Criar um GlobalExceptionHandler para respostas de erro limpas.

Desenvolvido por Gabriel Laureano
