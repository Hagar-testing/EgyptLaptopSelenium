package com.egyptlaptop.pages;

import com.egyptlaptop.base.BasePage;
import com.egyptlaptop.enums.LocatorType;
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


    @FindBy(css = CATEGORIES_DROPDOWN_CSS)
    WebElement categories_dropdown;

    @FindBy(css = CATEGORY_ITEM_CSS)
    WebElement categoryItem_button;
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

    @Step
    public boolean isSearchResultNotEmpty(){
        return  searchResults_list.size() > 0;
    }

    @Step
    public CategoriesListPage clickOnCategory(){
         elementInteraction.simpleClick(first_category_div, FIRST_CATEGORY_NAME);
         return new CategoriesListPage(driver);
    }


    @Step
    public MainPage selectCategoryFromDropdownList(){
        elementInteraction.simpleClick(categories_dropdown,CATEGORIES_DROPDOWN_NAME);
        return this;

    }

    @Step
    public String getFirstSubCategoryText(){
        return elementInteraction.locateElement(categoryItem_button, LocatorType.WITH_WAIT)
                .getText();
    }

    @Step
    public ProductsListPage selectSubCategory(){
        categoryItem_button.click();
        return new ProductsListPage(driver);
    }

}
