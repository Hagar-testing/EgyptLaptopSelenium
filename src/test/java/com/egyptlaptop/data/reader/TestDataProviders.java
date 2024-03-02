package com.egyptlaptop.data.reader;

import org.testng.annotations.DataProvider;

import java.io.IOException;

import static com.egyptlaptop.constants.DataFilesPathConstants.ORDER_DATA_FILE_PATH;
import static com.egyptlaptop.constants.DataFilesPathConstants.SEARCH_DATA_FILE_PATH;

public class TestDataProviders {

    DataReader reader;

    public TestDataProviders(){
        reader = new DataReader();
    }

    @DataProvider(name = "searchData")
    public Object[][] searchData() throws IOException {
        return reader.readAndProvideJsonData(SEARCH_DATA_FILE_PATH);
    }

    @DataProvider(name = "orderData")
    public Object[][] orderData() throws IOException {
        return reader.readAndProvideJsonData(ORDER_DATA_FILE_PATH);
    }

}
