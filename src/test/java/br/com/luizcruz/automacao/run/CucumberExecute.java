package br.com.luizcruz.automacao.run;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(monochrome = true, 
				 snippets = SnippetType.CAMELCASE, 
				 plugin = { "json:target/surefire-reports/cucumber.json" }, 
				 features = { "src/test/resources/features/" },
				 glue = { "br.com.luizcruz.automacao.steps" },
				 tags = {"@Postagem1"})
public class CucumberExecute {

}
