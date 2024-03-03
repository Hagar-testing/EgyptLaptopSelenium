package com.egyptlaptop.pages;

import com.egyptlaptop.base.BasePage;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static com.egyptlaptop.constants.pages.CartPageConstants.*;

public class CartPage extends BasePage {

    @FindBy(xpath = QUANTITY_INPUT_XPATH)
    WebElement quantity_input;

    @FindBy(css = CHECKOUT_BUTTON_XPATH)
    WebElement checkout_button;
    public CartPage(WebDriver driver) {
        super(driver);
    }

    @Step
    public String getProductQuantityInCart(){
         return elementInteraction.getInputValue(quantity_input,COUNTER_ELEMENT_NAME);
    }

    @Step
    public CheckoutPage clickOnCheckout(){
        elementInteraction.simpleClick(checkout_button,CHECKOUT_BUTTON_ELEMENT_NAME);
        return new CheckoutPage(driver);
    }
}
