package com.cybertek.step_definitions;

import com.cybertek.pages.EtsySearchPage;
import com.cybertek.utilities.ConfigurationReader;
import com.cybertek.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class Etsy_StepDefinitions {

    @Given("User is on Etsy landing page")
    public void user_is_on_etsy_landing_page() {
                // same as below --> Driver.getDriver().get(ConfigurationReader.getProperty("etsyUrl"));
        String url = ConfigurationReader.getProperty("etsyUrl");
        Driver.getDriver().get(url);
    }

    @Then("User should see Etsy title as expected")
    public void user_should_see_etsy_title_as_expected() {
        String expectedTitle = "Etsy - Shop for handmade, vintage, custom, and unique gifts for everyone";
        String actualTitle = Driver.getDriver().getTitle();
        Assert.assertTrue("Title is not as expected", actualTitle.equals(expectedTitle));
    }

    EtsySearchPage etsySearchPage = new EtsySearchPage(); // create in class so any method here can use it
    @When("User types wooden spoon in the search box")
    public void u_ser_types_wooden_spoon_in_the_search_box() {
        etsySearchPage.searchBar.sendKeys("wooden spoon");
    }

    @When("User clicks search button")
    public void u_ser_clicks_search_button() {
        etsySearchPage.searchButton.click();
    }

    @Then("User sees title is Wooden spoon | Etsy")
    public void user_sees_title_is_wooden_spoon_etsy() {
        String expectedTitle = "Wooden spoon | Etsy";
        String actualTitle = Driver.getDriver().getTitle();
        Assert.assertEquals("Title is not as expected", actualTitle.equals(expectedTitle));
    }

}
