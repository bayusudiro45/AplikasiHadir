package com.belajar.cucumber.definitions.cuti;

import com.belajar.cucumber.definitions.authentications.Hook;
import com.belajar.cucumber.definitions.providers.AuthProviders;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

public class CutiDisplayInfoSteps extends AuthProviders {
    @Given("user saat berada di halaman dashborad.")
    public void step01() {
        preConditionLogin();
        Hook.driver = this;
    }

    @When("lalu user menakan tab cuti.")
    public void step02() {
        dashboardPage().clickCutiButton();
    }

    @And("lalu user click button Ajukan Cuti.")
    public void step03() throws InterruptedException {
        cutiPage().clickAjukanCuti();
    }

    @Then("user click Info Cuti, untuk melihat total cuti.")
    public void step04() throws InterruptedException {
        cutiPage().clickInfoCuti();
        Assert.assertTrue(cutiPage().isListDataCutiDisplayed());
        Thread.sleep(2000);
    }
}
