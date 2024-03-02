package com.egyptlaptop.pages;

import com.egyptlaptop.base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static com.egyptlaptop.constants.locators.CartLocators.CHECKOUT_BUTTON_XPATH;
import static com.egyptlaptop.constants.locators.CartLocators.QUANTITY_INPUT_XPATH;

public class CartPage extends BasePage {

    @FindBy(xpath = QUANTITY_INPUT_XPATH)
    WebElement quantity_input;

    @FindBy(xpath = CHECKOUT_BUTTON_XPATH)
    WebElement checkout_button;
    public CartPage(WebDriver driver) {
        super(driver);
    }

    public String getProductQuantityInCart(){
         return quantity_input.getAttribute("value");
    }

    public CheckoutPage clickOnCheckout(){
        elementInteraction.javascriptClick(checkout_button);
        return new CheckoutPage(driver);
    }
}
