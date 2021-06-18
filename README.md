# Projeto `PAC-MAN`

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
[![Vídeo da prévia](http://img.youtube.com/vi/5QCycCbuyVY/0.jpg)](https://youtu.be/5QCycCbuyVY)

# Slides do Projeto

## Slides da Prévia
[Link dos slides da prévia](https://unicampbr-my.sharepoint.com/:p:/r/personal/c195641_m_unicamp_br/Documents/Pr%C3%A9via%20Pac-man%20-%20POO.pptx?d=wae4c790d8be24e2a91b3b25c6607d748&csf=1&web=1&e=FY9JLZ)

# Documentação dos Componentes

# Diagramas

## Diagrama Geral do Projeto

![Diagrama Geral de Componentes](assets/diagrama-arquitetura-geral.PNG)

> <Faça uma breve descrição do diagrama.>
## Diagrama Geral de Componentes

## Componente `Labirinto`

> <Resumo do papel do componente e serviços que ele oferece.>
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
public interface IDataSet extends ITableProducer, IDataSetProperties {
}
~~~

## Detalhamento das Interfaces

### Interface `IMontadorLabirinto`

`<Resumo do papel da interface.>`

~~~
<Interface em Java.>
~~~

Método | Objetivo
-------| --------
`<id do método em Java>` | `<objetivo do método e descrição dos parâmetros>`

### Interface `IAtualizaLabirinto`

`<Resumo do papel da interface.>`

~~~
<Interface em Java.>
~~~

Método | Objetivo
-------| --------
`<id do método em Java>` | `<objetivo do método e descrição dos parâmetros>`

### Interface `IMovimentoValido`

`<Resumo do papel da interface.>`

~~~
<Interface em Java.>
~~~

Método | Objetivo
-------| --------
`<id do método em Java>` | `<objetivo do método e descrição dos parâmetros>`

### Interface `ILabirintoPropriedades`

`<Resumo do papel da interface.>`

~~~
<Interface em Java.>
~~~

Método | Objetivo
-------| --------
`<id do método em Java>` | `<objetivo do método e descrição dos parâmetros>`

### Interface `ILabirinto`

`<Resumo do papel da interface.>`

~~~
<Interface em Java.>
~~~

Método | Objetivo
-------| --------
`<id do método em Java>` | `<objetivo do método e descrição dos parâmetros>`

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

Interface agregadora do componente em Java:

~~~java
public interface IDataSet extends ITableProducer, IDataSetProperties {
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
public interface IDataSet extends ITableProducer, IDataSetProperties {
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

![Montador Interfaces](montador-interfaces.png)

Interface agregadora do componente em Java:

~~~java
public interface IDataSet extends ITableProducer, IDataSetProperties {
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
