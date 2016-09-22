package StepDefinitions;

import BrowserFactory.Browser;
import PageObjects.Homepage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.ContextConfiguration;

/**
 * Created by asad.hasan on 17/08/2016.
 */
@Configuration
@ComponentScan({"PageObjects","StepDefinitions","BrowserFactory"})
public class SpringConfig {

  /*  @Bean
    public Homepage homepage(){
        return new Homepage(chrome());
    }*/

    @Bean
    public WebDriver chrome(){
        return new ChromeDriver();
    }
}
