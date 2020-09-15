# Xadrez CLI

Esse é um jogo de xadrez feito em Java, e roda direto no prompt. É um sistema simples que usa os conhecimentos básicos de Java:
* Basics
    * Sistema de camadas
    * Padrão MVC
    * Nomes bem definidos
    * SOLID e Clean Code
* POO
    * Encapsulamento
    * Polimorfismo
    * Herança
    * Funções Lambda
    * Associação de classes
    * Upcasting e Downcasting
    * Listas
    * Exceções e tratamentos

Esse projeto foi feito durante a realização do curso de Java do Prof. Nélio Alves https://www.udemy.com/course/java-curso-completo/ e vale muito a pena.

![Foto do jogo](https://i.ibb.co/k14Msmn/Captura-de-tela-de-2020-09-14-02-12-32.png)

>É posivel jogar com um amigo na mesma máquina. As peças pretas são simbolizadas pela cor amarela.

>Selecione uma peça indicando a coluna e a linha, por exemplo, a1 vai selecionar o Rook branco esquerdo.

Foi implementado o sistema de movimentos especiais do xadrez:
* En passant: En passant é um movimento especial de captura do Peão no jogo de xadrez. Na ocasião do avanço por duas casas do peão, caso haja um peão adversário na coluna adjacente na quarta fileira para as brancas, ou quinta para as pretas, este pode capturar o peão como se "de passagem", movendo-o para a casa por onde o peão capturado passou sobre. A captura en passant deve ser feita imediatamente após o peão ter sido movido por duas casas, caso contrário o jogador adversário perde o direito de fazê-lo posteriormente.[1] Tal movimento é a única ocasião no xadrez na qual a peça que captura não é movida para a casa ocupada pela peça capturada.[2] Como qualquer outro movimento, se a captura en passant é o único movimento disponível, deve ser feita. A captura é um tema comum em problemas de xadrez.

* Roque: O Roque é uma jogada especial que envolve a movimentação de duas peças em um único lance, o rei e uma das torres.[1] O objetivo da jogada é proteger o rei, tirando-o do centro.[2]
O movimento consiste no deslocamento lateral do rei na primeira fileira em duas casas na direção da torre com a qual desejar "rocar", e a torre escolhida passa através do rei permanecendo na primeira casa após o "salto".
Antes de executar a jogada, é necessário o atendimento aos seguintes requisitos:
    *  O rei e a torre envolvida não podem ter se movimentado nenhuma vez desde o início do jogo;
    * As casas entre o rei e a torre devem estar desocupadas;
    * O rei não pode estar em xeque, e também não pode ficar em xeque depois do roque;
    * Nenhuma das casas onde o rei passar ou ficar deverá estar no raio de ação de uma peça adversária. Isto não se aplica à torre envolvida.
    * Caso o roque seja com a torre da ala do rei, chama-se roque pequeno. Sendo a torre escolhida da ala da dama, chama-se roque maior.
    * Ao rocar o enxadrista deve mover primeiro o Rei e depois a Torre.
    
* Promoção: Quando o peão chega do outro lado do tabuleiro ele é promovido e deve escolher tornar-se uma rainha ou torre ou bispo ou cavalo, sendo que normalmente ele escolhe tornar-se uma rainha, por ser a peça mais poderosa.

Para jogar, primeiro faça um clone do projeto em sua máquina! Fique a vontade para modificar o jogo, e se quiser, pode fazer um fork com suas modificações!
Deve se compilar o projeto. O método mais fácil é abrir a sua IDE e rodar o projeto. Uma pasta com o arquivo em bitecode será criada. Então é so executar o comando ```java application/Program``` quando seu terminal estiver na pasta raiz do projeto em bitecode.
