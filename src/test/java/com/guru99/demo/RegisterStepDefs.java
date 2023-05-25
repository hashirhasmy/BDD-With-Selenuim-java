package com.guru99.demo;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import utils.TestApp;

public class RegisterStepDefs {

    HomePage homePage;
    RegisterPage registerPage;
    RegisterSuccessPage registerSuccessPage;
    @Given("User is on Mercury Home Page --> Register Page")
    public void userIsOnMercuryHomePageRegisterPage() {
        TestApp.getInstance().openBrowser();
        TestApp.getInstance().navigateToURL();
        homePage = PageFactory.initElements(TestApp.getInstance().getDriver(),HomePage.class);
        registerPage = homePage.selectRegisterMenu();
    }

    @Given("user enter first name as {string}")
    public void setFirstName(String firstName) {
        registerPage.setFirstName(firstName);
    }

    @And("user enter last name as {string}")
    public void setLastName(String lastName) {
        registerPage.setLastName(lastName);
    }

    @And("user enter phone number as {string}")
    public void userEnterPhoneNumberAs(String phoneNumber) {
        registerPage.setPhoneNumber(phoneNumber);
    }

    @And("user enter email as {string}")
    public void userEnterEmailAs(String email) {
        registerPage.setEmail(email);
    }

    @And("user enter user name {string}")
    public void userEnterUserName(String userName) {
        registerPage.setUserName(userName);
    }

    @And("user enter pass as {string}")
    public void userEnterPassAs(String pass) {
        registerPage.setPassword(pass);
    }

    @And("user enter confirm pass as {string}")
    public void userEnterConfirmPassAs(String conPass) {
        registerPage.setConfirmPassword(conPass);
    }

    @When("user submit")
    public void userSubmit() {
        registerSuccessPage = registerPage.submit();
    }

    @Then("Salutation message will display as {string}")
    public void salutationMessageWillDisplayAs(String expected) {
//        try{
//            Assert.assertEquals(registerSuccessPage.successText().getText(),expected,"Error Reason");
//        }catch (Exception e){
//            System.out.println("take scrrenshot");
//            TestApp.getInstance().takeScreenshot();
//        }
//        if (registerSuccessPage.successText().getText().equals(expected)){
//            System.out.println("pass");
//        } else{
//            System.out.println("take scrrenshot");
//            TestApp.getInstance().takeScreenshot();
//        }
        Assert.assertEquals(registerSuccessPage.successText().getText(),expected,"Error Reason");
    }
}
