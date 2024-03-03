package com.egyptlaptop.pages;

import com.egyptlaptop.base.BasePage;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static com.egyptlaptop.constants.pages.CategoriesPageConstants.CATEGORY_ITEM_CLASS;
import static com.egyptlaptop.constants.pages.CategoriesPageConstants.CATEGORY_ITEM_ELEMENT_NAME;

public class CategoriesListPage extends BasePage {

    @FindBy(className = CATEGORY_ITEM_CLASS)
    WebElement categoryItem;

    public CategoriesListPage(WebDriver driver) {
        super(driver);
    }

    @Step
    public ProductsListPage selectCategory(){
        elementInteraction.simpleClick(categoryItem,CATEGORY_ITEM_ELEMENT_NAME);
        return new ProductsListPage(driver);
    }

}
