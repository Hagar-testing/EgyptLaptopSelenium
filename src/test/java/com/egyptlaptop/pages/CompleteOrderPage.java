package com.egyptlaptop.pages;

import com.egyptlaptop.base.BasePage;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static com.egyptlaptop.constants.locators.CompleteOrderLocators.PLACE_ORDER_TEXT_CLASS;

public class CompleteOrderPage extends BasePage {

    @FindBy(className = PLACE_ORDER_TEXT_CLASS)
    WebElement placeOrder_text;
    public CompleteOrderPage(WebDriver driver) {
        super(driver);
    }

    @Step
    public boolean checkIfOrderCreationMsgIsDisplayed(){
        return placeOrder_text.isDisplayed();
    }
}
