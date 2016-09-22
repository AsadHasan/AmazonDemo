package BrowserFactory;

import StepDefinitions.SpringConfig;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.test.context.ContextConfiguration;

/**
 * Created by Asad.Hasan on 15/08/2016.
 */
@Component
@ContextConfiguration(classes = SpringConfig.class)
public class Browser {
    @Autowired
    protected WebDriver driver;

    protected WebDriverWait wait;

    protected Actions actions;

    public WebDriverWait getWait(){
        wait=new WebDriverWait(driver,60);
        return wait;
    }

    @Autowired
    public Actions getActions(WebDriver driver){
      actions=new Actions(driver);
      return actions;
  }

    public String pageTitle(){
        return driver.getTitle();
    }

    public Browser maximise(){
        driver.manage().window().maximize();
        return this;
    }
}
