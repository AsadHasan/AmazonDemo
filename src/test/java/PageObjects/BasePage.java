package PageObjects;

import BrowserFactory.Browser;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;

/**
 * Created by Asad.Hasan on 15/08/2016.
 */

public class BasePage {
    protected WebDriver driver;

    @CacheLookup
    @FindBy(id = "navbar")
    private WebElement header;

    @CacheLookup
    @FindBy(id = "navFooter")
    private WebElement footer;

    public BasePage(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }

   // public WebDriver

    public WebElement getHeader(){
        return header;
    }

    public WebElement getFooter(){
        return footer;
    }

}
