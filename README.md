# Kotlin HTTP Client Exploration

Este projeto Kotlin foi criado com o objetivo de explorar o funcionamento do cliente HTTP para consumir APIs externas. Nele, demonstramos o uso da biblioteca Micronaut para realizar requisições HTTP de maneiras declarativa e imperativa, além de incorporar a utilização da biblioteca OkHttp para complementar as formas de realizar requisições.

## Características Principais

- **Uso do Cliente HTTP do Micronaut**: Demonstração de diferentes maneiras de inicializar e utilizar o cliente HTTP fornecido pelo Micronaut, permitindo uma compreensão abrangente de suas capacidades tanto em abordagens declarativas quanto imperativas.

- **Integração com OkHttp**: Além das funcionalidades do Micronaut, exploramos como o OkHttp pode ser integrado ao projeto para oferecer uma alternativa robusta e eficaz para a realização de chamadas a APIs externas.

## Programação Imperativa vs. Declarativa

No contexto deste projeto, exploramos duas abordagens principais de programação para interagir com APIs externas: programação imperativa e declarativa.

### Programação Imperativa

- **Definição**: Na programação imperativa, o desenvolvedor especifica exatamente como algo deve ser feito passo a passo para alcançar um resultado desejado. Este estilo é caracterizado pelo controle explícito do fluxo do programa.
- **Aplicação no Projeto**: Demonstramos isso através do uso direto do cliente HTTP, onde controlamos cada aspecto da requisição e resposta HTTP, como a criação de objetos de requisição, execução da chamada, e processamento da resposta.

### Programação Declarativa

- **Definição**: A programação declarativa abstrai o fluxo de controle, permitindo que o desenvolvedor se concentre no "o que" deve ser feito, em vez de "como" deve ser feito. Este estilo é mais expressivo e menos propenso a erros, pois muitos detalhes de implementação são gerenciados pelo framework ou pela biblioteca.
- **Aplicação no Projeto**: Utilizamos a abordagem declarativa com o Micronaut, onde definimos um cliente HTTP usando anotações. O Micronaut cuida da execução da requisição e do processamento da resposta, permitindo-nos definir facilmente o comportamento desejado sem nos preocuparmos com os detalhes de baixo nível.

## Diferenças entre `retrieve` e `exchange` no Micronaut

- **`retrieve`**: Utilizado para acessar diretamente o corpo da resposta de uma requisição. Ideal quando o foco está unicamente no conteúdo da resposta.
- **`exchange`**: Oferece um controle completo sobre a resposta HTTP, permitindo a inspeção detalhada de elementos como status, cabeçalhos, e outros metadados. Essencial para cenários que demandam uma análise minuciosa da resposta.

## Conclusão

Este projeto serve como um guia prático para entender e aplicar diferentes métodos e bibliotecas para o consumo de APIs externas em Kotlin. Ao explorar as funcionalidades do Micronaut e do OkHttp, os desenvolvedores podem escolher a abordagem mais adequada para suas necessidades específicas, alternando entre programação imperativa e declarativa conforme necessário para garantir eficiência e eficácia na comunicação com serviços externos.
