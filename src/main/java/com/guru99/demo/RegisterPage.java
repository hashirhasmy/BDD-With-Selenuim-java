package com.guru99.demo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import utils.TestApp;

import java.time.Duration;

public class RegisterPage {

    WebDriver driver = TestApp.getInstance().getDriver();

    @FindBy(name = "firstName")
    private WebElement firstNameElement;

    @FindBy(name = "lastName")
    private WebElement lastNameElement;

    @FindBy(name = "phone")
    private WebElement phoneElement;

    @FindBy(name = "userName")
    private WebElement emailElement;

    @FindBy(name = "country")
    private  WebElement countryElement;

    @FindBy(name = "email")
    private WebElement usernameElemnt;

    @FindBy(name = "password")
    private WebElement passwordElemnt;

    @FindBy(name = "confirmPassword")
    private WebElement confirmPasswordElement;

    @FindBy(name = "submit")
    private WebElement submitElement;

    public RegisterPage setFirstName(String firstName){
        TestApp.getInstance().waitUntilNextElementAppears(By.name("firstName"), Duration.ofSeconds(10));
        firstNameElement.sendKeys(firstName);
        return this;
    }

    public RegisterPage setLastName(String lastName){
        TestApp.getInstance().waitUntilNextElementAppears(By.name("firstName"), Duration.ofSeconds(10));
        lastNameElement.sendKeys(lastName);
        return this;
    }

    public RegisterPage setPhoneNumber(String phoneNumber){
        TestApp.getInstance().waitUntilNextElementAppears(By.name("phone"), Duration.ofSeconds(10));
        phoneElement.sendKeys(phoneNumber);
        return this;
    }

    public RegisterPage setEmail(String email){
        TestApp.getInstance().waitUntilNextElementAppears(By.name("userName"), Duration.ofSeconds(10));
        emailElement.sendKeys(email);
        return this;
    }

    public RegisterPage selectCountry(){
        TestApp.getInstance().waitUntilNextElementAppears(By.name("country"), Duration.ofSeconds(10));
        Select dropdownCountry = new Select(countryElement);
        dropdownCountry.selectByIndex(2);
        return this;
    }

    public RegisterPage setUserName(String userName){
        TestApp.getInstance().waitUntilNextElementAppears(By.name("email"), Duration.ofSeconds(10));
        usernameElemnt.sendKeys(userName);
        return this;
    }

    public RegisterPage setPassword(String password){
        TestApp.getInstance().waitUntilNextElementAppears(By.name("password"), Duration.ofSeconds(10));
        passwordElemnt.sendKeys(password);
        return this;
    }

    public RegisterPage setConfirmPassword(String confirmPassword){
        TestApp.getInstance().waitUntilNextElementAppears(By.name("confirmPassword"), Duration.ofSeconds(10));
        confirmPasswordElement.sendKeys(confirmPassword);
        return this;
    }

    public RegisterSuccessPage submit(){
        TestApp.getInstance().waitUntilNextElementAppears(By.name("submit"), Duration.ofSeconds(10));
        submitElement.click();
        return PageFactory.initElements(driver, RegisterSuccessPage.class);
    }











}
