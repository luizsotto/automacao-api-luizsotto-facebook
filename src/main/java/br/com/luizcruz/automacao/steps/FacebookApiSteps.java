package br.com.luizcruz.automacao.steps;


import br.com.luizcruz.automacao.funcionalidade.ApiFuncionalidade;
import br.com.luizcruz.automacao.funcionalidade.FacebookApiFuncionalidade;
import cucumber.api.DataTable;
import cucumber.api.PendingException;
import cucumber.api.java.pt.Dado;
import cucumber.api.java.pt.Entao;
import cucumber.api.java.pt.Quando;


public class FacebookApiSteps {
	
	private FacebookApiFuncionalidade facebookApiFuncionalidade;
	
	public FacebookApiSteps(ApiFuncionalidade api) {
		ApiFuncionalidade apiLocal = api;
		facebookApiFuncionalidade = new FacebookApiFuncionalidade(apiLocal);
	}
	
	@Dado("^que tenho dados validos para realizar uma autenticacao$")
	public void queTenhoDadosValidosParaRealizarUmaAutenticacao() throws Throwable {
		facebookApiFuncionalidade.obterDadosParaAutenticar();
	}

	@Quando("^realizar uma autenticacao na API$")
	public void realizarUmaAutenticacaoNaAPI() throws Throwable {
		facebookApiFuncionalidade.realizarAutenticacaoNaApi();
	}

	@Entao("^um code sera gerado para obter um access_token$")
	public void umCodeSeraGeradoParaObterUmAcces_token() throws Throwable {
		facebookApiFuncionalidade.validarObtencaoDoCode();
	}
	
	@Dado("^que tenho um code gerado pela API do Facebook$")
	public void queTenhoUmCodeGeradoPelaAPIDoFacebook() throws Throwable {
		facebookApiFuncionalidade.obterCode();
	}

	@Quando("^realizar um GET$")
	public void realizarUmGET() throws Throwable {
	   facebookApiFuncionalidade.realizarGETNaAPI();
	}
	
	@Entao("^um access_token de usuario sera gerado para fazer requisicoes na API$")
	public void umTokenSeraGeradoParaFazerRequisicoesNaAPI() throws Throwable {
		facebookApiFuncionalidade.validarObtencaoDoToken();
	}
	
	@Dado("^que tenho dados validos para obter o acces_token de App$")
	public void queTenhoDadosValidosParaObterOAccestokenDeApp() throws Throwable {
		facebookApiFuncionalidade.obterDadosValidosObterAccessTokenDeApp();
	}
	
	@Entao("^um access_token do App sera gerado para fazer requisicoes na API$")
	public void umAccessTokenDoAppSeraGeradoParaFazerRequisicoesNaAPI() throws Throwable {
		facebookApiFuncionalidade.validarObtencaoDoTokenDoApp();
	}

	@Dado("^que tenho dados validos para fazer requisicao na API do Facebook$")
	public void queTenhoTokenValido() throws Throwable {
	    facebookApiFuncionalidade.obterTodosDadosValidosParaRequisicao();
	}

	@Dado("^que tenha a mensagem$")
	public void queTenhaAMensagem(DataTable arg1) throws Throwable {
		facebookApiFuncionalidade.obterMensagem(arg1);
	}

	@Quando("^realizar um POST na API$")
	public void realizarUmPOSTNaAPI() throws Throwable {
		facebookApiFuncionalidade.realizarUmPOSTNaAPI();
	}

	@Entao("^o codigo de retorno e (\\d+)$")
	public void oCodigoDeRetornoE(int arg1) throws Throwable {
		facebookApiFuncionalidade.validarCodigoRetorno(arg1);
	}
	
	@Entao("^um id sera gerado para a publicacao$")
	public void umIdSeraGeradoParaAPublicacao() throws Throwable {
		facebookApiFuncionalidade.validarPostagemDaMensagem();
	}
	
	@Dado("^que tenha a nova mensagem$")
	public void queTenhaANovaMensagem(DataTable arg1) throws Throwable {
		facebookApiFuncionalidade.obterDadosParaAtualizarAMensagem(arg1);
	}

	@Quando("^realizar um UPDATE na API$")
	public void realizarUmUPDATENaAPI() throws Throwable {
		facebookApiFuncionalidade.realizarUpdateNaApi();
	}
	

	

	@Entao("^um success sera obtido$")
	public void umSuccessSeraObtido() throws Throwable {
		facebookApiFuncionalidade.validarSeFoiObtidoSucesso();
	}


	@Dado("^que tenho token valido sem permissao \"([^\"]*)\"$")
	public void queTenhoTokenValidoSemPermissao(String arg1) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}

}
