package com.egyptlaptop.testcases;

import com.egyptlaptop.base.BaseTest;
import com.egyptlaptop.pages.MainPage;
import org.testng.annotations.Test;

public class CartTest extends BaseTest {


    @Test
    public void clickOnFirstCategory() {
        new MainPage(getDriver())
                .load()
                .clickOnCategory()
                .selectCategory()
               // .checkInStockCheckBox()
                .clickOnProduct()
                .setProductCountInCart()
                .clickOnAddToCartButton()
                .closeDialog()
                .clickOnCartButton()
                .navigateToCartPage();
    }
}
