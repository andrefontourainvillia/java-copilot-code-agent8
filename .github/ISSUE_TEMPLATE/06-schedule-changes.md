---
name: 📅 Alterar Horários e Cronogramas
about: Solicitar mudanças em horários de atividades ou resolução de conflitos de agenda
title: "[HORÁRIO] "
labels: ["enhancement", "schedule", "teacher-request"]
assignees: ["copilot"]
---

## 📅 Informações da Alteração de Horário

### Atividade Afetada
**Nome da atividade:** 
<!-- Ex: Programming Club, Chess Club -->

**Professor responsável:** 
<!-- Ex: mrodriguez, mchen, principal -->

### Tipo de Alteração
- [ ] Mudança permanente de horário
- [ ] Mudança temporária (algumas semanas)
- [ ] Resolução de conflito de horários
- [ ] Adição de horário extra
- [ ] Cancelamento de horário específico
- [ ] Criação de horários alternativos
- [ ] Outro (especificar): 

## 🕐 Detalhes do Horário Atual

### Configuração Atual
**Dias atuais:**
- [ ] Segunda-feira
- [ ] Terça-feira
- [ ] Quarta-feira
- [ ] Quinta-feira
- [ ] Sexta-feira
- [ ] Sábado
- [ ] Domingo

**Horário atual:**
- **Início:** 
- **Término:** 

**Descrição textual atual:** 
<!-- Ex: "Segundas e quartas das 14h às 16h" -->

## 🔄 Novo Horário Solicitado

### Nova Configuração
**Novos dias:**
- [ ] Segunda-feira
- [ ] Terça-feira
- [ ] Quarta-feira
- [ ] Quinta-feira
- [ ] Sexta-feira
- [ ] Sábado
- [ ] Domingo

**Novo horário:**
- **Início:** [Ex: 14:00]
- **Término:** [Ex: 16:00]

**Nova descrição textual:** 
<!-- Ex: "Terças e quintas das 15h às 17h" -->

### Período da Alteração (se temporária)
**Data de início:** 
**Data de término:** 
**Motivo da alteração temporária:** 

## 📋 Justificativa da Mudança

### Motivo da Alteração
- [ ] Conflito com outra atividade do mesmo professor
- [ ] Conflito com atividades de alunos
- [ ] Mudança na disponibilidade do professor
- [ ] Problema de infraestrutura/sala
- [ ] Melhoria na participação dos alunos
- [ ] Ajuste sazonal
- [ ] Outro (especificar): 

**Descrição detalhada:**
<!-- Explique por que esta mudança é necessária -->

## 🔍 Verificação de Conflitos

### Outras Atividades do Professor
**Você gerencia outras atividades que podem ter conflito?**
- [ ] Sim
- [ ] Não
- [ ] Não sei

**Se sim, liste as atividades:**
1. 
2. 
3. 

### Impacto nos Alunos
**Esta mudança pode afetar negativamente os alunos?**
- [ ] Não, horário é melhor para todos
- [ ] Pode afetar alguns alunos
- [ ] Sim, mas é necessário
- [ ] Não sei avaliar

**Como comunicar a mudança aos alunos:**
- [ ] E-mail direto
- [ ] Aviso no sistema
- [ ] Comunicado na próxima aula
- [ ] Não é necessário comunicar ainda

## ⚠️ Considerações Especiais

### Período de Transição
**Precisa de período de transição?**
- [ ] Mudança imediata
- [ ] Gradual ao longo de algumas semanas
- [ ] Aguardar final do período/módulo atual
- [ ] Flexível

### Recursos Necessários
**A mudança requer recursos adicionais?**
- [ ] Nova sala/espaço
- [ ] Equipamentos diferentes
- [ ] Apoio técnico
- [ ] Comunicação institucional
- [ ] Nenhum recurso adicional

## 🎯 Critérios de Aceitação

- [ ] Novo horário deve ser salvo corretamente no sistema
- [ ] Descrição textual deve refletir nova configuração
- [ ] Sistema deve validar que horário início < horário fim
- [ ] Não deve haver conflitos com outras atividades do mesmo professor
- [ ] Alunos inscritos devem permanecer na atividade (salvo especificado diferente)
- [ ] Interface deve mostrar novo horário imediatamente
- [ ] Se mudança temporária, deve reverter automaticamente

## 🔧 Contexto Técnico para o Agente Copilot

### Implementação Necessária:

#### Permanent Schedule Changes:
1. **Entity Update**: Usar setters `setSchedule()` e `setScheduleDetails()` em `Activity`
2. **Schedule Validation**: Aplicar validações do `ScheduleDetails` record
3. **Database Update**: Criar migration Mongock para atualizar dados persistentes
4. **Conflict Detection**: Verificar conflitos com outras atividades do mesmo professor

#### Temporary Schedule Changes:
1. **Temporary Override**: Considerar implementação de override temporário
2. **Scheduled Revert**: Sistema para reverter mudanças automaticamente
3. **History Tracking**: Manter histórico de mudanças se necessário
4. **Notification System**: Para lembrar de reverter alterações

### Arquivos Relevantes:
- `domain/entities/Activity.java` - Métodos de schedule management
- `domain/valueobjects/ScheduleDetails.java` - Validações de horário
- `infrastructure/migrations/` - Para persistir mudanças
- `application/usecases/ActivityUseCase.java` - Lógica de alteração
- `presentation/controllers/ActivityController.java` - Endpoints de schedule

### Schedule Validation Logic:
```java
// ScheduleDetails validation in domain
ScheduleDetails scheduleDetails = new ScheduleDetails(
    List.of("MONDAY", "WEDNESDAY"), // days
    LocalTime.of(14, 0),           // startTime
    LocalTime.of(16, 0)            // endTime
);
```

### Conflict Detection Strategy:
1. **Teacher Conflicts**: Query all activities for same teacher, compare schedules
2. **Time Overlap**: Check if any day + time ranges overlap
3. **Resource Conflicts**: If rooms/equipment are tracked, verify availability
4. **Student Impact**: Optional - check if registered students have conflicts

### Implementation Patterns:
- Use `ScheduleDetails` record for type-safe schedule representation
- Implement validation in domain layer (entity setters)
- Create specific use case for schedule updates with conflict checking
- Use Mongock migration for data persistence
- Consider event sourcing for schedule change history

### Technical Considerations:
- **Time Zones**: Ensure consistent time handling (LocalTime is timezone-agnostic)
- **Recurring Patterns**: Current system supports weekly recurring only
- **Validation Order**: Validate schedule format before checking conflicts
- **Rollback Strategy**: For failed updates or conflict resolution

## 📝 Informações Adicionais

### Urgência
- [ ] Imediata - precisa ser alterado hoje
- [ ] Esta semana
- [ ] Próximas duas semanas  
- [ ] Flexível

### Comunicação
**Como prefere ser notificado quando a alteração estiver pronta:**
- [ ] E-mail
- [ ] Notificação no sistema
- [ ] Não precisa notificar

**Contexto adicional:**
<!-- Qualquer informação extra relevante para a alteração -->

---
**⚠️ Importante:** O sistema verificará automaticamente conflitos de horário. Se houver conflitos detectados, você será notificado com sugestões de resolução.