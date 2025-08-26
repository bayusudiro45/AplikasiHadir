package com.belajar.cucumber.definitions.authentications;

import org.testng.Assert;
import com.belajar.cucumber.definitions.providers.AuthProviders;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LogoutSteps extends AuthProviders{
    @Given("user sudah berada pada halaman dashboard.")
    public void step01(){
        preConditionLogin();
        Hook.driver = this;
    }

    @When("user menekan burger line pada ujung kanan atas.")
    public void step02(){
        dashboardPage().clickBurgerButton();
    }

    @And("user menekan tombol 'Logout'.")
        public void step03(){
    dashboardPage().clickLogoutButton();
    }

    @Then("user berhasil keluar dari aplikasi dan kembali ke halaman login dengan url {string}.")
    public void step04(String url){
        Assert.assertEquals(dashboardPage().getCurrentURL(), url);
    }
}
