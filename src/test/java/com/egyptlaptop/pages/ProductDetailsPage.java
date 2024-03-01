package com.egyptlaptop.pages;

import com.egyptlaptop.base.BasePage;
import com.egyptlaptop.enums.LocatorType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static com.egyptlaptop.constants.ProductDetailsLocators.*;

public class ProductDetailsPage extends BasePage {
    @FindBy(id = COUNTER_INPUT_ID)
    WebElement counter_input;

    @FindBy(id = ADD_TO_CART_BUTTON_ID)
    WebElement addToCartButton;

    @FindBy(linkText = VIEW_CART_BUTTON_LINK_TEXT)
    WebElement viewCartDropDown_button;

    @FindBy(id = CART_BUTTON_ID)
    WebElement cart_button;
    @FindBy(xpath = CONTINUE_SHOPPING_BUTTON_XPath)
    WebElement continueShipping_btn;
    public ProductDetailsPage(WebDriver driver) {
        super(driver);
    }

    public ProductDetailsPage setProductCountInCart(){
        elementInteraction.setInput(counter_input,"1");
        return this;
    }

    public ProductDetailsPage clickOnAddToCartButton(){
        addToCartButton.click();
        return this;
    }

    public ProductDetailsPage closeDialog(){
        continueShipping_btn.click();
        return this;
    }

    public ProductDetailsPage clickOnCartButton() {
        cart_button.click();
        return this;
    }

    public CartPage navigateToCartPage(){
        elementInteraction.simpleClick(viewCartDropDown_button, LocatorType.WITH_WAIT);
        return new CartPage(driver);
    }
}
