---
name: 🎯 Adicionar Nova Atividade Extracurricular
about: Solicitar a criação de uma nova atividade extracurricular no sistema
title: "[NOVA ATIVIDADE] "
labels: ["enhancement", "activity", "teacher-request"]
assignees: ["copilot"]
---

## 📋 Informações da Nova Atividade

### Nome da Atividade
**Nome:** 
<!-- Ex: Club de Xadrez Avançado, Robótica para Iniciantes -->

### Descrição Detalhada
**Descrição:**
```
[Descreva a atividade em detalhes - o que os alunos farão, objetivos, metodologia]
```

### Categoria/Tipo
**Tipo de Atividade:** 
- [ ] Esportes (SPORTS)
- [ ] Artes (ARTS) 
- [ ] Acadêmico (ACADEMIC)
- [ ] Comunidade (COMMUNITY)
- [ ] Tecnologia (TECHNOLOGY)

### Horários e Cronograma
**Dias da Semana:**
- [ ] Segunda-feira
- [ ] Terça-feira
- [ ] Quarta-feira
- [ ] Quinta-feira
- [ ] Sexta-feira
- [ ] Sábado
- [ ] Domingo

**Horário:**
- **Início:** [Ex: 14:00]
- **Término:** [Ex: 16:00]

**Descrição do horário (formato texto):**
<!-- Ex: "Segundas e quartas das 14h às 16h" -->

### Capacidade
**Número máximo de participantes:** 
<!-- Ex: 25 alunos -->

### Professor Responsável
**Seu nome de usuário:** 
<!-- Ex: mrodriguez, mchen, principal -->

## 🎯 Critérios de Aceitação

- [ ] A nova atividade deve aparecer na lista de atividades disponíveis
- [ ] Alunos devem conseguir se inscrever na atividade
- [ ] O sistema deve respeitar o limite máximo de participantes
- [ ] A atividade deve ser categorizada automaticamente com base no nome/descrição
- [ ] O horário deve ser validado (hora início < hora fim)
- [ ] A atividade deve aparecer no painel do professor responsável

## 🔧 Contexto Técnico para o Agente Copilot

### Implementação Necessária:
1. **Database Migration**: Adicionar nova atividade via Mongock migration em `infrastructure/migrations/`
2. **Entity Validation**: A entidade `Activity` já possui validações para nome, descrição e capacidade
3. **Schedule Format**: Usar `ScheduleDetails` record com `List<String> days`, `LocalTime startTime/endTime`
4. **Activity Type**: O sistema determina automaticamente o tipo baseado em palavras-chave no nome/descrição
5. **Teacher Assignment**: Validar que o professor existe no sistema

### Arquivos Relevantes:
- `domain/entities/Activity.java` - Entidade principal
- `domain/valueobjects/ScheduleDetails.java` - Estrutura de horários
- `domain/valueobjects/ActivityType.java` - Categorização automática
- `infrastructure/migrations/` - Para persistir nova atividade
- `application/usecases/ActivityUseCase.java` - Lógica de negócio

### Padrões de Implementação:
- Usar construtor completo da entidade `Activity`
- Validar dados no domínio (construtor/setters)
- Implementar via migration Mongock para persistência
- Seguir padrão Clean Architecture (dependências apontam para dentro)

## 📝 Informações Adicionais
<!-- Qualquer contexto adicional, requisitos especiais, ou considerações importantes -->

---
**⚠️ Importante:** Este template fornece todas as informações necessárias para que o agente Copilot possa implementar a funcionalidade automaticamente. Preencha todos os campos obrigatórios.