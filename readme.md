[![Review Assignment Due Date](https://classroom.github.com/assets/deadline-readme-button-22041afd0340ce965d47ae6ef1cefeee28c7c493a6346c4f15d667ab976d596c.svg)](https://classroom.github.com/a/14jV-K72)

# Lista 4: Aplicativo de desenho vetorial

## Aluno: Igor da Silva
## Engenharia de Telecomunicações - IFSC câmpus São José
## Turma: 129003 - Programação Orientada à Objetos

## Operação

> Para rodar o código, aplique gradle run com o terminal na pasta "lista-4-igor1023";

> Para desenhar uma figura, é necessário escolher a figura, a cor e se possui preenchimento:
Ex.: (F1 ou F2 ou F3 ou F4) e (F5 ou F6 ou F7 ou FO) e (F) => clique em uma posição da tela;

Caso contrário a seguinte mensagem aparecerá no terminal: "Defina as características: FIGURA, COR e POSSUI PREENCHIMENTO"

> Para definir o tamanho da figura (teclas Q ou W), deve-se selecionar uma figura;

> A função de cada opção do MENU também está descrita na classe Constantes.java.

## Comandos - Função de cada tecla

* F1 : Círculo
* F2 : Quadrado
* F3 : Hexágono
* F4 : Losango
* F5 : Vermelho
* F6 : Azul
* F7 : Verde
* F8 : Amarelo
* C  : Limpa o tabuleiro
* F  : Alterna entre figura vazada ou preenchida
* P  : Imprime informações das figuras (área e perímetro total)
* Q  : Diminui tamanho da figura
* W  : Aumenta tamanho da figura
* SETA ESQUERDA ^ : Movimenta as figuras para esquerda
* SETA CIMA     v : Movimenta as figuras para cima
* SETA DIREITA  > : Movimenta as figuras para direita
* SETA BAIXO    < : Movimenta as figuras para baixo

## Diagrama de Classes
```mermaid
classDiagram

    class FormaGeometrica{
        <<abstract>>
        # cor : Color
        # tamanho : double
        # area : double
        # temPreenchimento : boolean
        # coordenada : Coordenada

        + aumentarTamanho() void
        + diminuirTamanho() void
        + setCor(Color cor) void
        + getTamanho() double
        + setTamanho(double i) void
        + getArea() double
        + getPerimetro() double;
        + setPreenchimento(boolean p) void
        + setCoordenada(double x, double y) void
        + getCoordenada() Coordenada
        + getCor() Color
    }

    class Desenhador{
        <<interface>>

        + desenhar(Draw tela) void
    }

    class Movedor{
        <<interface>>

        + moverBaixo(double a) void
        + moverCima(double a) void
        + moverEsquerda(double a) void
        + moverDireita(double a) void
    }

    class DrawListener{
        <<interface>>

        + mousePressed(double x, double y) void
        + keyReleased(int i) void
        + mouseDragged(double v, double v1) void
        + mouseReleased(double v, double v1) void
        + mouseClicked(double v, double v1) void
        + keyPressed(int i) void
        + keyTyped(char c) void
    }

    class Coordenada{

        + Coordenada()
        + setCX(double x) void
        + setCY(double y) void
        + getCX() double
        + getCY() double
    }

    class Circulo{
        
        + Circulo()
        - desenharComPreenchimento(Draw tela) void
        - desenharSemPreenchimento(Draw tela) void
    }

    class Quadrado {
        
        + Quadrado()
        - desenharComPreenchimento(Draw tela) void
        - desenharSemPreenchimento(Draw tela) void
    }

    class Hexagono {

        + Hexagono()
        - desenharComPreenchimento(Draw tela) void
        - desenharSemPreenchimento(Draw tela) void
    }

    class Losango {

        + Losango()
        - desenharComPreenchimento(Draw tela) void
        - desenharSemPreenchimento(Draw tela) void
        - coordenadasX(double cx) double[]
        - coordenadasY(double cy) double []
        - diagonal1() double
        - diagonal2() double
    }

    class InterfaceUsuario {

        - tela : Draw
        - figura : FormaGeometrica
        - coordenada : Coordenada
        - ehPreenchido : boolean
        - cor : Color
        - tamanho : double
        - tipoObjetoSelecionado : String
        - selecionouFigura : boolean
        - selecionouCor : boolean
        - selecionouPreenchimento : boolean
        - somatorioArea : double
        - somatorioPerimetro : double
        - figurasDesenhadas : List<FormaGeometrica>

        + InterfaceUsuario()
        - iniciarTela() void
        - desenharTela(String titulo) void
        + iniciar(String titulo) void
        - configuracaoDeCor(String nomeCor) void
        - configuracaoDePreenchimento() void
        - configuracaoDeFigura(String nomeFigura) void
        - configuracaoDeLimpeza() void
        - configuracaoDeTamanho(int i) void
        - processar() void
        - moverEsquerda(double a) void
        - moverDireita(double a) void
        - moverCima(double a) void
        - moverBaixo(double a) void
        - desenharFiguras() void
        - criarFigura() FormaGeometrica

    }

    class App{

        + main(String[] args) void
        
    }

    class InterfaceUsuario{

        - tela : Draw
        - figura : FormaGeometrica
        - coordenada : Coordenada
        - ehPreenchido : boolean
        - cor : Color
        - tamanho : double
        - tipoObjetoSelecionado : String
        - selecionouFigura : boolean
        - selecionouCor: boolean
        - selecionouPreenchimento
        - somatorioArea : double
        - somatorioPerimetro : double
        - figurasDesenhadas : List<FormaGeometrica>

        + InterfaceUsuario()
        - iniciarTela() void
        - desenharTela(String Titulo) void
        + iniciar(String titulo) void
        - configuracaoDeCor(String nomeCor) void
        - configuracaoDePreenchimento() void
        - configuracaoDeFigura(String nomeFigura) void
        - configuracaoDeLimpeza() void
        - configuracaoDeTamanho(int i) void
        - processar() void
        - moverEsquerda(double a) void
        - moverBaixo(double a) void
        - moverDireita(double a) void
        - moverCima(double a) void
        - criarFigura() void

    }

    class Constantes {

        <<utility>>
        
        +~TAMANHO_DEFAULT_CIRCULO : double
        +~TAMANHO_DEFAULT_QUADRADO : double
        +~TAMANHO_DEFAULT_HEXAGONO : double
        +~TAMANHO_DEFAULT_LOSANGO : double
        +~VALOR_MOVER : double
        +~VALOR_ALTERAR : double
        +~TAMANHO_MINIMO : double
        +~TAMANHO_MAXIMO : double
        +~DIMENSAO : double

    }

    FormaGeometrica <|-- Circulo
    FormaGeometrica <|-- Quadrado
    FormaGeometrica <|-- Hexagono
    FormaGeometrica <|-- Losango
    FormaGeometrica <|-- InterfaceUsuario
    App --|> "1" InterfaceUsuario : possui
    FormaGeometrica --> "1" Coordenada : coordenada
    Desenhador <|.. FormaGeometrica : implementa
    Movedor <|.. FormaGeometrica : implementa
    DrawListener <|.. InterfaceUsuario : implementa

```