package com.egyptlaptop.pages;

import com.egyptlaptop.base.BasePage;
import com.egyptlaptop.utils.ConfigUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CheckoutPage extends BasePage {

    @FindBy(className = "first-name")
    WebElement firstName_input;

    @FindBy(id = "litecheckout_phone")
    WebElement phone_input;

    @FindBy(name = "accept_terms")
    WebElement acceptTerms_checkbox;

    @FindBy(id = "litecheckout_s_address")
    WebElement address_input;

    @FindBy(id = "litecheckout_place_order")
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

    public CheckoutPage clickSubmit(){
        submit_button.click();
        return this;
    }
}
