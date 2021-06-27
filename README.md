# Projeto `POO-BEE Game`

# Estrutura de Arquivos e Pastas

~~~
├── README.md          <- apresentação do projeto
│
├── data               <- dados usados pelo jogo (se houver)
│
├── notebooks          <- Jupyter notebooks ou equivalentes
│
├── src                <- projeto em Java (preferencialmente projeto no Eclipse)
│   │
│   ├── src            <- arquivos-fonte do projeto (.java)
│   │
│   ├── bin            <- arquivos em bytecode (.class)
│   │
│   └── README.md      <- instruções básicas de instalação/execução
│
└── assets             <- mídias usadas no projeto
~~~


# Descrição Resumida do Projeto/Jogo

# Equipe: Não Tem Como
* `César Devens Grazioti` - `RA: 195641`
* `Cícero Pizzol Libardi` - `RA: 168810`

# Vídeos do Projeto

## Vídeo da Prévia
[![Vídeo da Prévia](http://img.youtube.com/vi/5QCycCbuyVY/0.jpg)](https://youtu.be/5QCycCbuyVY)


## Vídeo do Jogo
[![Vídeo do Jogo](http://img.youtube.com/vi/h94rXNB6hbA/0.jpg)](https://youtu.be/h94rXNB6hbA)

# Slides do Projeto

## Slides da Prévia
[Link dos slides da prévia](https://unicampbr-my.sharepoint.com/:p:/r/personal/c195641_m_unicamp_br/Documents/Pr%C3%A9via%20Pac-man%20-%20POO.pptx?d=wae4c790d8be24e2a91b3b25c6607d748&csf=1&web=1&e=FY9JLZ)

## Slides da Apresentação Final
`<Coloque um link para os slides da apresentação final do projeto.>`

# Documentação dos Componentes

# Diagramas

## Diagrama Geral do Projeto

![Diagrama Geral de Componentes](assets/diagrama-arquitetura-geral.PNG)

> Inicialmente, é criado um objeto do tipo Controle que, segundo sua metodologia, permite o fluxo do jogo na aplicação principal. Desse modo, o Controle instancia um objeto Montador, que por meio do contrato IMontador, oferece o serviço de criação do jogo. O objeto Montador, então, declara uma referência para um Labirinto com linhas × colunas Salas nulas, bem como para um Pacman e 4 Fantasmas, em forma de vetor. 
De acordo com a dificuldade selecionada pelo jogador, o Montador recebe do CSVHandling uma matriz de String. Para cada posição dessa matriz é instanciado um Ator, dependendo do caractere que a corresponde. Essa instância pode ser firmada pelas seguintes interfaces: IAtorEstatico, IFantasma, IPacman. Independentemente do tipo de instanciação, devemos conectar o Ator na  Sala pertencente à posição ij do labirinto, uma vez que o labirinto deve ter ciência de suas células. Essa conexão se dá por meio da interface IMontadorLabirinto.
 Caso o Ator instanciado anteriormente seja um Pacman ou um Fantasma, teremos uma conexão de via dupla, isto é, este Ator possui também uma referência para o tabuleiro - conforme acordado pela interface IConnectLabirinto. 

> Dado que a execução do jogo se dá no Controle, devemos conectar o Labirinto, o Pacman e o vetor de Fantasma (instanciados no Montador) ao devido ponteiro declarado nos atributos do objeto Controle. Quem é responsável por essas 3 conexões é a interface IRMontador.
Note que o Controle tem referência dos Fantasmas e do Pacman pois é nele que o movimento desses atores é gerenciado.
Isto é: dada uma instrução de movimentação do usuário para o Pacman, o Controle pergunta ao Labirinto se tal movimento é válido, por intermédio da interface IMovimentoValido. Em caso afirmativo, o Ator (Pacman) atualiza sua nova posição no tabuleiro, via conexão IAtualizaTabuleiro. Por conseguinte, é pedido que a interface gráfica seja atualizada, ou seja, seja mostrado estado atual do tabuleiro - serviço disponibilizado pelo componente LabirintoView e definido pela interface IAtualizaView.

## Diagrama Geral de Componentes

## Componente `Labirinto`

> Esse componente tem o papel de armazenar o tabuleiro do nosso jogo em sua clase Labirinto, que é representado por uma matriz de Salas, contendo também suas dimensões. O Labirinto também tem ciência da quantidade total de pastilhas no tabuleiro - atributo fundamental para saber se o jogador venceu o jogo - e, da existência dos Atores dados os índices correspondentes. Cada Sala é referenciada por indices i e j, equivalentes a linha e coluna no tabuleiro respectivamente, e nela pode haver uma referência para um dos Atores (Pacman, Fantasmas, Ouro, Cereja e Muro), se um ou mais deles estiverem contidos num mesmo espaço. Assim, para adicionar uma referência ou ver se ela é nula, basta acionar os métodos get e set da Sala. O mesmo é válido para as pastilhas, uma vez que ao longo da execução é necessário saber se o Pacman comeu a pastilha ou não.
> O Labirinto é responsável por receber a intenção de movimento do Pacman enviada pelo jogador, retornar se esse movimento é valido e realizar as devidas alterações em seu estado, por exemplo, a captura de um ouro/cereja/pastilha e o movimento dos fantasmas/pacman.

![Labirinto](assets/labirinto-componente.PNG)

**Ficha Técnica**
item | detalhamento
----- | -----
Classe | `src.Labirinto`
Autores | `César Devens Grazioti` e `Cícero Pizzol Libardi`
Interfaces | `IMontadorLabirinto`, `IConnectLabirinto`, `IAtualizaLabirinto`, `IMovimentoValido`

### Interfaces

Interfaces associadas a esse componente:

![Labirinto Interfaces](assets/labirinto-interfaces.PNG)

Interface agregadora do componente em Java:

~~~java
public interface ILabirinto extends ILabirintoPropriedades, IAtualizaLabirinto, IMovimentoValido, IMontadorLabirinto{
}
~~~

## Detalhamento das Interfaces

### Interface `ILabirintoPropriedades`

`Fornece ferramentas para acessar e modificar estados do labirinto.`

~~~java
public interface ILabirintoPropriedades {
    public void atualizaPastilha(int i, int j, boolean condicao);
    public boolean haPastilha(int i, int j);
    public boolean haCereja(int i, int j);
    public boolean haOuro(int i, int j);
    public boolean haMuro(int i, int j);
    public String[][] labirintoToString();
    public int getQtdPastilhas();
    public void setQtdPastilhas(int qtd_pastilhas);
    public void removerPastilha(int i, int j);
}
~~~

Método | Objetivo
-------| --------
`atualizaPastilha` | `Retira ou Insere na posição ij do labirinto uma pastilha, dependendo da condição dada`
`haPastilha` | `Retorna se há uma pastilha na posição ij do labirinto`
`haCereja` | `Retorna se há uma cereja na posição ij do labirinto`
`haOuro` | `Retorna se há um ouro na posição ij do labirinto`
`haMuro` | `Retorna se há um muro na posição ij do labirinto`
`labirintoToString` | `Retorna uma matriz de Strings do estado atual do tabuleiro, respeitando as prioridades de exibição`
`getQtdPastilhas` | `Retorna a quantidade de pastilhas restantes no tabuleiro`
`setQtdPastilhas` | `Define a quantidade de pastilhas existentes no tabuleiro`
`removerPastilha` | `Altera o estado da pastilha na posição ij para falso e subtrai em 1 a quantidade total de pastilhas`


### Interface `IAtualizaLabirinto`

`Possui métodos que permitem a remoção de atores da posição ij do tabuleiro, com exceção do Muro.`

~~~java
public interface IAtualizaLabirinto {
    public void removerPacman(int i, int j);
    public void removerFantasma(int i, int j, int idx);
    public void removerCereja(int i, int j);
    public void removerOuro(int i, int j);
}
~~~

Método | Objetivo
-------| --------
`removerPacman` | `Remove o Pacman da posição ij do tabuleiro`
`removerFantasma` | `Remove o Fantasma de índice idx do vetor de fantasmas na posição ij do tabuleiro`
`removerCereja` | `Remove a Cereja da posição ij do tabuleiro`
`removerOuro` | `Remove o Ouro da posição ij do tabuleiro`

### Interface `IMovimentoValido`

`Possui um método para verificar se a intenção de movimento do Pacman ou do Fantasma é válida.`

~~~java
public interface IMovimentoValido {
    public boolean ehMovimentoValido(int iFim, int jFim);
}
~~~

Método | Objetivo
-------| --------
`ehMovimentoValido` | `Recebe os índices finais da intenção de movimento dos Atores Móveis no labirinto e retorna se tal movimento é válido ou não`

### Interface `IMontadorLabirinto`

`<Resumo do papel da interface.>`

~~~java
public interface IMontadorLabirinto {
    public void montaLabirinto(int linhas, int colunas);
    public void connect(IAtorEstatico ator, int i, int j);
    public void connect(IPacman ator, int i, int j);
    public void connect(IFantasma ator, int i ,int j, int idx);
}
~~~

Método | Objetivo
-------| --------
`montaLabirinto` | `Recebe um número inteiro de linhas e colunas e instancia um labirinto com tais dimensões`
`connect` | `Conecta um Ator à posição ij do labirinto. Dependendo dos argumentos passados na chamada de função, será chamado um método connect diferente, uma vez que há sobrecarga`

## Componente `Ator`

> <Resumo do papel do componente e serviços que ele oferece.>
![Ator](assets/ator-componente.PNG)

**Ficha Técnica**
item | detalhamento
----- | -----
Classe | `src.Ator`
Autores | `César Devens Grazioti` e `Cícero Pizzol Libardi`
Interfaces | `IAtualizaLabirinto`, `IConnectLabirinto`, `IPacman`, `IFantasma`, `IMontadorEstatico`, `IMontadorPacman`, `IMontadorFantasma`

### Interfaces

Interfaces associadas a esse componente:

![Ator Interfaces](assets/ator-interfaces.PNG)

Interfaces agregadoras do componente em Java:

~~~java
public interface IAtorEstatico extends IAtorPropriedades, IMontadorAtor{
}
~~~

~~~java
public interface IFantasma extends IAtorPropriedades, IMontadorFantasma{
    public void moverAtor();
}
~~~

~~~java
public interface IPacman extends IAtorPropriedades, IMontadorPacman{
    public void moverAtor();
}
~~~

## Detalhamento das Interfaces

### Interface `IAtualizaLabirinto`

`<Resumo do papel da interface.>`

~~~
<Interface em Java.>
~~~

Método | Objetivo
-------| --------
`<id do método em Java>` | `<objetivo do método e descrição dos parâmetros>`

### Interface `IConnectLabirinto`

`<Resumo do papel da interface.>`

~~~
<Interface em Java.>
~~~

Método | Objetivo
-------| --------
`<id do método em Java>` | `<objetivo do método e descrição dos parâmetros>`

### Interface `IMontadorEstatico`

`<Resumo do papel da interface.>`

~~~
<Interface em Java.>
~~~

Método | Objetivo
-------| --------
`<id do método em Java>` | `<objetivo do método e descrição dos parâmetros>`

### Interface `IMontadorPacman`

`<Resumo do papel da interface.>`

~~~
<Interface em Java.>
~~~

Método | Objetivo
-------| --------
`<id do método em Java>` | `<objetivo do método e descrição dos parâmetros>`

### Interface `IMontadorFantasma`

`<Resumo do papel da interface.>`

~~~
<Interface em Java.>
~~~

Método | Objetivo
-------| --------
`<id do método em Java>` | `<objetivo do método e descrição dos parâmetros>`

### Interface `IPacman`

`<Resumo do papel da interface.>`

~~~
<Interface em Java.>
~~~

Método | Objetivo
-------| --------
`<id do método em Java>` | `<objetivo do método e descrição dos parâmetros>`

### Interface `IFantasma`

`<Resumo do papel da interface.>`

~~~
<Interface em Java.>
~~~

Método | Objetivo
-------| --------
`<id do método em Java>` | `<objetivo do método e descrição dos parâmetros>`

## Componente `Controle`

> <Resumo do papel do componente e serviços que ele oferece.>
![Controle](assets/controle-componente.PNG)

**Ficha Técnica**
item | detalhamento
----- | -----
Classe | `src.Controle`
Autores | `César Devens Grazioti` e `Cícero Pizzol Libardi`
Interfaces | `IPacman`, `IFantasma`, `IMontador`, `IAtualizaView`, `IMovimentoValido`

### Interfaces

Interfaces associadas a esse componente:

![Controle Interfaces](assets/controle-interfaces.PNG)

Interface agregadora do componente em Java:

~~~java
public interface IControle extends IRMontador{
    public void executaJogo();
}
~~~

## Detalhamento das Interfaces

### Interface `IRMontador`

`<Resumo do papel da interface.>`

~~~
<Interface em Java.>
~~~

Método | Objetivo
-------| --------
`<id do método em Java>` | `<objetivo do método e descrição dos parâmetros>`

## Componente `Montador`

> <Resumo do papel do componente e serviços que ele oferece.>
![Montador](assets/montador-componente.PNG)

**Ficha Técnica**
item | detalhamento
----- | -----
Classe | `src.Montador`
Autores | `César Devens Grazioti` e `Cícero Pizzol Libardi`
Interfaces | `IMontadorEstatico`, `IMontadorPacman`, `IMontadorFantasma`, `IMontadorLabirinto`, `IMontador`

### Interfaces

Interfaces associadas a esse componente:

![Montador Interfaces](assets/montador-interfaces.PNG)

Interface agregadora do componente em Java:

~~~java
public interface IMontador {
    public void criaJogo(IControle controle);
}
~~~

## Detalhamento das Interfaces

### Interface `IMontador`

`<Resumo do papel da interface.>`

~~~
<Interface em Java.>
~~~

Método | Objetivo
-------| --------
`<id do método em Java>` | `<objetivo do método e descrição dos parâmetros>`

## Componente `LabirintoView`

> <Resumo do papel do componente e serviços que ele oferece.>
![Montador](assets/labirintoview-componente.PNG)

**Ficha Técnica**
item | detalhamento
----- | -----
Classe | `src.LabirintoView`
Autores | `César Devens Grazioti` e `Cícero Pizzol Libardi`
Interfaces | `ILabirintoView`

### Interfaces

Interfaces associadas a esse componente:

![LabirintoView Interfaces](assets/labirintoview-interfaces.PNG)

Interface agregadora do componente em Java:

~~~java
public interface ILabirintoView {
    public void inicializarLabirinto(String[][] tabuleiro);
    public void atualizarLabirinto(String[][] tabuleiro, int pontos);
}
~~~

## Detalhamento das Interfaces

### Interface `ILabirintoView`

`<Resumo do papel da interface.>`

~~~
<Interface em Java.>
~~~

Método | Objetivo
-------| --------
`<id do método em Java>` | `<objetivo do método e descrição dos parâmetros>`
