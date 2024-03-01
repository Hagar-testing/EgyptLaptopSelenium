package com.egyptlaptop.testcases;

import com.egyptlaptop.base.BaseTest;
import com.egyptlaptop.data.reader.TestDataProviders;
import com.egyptlaptop.pages.MainPage;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.HashMap;

import static com.egyptlaptop.constants.JsonKeysConstants.SEARCH_TEXT;

public class MainTest extends BaseTest {


    @Test(dataProvider = "searchData", dataProviderClass = TestDataProviders.class, description = "Test the successful completion of the search process")
    public void CheckIfSearchFunctionWorksSuccessfully(HashMap<String, String> data) {
        boolean isTestResultTitlesMatchesSearchKey = new MainPage(getDriver())
                .load()
                .sendSearchInput(data.get(SEARCH_TEXT))
                .isSearchResultNotEmpty();
        Assert.assertTrue(isTestResultTitlesMatchesSearchKey);

    }


}
