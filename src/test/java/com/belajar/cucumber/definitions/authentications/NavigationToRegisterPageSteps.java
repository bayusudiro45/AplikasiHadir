package com.belajar.cucumber.definitions.authentications;

import java.time.Duration;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.belajar.cucumber.definitions.providers.AuthProviders;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class NavigationToRegisterPageSteps extends AuthProviders {
    @Given("user berada pada halaman login.")
    public void step01(){
        preTest();
        Hook.driver = this;
    }

    @When("user menekan teks 'disini' pada halaman login.")
    public void step02(){
        loginPage().clickRegisterPageButton();
    }

    @Then("user akan dibawa ke halaman registrasi dengan url {string}.")
    public void step03(String url){
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(20));
        wait.until(ExpectedConditions.urlContains(url));
        Assert.assertEquals(registerPage().getCurrentURL(), url);
    }
}
