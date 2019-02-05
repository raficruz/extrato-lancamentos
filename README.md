# Extrato-lancamentos
Projeto de uma tela de extrato de lançamentos a partir de um datasource dinâmico, gerado no projeto data-extractor, ou de um datasource estático provenientes da leitura de um arquivo Json nos resources do projeto data-manager.

# Data-Extractor
  Projeto Spring boot criado com o intuito de gerar uma massa de registros simulando o Json nos resources de data-manager.
A cada 45 segundos é gerado um novo lancamento na conta com N (randômico) controlesLancamento.
O Json desse novo registro é enviado para uma fila do RabbitMQ. Falarei onde ela é consumida mais tarde.
Existe apenas um endpoint neste projeto, a saber /novo-lancamento. Este endpoint serve apenas para testar a geração de um novo registro, assim como o envio do JSON para o broker. 

# Data-Manager
  Projeto Spring boot, backend que provê a lista de lançamentos para a tela de extrato.
Em /lancamentos o datasource é a fila RabbitMQ a qual data-extractor
enviava os payloads (Json contendo os lançamentos da conta). Data-manager atua como consumidor dessa fila e persiste os dados em um banco de dados H2 em memória.

 Em /lancamentos/json o datasource é o arquivo json nos resources do projeto(proposto no desafio). 
 Utilizei Serializer/Deserializers para as datas e um converter para poder salvar uma lista de strings em um unico campo, com os valores separados por virgula. Aproveitei que não sabia o que tinha no campo.

# Data-View
Frontend angularJS, utilizando material design com uma unica tela para exibir os lançamentos vindos do backend;
Criei um switcher para selecionar o datasource. 
Quando o datasource dinâmico está ligado o refresh da tabela é automático à cada 30 segundos.
Quando o datasource dinâmico está desligado o conteúdo da lista vem do arquivo Json no data-manager logo estático e não necessita de atualização.
O projeto foi configurado para rodar com NodeJs.

# Observações
Os projetos springBoot estão todos configurados com Swagger 2
Data-Extractor roda na porta 8009
Data-Manager roda na porta padrão 8080
Os outros projetos independem de data-extractor, mas caso este não esteja rodando, a função de datasource dinâmico não estará disponível


# O Desafio

1. Objetivo
Criar uma API para Extrato de Lançamentos em conta. 
Para isso, você deve: 
- transformar a informação de um sistema legado em um serviço a ser exposto e consumido por um site/mobile.
- criar uma aplicação com spring-boot, expor uma API REST
- consumir este serviço com uma aplicação Angular. 
Você deve disponibilizar o código no seu github para nossa avaliação.

2. Considerações
- Considerar a massa que está no arquivo lancamento-conta-legado.json como fonte de dados do sistema legado; 
- Considerar a seguinte forma de apresentação:

Data do lançamento | Descrição | Número | Situação | Data de confirmação | Dados bancários | Valor final
18/11/2016 | Regular | 67210807400 | Pago | 18/11/2016 | BANCO ABCD S.A Ag 12 CC 0001231234 | R$ 28.714,00
