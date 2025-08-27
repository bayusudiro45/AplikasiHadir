package com.belajar.cucumber.definitions.cuti;

import com.belajar.cucumber.definitions.authentications.Hook;
import com.belajar.cucumber.definitions.providers.AuthProviders;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.support.ui.Select;

public class CutiAjukanSteps extends AuthProviders {

    @Given("pengguna ada berada halaman dashboard.")
    public void step01() {
        preConditionLogin();
        Hook.driver = this;
    }

    @When("pegguna click tab cuti.")
    public void step02() {
        dashboardPage().clickCutiButton();
    }

    @And("lalu pengguna click button Ajukan cuti.")
    public void step03() {
        cutiPage().clickAjukanCuti();
    }

    @And("pengguna memilih tipe cuti {string}.")
    public void step04(String leaveType) throws InterruptedException {
        cutiPage().selectLeaveType(leaveType);
    }

    @And("pengguna memilih tanggal cuti pada tahun {string} bulan {string} tanggal {string} dan {string}.")
    public void step05(String tahun, String bulan, String tanggalAwal, String tanggalAkhir) throws InterruptedException {
        cutiPage().clickDivElement();
        Select select = new Select(cutiPage().setpilihTahun());
        select.selectByValue(tahun);
        Thread.sleep(2000);
        Select selectBulan = new Select(cutiPage().setpilihBulan());
        selectBulan.selectByVisibleText(bulan);
        Thread.sleep(2000);
        cutiPage().pilihTanggal(tanggalAwal);
        cutiPage().pilihTanggal(tanggalAkhir);
        cutiPage().clickButtonSimpan();
        Thread.sleep(4000);
    }

    @And("pengguna mengisi Catatan {string}.")
    public void step06(String message) throws InterruptedException {
        cutiPage().setCatatan(message);
        Thread.sleep(2000);
    }

    @And("pengguna click tombol Ajukan.")
    public void step07() throws InterruptedException {
        cutiPage().clickAjukanCuti();
        Thread.sleep(4000);
    }

    @Then("menampilkan notifikasi bahwa pengajuan cuti berhasil.")
    public void step08() {

    }


}
