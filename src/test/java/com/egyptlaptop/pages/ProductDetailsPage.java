package com.egyptlaptop.pages;

import com.egyptlaptop.base.BasePage;
import com.egyptlaptop.enums.LocatorType;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static com.egyptlaptop.constants.pages.ProductDetailsPageConstants.*;

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

    @Step
    public ProductDetailsPage addProductToCart(String quantity){
        elementInteraction
                .setInputWithJavaScriptExecutor(counter_input, quantity,COUNTER_INPUT_NAME)
                .javascriptClick(addToCartButton, ADD_TO_CART_BUTTON_NAME)
                .simpleClick(continueShipping_btn, CONTINUE_SHIPPING_BUTTON_NAME);

        return this;

    }

    @Step
    public CartPage navigateToCartPage(){
        elementInteraction
                .javascriptClick(cart_button,CART_BUTTON_NAME)
                .javascriptClick(viewCartDropDown_button, LocatorType.WAIT_VISIBILITY,VIEW_CART_DROPDOWN_BUTTON_NAME);
        return new CartPage(driver);
    }
}
