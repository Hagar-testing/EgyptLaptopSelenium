package com.egyptlaptop.testcases;

import com.egyptlaptop.base.BaseTest;
import com.egyptlaptop.listeners.RetryAnalyzer;
import com.egyptlaptop.pages.MainPage;
import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.testng.Assert;
import org.testng.annotations.Test;

@Feature("Cart Feature")
public class CartTest extends BaseTest {

    @Story("Add Product to Cart")
    @Description("Verify if the quantity is added correctly to the cart")
    @Test(description = "Test adding a product to the cart and checking the quantity",
            retryAnalyzer = RetryAnalyzer.class)
    public void checkIfQuantityIsAddedCorrectlyToCart() {
        String quantityToBeAdded = String.valueOf(1);
        String text = new MainPage(getDriver())
                .load()
                .clickOnCategory()
                .selectCategory()
                .clickOnProduct()
                .addProductToCart(quantityToBeAdded)
                .navigateToCartPage()
                .getProductQuantityInCart();

        Assert.assertEquals(quantityToBeAdded,text);
    }
}
