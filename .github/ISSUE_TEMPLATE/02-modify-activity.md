---
name: ⚙️ Modificar Atividade Existente
about: Solicitar alterações em uma atividade extracurricular já cadastrada
title: "[MODIFICAR ATIVIDADE] "
labels: ["enhancement", "activity", "teacher-request", "modification"]
assignees: ["copilot"]
---

## 📋 Identificação da Atividade

### Atividade a ser Modificada
**Nome da atividade atual:** 
<!-- Ex: Programming Club, Chess Club, Art Class -->

## 🔄 Alterações Solicitadas

### Que tipo de modificação você precisa?
- [ ] Alterar horário/cronograma
- [ ] Modificar capacidade máxima
- [ ] Alterar descrição
- [ ] Mudar nome da atividade
- [ ] Alterar categoria/tipo
- [ ] Remover atividade completamente
- [ ] Outro (especificar abaixo)

## 📝 Detalhes das Modificações

### Alteração de Nome (se aplicável)
**Nome atual:** 
**Novo nome:** 

### Alteração de Descrição (se aplicável)
**Descrição atual:** 
```
[Cole aqui a descrição atual, se souber]
```

**Nova descrição:** 
```
[Descreva como deve ficar a nova descrição]
```

### Alteração de Horário (se aplicável)
**Horário atual:** 
<!-- Ex: Segundas e quartas das 14h às 16h -->

**Novo horário:**
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

### Alteração de Capacidade (se aplicável)
**Capacidade atual:** 
**Nova capacidade:** 
<!-- Número máximo de participantes -->

### Alteração de Categoria (se aplicável)
**Nova categoria:**
- [ ] Esportes (SPORTS)
- [ ] Artes (ARTS)
- [ ] Acadêmico (ACADEMIC)
- [ ] Comunidade (COMMUNITY)
- [ ] Tecnologia (TECHNOLOGY)

## 📖 Justificativa
**Por que esta modificação é necessária?**
<!-- Ex: Mudança de horário devido a conflito com outras atividades, aumento de demanda, etc. -->

## 👥 Impacto nos Alunos
**Esta modificação afeta alunos já inscritos?**
- [ ] Sim - é necessário notificar os alunos
- [ ] Não - não há impacto nos alunos atuais
- [ ] Não sei

**Se sim, como devemos proceder com os alunos já inscritos?**
- [ ] Manter inscrições atuais
- [ ] Remover todas as inscrições (eles precisarão se inscrever novamente)
- [ ] Notificar alunos mas manter inscrições

## 🎯 Critérios de Aceitação

- [ ] A atividade deve manter seu identificador único (nome original é usado como ID)
- [ ] Modificações devem ser refletidas na interface do sistema
- [ ] Se houver mudança de horário, não deve conflitar com outras atividades do mesmo professor
- [ ] Se houver redução de capacidade, verificar se não excede número atual de inscritos
- [ ] Alunos inscritos devem continuar funcionando corretamente (a menos que especificado diferente)
- [ ] Validações de domínio devem ser aplicadas nas alterações

## 🔧 Contexto Técnico para o Agente Copilot

### Implementação Necessária:
1. **Entity Update**: Usar setters da entidade `Activity` que já incluem validações
2. **Database Update**: Criar migration Mongock para atualizar dados existentes
3. **Validation**: Aplicar todas as validações de domínio nas alterações
4. **ID Consistency**: O `name` é usado como ID - se nome mudar, considerar impacto
5. **Participant Management**: Verificar compatibilidade com inscrições existentes

### Arquivos Relevantes:
- `domain/entities/Activity.java` - Métodos setter com validação
- `infrastructure/migrations/` - Nova migration para updates
- `application/usecases/ActivityUseCase.java` - Lógica de atualização
- `infrastructure/persistence/ActivityRepositoryImpl.java` - Operações de update

### Considerações Especiais:
- **ID Changes**: Se nome mudar, pode ser necessário strategy de migração de dados
- **Capacity Reduction**: Validar se `newCapacity >= currentParticipants.size()`
- **Schedule Conflicts**: Verificar conflitos de horário se professor gerencia múltiplas atividades
- **Participant Impact**: Considerar notificação/migração de participantes se necessário

### Padrões de Implementação:
- Usar métodos setter da entidade para validações automáticas
- Implementar via migration Mongock para mudanças persistentes
- Validar regras de negócio antes de aplicar mudanças
- Manter consistência referencial com participantes

## 📝 Informações Adicionais
<!-- Qualquer contexto adicional, urgência, ou considerações especiais -->

---
**⚠️ Importante:** Para modificações que afetam identificadores ou estrutura básica, pode ser necessário criar migration complexa. O agente Copilot analisará o impacto automaticamente.