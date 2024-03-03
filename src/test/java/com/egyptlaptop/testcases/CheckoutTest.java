package com.egyptlaptop.testcases;

import com.egyptlaptop.base.BaseTest;
import com.egyptlaptop.data.reader.TestDataProviders;
import com.egyptlaptop.listeners.RetryAnalyzer;
import com.egyptlaptop.pages.MainPage;
import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.HashMap;

import static com.egyptlaptop.constants.JsonKeysConstants.*;

@Feature("Checkout Feature")
public class CheckoutTest extends BaseTest {

    @Story("Checkout Process")
    @Description("Verify if the checkout process works correctly")
    @Test(dataProvider = "orderData", dataProviderClass = TestDataProviders.class,
            description = "Verify if the checkout process works correctly",
            retryAnalyzer = RetryAnalyzer.class)
    public void checkIfCheckoutWorks(HashMap<String, String> data) {
        new MainPage(getDriver())
                .load()
                .clickOnCategory()
                .selectCategory()
                .checkInStockCheckBox()
                .clickOnProduct()
                .addProductToCart(String.valueOf(1))
                .navigateToCartPage()
                .clickOnCheckout()
                .fillCheckoutData(data.get(NAME),data.get(PHONE),data.get(ADDRESS));

        //.checkIfOrderCreationMsgIsDisplayed();

        // Assert.assertTrue(isSuccessMsgDisplayed);

    }
}

