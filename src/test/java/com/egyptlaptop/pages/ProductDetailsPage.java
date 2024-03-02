package com.egyptlaptop.pages;

import com.egyptlaptop.base.BasePage;
import com.egyptlaptop.enums.LocatorType;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static com.egyptlaptop.constants.ProductDetailsLocators.*;

public class ProductDetailsPage extends BasePage {

    @FindBy(xpath = "//input[contains(@id,'qty_count')]")
    WebElement counter_input;

    @FindBy(xpath = "//bdi[normalize-space()='Add to cart']")
    WebElement addToCartButton;

    @FindBy(xpath = "//a[@class='ty-btn ty-btn__outline' and contains(text(), 'View cart')]")
    WebElement viewCartDropDown_button;

    @FindBy(className = "ut2-icon-use_icon_cart")
    WebElement cart_button;
    @FindBy(xpath = CONTINUE_SHOPPING_BUTTON_XPath)
    WebElement continueShipping_btn;


    public ProductDetailsPage(WebDriver driver) {
        super(driver);
    }

    public ProductDetailsPage setProductCountInCart(String quantity){

        elementInteraction.setInputWithJavaScriptExecutor(counter_input, quantity);
        return this;
    }

    public ProductDetailsPage clickOnAddToCartButton(){
        elementInteraction.javascriptClick(addToCartButton);
        return this;
    }

    public ProductDetailsPage closeDialog(){
        continueShipping_btn.click();
        return this;
    }

    public ProductDetailsPage clickOnCartButton() {
        elementInteraction.javascriptClick(cart_button);
        return this;
    }

    public CartPage navigateToCartPage(){
        elementInteraction.javascriptClick(viewCartDropDown_button, LocatorType.WITH_WAIT);
        return new CartPage(driver);
    }
}
