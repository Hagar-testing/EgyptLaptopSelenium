package com.egyptlaptop.pages;

import com.egyptlaptop.base.BasePage;
import com.egyptlaptop.enums.LocatorType;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static com.egyptlaptop.constants.pages.ProductListPageConstants.*;

public class ProductsListPage extends BasePage {

    @FindBy(xpath = PRODUCT_XPATH)
    WebElement product;

    @FindBy(xpath = IN_STOCK_CHECKBOX_XPATH)
    WebElement inStock_checkbox;

    @FindBy(className = CATEGORY_ITEM_CLASS)
    WebElement categoryTitle_text;
    public ProductsListPage(WebDriver driver) {
        super(driver);
    }

    @Step
    public ProductDetailsPage clickOnProduct(){
        product.click();
        return new ProductDetailsPage(driver);
    }

    @Step
    public ProductsListPage checkInStockCheckBox(){
        elementInteraction.simpleClick(inStock_checkbox, LocatorType.WAIT_CLICKABLE,IN_STOCK_CHECKBOX_NAME);
        return this;
    }


    @Step
    public String getCategoryText(){
        return categoryTitle_text.getText();
    }

}
