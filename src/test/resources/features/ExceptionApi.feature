# language: pt
# encoding: UTF-8
@ExceptionPostagem
Funcionalidade: Validar as exceptions da Api.

  #Testes negativos autenticacao
  Cenario: O usuário não deve realizar a autenticação no facebook
    Dado que tenho dados validos para realizar uma autenticacao
    Quando realizar uma autenticacao na API
    Entao o codigo de retorno e 400

  #Testes negativos Permissão
  Cenario: Validar se o usuário consegue publicar na linha do tempo sem permissao de "user_posts"
    Dado que tenho token valido sem permissao "user_posts"
    E que tenha a mensagem
      | mensagem |
      | teste    |
    Quando realizar um POST na API
    Entao o codigo de retorno e 400

    Cenario: Validar se o usuário consegue atualizar a publicação na linha do tempo sem permissao de "user_posts"
    Dado que tenho token valido sem permissao "user_posts"
    E que tenha a mensagem
      | mensagem |
      | teste    |
    Quando realizar um UPDATE na API
    Entao o codigo de retorno e 400