package br.com.luizcruz.automacao.funcionalidade;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.WebElement;

import br.com.luizcruz.automacao.bean.OutPutAccountResponse;
import br.com.luizcruz.automacao.bean.OutPutAutenticacaoResponse;
import br.com.luizcruz.automacao.bean.OutPutDebugTokenResponse;
import br.com.luizcruz.automacao.bean.OutPutFeedResponse;
import br.com.luizcruz.automacao.bean.OutPutUpdateFeedResponse;
import br.com.luizcruz.automacao.bean.PageUserFeed;
import br.com.luizcruz.automacao.bean.Publicacoes;
import br.com.luizcruz.automacao.pages.LoginPage;
import br.com.luizcruz.commons.repositorio.CollectionService;
import br.com.luizcruz.commons.repositorio.interfaces.ICollectionService;
import cucumber.api.DataTable;
import io.restassured.response.ValidatableResponse;

public class FacebookApiFuncionalidade {
	
	private final static Logger logger = Logger.getLogger(FacebookApiFuncionalidade.class);

	private ApiFuncionalidade apiFuncionalidade;
	private LoginPage loginPage;
	private ICollectionService iCollectionService;
	
	public FacebookApiFuncionalidade(ApiFuncionalidade api) {
		this.apiFuncionalidade = api;
		iCollectionService = CollectionService.getInstance();
	}
	
	public void obterDadosParaAutenticar() {
		//montar a url
		iCollectionService.setCollection("url", apiFuncionalidade.montarUrlDeAutenticacao());
	}

	public void realizarAutenticacaoNaApi() {
		try {
			String url = iCollectionService.getCollection("url", String.class);
			loginPage = new LoginPage();
			//Aqui tenho que chamar a classe page
			loginPage.acessarTela(url);
			
			//validar se a tela acessada é de login
			WebElement element = loginPage.getCampoEmail();
			//Verificar se element é diferente de null
			if(null !=element) {
				//estou na tela de login
				logger.info("null !=element");
				//realizar o login
				loginPage.setUsuario();
				loginPage.setSenha();
				loginPage.clickButtonEntrar();
			}
			
			String urlAtual = loginPage.getUrlAtual();
			logger.info("urlAtual: "+urlAtual);
			iCollectionService.setCollection("code", obterCodeFromUrl(urlAtual));
			
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
		
	}

	private String obterCodeFromUrl(String url) {
		List<String> listParte = Arrays.asList(url.split("&"));
		if(listParte.size() > 0) {
			for (String strParam : listParte) {
				if(strParam.contains("code")) {
					int index = strParam.indexOf("=");
					logger.info("code: "+strParam.substring(index+1));
					return strParam.substring(index+1);
				}
			}
		}
			
		return "";
	}

	public void validarObtencaoDoCode() {
		String value = iCollectionService.getCollection("code", String.class);
		Assert.assertNotNull("O code retornado pelo Facebook não pode ser nulo!", value);
	}
	

	public void obterCode() {
		//senão estiver salvo, fazer todo o processo para pegar o code
		obterDadosParaAutenticar();
		realizarAutenticacaoNaApi();
		String strCode = iCollectionService.getCollection("code", String.class);
		iCollectionService.setCollection("url", apiFuncionalidade.montarUrlDeAccesTokenDeUsuario(strCode));
	}

	public void realizarGETNaAPI() {
		String urlMontada = iCollectionService.getCollection("url", String.class);
		apiFuncionalidade.realizarGETNaAPI(urlMontada);
		iCollectionService.setCollection("validation", apiFuncionalidade.getValidation());
	}
	
	public String obterAutenticacaoResponseBody() {
		ValidatableResponse validation = iCollectionService.getCollection("validation", ValidatableResponse.class);		
		OutPutAutenticacaoResponse response = validation.extract().body().as(OutPutAutenticacaoResponse.class);
		iCollectionService.setCollection("responseAutenticacao", response);
		logger.info("response: "+response);
		return response.getAccessToken();
	}
	
	public void validarObtencaoDoToken() {
		String value = obterAutenticacaoResponseBody();
		Assert.assertNotNull("O acces_token retornado pelo Facebook não pode ser nulo!", value);
	}

	public void obterTodosDadosValidosParaRequisicao() {
		//montar a url para pegar o acesso do usuario
		obterCode();
		realizarGETNaAPI();
		String	accessTokenUser = obterAutenticacaoResponseBody();
		iCollectionService.setCollection("accessTokenUser", accessTokenUser);
		
		//obter o acesso do app
		obterDadosValidosObterAccessTokenDeApp();
		realizarGETNaAPI();
		String accessTokenApp = obterAutenticacaoResponseBody();
		iCollectionService.setCollection("accessTokenApp", accessTokenApp);
		
		// obter a info do ID
		iCollectionService.setCollection("url", apiFuncionalidade.montarUrlInspecionarToken(accessTokenUser, accessTokenApp));
		realizarGETNaAPI();
		String userId = obterDebugTokenResponseBody();
		logger.info(userId);
		iCollectionService.setCollection("userId", userId);
		
		iCollectionService.setCollection("url", apiFuncionalidade.montarUrlAccounts(userId, accessTokenUser));
		realizarGETNaAPI();
		obterAccountsResponseBody();
				
	}

	private void obterAccountsResponseBody() {
		ValidatableResponse validation = iCollectionService.getCollection("validation", ValidatableResponse.class);		
		OutPutAccountResponse response = validation.extract().body().as(OutPutAccountResponse.class);
		iCollectionService.setCollection("responseAccounts", response);
		logger.info("response: "+response);
		if(response.getData().size() > 0) {
			iCollectionService.setCollection("userPageId", response.getData().get(0).getId());
			iCollectionService.setCollection("accessTokenUserPage",response.getData().get(0).getAccessToken());
		}
		
		iCollectionService.setCollection("userPageId", "");
		iCollectionService.setCollection("accessTokenUserPage","");
	}

	public void obterMensagem(DataTable arg1) {
		String mensagem = null;
		for (Map<String, String> map : arg1.asMaps(String.class, String.class)) {
			mensagem = map.get("mensagem");
		}
		
		iCollectionService.setCollection("mensagem", mensagem);
	}
	
	public void obterDadosValidosObterAccessTokenDeApp() {
		iCollectionService.setCollection("url", apiFuncionalidade.montarUrlDeAccesTokenDeApp());
	}

	public void validarObtencaoDoTokenDoApp() {
		String value = obterAutenticacaoResponseBody();
		Assert.assertNotNull("O acces_token retornado pelo Facebook não pode ser nulo!", value);
	}

	public String obterDebugTokenResponseBody() {
		ValidatableResponse validation = iCollectionService.getCollection("validation", ValidatableResponse.class);		
		OutPutDebugTokenResponse response = validation.extract().body().as(OutPutDebugTokenResponse.class);
		iCollectionService.setCollection("responseDebugToke", response);
		logger.info("response: "+response);
		return response.getData().getUserId();
	}

	public void realizarUmPOSTNaAPI() {
		String accessTokenUserPage = iCollectionService.getCollection("accessTokenUserPage", String.class);
		String userPageId = iCollectionService.getCollection("userPageId", String.class);
		String dados = iCollectionService.getCollection("mensagem", String.class);
		apiFuncionalidade.postApi(apiFuncionalidade.montarUrlFeed(userPageId, accessTokenUserPage), dados);
	}
	
	public void validarCodigoRetorno(int codigo) {
		ValidatableResponse validation = iCollectionService.getCollection("validation", ValidatableResponse.class);
		validation.statusCode(codigo);
	}

	public void validarPostagemDaMensagem() {
		String value = obterFeedResponseBody();
		Assert.assertNotNull("A mensagem não foi postada no feed!", value);
	}
	
	public String obterFeedResponseBody() {
		ValidatableResponse validation = iCollectionService.getCollection("validation", ValidatableResponse.class);		
		OutPutFeedResponse response = validation.extract().body().as(OutPutFeedResponse.class);
		iCollectionService.setCollection("responseFeed", response);
		logger.info("response: "+response);
		return response.getId();
	}



	public void obterDadosParaAtualizarAMensagem(DataTable arg1) {
		obterMensagem(arg1);
		String accessTokenUserPage = iCollectionService.getCollection("accessTokenUserPage", String.class);
		String userPageId = iCollectionService.getCollection("userPageId", String.class);
		//Obter o id da mensagem
		apiFuncionalidade.getApi(apiFuncionalidade.montarUrlFeed(userPageId, accessTokenUserPage));
		
		List<PageUserFeed> lista = obterPublicacoesResponseBody();
		if(lista.size() > 0) {
			iCollectionService.setCollection("idPublicacao", lista.get(0).getId());
		}
		
	}
	
	public List<PageUserFeed> obterPublicacoesResponseBody() {
		ValidatableResponse validation = iCollectionService.getCollection("validation", ValidatableResponse.class);		
		Publicacoes response = validation.extract().body().as(Publicacoes.class);
		iCollectionService.setCollection("responsePublicacoes", response);
		logger.info("response: "+response);
		return response.getData();
	}
	
	
	public void realizarUpdateNaApi() {
		String accessTokenUserPage = iCollectionService.getCollection("accessTokenUserPage", String.class);
		String idPublicacao = iCollectionService.getCollection("idPublicacao", String.class);
		String dados = iCollectionService.getCollection("mensagem", String.class);
		apiFuncionalidade.putApi(apiFuncionalidade.montarUrlUpdate(idPublicacao, accessTokenUserPage), dados);		
	}


	public void validarSeFoiObtidoSucesso() {
		String value = obterUpdateResponseResponseBody();
		Assert.assertNotNull("A mensagem não foi atualizada no feed!", value);
		Assert.assertEquals("true", value, "A mensagem não foi atualizada no feed!");
	}

	private String obterUpdateResponseResponseBody() {
		ValidatableResponse validation = iCollectionService.getCollection("validation", ValidatableResponse.class);		
		OutPutUpdateFeedResponse response = validation.extract().body().as(OutPutUpdateFeedResponse.class);
		iCollectionService.setCollection("responseUpdate", response);
		logger.info("response: "+response);
		return response.getSuccess();
	}
	
}
