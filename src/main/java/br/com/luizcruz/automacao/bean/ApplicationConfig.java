package br.com.luizcruz.automacao.bean;

import java.util.NoSuchElementException;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import br.com.luizcruz.commons.utils.Constantes;
import br.com.luizcruz.commons.utils.PropertiesLoader;

public class ApplicationConfig {
	
	private final static Logger logger = Logger.getLogger(ApplicationConfig.class);
	private static ApplicationConfig instance = null;
		
	private String login;
	private String senha;
	private String appId;
	private String appSenha;
	private String baseUrl;
	private String endPointOath;
	private String endPointAccesToken;
	private String endpointDegubToken;
	//endpoint.feed
	private String endpointFeed;
	private String endpointAccounts;
	private String encoding;
	private String algorithm;
	private WebDriver webDriver;
	
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	public String getAppId() {
		return appId;
	}
	public void setAppId(String appId) {
		this.appId = appId;
	}
	public String getAppSenha() {
		return appSenha;
	}
	public void setAppSenha(String appSenha) {
		this.appSenha = appSenha;
	}
	public String getBaseUrl() {
		return baseUrl;
	}
	public void setBaseUrl(String baseUrl) {
		this.baseUrl = baseUrl;
	}
	public String getEndPointOath() {
		return endPointOath;
	}
	public void setEndPointOath(String endPointOath) {
		this.endPointOath = endPointOath;
	}
	public String getEndPointAccesToken() {
		return endPointAccesToken;
	}
	public void setEndPointAccesToken(String endPointAccesToken) {
		this.endPointAccesToken = endPointAccesToken;
	}
	public String getEndpointDegubToken() {
		return endpointDegubToken;
	}
	public void setEndpointDegubToken(String endpointDegubToken) {
		this.endpointDegubToken = endpointDegubToken;
	}
	public String getEndpointFeed() {
		return endpointFeed;
	}
	public void setEndpointFeed(String endpointFeed) {
		this.endpointFeed = endpointFeed;
	}
	public String getEndpointAccounts() {
		return endpointAccounts;
	}
	public void setEndpointAccounts(String endpointAccounts) {
		this.endpointAccounts = endpointAccounts;
	}
	public String getEncoding() {
		return encoding;
	}
	public void setEncoding(String encoding) {
		this.encoding = encoding;
	}
	public String getAlgorithm() {
		return algorithm;
	}
	public void setAlgorithm(String algorithm) {
		this.algorithm = algorithm;
	}
	public WebDriver getWebDriver() {
		return webDriver;
	}
	public void setWebDriver(WebDriver webDriver) {
		this.webDriver = webDriver;
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "login: ".concat(login)
				.concat("; \t senha: ").concat(senha)
				.concat(";\t baseUrl: ").concat(baseUrl)
				.concat(";\t encoding: ").concat(encoding)
				.concat(";\t endPointOath: ").concat(endPointOath);
	}	
	public WebElement getDataByXpath(String xPath) {
		WebElement element = null;
		try {
			element = this.webDriver.findElement(By.xpath(xPath));
		}catch(NoSuchElementException nE){
			logger.error(nE.getMessage(), nE);
		}catch(Exception e){
			logger.error(e.getMessage(), e);
		}
		return element;
	}
	
	public String obterDadosFromPropertie(String value) {
		 return PropertiesLoader.getInstance().getValue(Constantes.APPLICATION_PROPERTIES, value);
	}

	private ApplicationConfig () {
		login				= obterDadosFromPropertie("usuario.login");
		senha				= obterDadosFromPropertie("usuario.senha");
		appId				= obterDadosFromPropertie("app.id");
		appSenha			= obterDadosFromPropertie("app.senha");
		baseUrl				= obterDadosFromPropertie("url.base");
		endPointOath		= obterDadosFromPropertie("endpoint.oauth");
		endPointAccesToken	= obterDadosFromPropertie("endpoint.token");
		endpointDegubToken	= obterDadosFromPropertie("endpoint.degub.token");
		endpointFeed		= obterDadosFromPropertie("endpoint.feed");
		endpointAccounts	= obterDadosFromPropertie("endpoint.accounts");
		encoding			= obterDadosFromPropertie("encoding");
		algorithm			= obterDadosFromPropertie("algorithm");
    }
    
	public static ApplicationConfig getInstance() {
       if(instance == null) {
           try {
               instance = new ApplicationConfig();
           } catch (Exception e) {
               throw new IllegalArgumentException("Erro, ao inicializar o reposit�rio.");
           }
       }
       return instance;
	}
}

