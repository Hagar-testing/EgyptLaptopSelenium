package com.egyptlaptop.pages;

import com.egyptlaptop.base.BasePage;
import com.egyptlaptop.enums.LocatorType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static com.egyptlaptop.constants.locators.ProductDetailsLocators.*;

public class ProductDetailsPage extends BasePage {

    @FindBy(xpath = COUNTER_INPUT_XPATH)
    WebElement counter_input;

    @FindBy(xpath = ADD_TO_CART_BUTTON_XPATH)
    WebElement addToCartButton;

    @FindBy(xpath = VIEW_CART_DROPDOWN_BUTTON_XPATH)
    WebElement viewCartDropDown_button;

    @FindBy(className = CART_BUTTON_CLASS)
    WebElement cart_button;
    @FindBy(xpath = CONTINUE_SHOPPING_BUTTON_XPath)
    WebElement continueShipping_btn;


    public ProductDetailsPage(WebDriver driver) {
        super(driver);
    }

    public ProductDetailsPage addProductToCart(String quantity){
        elementInteraction
                .setInputWithJavaScriptExecutor(counter_input, quantity)
                .javascriptClick(addToCartButton)
                .simpleClick(continueShipping_btn);

        return this;

    }
    
    public CartPage navigateToCartPage(){
        elementInteraction
                .javascriptClick(cart_button)
                .javascriptClick(viewCartDropDown_button, LocatorType.WITH_WAIT);
        return new CartPage(driver);
    }
}
