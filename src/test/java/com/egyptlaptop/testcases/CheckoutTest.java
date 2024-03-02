package com.egyptlaptop.testcases;

import com.egyptlaptop.base.BaseTest;
import com.egyptlaptop.data.reader.TestDataProviders;
import com.egyptlaptop.pages.MainPage;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.HashMap;

import static com.egyptlaptop.constants.JsonKeysConstants.*;

public class CheckoutTest extends BaseTest {
    @Test(dataProvider = "orderData", dataProviderClass = TestDataProviders.class)
    public void checkIfCheckoutWorks(HashMap<String, String> data) {
         new MainPage(getDriver())
                .load()
                .clickOnCategory()
                .selectCategory()
                .clickOnProduct()
                .setProductCountInCart(String.valueOf(1))
                .clickOnAddToCartButton()
                .closeDialog()
                .clickOnCartButton()
                .navigateToCartPage()
                .clickOnCheckout()
                 .fillCheckoutData(data.get(NAME),data.get(PHONE),data.get(ADDRESS));

                //.checkIfOrderCreationMsgIsDisplayed();

       // Assert.assertTrue(isSuccessMsgDisplayed);

    }


}
