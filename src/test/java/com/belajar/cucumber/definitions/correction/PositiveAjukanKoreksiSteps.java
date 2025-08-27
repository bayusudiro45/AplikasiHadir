package com.belajar.cucumber.definitions.correction;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.belajar.cucumber.definitions.authentications.Hook;
import com.belajar.cucumber.definitions.providers.AuthProviders;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class PositiveAjukanKoreksiSteps extends AuthProviders{
    private Integer totalAwal;
    @Given("user berada pada halaman koreksi absen untuk ajukan koreksi.")
    public void step01(){
        preConAjukanKoreksi();
        Hook.driver = this;
    }

    @When("user menekan tombol ajukan koreksi.")
    public void step02(){
        totalAwal = koreksiAbsenPage().getTotal();
        driver.navigate().refresh();
        koreksiAbsenPage().clickAjukanKoreksiButton();
    }

    @And("user menekan tombol jam masuk dan memasukkan data pada jam {int} menit {int} tanggal {string} bulan {string} tahun {string}.")
    public void step03(Integer hour, Integer minute, String date, String  month, String year) throws InterruptedException{
        koreksiAbsenPage().clickJamMasukButton();
        dragnDrop().pilihTanggalJam(year,month,date,hour,minute);
        Thread.sleep(1000);
    }

    @And("user menekan tombol jam keluar dan memasukkan data pada jam {int} menit {int} tanggal {string} bulan {string} tahun {string}.")
    public void step04(Integer hour, Integer minute, String date, String  month, String year) throws InterruptedException{
        koreksiAbsenPage().clickJamKeluarButton();
        dragnDrop().pilihTanggalJam(year, month, date, hour, minute);
    }

    @And("user memilih tipe Absen {string}.")
    public void step05(String dataValue) throws InterruptedException{
        if (!dataValue.isEmpty()) {
            koreksiAbsenPage().clickPilihTipeAbsen();
            WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));
            WebElement option = wait.until(ExpectedConditions.presenceOfElementLocated(
            By.cssSelector(".MuiButtonBase-root.MuiMenuItem-root[data-value='" + dataValue + "']")));
            option.click();
            Thread.sleep(1000);
        }else{}
        
    }

    @And("user menekan tombol ajukan.")
    public void step06() throws InterruptedException{
        koreksiAbsenPage().clickAjukanButton();
        Thread.sleep(5000);
    }

    @Then("user berhasil ajukan koreksi setelah isi data sesuai {string}.")
    public void step07(String value) throws InterruptedException{ 
        Assert.assertEquals(totalAwal+1, koreksiAbsenPage().getTotal());

        String dataValue;
        if (value.equals("wfh")) {
            dataValue = "Home";
        }else if (value.equals("wfo")) {
            dataValue = "Office"; 
        } else {
            dataValue = "-";
        }
        Assert.assertEquals(dataValue, koreksiAbsenPage().getTipeAbsen());
    }
}
