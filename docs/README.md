# Sistema de Gestão Escolar - Mergington High School

Sistema de gestão de atividades extracurriculares desenvolvido com Spring Boot e arquitetura limpa (Clean Architecture).

## 📋 Visão Geral

O **School Management System** é uma aplicação web que permite o gerenciamento de atividades extracurriculares da Mergington High School. O sistema possibilita que professores administrem atividades e que estudantes se inscrevam nelas através de uma interface web intuitiva.

## 🏗️ Arquitetura

### Princípios Arquiteturais

- **Clean Architecture**: Separação clara entre camadas de domínio, aplicação, infraestrutura e apresentação
- **Domain-Driven Design (DDD)**: Modelagem focada no domínio escolar
- **SOLID Principles**: Código bem estruturado e extensível
- **Hexagonal Architecture**: Isolamento das regras de negócio

### Estrutura de Camadas

```text
src/main/java/com/mergingtonhigh/schoolmanagement/
├── domain/                    # 🎯 Camada de Domínio
│   ├── entities/             # Entidades principais
│   │   ├── Activity.java     # Atividade extracurricular
│   │   └── Teacher.java      # Professor/Administrador
│   ├── repositories/         # Interfaces de repositório
│   │   ├── ActivityRepository.java
│   │   └── TeacherRepository.java
│   └── valueobjects/         # Objetos de valor
│       ├── ActivityType.java   # Enum de tipos de atividade
│       ├── Email.java        # Validação de email
│       └── ScheduleDetails.java # Detalhes de horário
├── application/              # 🔧 Camada de Aplicação
│   ├── dtos/                 # Data Transfer Objects
│   │   ├── ActivityDTO.java
│   │   ├── StudentRegistrationDTO.java
│   │   └── TeacherDTO.java
│   └── usecases/             # Casos de uso
│       ├── ActivityUseCase.java
│       ├── AuthenticationUseCase.java
│       └── StudentRegistrationUseCase.java
├── infrastructure/           # 🏭 Camada de Infraestrutura
│   ├── config/               # Configurações
│   ├── migrations/           # Migrações do banco
│   │   ├── V001_InitialDatabaseSetup.java
│   │   └── V002_AddMangaManiacsClub.java
│   └── persistence/          # Implementações de repositório
│       ├── ActivityRepositoryImpl.java
│       ├── MongoActivityRepository.java
│       ├── MongoTeacherRepository.java
│       └── TeacherRepositoryImpl.java
└── presentation/             # 🎨 Camada de Apresentação
    ├── controllers/          # Controllers REST
    │   ├── ActivityController.java
    │   ├── AuthController.java
    │   └── StaticController.java
    └── mappers/              # Mapeadores DTO ↔ Entity
        ├── ActivityMapper.java
        └── TeacherMapper.java
```

## 🚀 Tecnologias Utilizadas

### Backend

- **Java 21** - Linguagem de programação
- **Spring Boot 3.5.4** - Framework principal
- **Spring Data MongoDB** - Integração com MongoDB
- **Spring Security** - Autenticação e autorização
- **Spring Web** - APIs REST
- **Spring Validation** - Validação de dados
- **Mongock 5.5.1** - Migrações do banco de dados
- **BouncyCastle** - Criptografia para senhas

### Frontend

- **HTML5/CSS3/JavaScript** - Interface web
- **Vanilla JavaScript** - Interatividade do frontend

### Banco de Dados

- **MongoDB** - Banco de dados NoSQL

### Ferramentas de Desenvolvimento

- **Maven** - Gerenciamento de dependências
- **JUnit 5** - Testes unitários
- **Mockito** - Mocks para testes
- **Testcontainers** - Testes de integração
- **Jacoco** - Cobertura de testes

## 📦 Funcionalidades Principais

### 🎓 Gestão de Atividades

- **Listagem de atividades** com filtros por:
  - Busca textual por nome
  - Dia da semana (Segunda a Domingo)
  - Horário (manhã, tarde, fim de semana)
  - Categoria (Esportes, Artes, Acadêmica, Comunidade, Tecnologia)
- **Detalhes de atividades**:
  - Nome e descrição completa
  - Horários e dias da semana
  - Capacidade máxima
  - Lista de participantes

### 👨‍🏫 Sistema de Autenticação

- **Login de professores** com username/senha via `/auth/login`
- **Verificação de sessão** via `/auth/check-session`
- **Controle de acesso** baseado em roles (TEACHER/ADMIN)
- **Autenticação requerida** para inscrições e gestão de atividades
- **Usernames disponíveis**: `principal`, `mrodriguez`, `mchen`

### 📝 Gestão de Inscrições

- **Inscrição de estudantes** em atividades
- **Cancelamento de inscrições**
- **Validações**:
  - Capacidade máxima
  - Duplicatas
  - Autenticação do professor

### 🎨 Interface Web

- **Design responsivo** e intuitivo em português
- **Filtros dinâmicos** para busca de atividades por:
  - Busca textual
  - Categoria (Esportes, Artes, Acadêmica, Comunidade, Tecnologia)
  - Dia da semana (Segunda a Domingo)
  - Horário (Manhã, Tarde, Fim de semana)
- **Sistema de autenticação** com modal de login
- **Modais** para login e inscrições de estudantes
- **Feedback visual** para ações do usuário
- **Exibição de participantes** por atividade

## 🔧 Configuração e Execução

### Pré-requisitos

- Java 21
- Maven 3.8+
- MongoDB 4.4+

### Variáveis de Ambiente

Crie um arquivo `.env` baseado no `.env.example`

### Executando o Projeto

1. **Iniciar MongoDB**:

   ```bash
   # Docker
   docker run -d -p 27017:27017 --name mongodb mongo:latest
   
   # Ou MongoDB local
   mongod
   ```

2. **Compilar e executar**:

   ```bash
   # Compilar o projeto
   mvn clean compile
   
   # Executar os testes
   mvn test
   
   # Iniciar a aplicação
   mvn spring-boot:run
   ```

3. **Acessar a aplicação**:
   - Frontend: <http://localhost:8080>
   - API REST: <http://localhost:8080/activities>

### Tasks Maven Disponíveis

- `mvn clean install` - Build completo
- `mvn test` - Executar testes
- `mvn spring-boot:run` - Iniciar aplicação
- `mvn package -DskipTests` - Gerar JAR

## 🌐 API REST

### Endpoints Principais

#### Atividades

```http
GET /activities
GET /activities?day=Monday&start_time=15:00&end_time=17:00
GET /activities/days
```

#### Inscrições

```http
POST /activities/{activityName}/signup
Content-Type: application/x-www-form-urlencoded

email=student@mergington.edu&teacher_username=mrodriguez

POST /activities/{activityName}/unregister
Content-Type: application/x-www-form-urlencoded

email=student@mergington.edu&teacher_username=mrodriguez
```

#### Autenticação

```http
POST /auth/login
Content-Type: application/x-www-form-urlencoded

username=mrodriguez&password=art123

GET /auth/check-session?username=mrodriguez
```

## 🧪 Testes

### Estrutura de Testes

```text
src/test/java/
├── application/usecases/     # Testes de casos de uso
├── domain/entities/          # Testes de entidades
└── integration/             # Testes de integração
```

### Executar Testes

```bash
# Todos os testes
mvn test

# Testes específicos
mvn test -Dtest=ActivityTest
mvn test -Dtest=StudentRegistrationUseCaseTest

# Com cobertura
mvn jacoco:report
```

## 📊 Dados Iniciais

O sistema utiliza **Mongock** para realizar migrações automáticas do banco de dados, incluindo:

### Professores Padrão

- **principal** - Diretor Martinez (Administrador)
- **mrodriguez** - Sr. Rodriguez (Professor)
- **mchen** - Sra. Chen (Professor)

### Atividades Exemplo

- **Clube de Xadrez** - Segundas e sextas, 15:15-16:45
- **Aula de Programação** - Terças e quintas, 07:00-08:00
- **Clube de Arte** - Quintas, 15:15-17:00
- **Clube de Teatro** - Segundas e quartas, 15:30-17:30
- **Time de Futebol** - Terças e quintas, 15:30-17:30
- **Time de Basquete** - Quartas e sextas, 15:15-17:00
- **Manga Maniacs** - Terças, 19:00-20:30 (Clube de mangás)
- **Fitness Matinal** - Segundas, quartas e sextas, 06:30-07:45
- **Clube de Matemática** - Terças, 07:15-08:00
- **Equipe de Debates** - Sextas, 15:30-17:30
- **Oficina de Robótica** - Sábados, 10:00-14:00
- **Olimpíada de Ciências** - Sábados, 13:00-16:00
- **Torneio de Xadrez** - Domingos, 14:00-17:00
- **Serviço Comunitário** - Sábados, 09:00-12:00

## 🔒 Segurança

- **Autenticação HTTP Basic** para endpoints administrativos
- **Criptografia Argon2** para senhas
- **Validação de dados** em todas as camadas
- **CORS** configurado para desenvolvimento

## 📈 Monitoramento

- **Spring Actuator** - Métricas da aplicação
- **Logs estruturados** - Nível DEBUG para desenvolvimento
- **Health checks** - Status da aplicação e banco

## 🚀 Deploy

### Perfis de Ambiente

- **dev** - Ambiente de desenvolvimento
