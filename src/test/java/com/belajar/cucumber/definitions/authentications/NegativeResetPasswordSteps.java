package com.belajar.cucumber.definitions.authentications;

import org.testng.Assert;

import com.belajar.cucumber.definitions.providers.AuthProviders;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class NegativeResetPasswordSteps extends AuthProviders {
    @Given("user sudah berada pada halaman lupa password.")
    public void step01(){
        preTest();
        loginPage().clickLupaPasswordButton();
        Hook.driver = this;
    }

    @When("user memasukkan email {string} pada field email.")
    public void step02(String email){
        lupaPasswordPage().setEmail(email);
    }

    @And("user menekan tombol submit setelah memasukkan email.")
    public void step03(){
        lupaPasswordPage().clickSubmit();
    }

    @Then("user melihat pesan validasi {string}.")
    public void step04(String validationMessage){
        Assert.assertEquals(lupaPasswordPage().getValidationMessage(), validationMessage);
    }
}
