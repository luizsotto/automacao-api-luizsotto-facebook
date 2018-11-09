package br.com.luizcruz.automacao.funcionalidade;

import org.apache.log4j.Logger;

import br.com.luizcruz.automacao.bean.ApplicationConfig;
import br.com.luizcruz.commons.utils.Constantes;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

public class ApiFuncionalidade {
	private final static Logger logger = Logger.getLogger(ApiFuncionalidade.class);
	
	private ApplicationConfig applicationConfig;
	private RequestSpecification requestSpecification;
	private ValidatableResponse validation;
	
	public ApiFuncionalidade() {
		applicationConfig =  ApplicationConfig.getInstance();
	}
	
	public RequestSpecification create() {
		defineRelaxedHttps();
		return defineBaseURL();
	}
	
	private  void defineRelaxedHttps() {
		RestAssured.useRelaxedHTTPSValidation();
	}
	
	private RequestSpecification defineBaseURL() {
		RequestSpecification espc = new RequestSpecBuilder().setBaseUri(applicationConfig.getBaseUrl()).build();
		return RestAssured.given().spec(espc);
		
	}
	
	public void postApi(String url, String dados) {
		validation = 
				this.requestSpecification
				.body(dados)
				.contentType(ContentType.JSON)
				.when()
					.put(url)
				.then();
	}

	public void putApi(String url, String dados) {	
		validation = 
				this.requestSpecification
				.body(dados)
				.contentType(ContentType.JSON)
				.when()
					.put(url)
				.then();		
	}
	
	public void getApi(String url) {
		validation = 
				this.requestSpecification
					.contentType(ContentType.JSON)
				.when()
					.get(url)
				.then();
	}

	public RequestSpecification getRequestSpecification() {
		return requestSpecification;
	}

	public ValidatableResponse getValidation() {
		return validation;
	}

	public String montarUrlDeAutenticacao() {
		StringBuffer strBuffer = new StringBuffer(applicationConfig.getBaseUrl());
		strBuffer.append(applicationConfig.getEndPointOath());
		strBuffer.append("?client_id=");
		strBuffer.append(applicationConfig.getAppId());
		strBuffer.append("&redirect_uri=");
		strBuffer.append(Constantes.REDIRECT_URI);
		
		logger.info(strBuffer.toString());
		
		return strBuffer.toString();
	}
	
	
	public String montarUrlDeAccesTokenDeUsuario(String code) {
		StringBuffer strBuffer = new StringBuffer(applicationConfig.getBaseUrl());
		strBuffer.append(applicationConfig.getEndPointAccesToken());
		strBuffer.append("?client_id=");
		strBuffer.append(applicationConfig.getAppId());
		strBuffer.append("&client_secret=");
		strBuffer.append(applicationConfig.getAppSenha());
		strBuffer.append("&redirect_uri=");
		strBuffer.append(Constantes.REDIRECT_URI);
		strBuffer.append("&code=");
		strBuffer.append(code);
		
		logger.info("User url acces: "+strBuffer.toString());
		
		return strBuffer.toString();
	}
	
	public String montarUrlDeAccesTokenDeApp() {
		StringBuffer strBuffer = new StringBuffer(applicationConfig.getBaseUrl());
		strBuffer.append(applicationConfig.getEndPointAccesToken());
		strBuffer.append("?client_id=");
		strBuffer.append(applicationConfig.getAppId());
		strBuffer.append("&client_secret=");
		strBuffer.append(applicationConfig.getAppSenha());
		strBuffer.append("&grant_type=client_credentials");
		
		logger.info("App url acces: "+strBuffer.toString());
		
		return strBuffer.toString();
	}
	
	public String montarUrlInspecionarToken(String accessTokenUser, String accessTokenApp) {
		StringBuffer strBuffer = new StringBuffer(applicationConfig.getBaseUrl());
		strBuffer.append(applicationConfig.getEndpointDegubToken());
		strBuffer.append("?input_token=");
		//Access_token do usuario
		strBuffer.append(accessTokenUser);
		strBuffer.append("&access_token=");
		//Access_token do usuario
		strBuffer.append(accessTokenApp);
		
		logger.info("App url acces: "+strBuffer.toString());
		
		return strBuffer.toString();
	}
	
	public String montarUrlAccounts(String userId, String accessTokenUser) {
		StringBuffer strBuffer = new StringBuffer(applicationConfig.getBaseUrl());
		strBuffer.append("/");
		strBuffer.append(userId);
		strBuffer.append(applicationConfig.getEndpointAccounts());
		strBuffer.append("?access_token=");
		//Access_token do usuario
		strBuffer.append(accessTokenUser);
		
		logger.info("App url acces: "+strBuffer.toString());
		
		return strBuffer.toString();
		
	}
	
	
	public String montarUrlFeed(String userPageId, String accessTokenUserPage) {
		StringBuffer strBuffer = new StringBuffer(applicationConfig.getBaseUrl());
		strBuffer.append("/");
		strBuffer.append(userPageId);
		strBuffer.append(applicationConfig.getEndpointFeed());
		strBuffer.append("?access_token=");
		//Access_token do usuario
		strBuffer.append(accessTokenUserPage);
		
		logger.info("App url acces: "+strBuffer.toString());
		
		return strBuffer.toString();
	}

	public void realizarGETNaAPI(String urlMontada) {
		requestSpecification = create();
		getApi(urlMontada);
	}

	public String montarUrlUpdate(String idPublicacao, String accessTokenUserPage) {
		StringBuffer strBuffer = new StringBuffer(applicationConfig.getBaseUrl());
		strBuffer.append("/");
		strBuffer.append(idPublicacao);
		strBuffer.append("?access_token=");
		//Access_token do usuario
		strBuffer.append(accessTokenUserPage);
		
		logger.info("App url acces: "+strBuffer.toString());
		
		return strBuffer.toString();
	}


	


}
