package com.egyptlaptop.utils;

import com.egyptlaptop.enums.LocatorType;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import static com.egyptlaptop.enums.LocatorType.LOCATE_ONLY;


public class ElementInteraction {
    private final WebDriver driver;
    private final WaitUtils waitUtils;
    private final JavascriptExecutorUtils javascriptExecutorUtils;
    public ElementInteraction(WebDriver driver) {
        this.driver = driver;
        this.waitUtils = new WaitUtils(driver);
        this.javascriptExecutorUtils = new JavascriptExecutorUtils(driver);

    }

    // Generic method to handle element visibility based on locator type
    public WebElement locateElement(WebElement element, LocatorType type) {
        switch (type) {
            case LOCATE_ONLY -> {
                return element;
            }
            case WAIT_VISIBILITY -> {
                return waitUtils.waitForVisibilityOfElement(element);
            }
            case WAIT_CLICKABLE ->{
                return waitUtils.waitForElementToBeClickable(element);
            }
            default -> throw new IllegalArgumentException("Invalid locator type");
        }
    }


    // Method to perform a simple click with element visibility wait
    public ElementInteraction simpleClick(WebElement element, LocatorType type,String elementName) {
        logElementActionStep("Simple click on", elementName);
        locateElement(element,type).click();
        return this;
    }

    // Overloaded method with default value for LocatorType
    public ElementInteraction simpleClick(WebElement element,String elementName) {
        return simpleClick(element, LOCATE_ONLY,elementName);
    }

    // Method to perform a click with hover and element visibility wait
    public ElementInteraction clickWithHover(WebElement element, LocatorType type) {
        Actions actions = new Actions(driver);
        actions.moveToElement(locateElement(element, type)).perform();
        element.click();
        return this;
    }

    // Method to perform a click using JavaScript and element visibility wait
    public ElementInteraction javascriptClick(WebElement element, LocatorType type,String elementName) {
        WebElement element1 = locateElement(element, type);
        logElementActionStep("javascript click on",elementName);
        javascriptExecutorUtils.executeJavaScriptClick(element1);

        return this;
    }

    public ElementInteraction javascriptClick(WebElement element,String elementName){
        return javascriptClick(element, LOCATE_ONLY,elementName);
    }


    public ElementInteraction setInput(WebElement element, String text, LocatorType type,String elementName){
        logElementActionStep("set input [ " + text + " ] to ",elementName);
        WebElement locatedElement = locateElement(element,type);
        javascriptExecutorUtils.clearInput(locatedElement);
        locatedElement.sendKeys(text);

        return this;
    }

    public ElementInteraction setInput(WebElement element, String text,String elementName){
        return setInput(element,text, LOCATE_ONLY,elementName);
    }


    // Method to set input text using JavaScriptExecutor
    public ElementInteraction setInputWithJavaScriptExecutor(WebElement element, String text, LocatorType type,String elementName) {
        logElementActionStep("set input [ " + text + "] with java script executor to ",elementName);
        WebElement locatedElement = locateElement(element,type);
        javascriptExecutorUtils.clearInput(locatedElement);
        javascriptExecutorUtils.sendInput(locatedElement, text);
        return this;
    }

    public ElementInteraction setInputWithJavaScriptExecutor(WebElement element, String text,String elementName) {
        return setInputWithJavaScriptExecutor(element,text, LOCATE_ONLY,elementName);
    }

    // Method to simulate Backspace key press using sendKeys
    public ElementInteraction simulateBackspace(WebElement element, LocatorType type,String elementName) {
        locateElement(element,type).sendKeys(Keys.BACK_SPACE);
        logElementActionStep("Click on back space",elementName);

        return this;
    }

    public ElementInteraction simulateBackspace(WebElement element,String elementName) {
        return simulateBackspace(element, LOCATE_ONLY,elementName);
    }

    public ElementListInteraction withList() {
        return new ElementListInteraction(driver);
    }

    public String  getInputValue(WebElement element, String elementName){
        logElementActionStep("get input value from ",elementName);
        return element.getAttribute("value");
    }
    private static void logElementActionStep(String action, String elementName) {
        Logger.logStep("[Element Interaction] " + action + " [" + elementName + "] element");
    }

}
