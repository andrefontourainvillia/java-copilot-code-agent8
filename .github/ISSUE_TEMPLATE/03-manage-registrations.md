---
name: 👥 Gerenciar Inscrições de Alunos
about: Solicitar modificações no sistema de inscrições de alunos em atividades
title: "[INSCRIÇÕES] "
labels: ["enhancement", "registration", "teacher-request"]
assignees: ["copilot"]
---

## 📋 Informações da Solicitação

### Atividade Relacionada
**Nome da atividade:** 
<!-- Ex: Programming Club, Chess Club -->

### Tipo de Modificação de Inscrição
- [ ] Inscrever aluno manualmente
- [ ] Remover inscrição de aluno
- [ ] Modificar sistema de inscrições (processo/regras)
- [ ] Criar lista de espera
- [ ] Alterar validações de e-mail
- [ ] Relatório de inscrições
- [ ] Outro (especificar)

## 👤 Gestão Individual de Alunos

### Inscrever Aluno (se aplicável)
**E-mail do aluno:** 
<!-- Ex: joao.silva@student.mergingtonhigh.edu -->

**Justificativa para inscrição manual:**
<!-- Ex: Aluno perdeu prazo, caso especial, transferência -->

### Remover Inscrição (se aplicável)
**E-mail do aluno a ser removido:** 

**Motivo da remoção:**
<!-- Ex: Aluno solicitou cancelamento, transferência, problemas disciplinares -->

## 🔧 Modificações no Sistema

### Alterações nas Regras de Inscrição (se aplicável)
**Que regra precisa ser modificada?**
- [ ] Permitir inscrições mesmo com atividade lotada
- [ ] Implementar sistema de lista de espera
- [ ] Modificar validação de formato de e-mail
- [ ] Alterar processo de inscrição (automático vs manual)
- [ ] Implementar pré-requisitos para inscrição
- [ ] Outro (especificar)

**Descrição detalhada da modificação:**
```
[Explique exatamente como o sistema deve funcionar após a modificação]
```

### Relatórios e Consultas (se aplicável)
**Que tipo de relatório você precisa?**
- [ ] Lista completa de inscritos em uma atividade
- [ ] Lista de atividades com vagas disponíveis
- [ ] Alunos inscritos em múltiplas atividades
- [ ] Histórico de inscrições/cancelamentos
- [ ] Estatísticas de ocupação por atividade

**Formato desejado:**
- [ ] Lista no sistema web
- [ ] Arquivo CSV para download
- [ ] Relatório em PDF
- [ ] API endpoint para consulta

## 🎯 Critérios de Aceitação

### Para Inscrições Individuais:
- [ ] Inscrição deve respeitar limite de capacidade (a menos que especificado diferente)
- [ ] E-mail deve ser validado antes da inscrição
- [ ] Sistema deve prevenir inscrições duplicadas
- [ ] Deve haver feedback claro de sucesso/erro

### Para Modificações do Sistema:
- [ ] Novas regras devem ser aplicadas consistentemente
- [ ] Sistema deve manter integridade dos dados existentes
- [ ] Interface deve refletir novas funcionalidades
- [ ] Validações devem ser apropriadas para novos fluxos

### Para Relatórios:
- [ ] Dados devem estar atualizados e precisos
- [ ] Formato deve ser adequado para uso pretendido
- [ ] Performance deve ser adequada para volume de dados

## 🔧 Contexto Técnico para o Agente Copilot

### Implementação Necessária:

#### Para Gestão Individual:
1. **Manual Registration**: Usar método `addParticipant(Email)` da entidade `Activity`
2. **Manual Removal**: Usar método `removeParticipant(Email)` da entidade `Activity`
3. **Validation**: Aplicar validação de `Email` value object
4. **Use Case**: Implementar em `StudentRegistrationUseCase` ou `ActivityUseCase`

#### Para Modificações do Sistema:
1. **Business Rules**: Modificar validações na entidade `Activity`
2. **Waiting List**: Pode requerer nova entidade ou campo na `Activity`
3. **Email Validation**: Modificar `Email` value object se necessário
4. **Process Changes**: Ajustar controllers e use cases

#### Para Relatórios:
1. **Query Methods**: Implementar em `ActivityRepository`
2. **DTOs**: Criar DTOs específicos para relatórios se necessário
3. **Controllers**: Criar endpoints para relatórios
4. **Export**: Implementar serialização CSV/PDF se solicitado

### Arquivos Relevantes:
- `domain/entities/Activity.java` - Métodos de gestão de participantes
- `domain/valueobjects/Email.java` - Validação de e-mail
- `application/usecases/StudentRegistrationUseCase.java` - Lógica de inscrições
- `presentation/controllers/ActivityController.java` - Endpoints relacionados
- `infrastructure/persistence/ActivityRepositoryImpl.java` - Consultas de dados

### Padrões de Implementação:
- Validar e-mail usando `Email` value object antes de operações
- Aplicar regras de negócio na camada de domínio
- Usar use cases para coordenar operações complexas
- Manter consistência de dados em operações de modificação
- Implementar relatórios via repository queries otimizadas

### Considerações Especiais:
- **Capacity Override**: Se inscrição manual deve ignorar limite, documentar exceção
- **Email Format**: Sistema atual usa formato específico - verificar compatibilidade
- **Concurrency**: Considerar cenários de inscrições simultâneas
- **Audit Trail**: Pode ser necessário log de modificações manuais

## 📝 Contexto Adicional
**Professor responsável:** 
**Urgência:** 
- [ ] Baixa - pode aguardar próxima sprint
- [ ] Média - necessário esta semana
- [ ] Alta - necessário hoje

**Informações extras:**
<!-- Qualquer contexto adicional, restrições, ou requirements especiais -->

---
**⚠️ Importante:** Para modificações que afetam regras de negócio core, o agente Copilot analisará impacto em todo o sistema antes de implementar.