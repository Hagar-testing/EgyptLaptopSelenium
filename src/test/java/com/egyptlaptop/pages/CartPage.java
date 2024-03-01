package com.egyptlaptop.pages;

import com.egyptlaptop.base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import static com.egyptlaptop.constants.CartLocators.CHECKOUT_BTN;

public class CartPage extends BasePage {

    @FindBy(xpath = "//div[@class=\"ty-center ty-value-changer cm-value-changer\"]//input")
    WebElement quantity_input;

    @FindBy(xpath = "//a[@class=\"ty-btn ty-btn__primary \"]")
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
