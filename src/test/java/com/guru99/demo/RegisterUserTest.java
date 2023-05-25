package com.guru99.demo;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utils.TestApp;

public class RegisterUserTest {

    HomePage homePage;
    RegisterPage registerPage;
    RegisterSuccessPage registerSuccessPage;


    @BeforeMethod
    public void setUp() {
        TestApp.getInstance().openBrowser();
        TestApp.getInstance().navigateToURL();
        homePage = PageFactory.initElements(TestApp.getInstance().getDriver(),HomePage.class);
        registerPage = homePage.selectRegisterMenu();
    }

    @Test
    public void testName(){

        String firstName = "Mohamed";
        String lastName = "Harsan";

        registerSuccessPage = registerPage
                .setFirstName(firstName)
                .setLastName(lastName)
                .setPhoneNumber("0772221030")
                .setEmail("hasmy@gmail.com")
                .selectCountry()
                .setUserName("Hasmy")
                .setPassword("12345")
                .setConfirmPassword("12345")
                .submit();
        Assert.assertEquals(registerSuccessPage.successText().getText(),"Dear"+ " " + firstName+ " " + lastName + ",","Error Reason");
    }


    @AfterMethod
    public void tearRegisterNewUser() {
        TestApp.getInstance().closeBrowser();
    }
}
