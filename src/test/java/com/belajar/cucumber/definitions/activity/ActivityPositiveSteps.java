package com.belajar.cucumber.definitions.activity;

import com.belajar.cucumber.definitions.authentications.Hook;
import com.belajar.cucumber.definitions.providers.AuthProviders;
import com.belajar.cucumber.pages.DashboardPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class ActivityPositiveSteps extends AuthProviders {

    @Given("user di bawa kehalaman dashbord.")
    public void step01() {
        preTest();
        preConditionLogin();
        Hook.driver = this;
    }

    @When("user clik tab Absensi.")
    public void step02() {
        dashboardPage().clickAbsenButton();
    }

    @Then("user akan di bawa ke halaman History Absensi dengan url {string} untuk memeriksa hasil test.")
    public void step03(String url) {
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(20));
        wait.until(ExpectedConditions.urlContains(url));
        DashboardPage dashboardPage = new DashboardPage(getDriver());
        Assert.assertEquals(dashboardPage.getCurrentURL(), url);
    }

}