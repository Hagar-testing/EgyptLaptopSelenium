package com.egyptlaptop.pages;

import com.egyptlaptop.base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CartPage extends BasePage {


    @FindBy(xpath = "//div[@class=\"ty-center ty-value-changer cm-value-changer\"]//input")
    WebElement quantity_input;
    public CartPage(WebDriver driver) {
        super(driver);
    }

    public String getProductQuantityInCart(){
         return quantity_input.getAttribute("value");

    }
}
