package com.egyptlaptop.testcases;

import com.egyptlaptop.base.BaseTest;
import com.egyptlaptop.pages.MainPage;
import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.testng.Assert;
import org.testng.annotations.Test;

@Feature("Products List Feature")
public class ProductsListTest extends BaseTest {

    @Story("Category Selection")
    @Description("Verify if user navigates to the correct category from home")
    @Test(description = "Verify if user navigates to the correct category from home")
    public void checkIfUserNavigatesToCorrectCategory(){
        MainPage mainPage = new MainPage(getDriver());
        String actualCategory = new MainPage(getDriver())
                .load()
                .selectCategoryFromDropdownList()
                .getFirstSubCategoryText();
        
        String expectedCategory = mainPage.selectSubCategory().getCategoryText();

        Assert.assertEquals(actualCategory,expectedCategory);

    }

}
