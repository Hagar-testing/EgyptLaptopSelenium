package com.egyptlaptop.pages;

import com.egyptlaptop.base.BasePage;
import com.egyptlaptop.utils.ElementInteraction;
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


    public CompleteOrderPage fillCheckoutData(String firstName,String phone,String address){
        elementInteraction.setInput(firstName_input, firstName)
                .setInput(phone_input,phone)
                .setInput(address_input,address)
                .simpleClick(acceptTerms_checkbox)
                .simpleClick(submit_button);

        return new CompleteOrderPage(driver);
    }

}
