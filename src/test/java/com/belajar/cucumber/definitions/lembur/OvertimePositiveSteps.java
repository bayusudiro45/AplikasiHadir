package com.belajar.cucumber.definitions.lembur;

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

public class OvertimePositiveSteps extends AuthProviders {

    @Given("user berada pada halaman dashboard.")
    public void step01() {
        preTest();
        preConditionLogin();
        Hook.driver = this;
    }

    @When("user menekan tab lembur.")
    public void step02() {
        zoomOut();
        dashboardPage().clickLemburButton();
    }

    @Then("user akan di bawa ke halaman lembur dengan url {string} untuk memeriksa hasil test.")
    public void step03(String url) {
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(20));
        wait.until(ExpectedConditions.urlContains(url));
        DashboardPage dashboardPage = new DashboardPage(getDriver());
        Assert.assertEquals(dashboardPage.getCurrentURL(), url);
    }

}