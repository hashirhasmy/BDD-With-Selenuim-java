package com.guru99.demo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utils.TestApp;

import java.time.Duration;

public class RegisterSuccessPage {

    WebDriver driver = TestApp.getInstance().getDriver();

    @FindBy(xpath = "//*[contains(text(),'Dear')]")
    private  WebElement successTextElemnt;

    public WebElement successText(){
        TestApp.getInstance().waitUntilNextElementAppears(By.xpath("//*[contains(text(),'Dear')]"), Duration.ofSeconds(10));
        return successTextElemnt;
    }



}
