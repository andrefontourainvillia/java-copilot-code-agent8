---
name: 🐛 Reportar Bug ou Problema
about: Reportar um problema ou erro encontrado no sistema de atividades extracurriculares
title: "[BUG] "
labels: ["bug", "teacher-request"]
assignees: ["copilot"]
---

## 🐛 Descrição do Problema

### Resumo do Bug
**O que está acontecendo:**
<!-- Ex: Não consigo adicionar alunos na atividade de xadrez -->

**O que deveria estar acontecendo:**
<!-- Ex: Deveria conseguir inscrever alunos normalmente -->

## 📍 Localização do Problema

### Onde o problema ocorre?
- [ ] Página inicial / Dashboard
- [ ] Lista de atividades
- [ ] Página de inscrição de alunos
- [ ] Edição de atividades
- [ ] Login / Autenticação
- [ ] Relatórios
- [ ] Outro (especificar): 

### URL ou tela específica (se aplicável):
**URL:** 
**Tela:** 

## 🔄 Passos para Reproduzir

**Como reproduzir o problema:**
1. 
2. 
3. 
4. 

**Resultado atual:**
<!-- O que acontece quando você segue os passos acima -->

**Resultado esperado:**
<!-- O que deveria acontecer -->

## 📊 Informações Técnicas

### Contexto do Usuário
**Seu usuário:** 
<!-- Ex: mrodriguez, mchen, principal -->

**Quando o problema começou:**
- [ ] Hoje
- [ ] Esta semana  
- [ ] Sempre foi assim
- [ ] Não sei dizer

### Informações do Sistema
**Navegador usado:**
- [ ] Chrome
- [ ] Firefox
- [ ] Safari
- [ ] Edge
- [ ] Outro: 

**Dispositivo:**
- [ ] Computador Desktop
- [ ] Laptop
- [ ] Tablet
- [ ] Celular

### Dados Relacionados (se aplicável)
**Atividade afetada:** 
**Aluno(s) afetado(s):** 
**Horário aproximado:** 

## 💾 Evidências

### Mensagens de Erro
**Se há mensagem de erro, cole aqui:**
```
[Cole a mensagem de erro exata aqui]
```

### Capturas de Tela
**Se possível, adicione capturas de tela:**
<!-- Cole imagens ou descreva o que você vê na tela -->

## 🎯 Impacto

### Severidade do Problema
- [ ] 🔴 Crítico - Não consigo trabalhar
- [ ] 🟡 Alto - Dificulta muito o trabalho
- [ ] 🟢 Médio - Inconveniente mas consigo contornar
- [ ] 🔵 Baixo - Problema menor

### Quantas pessoas afeta?
- [ ] Só eu
- [ ] Alguns professores
- [ ] Todos os professores
- [ ] Também afeta alunos

### Workaround (solução temporária)
**Existe alguma forma de contornar o problema?**
<!-- Ex: "Consigo fazer pelo celular" ou "Não consegui encontrar alternativa" -->

## 🔧 Contexto Técnico para o Agente Copilot

### Áreas de Investigação Prioritárias:

#### Frontend Issues:
1. **Static Resources**: Verificar `src/main/resources/static/` se problema de interface
2. **CORS Configuration**: Checar configuração CORS em desenvolvimento
3. **Form Submissions**: Validar `application/x-www-form-urlencoded` submissions
4. **Authentication Flow**: Verificar fluxo de login com `teacher_username`

#### Backend Issues:
1. **Controller Layer**: Verificar `presentation/controllers/` para erros de endpoint
2. **Use Case Layer**: Checar `application/usecases/` para erros de lógica
3. **Domain Validation**: Verificar validações em `domain/entities/`
4. **Database Layer**: Checar `infrastructure/persistence/` para problemas de dados

#### Data Issues:
1. **MongoDB Connection**: Verificar configuração de banco
2. **Mongock Migrations**: Checar se migrations executaram corretamente
3. **Data Integrity**: Validar consistência dos dados
4. **Seed Data**: Verificar se dados iniciais estão corretos

### Arquivos de Investigação por Tipo de Problema:

#### Authentication Problems:
- `application/usecases/AuthenticationUseCase.java`
- `presentation/controllers/AuthController.java`
- `infrastructure/security/` (se existir)

#### Activity Management Problems:
- `domain/entities/Activity.java`
- `application/usecases/ActivityUseCase.java`
- `presentation/controllers/ActivityController.java`
- `infrastructure/persistence/ActivityRepositoryImpl.java`

#### Registration Problems:
- `application/usecases/StudentRegistrationUseCase.java`
- `domain/valueobjects/Email.java`
- `domain/entities/Activity.java` (métodos addParticipant/removeParticipant)

### Debugging Strategy:
1. **Logs**: Verificar logs da aplicação para stack traces
2. **Database**: Consultar MongoDB para verificar estado dos dados
3. **Network**: Verificar requests/responses HTTP
4. **Validation**: Testar todas as validações de domínio
5. **Environment**: Verificar variáveis de ambiente e configurações

### Testing Approach:
1. **Unit Tests**: Executar testes relacionados ao módulo afetado
2. **Integration Tests**: Verificar fluxo completo da funcionalidade
3. **Manual Testing**: Reproduzir problema em ambiente de desenvolvimento
4. **Data Verification**: Verificar integridade e formato dos dados

## 📝 Informações Adicionais

**Contexto adicional:**
<!-- Qualquer informação extra que possa ajudar a entender ou reproduzir o problema -->

**Tentativas de solução:**
<!-- Se você tentou algo para resolver, descreva aqui -->

---
**⚠️ Importante:** Quanto mais detalhes fornecidos, mais rápido o agente Copilot conseguirá identificar e corrigir o problema. Inclua mensagens de erro exatas sempre que possível.