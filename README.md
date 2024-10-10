# Sistemas de Gerenciamento Integrados: Clínica Médica, Eventos e Restaurante

### Integrantes do Projeto: Nunno Wakiyama Diniz Carvaho, Pedro Henrique Mendes Macedo, Ricardo Nery de Brito Junior, Matheus Fabiano Barbosa Aguiar e Noemi Soares Gonçalves da Silva

Neste projeto, desenvolvemos uma aplicação em Java que simula sistemas de gerenciamento em três contextos distintos: uma clínica médica, um sistema de eventos e um restaurante. O objetivo é aplicar conceitos de programação orientada a objetos, demonstrando nossa compreensão e habilidade na manipulação de objetos e na implementação de funcionalidades práticas.

Na clínica médica, criamos um sistema que permite agendar consultas, gerenciar informações de pacientes e médicos, e gerar relatórios de atendimentos. Para o sistema de eventos, abordamos a criação de um ambiente que facilita o cadastro de eventos e a inscrição de participantes, além de permitir o controle da lotação dos eventos. No contexto do restaurante, implementamos um sistema de gerenciamento de pedidos, que possibilita registrar pedidos, calcular o total a pagar e gerenciar a ocupação das mesas.

Este projeto também inclui a integração entre os sistemas, utilizando métodos que apoiam a tomada de decisões estratégicas. Elaboramos seis perguntas que podem ser respondidas por meio dos dados gerados pelos sistemas. Essas perguntas são fundamentais para auxiliar na análise de desempenho e na definição de estratégias.

A seguir, apresentamos o passo a passo das funcionalidades implementadas em cada um dos sistemas.

### Case 1: Sistema de Gerenciamento Clínica Médica - Nunno Wakiyama e Pedro Henrique

### Case 2: Sistema de Gerenciamento de Eventos - Ricardo Nery e Matheus Fabiano

O sistema de gerenciamento de eventos e projetado para oferecer um sistema de gerenciamento pratico para controle e automação do serviço,oferecendo as seguintes funcionalidades de sistema: inscrição de participantes,manejamento de eventos e atraçãoes,e manejamento do local do evento.
(continua)

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
