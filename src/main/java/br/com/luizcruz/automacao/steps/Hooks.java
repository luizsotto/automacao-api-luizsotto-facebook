package br.com.luizcruz.automacao.steps;

import java.nio.file.Paths;

import org.apache.log4j.Logger;
import org.openqa.selenium.chrome.ChromeDriver;

import br.com.luizcruz.automacao.bean.ApplicationConfig;
import br.com.luizcruz.commons.repositorio.CollectionService;
import br.com.luizcruz.commons.repositorio.interfaces.ICollectionService;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;


public class Hooks {
	
	final static Logger logger = Logger.getLogger(Hooks.class.getName());
	
	private ICollectionService iCollectionService = null;
	private ApplicationConfig config ;
	
	public Hooks() {
	}
	
	@Before
	public void init(Scenario scenario) {
		logger.info("------------------------------------------------------------------------------------------------------------------------------------------");
		logger.info("Cenario: ".concat(scenario.getName()));
		iCollectionService = CollectionService.getInstance();
		config = ApplicationConfig.getInstance();
		if(null == config.getWebDriver()){
			String path = Paths.get("").toAbsolutePath().toString()+ "\\src\\test\\resources\\drivers\\chromedriver.exe";
			logger.info("path: "+path);
			System.setProperty("webdriver.chrome.driver", path);
			ChromeDriver webDriver = new ChromeDriver();
			config.setWebDriver(webDriver);
		}
	}
	
	@After 
	public void afterScenarioExecution(Scenario scenario) {
		logger.info("------------------------------------------------------------------------------------------------------------------------------------------");
		logger.info("Fim do Cenario: '".concat(scenario.getName()).concat("' teve status ").concat(scenario.getStatus()));
		logger.info("------------------------------------------------------------------------------------------------------------------------------------------");
		
		iCollectionService = CollectionService.clean();
		config.getWebDriver().close();
	}
	
}
