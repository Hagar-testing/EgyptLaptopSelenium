package com.egyptlaptop.pages;

import com.egyptlaptop.base.BasePage;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static com.egyptlaptop.constants.locators.CategoriesListLocators.CATEGORY_ITEM_CLASS;

public class CategoriesListPage extends BasePage {

    @FindBy(className = CATEGORY_ITEM_CLASS)
    WebElement categoryItem;

    public CategoriesListPage(WebDriver driver) {
        super(driver);
    }

    @Step
    public ProductsListPage selectCategory(){
        elementInteraction.simpleClick(categoryItem,"category item");
        return new ProductsListPage(driver);
    }

}
