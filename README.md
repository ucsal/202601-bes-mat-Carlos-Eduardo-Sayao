# README – Refatoração do Sistema de Olimpíadas

## Alterações realizadas na refatoração

### Separação em camadas
Antes o sistema era centralizado. Após a refatoração, foi dividido em:

- **Repository** → persistência em memória
- **Service** → regras de negócio do sistema 
- **View** → interação com usuário
- **App** → controle do fluxo

---

### Separação de responsabilidades
Funções que estavam misturadas foram separadas:

- Entrada/saída → movida para `Views`
- Regras de negócio → movidas para `Services`
- Armazenamento → movido para `Repositories`

---

### Criação de Services
Foram criadas classes específicas para regras:

- `ParticipanteServices`
- `ProvaServices`
- `QuestaoServices`

Responsáveis por:
- validação
- geração de ID
- lógica de prova (nota, respostas, tentativa)

---

### Criação de Repositories
Cada entidade passou a ter seu próprio repositório:

- `ParticipanteRepository`
- `ProvaRepository`
- `QuestaoRepository`
- `TentativaRepository`

---

### Criação de Views
Interação com usuário foi isolada:

- `ParticipanteViews`
- `ProvaViews`
- `QuestaoViews`

---

### Introdução de SeedService
- Responsável por dados iniciais

---

### Organização do fluxo no App
- `App` virou a classe de orquestração
- Delega responsabilidades para services, repositories e views

---

## 🧠 Princípios SOLID aplicados

### 🔹 S — Single Responsibility Principle (SRP)

Cada classe tem uma única responsabilidade:

- `ParticipanteRepository` → apenas persistência
- `ParticipanteServices` → apenas regras de negócio
- `ParticipanteViews` → apenas interface com usuário
- `App` → controle do fluxo


---

### 🔹 O — Open/Closed Principle (OCP)

O sistema está aberto para extensão e fechado para modificação:

- Novas regras podem ser adicionadas nos `Services`
- Novos tipos de persistência podem ser criados sem alterar lógica existente


---

### 🔹 I — Interface Segregation Principle (ISP)

Não foram usadas interfaces formais, porém:

- Classes são pequenas e específicas
- Não existem classes com métodos desnecessários
- Cada classe não possui métodos que elas não usem

---

### 🔹 D — Dependency Inversion Principle (DIP)


- `SeedService` recebe dependências via construtor
- `App` utiliza instâncias separadas de services e repositories

