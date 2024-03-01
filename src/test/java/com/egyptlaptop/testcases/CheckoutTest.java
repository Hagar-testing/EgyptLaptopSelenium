package com.egyptlaptop.testcases;

import com.egyptlaptop.base.BaseTest;
import com.egyptlaptop.pages.MainPage;
import org.testng.annotations.Test;

public class CheckoutTest extends BaseTest {


    @Test
    public void checkIfCheckoutWorks() {
        new MainPage(getDriver())
                .load()
                .clickOnCategory()
                .selectCategory()
                // .checkInStockCheckBox()
                .clickOnProduct()
                .setProductCountInCart("1")
                .clickOnAddToCartButton()
                .closeDialog()
                .clickOnCartButton()
                .navigateToCartPage()
                .clickOnCheckout()
                .setFirstName("Hger")
                .setPhone("0100000000")
                .setAddress("addresss")
                .acceptTerms().clickSubmit();

    }


}
