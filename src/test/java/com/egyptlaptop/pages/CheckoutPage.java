package com.egyptlaptop.pages;

import com.egyptlaptop.base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static com.egyptlaptop.constants.locators.CheckoutLocators.*;

public class CheckoutPage extends BasePage {

    @FindBy(className = FIRST_NAME_INPUT_CLASS)
    WebElement firstName_input;

    @FindBy(id = PHONE_INPUT_ID)
    WebElement phone_input;

    @FindBy(name = ACCEPT_TERMS_CHECKBOX_NAME)
    WebElement acceptTerms_checkbox;

    @FindBy(id = ADDRESS_INPUT_ID)
    WebElement address_input;

    @FindBy(id = SUBMIT_BUTTON_ID)
    WebElement submit_button;

    public CheckoutPage(WebDriver driver) {
        super(driver);
    }

    public CheckoutPage setFirstName(String firstName){
        firstName_input.sendKeys(firstName);
        return this;
    }

    public CheckoutPage setPhone(String phone){
        phone_input.sendKeys(phone);
        return this;
    }

    public CheckoutPage setAddress(String address){
        address_input.sendKeys(address);
        return this;
    }
    public CheckoutPage acceptTerms(){
        acceptTerms_checkbox.click();
        return this;
    }

    public CompleteOrderPage clickSubmit(){
        submit_button.click();
        return new CompleteOrderPage(driver);
    }
}
