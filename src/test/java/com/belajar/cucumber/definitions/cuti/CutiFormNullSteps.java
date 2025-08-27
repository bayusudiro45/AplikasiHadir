package com.belajar.cucumber.definitions.cuti;

import com.belajar.cucumber.definitions.authentications.Hook;
import com.belajar.cucumber.definitions.providers.AuthProviders;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

public class CutiFormNullSteps extends AuthProviders {
    @Given("pengguna saat ini membuka halaman dashboard.")
    public void step01() {
        preConditionLogin();
        Hook.driver = this;
    }

    @When("selanjutnya pengguna memilih tab cuti.")
    public void step02() {
        dashboardPage().clickCutiButton();
    }

    @And("pengguna clik button Ajukan cuti.")
    public void step03() {
        cutiPage().clickAjukanCuti();
    }

    @Then("pengguna click button Ajukan,dan pengguna melihat message error.")
    public void step04() throws InterruptedException {
        cutiPage().clickAjukan();
        Assert.assertTrue(cutiPage().isErrorMessageDisplayed());
        Assert.assertTrue(cutiPage().isNotificationDisplayed());
        cutiPage().closeNotification();
    }
}
