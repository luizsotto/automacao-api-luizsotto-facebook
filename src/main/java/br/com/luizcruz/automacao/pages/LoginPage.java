package br.com.luizcruz.automacao.pages;

import java.io.IOException;

import org.openqa.selenium.WebElement;

import br.com.luizcruz.automacao.bean.ApplicationConfig;


public class LoginPage {

	private static final String TITLE_LOGIN_PAGE =".//*[@id='pageTitle' and contains(text(),''Entrar no Facebook')]";
	private static final String CAMPO_EMAIL  =".//input[@id='email']";
	private static final String CAMPO_SENHA  =".//input[@id='pass']";
	private static final String BOTAO_ENTRAR  =".//*[@id='loginbutton']";
	
	private ApplicationConfig config;
	
	public LoginPage() {
		config = ApplicationConfig.getInstance();
	}
	
	public void acessarTela(String url) throws IOException{
		config.getWebDriver().navigate().to(url);
	}
	
	public WebElement getCampoEmail() {
		return getCampoGenerico(CAMPO_EMAIL);
	}
	
	private WebElement getCampoGenerico(String campo) {
		return config.getDataByXpath(campo);
	}
	
	public void setUsuario() throws IOException{
		WebElement element  = getCampoGenerico(CAMPO_EMAIL);
		element.click();
		element  = getCampoGenerico(CAMPO_EMAIL);
		element.sendKeys(config.getLogin());
	}
	
	public void setSenha() throws IOException{
		WebElement element  = getCampoGenerico(CAMPO_SENHA);
		element.click();
		element  = getCampoGenerico(CAMPO_SENHA);
		element.sendKeys(config.getSenha());
	}
	
	public void clickButtonEntrar() throws IOException{
		getCampoGenerico(BOTAO_ENTRAR).click();
	}
	
	public String getUrlAtual() {
		return config.getWebDriver().getCurrentUrl();
	}
}
