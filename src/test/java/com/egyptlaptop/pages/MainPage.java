package com.egyptlaptop.pages;

import com.egyptlaptop.base.BasePage;
import com.egyptlaptop.utils.ConfigUtils;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import java.util.List;
import static com.egyptlaptop.constants.locators.MainPageLocators.CATEGORY_XPATH;
import static com.egyptlaptop.constants.locators.MainPageLocators.SEARCH_INPUT_ID;
import static com.egyptlaptop.constants.locators.MainPageLocators.SEARCH_PRODUCTS_LIST_TITLES_XPATH;

public class MainPage extends BasePage {

    @FindBy(id = SEARCH_INPUT_ID)
    WebElement search_input;

    @FindBy(xpath = SEARCH_PRODUCTS_LIST_TITLES_XPATH)
    List<WebElement> searchResults_list;

    @FindBy(xpath = CATEGORY_XPATH)
    WebElement first_category_div;
    public MainPage(WebDriver driver) {
        super(driver);
    }

    @Step
    public MainPage load(){
        driver.get(ConfigUtils.getBaseUrl() );
        return this;
    }
    @Step
    public MainPage sendSearchInput(String searchText) {
        elementInteraction.setInput(search_input,searchText);
        return this;
    }

    public boolean isSearchResultNotEmpty(){
        return  searchResults_list.size() > 0;
    }

    public CategoriesListPage clickOnCategory(){
         elementInteraction.simpleClick(first_category_div);
         return new CategoriesListPage(driver);
    }
}
