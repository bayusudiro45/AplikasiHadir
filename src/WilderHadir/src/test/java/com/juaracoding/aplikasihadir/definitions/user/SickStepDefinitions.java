package com.juaracoding.aplikasihadir.definitions.user;

import com.juaracoding.aplikasihadir.page.DashboardPage;
import com.juaracoding.aplikasihadir.page.SickPage;
import com.juaracoding.aplikasihadir.utils.DriverManager;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

// [PENAMBAHAN] File step definitions untuk fitur Sakit
public class SickStepDefinitions {

    private final WebDriver driver;
    private final DashboardPage dashboardPage;
    private final SickPage sickPage;

    public SickStepDefinitions() {
        this.driver = DriverManager.getDriver();
        this.dashboardPage = new DashboardPage(driver);
        this.sickPage = new SickPage(driver);
    }

    @When("user klik menu Sakit dari dashboard")
    public void step01() {
        dashboardPage.clickMenuSakit();
    }

    @Then("halaman sakit berhasil dimuat")
    public void step02() {
        Assert.assertTrue(sickPage.isPageLoaded());
    }

    @Then("list request sakit ditampilkan")
    public void step03() {
        Assert.assertTrue(sickPage.isListSickDisplayed());
        Assert.assertTrue(sickPage.getSickCardCount() > 0);
    }

    @Then("tombol Ajukan Sakit ditampilkan")
    public void step04() {
        Assert.assertTrue(sickPage.isAjukanSakitButtonDisplayed());
    }

    @Then("cetak data list request sakit")
    public void step05() {
        sickPage.printListData();
    }

    @When("pengguna klik menu Sakit dari dashboard")
    public void step08() {
        dashboardPage.clickMenuSakit();
    }
    @When("user klik tombol Kembali di halaman sakit")
    public void step06() {
        sickPage.clickKembali();
    }

    @Then("user diarahkan kembali ke dashboard")
    public void step07() {
        Assert.assertTrue(dashboardPage.isAt());
    }
}