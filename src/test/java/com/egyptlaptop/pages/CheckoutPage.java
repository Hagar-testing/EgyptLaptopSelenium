package com.egyptlaptop.pages;

import com.egyptlaptop.base.BasePage;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static com.egyptlaptop.constants.pages.CheckoutPageConstants.*;

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


    @Step
    public CompleteOrderPage fillCheckoutData(String firstName, String phone, String address) {
        elementInteraction.setInput(firstName_input, firstName, FIRST_NAME_INPUT_ELEMENT_NAME)
                .setInput(phone_input, phone, PHONE_INPUT_ELEMENT_NAME)
                .setInput(address_input, address, ADDRESS_INPUT_ELEMENT_NAME)
                .simpleClick(acceptTerms_checkbox, ACCEPT_TERMS_CHECKBOX_ELEMENT_NAME)
                .simpleClick(submit_button,SUBMIT_BUTTON_ELEMENT_NAME);

        return new CompleteOrderPage(driver);
    }

}
