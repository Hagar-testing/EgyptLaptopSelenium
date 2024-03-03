package com.egyptlaptop.testcases;

import com.egyptlaptop.base.BaseTest;
import com.egyptlaptop.data.reader.TestDataProviders;
import com.egyptlaptop.pages.MainPage;
import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.util.HashMap;
import static com.egyptlaptop.constants.JsonKeysConstants.SEARCH_TEXT;

@Feature("Main Page Feature")
public class MainTest extends BaseTest {

    @Story("Search Functionality")
    @Description("Verify if the search function works successfully")
    @Test(dataProvider = "searchData", dataProviderClass = TestDataProviders.class,
            description = "Test if the search process works successfully")
    public void CheckIfSearchFunctionWorksSuccessfully(HashMap<String, String> data) {
        boolean isTestResultTitlesMatchesSearchKey = new MainPage(getDriver())
                .load()
                .sendSearchInput(data.get(SEARCH_TEXT))
                .isSearchResultNotEmpty();
        Assert.assertTrue(isTestResultTitlesMatchesSearchKey);
    }


}
