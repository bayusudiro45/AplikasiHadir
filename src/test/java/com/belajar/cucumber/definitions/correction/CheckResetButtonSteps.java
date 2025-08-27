package com.belajar.cucumber.definitions.correction;

import com.belajar.cucumber.definitions.authentications.Hook;
import com.belajar.cucumber.definitions.providers.AuthProviders;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;

public class CheckResetButtonSteps extends AuthProviders{
    @Given("user sudah berada di halaman koreksi absen untuk pengajuan koreksi.")
    public void step01(){
        preConAjukanKoreksi();
        // Hook.driver = this;
    }

    @When("user menekan tombol ajukan koreksi untuk mengajukan koreksi.")
    public void step02(){
        driver.navigate().refresh();
        koreksiAbsenPage().clickAjukanKoreksiButton();
    }

    @And("user menekan ikon jam masuk dan menginput data jam {int} menit {int} untuk tanggal {string} bulan {string} tahun {string}.")
    public void step03(Integer jamMasuk, Integer menitMasuk, String tanggal, String bulan, String tahun) throws InterruptedException{
        koreksiAbsenPage().clickJamMasukButton();
        dragnDrop().pilihTanggalJam(tahun, bulan, tanggal, jamMasuk, menitMasuk);
        Thread.sleep(1000);
    }

    @And("user menekan ikon jam keluar dan menginput data jam {int} menit {int} untuk tanggal {string} bulan {string} tahun {string}.")
    public void step04(Integer jamKeluar, Integer menitKeluar, String tanggal, String bulan, String tahun){
        koreksiAbsenPage().clickJamKeluarButton();
        dragnDrop().pilihTanggalJam(tahun, bulan, tanggal, jamKeluar, menitKeluar);
    }
    
    @And("user menekan tombol reset.")
    public void step05(){
        koreksiAbsenPage().clickResetButton();

    }

}
