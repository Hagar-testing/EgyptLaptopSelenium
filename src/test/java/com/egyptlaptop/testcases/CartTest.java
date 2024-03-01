package com.egyptlaptop.testcases;

import com.egyptlaptop.base.BaseTest;
import com.egyptlaptop.pages.MainPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CartTest extends BaseTest {


    @Test
    public void checkIfQuantityIsAddedCorrectlyToCart() {
        String quantityToBeAdded = String.valueOf(1);
        String text = new MainPage(getDriver())
                .load()
                .clickOnCategory()
                .selectCategory()
                // .checkInStockCheckBox()
                .clickOnProduct()
                .setProductCountInCart(quantityToBeAdded)
                .clickOnAddToCartButton()
                .closeDialog()
                .clickOnCartButton()
                .navigateToCartPage()
                .getProductQuantityInCart();

        Assert.assertEquals(quantityToBeAdded,text);
    }
}
