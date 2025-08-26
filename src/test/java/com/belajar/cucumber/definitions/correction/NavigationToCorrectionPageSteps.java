package com.belajar.cucumber.definitions.correction;

import org.testng.Assert;

import com.belajar.cucumber.definitions.authentications.Hook;
import com.belajar.cucumber.definitions.providers.AuthProviders;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class NavigationToCorrectionPageSteps extends AuthProviders{
    @Given("user berada pada halaman dashboard sebelum ke halaman koreksi absen.")
    public void step01(){
        preConditionLogin();
        Hook.driver = this;
    }

    @When("user menekan icon koreksi absen.")
    public void step02(){
        dashboardPage().clikKoreksiIcon();
    }

    @Then("user dibawa ke halaman koreksi dengan url {string}.")
    public void step03(String url){
        Assert.assertEquals(koreksiAbsenPage().getCurrentURL(), url);
    }
}
