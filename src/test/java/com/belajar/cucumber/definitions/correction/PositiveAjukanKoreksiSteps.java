package com.belajar.cucumber.definitions.correction;

import com.belajar.cucumber.definitions.authentications.Hook;
import com.belajar.cucumber.definitions.providers.AuthProviders;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;

public class PositiveAjukanKoreksiSteps extends AuthProviders{
    @Given("user berada pada halaman koreksi absen untuk ajukan koreksi.")
    public void step01(){
        preConAjukanKoreksi();
        Hook.driver = this;
    }

    @When("user menekan tombol ajukan koreksi.")
    public void step02(){
        driver.navigate().refresh();
        koreksiAbsenPage().clickAjukanKoreksiButton();
    }

    @And("user menekan icon jam untuk isi data jam masuk.")
    public void step03() throws InterruptedException{
        koreksiAbsenPage().clickJamMasukButton();
        dragnDrop().pilihTanggalJam("2025","February","27",5,01);
        Thread.sleep(1000);
    }
}
