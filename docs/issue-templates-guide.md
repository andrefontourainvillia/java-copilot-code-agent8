# 📋 Guia de Templates de Issue para Professores

## 🎯 Visão Geral

Este sistema oferece templates padronizados para que professores possam solicitar modificações no sistema de gerenciamento de atividades extracurriculares de forma simples e eficiente. Cada template coleta todas as informações necessárias para que o agente de codificação Copilot possa implementar as mudanças automaticamente.

## 📚 Templates Disponíveis

### 1. 🎯 Adicionar Nova Atividade Extracurricular
**Quando usar:** Para criar uma nova atividade no sistema.

**Informações coletadas:**
- Nome e descrição da atividade
- Categoria (Esportes, Artes, Acadêmico, Comunidade, Tecnologia)
- Horários e dias da semana
- Capacidade máxima de alunos
- Professor responsável

**Resultado:** Nova atividade criada e disponível para inscrições de alunos.

### 2. ⚙️ Modificar Atividade Existente
**Quando usar:** Para alterar informações de uma atividade já cadastrada.

**Tipos de modificação:**
- Alterar horário/cronograma
- Modificar capacidade máxima
- Alterar descrição ou nome
- Mudar categoria
- Remover atividade

**Resultado:** Atividade atualizada conforme solicitado, com preservação de inscrições existentes.

### 3. 👥 Gerenciar Inscrições de Alunos
**Quando usar:** Para modificar inscrições de alunos ou regras de inscrição.

**Funcionalidades:**
- Inscrever/remover alunos manualmente
- Modificar processo de inscrições
- Gerar relatórios de inscrições
- Implementar lista de espera

**Resultado:** Sistema de inscrições ajustado conforme necessidade.

### 4. 🐛 Reportar Bug ou Problema
**Quando usar:** Quando algo não está funcionando corretamente.

**Informações coletadas:**
- Descrição detalhada do problema
- Passos para reproduzir
- Contexto técnico (navegador, dispositivo)
- Severidade e impacto

**Resultado:** Problema identificado e corrigido rapidamente.

### 5. ✨ Solicitar Nova Funcionalidade
**Quando usar:** Para sugerir melhorias ou novas funcionalidades.

**Categorias:**
- Notificações e Comunicação
- Relatórios e Analytics
- Gestão de Usuários/Horários
- Melhorias de Interface
- Integrações Externas

**Resultado:** Funcionalidade avaliada e implementada conforme viabilidade.

### 6. 📅 Alterar Horários e Cronogramas
**Quando usar:** Para mudanças específicas de horários.

**Tipos de alteração:**
- Mudanças permanentes ou temporárias
- Resolução de conflitos de horário
- Horários extras ou alternativos

**Resultado:** Horários atualizados com verificação automática de conflitos.

### 7. 💬 Pergunta ou Suporte Geral
**Quando usar:** Para dúvidas sobre como usar o sistema.

**Tipos de suporte:**
- Como usar funcionalidades existentes
- Melhores práticas
- Interpretação de dados/relatórios
- Treinamento e documentação

**Resultado:** Resposta detalhada ou criação de documentação adicional.

## 🚀 Como Usar os Templates

### Passo 1: Acesse as Issues
1. Vá para o repositório no GitHub
2. Clique na aba "Issues"
3. Clique em "New Issue"

### Passo 2: Escolha o Template
1. Selecione o template que melhor descreve sua necessidade
2. O template será carregado automaticamente

### Passo 3: Preencha as Informações
1. Complete todos os campos obrigatórios
2. Seja específico e detalhado
3. Use os exemplos fornecidos como guia

### Passo 4: Envie a Solicitação
1. Revise as informações preenchidas
2. Clique em "Submit new issue"
3. O agente Copilot será automaticamente designado

## ✅ Dicas para Melhores Resultados

### 📝 Seja Específico
- Use exemplos concretos
- Forneça dados exatos (horários, nomes, números)
- Descreva o resultado esperado claramente

### 🎯 Escolha o Template Correto
- Leia as descrições dos templates
- Use o template mais específico possível
- Para dúvidas, use o template de "Pergunta ou Suporte"

### 📋 Preencha Todos os Campos
- Campos marcados como obrigatórios são essenciais
- Informações técnicas ajudam na implementação
- Critérios de aceitação garantem qualidade

### ⏰ Indique Urgência
- Especifique prazos quando relevante
- Explique impacto de atrasos
- Use níveis de prioridade apropriados

## 🔧 Informações Técnicas

### Processamento Automático
Os templates foram projetados para fornecer todas as informações necessárias para implementação automática pelo agente Copilot, incluindo:

- **Contexto Técnico:** Arquivos relevantes e padrões de implementação
- **Validações:** Regras de negócio e critérios de aceitação
- **Arquitetura:** Guidance sobre Clean Architecture e separação de camadas
- **Testes:** Sugestões para validação de funcionalidades

### Assignee Automático
- Todos os templates automaticamente designam `@copilot`
- O agente processará a solicitação automaticamente
- Implementação seguirá padrões estabelecidos no sistema

### Labels Organizacionais
- `teacher-request`: Identifica solicitações de professores
- `enhancement`, `bug`, `question`: Categoriza tipo de solicitação
- `activity`, `schedule`, `registration`: Especifica área funcional

## 📞 Suporte

Se você tiver dúvidas sobre qual template usar ou como preencher as informações, use o template "💬 Pergunta ou Suporte Geral" - ele foi projetado especificamente para ajudar com essas questões.

## 🔄 Processo de Atendimento

1. **Submissão:** Issue criada com template preenchido
2. **Análise:** Agente Copilot analisa requisitos
3. **Implementação:** Código desenvolvido seguindo padrões
4. **Testes:** Validação automática da funcionalidade
5. **Entrega:** Funcionalidade disponível no sistema
6. **Feedback:** Confirmação e esclarecimentos se necessário

---

**💡 Lembre-se:** Quanto mais detalhadas as informações fornecidas, mais rápida e precisa será a implementação. Os templates foram criados para simplificar este processo e garantir que nada importante seja esquecido.