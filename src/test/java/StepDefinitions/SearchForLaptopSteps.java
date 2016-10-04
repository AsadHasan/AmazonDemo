package StepDefinitions;

import BrowserFactory.Browser;
import PageObjects.Homepage;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;


/**
 * Created by Asad.Hasan on 15/08/2016.
 */

public class SearchForLaptopSteps extends Browser{

    private static final Logger logger=LoggerFactory.getLogger(SearchForLaptopSteps.class);

    @Autowired
    private Homepage homepage;

    @Given("^I navigate to \"([^\"]*)\"$")
    public void loadHomepage(String arg0) {
            driver.get("https://www.amazon.com/");
            maximise();
        }

    @And("^I select \"([^\"]*)\" from the dropdown menu next to the search bar$")
    public void iSelectFromTheDropdownMenuNextToTheSearchBar(String s){
        try {
            homepage.selectSearchCategory("Computers");
        }
        catch (NullPointerException e){
        logger.debug("Exception",e);
        }
    }

    @When("^I type \"([^\"]*)\" in the search bar$")
    public void iTypeInTheSearchBar(String text){
        try {
            homepage.searchForItem(text);
        }
        catch (NullPointerException e){
            logger.debug("Exception",e);
        }
    }

    @And("^I select \"([^\"]*)\" from auto-complete$")
    public void iSelectFromAutoComplete(String suggestions){
        try {
            homepage.autoComplete();
        }
        catch (NullPointerException e){
            logger.debug("Exception",e);
        }
    }

    @And("^submit search$")
    public void submitSearch(){
        // Write code here that turns the phrase above into concrete actions

    }
}
             

