# 🧠 Sistemas de Gerenciamento Integrados: Clínica Médica, Eventos e Restaurante

### 👥 Integrantes do Projeto
- Nunno Wakiyama Diniz Carvaho  
- Pedro Henrique Mendes Macedo  
- Ricardo Nery de Brito Junior  
- Matheus Fabiano Barbosa Aguiar  
- Noemi Soares Gonçalves da Silva

<p>-</p>

## 📌 Descrição

Este projeto é uma aplicação desenvolvida em Java que simula três sistemas de gerenciamento distintos:

- Clínica Médica
- Sistema de Eventos
- Restaurante

A proposta é aplicar conceitos de **Programação Orientada a Objetos**, com foco em encapsulamento, herança e modularidade, resultando em um sistema robusto, modular e interativo.

Além das funcionalidades específicas de cada módulo, há também um sistema de **integração centralizada** que une todos os serviços e implementa funcionalidades de **tomada de decisão** com base nos dados dos sistemas.

<p>__</p>

## 💻 Funcionalidades

<p>__</p>

### 🏥 Case 1: Sistema de Gerenciamento Clínica Médica  

---

#### 📋 Descrição Geral

O sistema de gerenciamento de clínicas médicas, desenvolvido em **Java**, tem como objetivo principal a criação e administração de **consultas médicas**, com base nos **médicos** e **pacientes** cadastrados.

Além disso, o sistema incorpora funcionalidades voltadas à **usabilidade**, como:

- Identificação do **médico mais requisitado**
- Consulta de **datas e horários ocupados** por um médico específico

Os usuários podem:

- Inserir novos médicos e pacientes
- Agendar novas consultas

---

#### 🧱 Estrutura de Classes

##### 🏛️ Classe `Clinica`

A principal classe do sistema. Seus atributos são três `ArrayList` contendo objetos das classes:

- `Medico`
- `Consulta`
- `Paciente`

Principais funções:

- `adicionarConsulta()`
- `adicionarMedico()`
- `adicionarPaciente()`
- `criarPaciente()`
- `criarMedico()`
- `criarConsulta()`
- `exibirDadosConsulta()`
- `exibirDadosMedico()`
- `exibirDadosPaciente()`

Funções auxiliares:

- `dataHorariosDeUmMedico()` – lista datas e horários ocupados
- `medicoMaisSolicitado()` – retorna o médico com mais consultas

---

##### 👤 Classe `Paciente`

Responsável por armazenar os dados do paciente.

**Atributos:**

- `String nomePaciente`
- `int idade`
- `String sintoma`
- `boolean planoSaude`
- `String numeroContato`
- `String tipoSanguineo`

**Funcionalidades:**

- Construtor para inicializar atributos
- Métodos `getters` e `setters`
- Função `temPlanoSaude()` – exibe mensagem conforme o plano de saúde do paciente

---

##### 🩺 Classe `Medico`

Armazena os dados dos médicos cadastrados.

**Atributos:**

- `String nomeMedico`
- `boolean disponibilidade`
- `String especializacao`
- `int crm`
- `int numeroDeConsultas`

**Funcionalidades:**

- Construtor para inicialização
- Métodos `getters` e `setters`
- `estaDisponivel()` – exibe status de disponibilidade
- `incrementarContadorDeConsultas()` – incrementa o contador de consultas

---

##### 📅 Classe `Consulta`

Registra os dados de uma consulta.

**Atributos:**

- `String data`
- `String horario`
- `boolean prioridade`
- `Medico medico`
- `Paciente paciente`

**Funcionalidades:**

- Construtor para inicialização
- Métodos `getters` e `setters`
- `possivelPrioridade()` – exibe se o paciente tem prioridade (com base no plano de saúde)

---

Este módulo é totalmente encapsulado e pronto para ser integrado a sistemas maiores. Ele exemplifica o uso eficiente de **POO em Java**, com foco em modularidade, reuso de código e tomada de decisão automatizada.

<p>-</p>

### 🎉 Case 2: Sistema de Gerenciamento de Eventos  

---

#### 📋 Descrição Geral

O sistema foi projetado para oferecer uma solução prática de controle e automação na gestão de eventos. As funcionalidades principais incluem:

- Inscrição de participantes  
- Gerenciamento de eventos e atrações  
- Controle do local do evento  

---

#### 🧱 Estrutura de Classes

##### 📅 Classe `Evento`

Responsável por centralizar a lógica de gerenciamento do evento.

**Atributos:**

- `String nomeEvento`
- `String data`
- `Local local` (instância da classe `Local`)
- `int capacidadeMaxima`
- `ArrayList<Participante> participantes`

**Principais métodos:**

- `registrarParticipante()` – inscreve participantes se houver vagas
- `verificarLotacao()` – confirma se a capacidade foi atingida
- `gerarRelatorio()` – exibe detalhes do evento, local e lista de participantes

---

##### 📍 Classe `Local`

Gerencia informações sobre o local do evento.

**Atributos:**

- `String nomeLocal`
- `String endereco`

**Funcionalidades:**

- Métodos `getters`
- Sobrescrita de `toString()` para exibir: `"nomeLocal (endereço)"`

---

##### 🖥️ Classe `main_event`

Atua como interface principal com o usuário, utilizando a classe `Scanner`.

**Organização funcional:**

- **Gerenciamento do evento:**  
  - Adicionar/remover atrações  
  - Gerar relatórios (limite de atrações por evento)

- **Gerenciamento de participantes:**  
  - Registro com nome, idade, tipo de entrada (meia/inteira)  
  - Verificação da capacidade  

- **Gerenciamento do local:**  
  - Alterar local do evento  
  - Ajustar limite de participantes  
  - Verificar lotação  

---

#### 💡 Observações

Este sistema é modular e extensível, com potencial para receber melhorias como novos tipos de relatórios ou uma interface gráfica. A aplicação prática de **POO em Java** com **encapsulamento e abstração** permite um fluxo de trabalho claro, organizado e eficiente.

---

<p>-</p>

### 🍽️ Case 3: Sistema de Gerenciamento de Restaurante  

---

#### 📋 Descrição Geral

Um sistema em Java criado para gerenciar mesas, pedidos e itens do menu de um restaurante. Estruturado de forma modular, cada classe possui responsabilidades bem definidas.

---

#### 🧱 Estrutura de Classes

##### 🏪 Classe `Restaurante`

Núcleo do sistema. Controla:

- A lista de mesas (15 mesas por padrão)
- Registro e gerenciamento de pedidos

**Principais métodos:**

- `inicializarMesas()` – define todas as mesas como disponíveis  
- `fazerPedido(mesa, cliente)` – registra pedidos por mesa  
- `fecharConta()` – calcula o total e apresenta opções de pagamento (inclusive divisão da conta)

---

##### 🍴 Classe `Mesa`

Representa cada mesa do restaurante.

**Atributos:**

- `int numero`
- `boolean ocupada`

**Métodos:**

- `reservar()` – marca como ocupada  
- `liberar()` – marca como disponível  

---

##### 🧾 Classe `Pedido`

Gerencia os pedidos da mesa.

**Principais métodos:**

- `adicionarItem(item)` – adiciona um item ao pedido  
- `removerItem(item)` – remove um item  
- `calcularTotal()` – retorna o valor total do pedido  

---

##### 🧂 Classe `ItemDoPedido`

Define os itens do menu.

**Atributos:**

- `String nome`
- `double preco`
- `String tamanho` (porção)

Facilita a personalização e apresentação do cardápio.

---

#### 🧑‍💻 Interação com o Usuário

O sistema utiliza `Scanner` para capturar entradas em um **menu interativo**, com opções como:

- Fazer pedido  
- Fechar conta  
- Verificar disponibilidade de mesas  

---

#### 💡 Observações

O sistema cobre todas as áreas essenciais da operação de um restaurante. Seu design permite expansões futuras como:

- Gerenciamento de estoque  
- Painel administrativo para análises de vendas  

A aplicação dos princípios de **POO**, aliada à modularidade do código, garante eficiência e manutenção simplificada.

<p>-</p>

### 🔗 Case 4: Integração dos Sistemas de Gerenciamento  
**Sistema Integrado de Restaurante, Eventos e Clínica**

---

#### 📋 Descrição Geral

O sistema unifica o gerenciamento de **três serviços distintos**:  
- Restaurante  
- Eventos  
- Clínica médica  

Através de um **menu principal interativo**, o usuário pode acessar qualquer um dos módulos, otimizando o gerenciamento e facilitando a navegação entre funcionalidades.

---

#### 🧱 Classe Principal: `SistemaIntegrado`

Atua como **núcleo do sistema**.

**Atributos:**

- `Restaurante restaurante`
- `Clinica clinica`
- `ArrayList<Evento> eventos`

**Funcionalidades do construtor:**

- Inicializa os objetos de cada serviço  
- Prepara o ambiente para uso imediato  

---

#### 🧭 Método: `exibirMenuPrincipal()`

Exibe o menu principal com opções como:

1. Acessar Restaurante  
2. Gerenciar Eventos  
3. Acessar Clínica  
4. Responder perguntas de **tomada de decisão**  
5. Sair do sistema  

Um loop `while` mantém o menu ativo até o usuário optar por encerrar o programa.

---

#### 🍽️ Módulo: Gerenciamento de Restaurante

Funcionalidades disponíveis:

- Exibição do cardápio  
- Realização de pedidos  
- Fechamento de contas  
- Verificação de status de pedidos  
- Geração de **relatórios financeiros detalhados**  

---

#### 🎉 Módulo: Gerenciamento de Eventos

Permite:

- Criação de novos eventos  
- Registro de participantes  
- Geração de relatórios de desempenho  
- Identificação de eventos mais populares e rentáveis  

Ideal para **organizadores que buscam controle preciso** sobre suas atividades.

---

#### 🏥 Módulo: Gerenciamento de Clínica

Oferece:

- Cadastro de médicos e pacientes  
- Agendamento de consultas  
- Relatórios sobre consultas realizadas  
- Identificação de **médicos mais solicitados**

Auxilia clínicas a **otimizar recursos e agendas médicas**.

---

#### 📊 Módulo: Tomada de Decisões

Inclui perguntas analíticas para auxiliar em decisões estratégicas, como:

- Qual o prato mais pedido no restaurante?  
- Qual evento teve maior receita?  
- Qual médico foi mais procurado?  

Essas perguntas fornecem **insights valiosos para a gestão eficiente** de cada serviço.

---

#### 💡 Conclusão

O sistema integrado proporciona uma **solução robusta e flexível** para o gerenciamento simultâneo de diferentes áreas de negócio. Sua arquitetura modular e capacidade de análise tornam-no ideal para **projetos que buscam eficiência, organização e embasamento para decisões mais assertivas**.

<p>-</p>

## 🛠️ Tecnologias Utilizadas

- **Java (JDK 17)**
- Programação Orientada a Objetos
- Paradigma modular
- Entrada de dados via `Scanner`
- `ArrayList` para controle dinâmico de dados

<p>-</p>

## 🧠 Conclusão
Este projeto nos proporcionou a oportunidade de aplicar os conceitos de POO na prática e desenvolver um sistema funcional com diferentes contextos de uso. Conseguimos integrar os módulos de forma coesa e implementar funcionalidades estratégicas que ampliam a utilidade do sistema. Foi um exercício fundamental na organização de código, trabalho em equipe e na criação de soluções práticas em Java.
