package com.guru99.demo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.TestApp;

import java.time.Duration;

public class HomePage {

    WebDriver driver = TestApp.getInstance().getDriver();

    @FindBy(linkText = "REGISTER")
    private WebElement registerMenuElement;

    public RegisterPage selectRegisterMenu(){
        TestApp.getInstance().waitUntilNextElementAppears(By.linkText("REGISTER"), Duration.ofSeconds(10));
       registerMenuElement.click();
       return PageFactory.initElements(driver, RegisterPage.class);
    }
}
