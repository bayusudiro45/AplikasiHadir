package com.belajar.cucumber.definitions.authentications;

import java.time.Duration;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.belajar.cucumber.definitions.providers.AuthProviders;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class NavigationToLupaPasswordSteps extends AuthProviders {
    @Given("user berada pada halaman login untuk uji link menuju halaman lupa password.")
    public void step01(){
        preTest();
        Hook.driver = this;
    }

    @When("user menekan teks 'Lupa password' pada halaman login.")
    public void step02(){
        loginPage().clickLupaPasswordButton();
    }

    @Then("user akan dibawa ke halaman lupa password dengan url {string}.")
    public void step03(String url){
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(20));
        wait.until(ExpectedConditions.urlContains(url));
        Assert.assertEquals(lupaPasswordPage().getCurrentURL(),url);
    }
}
