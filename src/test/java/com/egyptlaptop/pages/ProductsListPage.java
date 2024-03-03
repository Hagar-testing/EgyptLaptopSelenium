package com.egyptlaptop.pages;

import com.egyptlaptop.base.BasePage;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static com.egyptlaptop.constants.locators.ProductListLocators.IN_STOCK_CHECKBOX_XPATH;
import static com.egyptlaptop.constants.locators.ProductListLocators.PRODUCT_XPATH;

public class ProductsListPage extends BasePage {

    @FindBy(xpath = PRODUCT_XPATH)
    WebElement product;

    @FindBy(xpath = IN_STOCK_CHECKBOX_XPATH)
    WebElement inStock_checkbox;
    public ProductsListPage(WebDriver driver) {
        super(driver);
    }

    @Step
    public ProductDetailsPage clickOnProduct(){
        product.click();
        return new ProductDetailsPage(driver);
    }

    public ProductsListPage checkInStockCheckBox(){
        inStock_checkbox.click();
        return this;
    }

}
