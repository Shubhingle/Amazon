package steps;
import com.google.common.base.Equivalence;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.testng.Assert ;
import org.testng.IDataProviderInterceptor;
import pages.HomePage;
import utils.BrowserManager;
import utils.QaProps;
import utils.TestDataReader;

import java.util.HashMap;


public class StepDefinitions {
    private WebDriver driver;
    HomePage homePage;

    String url;
    HashMap<String, String> data;
    Scenario scenario;

    public StepDefinitions(BrowserManager browserManager) throws InterruptedException {
        this.driver = browserManager.getDriver();
    }

        @Before(order = 1)
        public void before (Scenario scenario){
            this.scenario = scenario;
        }

        //search
        @Given("When the user navigates to the home page")
        public void when_the_user_navigates_to_the_home_page () {
            url = QaProps.getValue("url");
            driver.get(url);
           // System.out.println(1/0);
            data = TestDataReader.getData(scenario.getName());
        }

        @When("the user enters the product name")
        public void the_user_enters_the_product_name () {
            homePage = new HomePage(driver);
            homePage.getSearchBox().sendKeys(data.get("TypeValue"));
            homePage.getSearchBox().sendKeys(Keys.ENTER);
        }
        @Then("the product results should be displayed")
        public void the_product_results_should_be_displayed () {
            String text = homePage.getSearchResult().getText();
            System.out.println(text);
            Assert.assertEquals(text, data.get("SearchValues"));
        }

        //negative

         @Given("the user navigates to the home page")
         public void theUserNavigatesToTheHomePage() {
             url = QaProps.getValue("url");
             driver.get(url);
        }
        @When("the user enters invalid name")
        public void the_user_enters_invalid_name () {
            homePage = new HomePage(driver);
            homePage.getInvalidText().sendKeys("1234");
            homePage.getInvalidText().sendKeys(Keys.ENTER);
        }
        @Then("the user should get error message")
        public void the_user_should_get_error_message () {
            String text = homePage.getInvalidResult().getText();
            System.out.println(text);
            Assert.assertEquals(text, "\"1234\"");
        }

        //Today's deal
        @Given("user navigates to the home page")
        public void userNavigatesToTheHomePage() {
            url = QaProps.getValue("url");
            driver.get(url);
        }
        @When("the user should access today's deal page")
        public void the_user_should_access_today_s_deal_page () throws InterruptedException {
            homePage = new HomePage(driver);
            Thread.sleep(2000);
            homePage.getDealTab().click();
        }

        @Then("the Today's deal tab will be displayed")
        public void the_today_deal_tab_will_be_displayed () throws Exception {
            String url =  driver.getCurrentUrl();
            Assert.assertEquals(url,"https://www.amazon.in/deals?ref_=nav_cs_gb");

        }

        //Best seller
        @Given("When user navigates to amazon homepage")
        public void whenUserNavigatesToAmazonHomepage() {
            url = QaProps.getValue("url");
            driver.get(url);
        }

        @When("the user should be able to access Best sellers tab")
        public void theUserShouldBeAbleToAccessBestSellersTab() throws  Exception{
            homePage = new HomePage(driver);
            Thread.sleep(2000);
            homePage.getBestTab().click();
        }

        @Then("the Best Sellers tab will be displayed")
        public void theBestSellersTabWillBeDisplayed() {
        String url =  driver.getCurrentUrl();
        Assert.assertEquals(url,"https://www.amazon.in/gp/bestsellers/?ref_=nav_cs_bestsellers");
        }

        //Scenario Outline
        @Given("When the user navigates to the home page of amazon")
        public void whenTheUserNavigatesToTheHomePageOfAmazon() {
            url = QaProps.getValue("url");
            driver.get(url);
        }

        @When("the user should click on the search bar and enters {string}")
        public void theUserShouldClickOnTheSearchBarAndEnters(String Product) {
            homePage.getResults().click();
            homePage.getResults().sendKeys("Product");

        }

        @Then("the product gets displayed")
        public void theProductGetsDisplayed() {
        String text = homePage.getProductResult().getText();

        }

        //category
        @Given("the user navigated to amazon homepage")
        public void theUserNavigatedToAmazonHomepage() {
            url = QaProps.getValue("url");
            driver.get(url);
        }

        @When("user clicks on dropdown and selects a category")
        public void userClicksOnDropdownAndSelectsACategory() {
            homePage = new HomePage(driver);
            homePage.getCategory().click();
            homePage.getSearchCategory().click();
       }

        @And("the user enters name of product")
        public void theUserEntersNameOfProduct() {
            homePage = new HomePage(driver);
            homePage.getSearchBar().sendKeys("Saree");
            homePage.getSearchIcon().click();
       }

        @Then("the product gets displayed for category")
        public void theProductGetsDisplayedForCategory() throws InterruptedException{
            String text = homePage.getCategoryResult().getText();
            System.out.println(text);
            Assert.assertEquals(text,"\"Saree\"");




        }

}

