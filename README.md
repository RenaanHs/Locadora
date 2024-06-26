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
  - Comprar: contém o menu de compras, através do qual é possível acessar os filmes e séries disponíveis para compra, realizar a compra e também acessar o histórico de vendas dos filmes e séries;
  - Devolver: realiza o processo de devolução de um filme/série, vinculado a um cliente;
  - Estoque: apresenta um catálogo com todas os filmes e séries disponíveis e também chama a função que tem acesso aos arquivos de filmes e séries, para subir eles no sistema;
  - Estoquista: funcionário que realiza o controle do estoque;
  - Filme: contém variáveis que dão origem aos dados do filme, assim como uma lista onde os filmes da locadora são armazenados. Também é onde se cadastra novos filmes, faz a busca dos filmes por categoria ou os lista de maneira geral, além de acessar um arquivo de texto onde os filmes estão previamente armazenados.
  - Filme.txt e Series.txt: arquivos de texto que contém os filmes/séries já cadastrados anteriormente, respectivamente;
  - Funcionario: classe abstrata, com dados básicos de todos os funcionários e uma lista que armazena todos os funcionários. Também tem uma função de listar todos os funcionários;
  - Gerente: gerencia os demais funcionários;
  - Locadora: interface que contém as ações a serem realizadas pelos funcionários;
  - Main: menu principal que possui acesso a todas as outras funções do sistema;
  - Pessoa: classe abstrata base para as classes funcionários e clientes;
  - Repositor: repõem o estoque;
  - Series: contém variáveis que dão origem aos dados da série, assim como uma lista onde as séries da locadora são armazenados. Também é onde se cadastra novas séries, faz a busca das séries por categoria ou os lista de maneira geral, além de acessar um arquivo de texto onde as séries estão previamente armazenadas.

Para executar o projeto, basta baixar ele em seu computador e usar uma máquina virtual do Java. Pode ser executado usando o Visual Studio Code, com uma extenção para a linguagem Java, ou o IntelliJ.
O ChatGPT foi utilizado para auxiliar e guiar a equipe no acesso aos arquivos de texto que armazenam os dados do sistema.
