# language: pt
# encoding: UTF-8
@Autenticacao
Funcionalidade: Autenticar um usuário na API do facebook.
  Eu como usuario 
  Quero me autenticar na API do facebook para ter acesso as minhas informações

  #Testes positivos
  @Autenticacao1
  Cenario: O usuário deve realizar a autenticação no facebook
    Dado que tenho dados validos para realizar uma autenticacao
    Quando realizar uma autenticacao na API
    Entao um code sera gerado para obter um access_token

  @Autenticacao2
  Cenario: O usuário deve solicitar um acces_token na API facebook
    Dado que tenho um code gerado pela API do Facebook
    Quando realizar um GET
    Entao um access_token de usuario sera gerado para fazer requisicoes na API

  @Autenticacao3
  Cenario: O usuário deve solicitar um acces_token do seu App na API facebook
    Dado que tenho dados validos para obter o acces_token de App
    Quando realizar um GET
    Entao um access_token do App sera gerado para fazer requisicoes na API