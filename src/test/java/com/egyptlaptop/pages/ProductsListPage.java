package com.egyptlaptop.pages;

import com.egyptlaptop.base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductsListPage extends BasePage {

    @FindBy(xpath = "//div[@id='categories_view_pagination_contents']//div[@class='ty-column4']//div[@class='ut2-gl__item ']")
    WebElement product;

    @FindBy(xpath = "//li[contains(., 'In stock')]/input[@type='checkbox']")
    WebElement inStock_checkbox;
    public ProductsListPage(WebDriver driver) {
        super(driver);
    }

    public ProductDetailsPage clickOnProduct(){
        elementInteraction.javascriptClick(product);
        return new ProductDetailsPage(driver);
    }

    public ProductsListPage checkInStockCheckBox(){
        inStock_checkbox.click();
        return this;
    }

}
