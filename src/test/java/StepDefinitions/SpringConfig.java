package StepDefinitions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * Created by asad.hasan on 17/08/2016.
 */
@Configuration
@ComponentScan({"PageObjects","StepDefinitions","BrowserFactory"})
public class SpringConfig {
/*
    @Bean
    public WebDriver chrome(){
        return new ChromeDriver();
    }*/

    @Bean
    public WebDriver htmlunit(){
        return new HtmlUnitDriver();
    }

    @Bean
    public WebDriver phantom(){
        return new PhantomJSDriver();
    }
}
