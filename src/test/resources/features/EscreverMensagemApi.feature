# language: pt
# encoding: UTF-8
@Postagem
Funcionalidade: Validar a postagem de mensagem do usuário na sua própria pagina no facebook.

  Contexto: 
    Dado que tenho dados validos para fazer requisicao na API do Facebook

  #Testes positivos
  @Postagem1
  Cenario: O usuário posta uma mensagem na sua timeline.
    E que tenha a mensagem
      | mensagem |
      | teste    |
    Quando realizar um POST na API
    Entao o codigo de retorno e 200
    Entao um id sera gerado para a publicacao

  @Postagem2
  Cenario: O usuário atualiza uma mensagem na sua timeline.
    E que tenha a nova mensagem
      | mensagem |
      | teste123 |
    Quando realizar um UPDATE na API
    Entao o codigo de retorno e 200
    Entao um success sera obtido