package com.belajar.cucumber.definitions.authentications;

import java.time.Duration;

import com.belajar.cucumber.pages.DashboardPage;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.belajar.cucumber.definitions.providers.AuthProviders;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class PositiveSignInSteps extends AuthProviders {

    @Given("saat menguji test positive, pengguna masuk ke halaman login.")
    public void step01() {
        preTest();
        Hook.driver = this; //Assign instance ke hook
    }

    @When("pengguna melakukan login dengan username {string} dan password {string} yang valid.")
    public void step02(String username, String password) {
        loginPage().performLogin(username, password);
    }

    @Then("pengguna akan di bawa ke halaman inventory dengan url {string} untuk memeriksa hasil test.")
    public void step03(String url) {
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(20));
        wait.until(ExpectedConditions.urlContains(url));
        DashboardPage dashboardPage = new DashboardPage(getDriver());
        Assert.assertEquals(dashboardPage.getCurrentURL(), url);
    }

}
