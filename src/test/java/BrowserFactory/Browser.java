package BrowserFactory;

import StepDefinitions.SpringConfig;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;
import org.springframework.test.context.ContextConfiguration;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Asad.Hasan on 15/08/2016.
 */
@Component
@ContextConfiguration(classes = SpringConfig.class)
public class Browser {

    @Autowired
    @Qualifier("phantom")
    protected WebDriver driver;

    protected WebDriverWait wait;

    protected Actions actions;

    private AnnotationConfigApplicationContext annotationConfigApplicationContext;

    private static Map<String, WebDriver> drivers = new HashMap<String, WebDriver>();
/*
    protected Browser(){
        annotationConfigApplicationContext=new AnnotationConfigApplicationContext(SpringConfig.class);
    }
*/
    public WebDriver getBrowser(String browserName) {
        annotationConfigApplicationContext=new AnnotationConfigApplicationContext(SpringConfig.class);
        WebDriver driver = null;

        switch (browserName) {
            case "chrome":
                driver = drivers.get("chrome");
                if (driver == null) {
                    driver = (ChromeDriver)annotationConfigApplicationContext.getBean("chrome");
                    drivers.put("chrome", driver);
                }
                break;
            case "phantom":
                driver = drivers.get("phantom");
                if (driver == null) {
                    driver = (PhantomJSDriver)annotationConfigApplicationContext.getBean("Phantom");
                    drivers.put("phantom", driver);
                }
                break;
            case "htmlunit":
                driver = drivers.get("htmlunit");
                if (driver == null) {
                    driver = (HtmlUnitDriver)annotationConfigApplicationContext.getBean("htmlunit");
                    drivers.put("htmlunit", driver);
                }
                break;
        }
        return driver;
    }

    public WebDriverWait getWait(){
        wait=new WebDriverWait(driver,60);
        return wait;
    }

    public Actions getActions(){
      actions=new Actions(driver);
      return actions;
  }

    public String pageTitle(){
        return driver.getTitle();
    }

    public Browser maximise(){
     //   driver.manage().window().maximize();
        return this;
    }
}
