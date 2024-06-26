O projeto foi criado com o objetivo compor uma nota parcial do semestre, como uma avaliação, solicitada pelo professor. 
O projeto é um sistema para uma locadora de filmes, e possuí as seguintes funções:
  - Alugar e devolver filmes e séries;
  - Comprar filmes e séries;
  - Cadastrar novos clientes;
  - Acessar o catálogo de filmes e séries;
  - Cadastrar novos filmes ou séries;
  - Acessar funcionários e ver suas funções na locadora.

Sobre as classes: 
  - Alugar: realiza o processo de alugar um filme/série, vinculando o aluguel a um cliente;
  - Caixa: funcionário que realiza o processamento do pagamento;
  - Categoria e Status: enumerações com os genêros e o status dos filmes/séries existentes, respectivamente;
  - Cliente: contém variáveis que dão origem aos dados do cliente, assim como uma lista onde os clientes da locadora são armazenados. Também é onde se cadastra novos clientes, faz a busca dos clientes por ID, armazena os clientes em arquivo de texto e é por onde é acessado o menu do cliente;
  - Cliente.txt: arquivo de texto que contém os clientes já cadastrados anteriormente;
  - Comprar: 
  - Devolver: realiza o processo de devolução de um filme/série, vinculado a um cliente;
  - Estoquista: funcionário que realiza o controle do estoque;
  - Filme: contém variáveis que dão origem aos dados do filme, assim como uma lista onde os filmes da locadora são armazenados. Também é onde se cadastra novos filmes, faz a busca dos filmes por categoria ou os lista de maneira geral, além de acessar um arquivo de texto onde os filmes estão previamente armazenados.
  - Filme.txt e Series.txt: arquivos de texto que contém os filmes/séries já cadastrados anteriormente, respectivamente;
  - Funcionario: classe abstrata, com dados básicos de todos os funcionários e uma lista que armazena todos os funcionários. Também tem uma função de listar todos os funcionários;
  - 
