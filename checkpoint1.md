# Descrição do Projeto
Projeto desenvolvido com Kotlin, onde temos uma tela de
Login, Menu, Pedidos e Perfil, 
sendo possível navegar entre essas telas.

## Objetivo da Prova
Evoluir o projeto desenvolvido em aula, aplicando conceitos de navegação
entre telas utilizando Jetpack Compose com foco na passagem de parâmetros


## Explicação de cada commit e o que foi implementado


### 1 - Passagem de parâmetros obrigatórios na tela de Perfil
A ideia aqui é foi ir na classe MainActivity, na rota PERFIL, dentro do componente composablea
colocar entre chaves o parametro nome ({nome}). Ou seja quando a rota "perfil/" for chamada
ela vai receber um nome 

Criei uma variável nome do tipo String (O ponto de interrogação nesse caso é para indicar que a variavel pode receber null)
que recebe it.arguments?.getString("nome", "Usuario Genérico), aqui basicamente acessamos o argumento que vem
na rota, caso não venha nada, utilizamos "Usuario Genérico"

Logo depois chamamos a função/método PerfilScreen enviando como argumento o modifier (objeto que contem propriedades CSS capaz de estilizar elementos como Text, Colum, button e etc),
o innerPadding (componente que desconto os pixels em relação a câmera), e o parâmetro nome, que foi armazenado na variável local nome

Na função MenuScreen, no método navigate , passei como parâmetro a rota com o nome "Fulano de tal"

E na função PerfilScreen, alterei para que ela possa receber como parâmetro modifier, navController e um nome
do tipo String. Na menu screen é onde tudo acontece, quando o botão é clicado, ele chama a rota enviando
o nome "Fulano de Tal"


### 2 - Passagem de parâmetros opcionais na tela de Pedidos
Na MainActivity, na rota de pedidos, coloquei que ela recebe um cliente ("pedidos?cliente={cliente}), importante se atentar
que é um parâmetro opcional. O arguments recebe uma lista com o parâmetro cliente, caso não venha nada,
ele estabelece um valor padrão "Cliente Genérico"

Após isso, defini que a função PedidosScreen, é enviado como argumento a String Cliente.

No Perfil Screen inseri a variável nome com o simbolo !!, garantindo que não é null

Na pedidosScreen adicionei o parâmetro cliente do tipo String. E no texto referenciei a variável cliente, concatenando com a palavra Pedidos


### 3 - Inserindo valor ao parâmetro opcional na tela de Pedidos
Aqui foi uma alteração simples, no método navigate passei a rota pedidos ("pedidos?") com o cliente XPTO (passei basicamnete uma string)
Quando o botão pedidos for clicado, ele envia como argumento essa string, a string é extraída da rota e é enviada para a Screen.


### 4 - Passagem de múltiplos parâmetros
Na MainActivity, dentro do Composable PedidosScreen, passei como argumento o cliente que foi extraído da rota.

Agora no composable Perfil, na rota adicionei mais um parâmetro idade ({idade}). Aqui temos uma lista
com uma validação, dizendo que o nome que vem do parâmetro tem que ser do tipo String
e o parâmetro idade tem que ser do tipo Int. Após isso adicionei uma variavel idade que recebe
o argumento idade que vem da rota. Depois disso, na hamada da função PerfilScreen, enviei o argumento idade (idade!!)


No botão, no parâmetro que contem a rota perfil, adicionei a idade 27 como argumento. 

Na função PerfilScreen adicionei o parâmetro idade do tipo Int. E por fim no texto que exibe "PERFIL" adicionei a variáveis 
nome e idade concatenando com o texto PERFIL - 




