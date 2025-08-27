package com.belajar.cucumber.definitions.correction;

import org.testng.Assert;

import com.belajar.cucumber.definitions.authentications.Hook;
import com.belajar.cucumber.definitions.providers.AuthProviders;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class NegativeAjukanKoreksiSteps extends AuthProviders{

    @Given("user sudah berada pada halaman koreksi absen untuk ajukan koreksi.")
    public void step01() {
        preConAjukanKoreksi();
        Hook.driver = this;
    }

    @When("user klik tombol ajukan koreksi.")
    public void step02(){
        driver.navigate().refresh();
        koreksiAbsenPage().clickAjukanKoreksiButton();
    }

    @And("user klik tombol jam masuk dan memasukkan data pada jam {string} menit {string} tanggal {string} bulan {string} tahun {string}.")
    public void step03(String jamMasuk, String menitMasuk, String tanggal, String bulan, String tahun) throws InterruptedException {
        if (!jamMasuk.isEmpty() || !menitMasuk.isEmpty()) {
            koreksiAbsenPage().clickJamMasukButton();
            dragnDrop().pilihTanggalJam(tahun, bulan, tanggal, Integer.parseInt(jamMasuk), Integer.parseInt(menitMasuk));
            Thread.sleep(1000);
        }else{
            // tidak melakukan apa-apa
        }
    }

    @And("user klik tombol jam keluar dan memasukkan data pada jam {string} menit {string} tanggal {string} bulan {string} tahun {string}.")
    public void step04(String jamKeluar, String menitKeluar, String tanggal, String bulan, String tahun) throws InterruptedException {
        if (!jamKeluar.isEmpty() || !menitKeluar.isEmpty()){
            koreksiAbsenPage().clickJamKeluarButton();
            dragnDrop().pilihTanggalJam(tahun, bulan, tanggal, Integer.parseInt(jamKeluar), Integer.parseInt(menitKeluar));
        }else{
            Thread.sleep(1000);
        }
    }

    @And("user klik tombol ajukan.")
    public void step05() throws InterruptedException {
        koreksiAbsenPage().clickAjukanButton();
        Thread.sleep(5000);
    }

    @Then("user gagal ajukan koreksi dan muncul pesan kesalahan {string}.")
    public void step06(String pesan) {
        Assert.assertEquals(pesan, koreksiAbsenPage().getPesanError());
    }

}
