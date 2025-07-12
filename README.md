# 🐭 Buffmice — API para Criação de Treinos

## 📌 Sobre o Projeto

Criei essa API com o objetivo de praticar minhas habilidades com o **Spring Framework**. A ideia inicial era desenvolver um aplicativo mobile, mas decidi focar em aprimorar meu conhecimento no ecossistema Spring. Por isso, vou encerrar (por enquanto) na criação da **API REST**.

A proposta é simples: permitir a criação de treinos e o cadastro de exercícios dentro deles. Pensei nisso porque, sinceramente, eu **odeio fichas de treino físicas** — sempre acabo improvisando pra lembrar o que preciso fazer na academia.

> 🔮 Quem sabe no futuro role um front bem massa pra acompanhar a API?

---

## 🛠️ Tecnologias Utilizadas

- ✅ **Spring Web** — construção dos endpoints da API  
- 🔐 **Spring Security + JWT** — autenticação segura  
- 🗂️ **Flyway** — controle de versões de banco de dados (migrations)  
- 💾 **Spring Data JPA** — manipulação e abstração do banco relacional  
- 📚 **Swagger** — documentação automática dos endpoints REST  

---

## 🚀 Como Executar o Projeto

1. Instale o **Java 22** ou superior (eu usei o Java 23, mas o 22 deve funcionar sem problemas).  
2. Clone este repositório:  
```bash
git clone https://github.com/DanielGomesOtt/buffmice.git
```
De resto, só clonar, criar seu arquivo .env e preenche-lo com as suas credenciais de banco de dados (Use banco de dados relacional, de preferência Mysql ou MariaDB), seguindo o .env-example como base, rodar o projeto e ser feliz.

## Como saber quais requisições posso usar ?
Acesse o Swagger UI na URL abaixo para visualizar todos os endpoints da API, bem como seus métodos e formatos de dados (Rode o projeto antes de acessar):

📍 /swagger-ui/index.html

## Minhas Impressões sobre o Primeiro Projeto com o Ecossistema Spring
Gostei demais do ecossistema Spring. Achei ele sólido, organizado e muito bem estruturado.

Vindo do Node.js, percebi que:

No Spring, me sinto mais "preso" no começo — mas isso é bom!

A configuração inicial pode ser trabalhosa, mas depois disso, tudo roda de forma limpa e eficiente.

Exemplo: a configuração do JWT com Spring Security foi desafiadora, mas depois de concluída, o Spring faz quase tudo sozinho.

Já no Node, o processo é mais manual e menos integrado.

Outro ponto que me conquistou foi a organização do projeto. O Spring praticamente te guia na estrutura do código.
Em outras linguagens (Node, PHP...), eu tinha liberdade demais — o que me levava a criar verdadeiras monstruosidades de gambiarras 😅

Hoje em dia, busco ser o mais organizado possível — em qualquer linguagem. 💪

Desenvolvido por Daniel Gomes Ott
📧 danielgomesott@gmail.com
