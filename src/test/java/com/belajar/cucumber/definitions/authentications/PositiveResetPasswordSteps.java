package com.belajar.cucumber.definitions.authentications;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.belajar.cucumber.definitions.providers.AuthProviders;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class PositiveResetPasswordSteps extends AuthProviders{
    @Given("user berada pada halaman lupa password.")
    public void step01(){
        preTest();
        loginPage().clickLupaPasswordButton();
        Hook.driver = this;
    }

    @When("user memasukkan email {string} yang terdaftar pada sistem.")
    public void step02(String email){
        lupaPasswordPage().setEmail(email);
    }

    @And("user menekan tombol submit.")
    public void step03(){
        lupaPasswordPage().clickSubmit();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.urlContains("reset-password?email=hadirsqa1%40gmail.com&message=success"));
        }

    @Then("Then user melihat pesan validasi {string} dan diarahkan ke halaman url {string}.")
    public void step04(String message, String url){
        Assert.assertEquals(lupaPasswordPage().getValidationMessage(), message);
        // Assert.assertEquals(lupaPasswordPage().getCurrentURL(), url);
    }
}
