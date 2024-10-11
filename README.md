# Sistemas de Gerenciamento Integrados: Clínica Médica, Eventos e Restaurante

### Integrantes do Projeto: Nunno Wakiyama Diniz Carvaho, Pedro Henrique Mendes Macedo, Ricardo Nery de Brito Junior, Matheus Fabiano Barbosa Aguiar e Noemi Soares Gonçalves da Silva

Neste projeto, desenvolvemos uma aplicação em Java que simula sistemas de gerenciamento em três contextos distintos: uma clínica médica, um sistema de eventos e um restaurante. O objetivo é aplicar conceitos de programação orientada a objetos, demonstrando nossa compreensão e habilidade na manipulação de objetos e na implementação de funcionalidades práticas.

Na clínica médica, criamos um sistema que permite agendar consultas, gerenciar informações de pacientes e médicos, e gerar relatórios de atendimentos. Para o sistema de eventos, abordamos a criação de um ambiente que facilita o cadastro de eventos e a inscrição de participantes, além de permitir o controle da lotação dos eventos. No contexto do restaurante, implementamos um sistema de gerenciamento de pedidos, que possibilita registrar pedidos, calcular o total a pagar e gerenciar a ocupação das mesas.

Este projeto também inclui a integração entre os sistemas, utilizando métodos que apoiam a tomada de decisões estratégicas. Elaboramos seis perguntas que podem ser respondidas por meio dos dados gerados pelos sistemas. Essas perguntas são fundamentais para auxiliar na análise de desempenho e na definição de estratégias.

A seguir, apresentamos o passo a passo das funcionalidades implementadas em cada um dos sistemas.

### Case 1: Sistema de Gerenciamento Clínica Médica - Nunno Wakiyama e Pedro Henrique



### Case 2: Sistema de Gerenciamento de Eventos - Ricardo Nery e Matheus Fabiano

O sistema de gerenciamento de eventos e projetado para oferecer um sistema de gerenciamento pratico para controle e automação do serviço,oferecendo as seguintes funcionalidades de sistema: inscrição de participantes,manejamento de eventos e atraçãoes,e manejamento do local do evento.

a classe principal e a de eventos,nela vocé podera fazer todo o gerenciamento do sistema,sendo responsavel por gerenciar os cadastros dos participantes do evento,atraçãoes dos eventos dia e local destinado para cada evento
(vou continuar)

A classe Evento centraliza a lógica de gerenciamento do evento, controlando os participantes, a lotação e as atrações. Ela mantém um registro do nome do evento, data, local (referenciado por uma instância da classe Local), a capacidade máxima de participantes e uma lista de Participantes. Entre seus métodos, destaca-se o registrarParticipante, que adiciona um participante ao evento se ainda houver vagas disponíveis, evitando inscrições quando a capacidade máxima é atingida. O método verificarLotacao confirma se o número máximo de participantes já foi alcançado, e o gerarRelatorio produz um relatório detalhado sobre o evento, incluindo o local, data e lista de participantes, oferecendo uma visão geral da situação do evento.

A classe Local gerencia as informações sobre o local onde o evento será realizado, com dois atributos principais: nomeLocal e endereco. Os métodos getter fornecem acesso a essas informações, e a sobrescrita de toString() organiza os dados para exibição no formato "nomeLocal (endereço)", tornando mais fácil a identificação e manipulação dos locais do evento.

O programa principal, representado pela classe main_event, atua como a interface interativa do sistema, utilizando a classe Scanner para capturar entradas do usuário e executar operações de gerenciamento do evento. As funcionalidades principais estão organizadas em três áreas: gerenciamento do evento, gerenciamento de participantes e gerenciamento do local. No gerenciamento do evento, o usuário pode adicionar e remover atrações, além de gerar relatórios sobre o evento e suas atrações, com a limitação de adicionar atrações até um número máximo. O gerenciamento de participantes facilita o registro de novos inscritos, com verificações automáticas da capacidade máxima do evento. Cada participante é registrado com nome, idade, tipo de entrada (meia ou inteira), e os dias em que estará presente no evento. No gerenciamento do local, o usuário pode alterar o local do evento, verificar a lotação e ajustar o limite de participantes permitidos.

Esse sistema de gerenciamento de eventos em Java foi desenvolvido de forma modular e eficiente. A separação clara das responsabilidades de cada classe e o uso de métodos específicos para cada funcionalidade permitem uma operação fluida e precisa. Além disso, o design do sistema é flexível, permitindo a adição de novas funcionalidades, como a criação de novos tipos de relatórios ou melhorias na interface do usuário. Este código é um exemplo claro da aplicação dos princípios da programação orientada a objetos, utilizando encapsulamento e abstração para organizar as funcionalidades de um sistema de gerenciamento de eventos.

### Case 3: Sistema de Gerenciamento de Restaurante - Noemi Soares

O sistema de gerenciamento de restaurante em Java foi projetado para oferecer uma solução para o controle de mesas, pedidos e itens do menu. A estrutura do código é dividida em várias classes, cada uma desempenhando um papel essencial no funcionamento do sistema.

A classe `Restaurante` é o coração do sistema, responsável por orquestrar todas as operações. Ela contém uma lista de mesas, com um total de 15 mesas disponíveis para os clientes. O método `inicializarMesas` é crucial, pois inicializa cada mesa como disponível, garantindo que a equipe do restaurante tenha um controle preciso sobre a ocupação.

Dentro da classe `Restaurante`, o método `fazerPedido` permite que um cliente faça um pedido a partir de uma mesa específica. Esse método recebe a mesa e o cliente como parâmetros, garantindo que a ordem seja registrada corretamente. Após capturar o pedido, ele utiliza o método `adicionarItem` da classe `Pedido` para incluir os itens selecionados pelo cliente. A lógica aqui assegura que o sistema não apenas registre os pedidos, mas também mantenha um histórico de todos os pedidos feitos para cada mesa.

O método `fecharConta` é responsável por calcular o total do pedido e exibir as opções de pagamento. Ele soma o preço dos itens do pedido, oferece um resumo detalhado e verifica se o cliente deseja dividir a conta. Esta funcionalidade é essencial em ambientes de restaurante, onde os clientes frequentemente desejam compartilhar despesas.

A classe `Mesa` representa cada mesa do restaurante. Atribuindo um número à mesa e seu status de ocupação, essa classe fornece uma interface simples para gerenciar a disponibilidade. Os métodos da classe incluem `reservar` e `liberar`, que alteram o status da mesa. Essa estrutura permite que os atendentes consultem rapidamente a disponibilidade das mesas e façam reservas de forma eficiente.

A classe `ItemDoPedido` é responsável por representar os itens que estão disponíveis no menu. Cada instância desta classe contém informações detalhadas sobre um item, como nome, preço e tamanho (porção). Este design modular facilita a adição de novos itens ao menu e permite uma apresentação clara e organizada dos pratos oferecidos. Os itens podem ser adicionados a um pedido de forma flexível, pois o sistema permite que os atendentes selecionem e ajustem os pedidos conforme necessário.

A classe `Pedido` é uma das partes mais importantes do sistema, pois é onde os detalhes dos pedidos são gerenciados. Esta classe permite que os atendentes adicionem e removam itens do pedido, além de calcular o total de cada pedido. O método `adicionarItem` facilita a inclusão de um novo item ao pedido, enquanto `removerItem` permite cancelar um item, assegurando que o pedido possa ser ajustado conforme as solicitações do cliente. 

Adicionalmente, o método `calcularTotal` fornece uma soma detalhada dos itens do pedido, permitindo que os atendentes apresentem uma conta precisa aos clientes. A lógica contida nesta classe é vital para garantir que os pedidos sejam manipulados de forma clara e precisa.

A interação com o usuário é facilitada através de um menu de opções que orienta os atendentes nas operações a serem realizadas. O uso da classe `Scanner` permite a captura de entradas do usuário de maneira eficiente e intuitiva. Ao iniciar o sistema, o usuário é apresentado a um menu com opções como fazer um pedido, fechar a conta ou consultar a disponibilidade das mesas, proporcionando uma experiência fluida e acessível.

O sistema de gerenciamento de restaurante em Java é uma implementação que abrange todas as facetas da operação de um restaurante. Cada classe foi projetada para desempenhar funções específicas, colaborando de maneira eficiente para manter o fluxo de informações e operações. A modularidade e a flexibilidade do código permitem futuras expansões, como a inclusão de um sistema de gerenciamento de estoque ou um painel administrativo para análise de dados de vendas e ocupação. A estrutura do código não apenas facilita o uso diário, mas também serve como uma base sólida para melhorias e atualizações futuras no sistema.

### Case 4: Integração dos Sistemas de Gerenciamentos

### Conclusão
