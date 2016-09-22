package PageObjects;

import BrowserFactory.Browser;
import StepDefinitions.SpringConfig;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.test.context.ContextConfiguration;

/**
 * Created by Asad.Hasan on 15/08/2016.
 */
@Component
@ContextConfiguration(classes = SpringConfig.class)
public class Homepage extends BasePage {

    private Select select;

    @Autowired
    private Browser browser;

    @CacheLookup
    @FindBy(id = "searchDropdownBox")
    private WebElement searchDropdownBox;

    @CacheLookup
    @FindBy(id = "twotabsearchtextbox")
    private WebElement searchTextBox;

    @CacheLookup
    @FindBy(id = "nav-search-submit-text")
    private WebElement searchSubmitButton;

    @CacheLookup
    @FindBy(id = "nav-link-yourAccount")
    private WebElement yourAccount;

    @CacheLookup
    @FindBy(id = "nav-link-shopall")
    private WebElement departmentsDropdown;

    @Autowired
    public Homepage(WebDriver driver){
        super(driver);
        PageFactory.initElements(driver,this);
    }

    public Homepage searchForItem(String text){
        searchTextBox.sendKeys(text);
        return this;
    }

    public Homepage selectSearchCategory(String suggestions){
    //    super.driver=driver;
        select=new Select(searchDropdownBox);
        select.selectByVisibleText(suggestions);
        return this;
    }

    public Homepage selectDepartmentOptions(String term){
   //     super.driver=driver;
        select=new Select(departmentsDropdown);
        select.selectByVisibleText(term);
        return this;
    }

    public Homepage submitSearch(){
        browser.getWait().until(ExpectedConditions.elementToBeClickable(searchSubmitButton));
        browser.getActions(driver).moveToElement(searchSubmitButton).click().build().perform();
        return this;
    }
}
