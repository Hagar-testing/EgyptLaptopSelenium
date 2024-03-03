package com.egyptlaptop.pages;

import com.egyptlaptop.base.BasePage;
import com.egyptlaptop.utils.ConfigUtils;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import java.util.List;

import static com.egyptlaptop.constants.pages.MainPageConstants.*;

public class MainPage extends BasePage {

    @FindBy(id = SEARCH_INPUT_ID)
    WebElement search_input;

    @FindBy(xpath = SEARCH_PRODUCTS_LIST_TITLES_XPATH)
    List<WebElement> searchResults_list;

    @FindBy(xpath = CATEGORY_XPATH)
    WebElement first_category_div;

    @FindBy(xpath = "//a[normalize-space()='Profile details']")
    WebElement profileDetails_btn;

    @FindBy(css = "a[class=\"ty-menu__item-link a-first-lvl childs\"]")
    WebElement categories_dropdown;
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
        elementInteraction.setInput(search_input,searchText,SEARCH_INPUT_NAME);
        return this;
    }

    public boolean isSearchResultNotEmpty(){
        return  searchResults_list.size() > 0;
    }

    @Step
    public CategoriesListPage clickOnCategory(){
         elementInteraction.simpleClick(first_category_div, FIRST_CATEGORY_NAME);
         return new CategoriesListPage(driver);
    }

    @Step
    public boolean isProfileDetailsDisplayed(){
        return profileDetails_btn.isDisplayed();
    }

    @Step
    public void test(){
        categories_dropdown.click();
    }
}
