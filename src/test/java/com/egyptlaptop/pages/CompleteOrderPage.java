package com.egyptlaptop.pages;

import com.egyptlaptop.base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CompleteOrderPage extends BasePage {

    @FindBy(className = "ty-checkout-complete__order-success")
    WebElement placeOrder_text;
    public CompleteOrderPage(WebDriver driver) {
        super(driver);
    }

    public boolean checkIfOrderCreationMsgIsDisplayed(){
        return placeOrder_text.isDisplayed();
    }
}
