package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.BrowserManager;

public class HomePage {
    private WebDriver driver;

    public HomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    public WebElement getSearchBox() {
        return searchBox;
    }

    @FindBy(id = "twotabsearchtextbox")
    WebElement searchBox;

    public WebElement getSearchResult() {
        return searchResult;
    }

    @FindBy(xpath ="//span[@class='a-color-state a-text-bold']")
    WebElement searchResult;

    public WebElement getInvalidText() {
        return invalidText;
    }

    @FindBy(id ="twotabsearchtextbox" )
    WebElement invalidText;

    public WebElement getInvalidResult() {
        return invalidResult;
    }

    @FindBy(xpath = "//span[@class='a-color-state a-text-bold']")
    WebElement invalidResult;

    public WebElement getDealTab() {
        return dealTab;
    }

    @FindBy(xpath = "//a[@href='/deals?ref_=nav_cs_gb']")
    WebElement dealTab;


    public WebElement getBestTab() {
        return bestTab;
    }

    @FindBy(xpath = "//a[@href='/gp/bestsellers/?ref_=nav_cs_bestsellers']")
    WebElement bestTab;

    public WebElement getSearchIcon() {
        return searchIcon;
    }

    @FindBy(xpath = "//input[@id='nav-search-submit-button']")
    WebElement searchIcon;

    public WebElement getResults() {
        return Results;
    }

    @FindBy(id = "twotabsearchtextbox")
    WebElement Results;

    public WebElement getProductResult() {
        return ProductResult;
    }

    @FindBy(xpath = "//span[@class='a-color-state a-text-bold']")
    WebElement ProductResult;

    public WebElement getCategory() {
        return Category;
    }
    @FindBy(xpath = "//div[@class='nav-search-scope nav-sprite']")
    WebElement Category;

    public WebElement getSearchCategory() {
        return searchCategory;
    }

    @FindBy(xpath = "//option[@value='search-alias=fashion']")
    WebElement searchCategory;

    public WebElement getSearchBar() {
        return searchBar;
    }

    @FindBy(id = "twotabsearchtextbox")
    WebElement searchBar;

    public WebElement getCategoryResult() {
        return categoryResult;
    }

    @FindBy(xpath = "//span[@class='a-color-state a-text-bold']")
    WebElement categoryResult;

}


