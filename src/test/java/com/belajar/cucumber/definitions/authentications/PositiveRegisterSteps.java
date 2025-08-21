package com.belajar.cucumber.definitions.authentications;

import org.testng.Assert;

import com.belajar.cucumber.definitions.providers.AuthProviders;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class PositiveRegisterSteps extends AuthProviders {
    @Given("user berada pada halaman register.")
    public void step01(){
        preTest();
        preConRegister();
        Hook.driver = this;
    }

    @When("user memasukkan NIK yang terdaftar pada sistem secara random.")
    public void step02(){
        dashboardPage().setNIK(getRandomValidNIK());
    }

    @And("user memasukkan data valid nama lengkap {string}, email, password {string}, file foto {string}.")
    public void step03(String fullname, String password, String fileName){
        dashboardPage().setFullname(fullname);
        dashboardPage().setEmail(getRandomEmail());
        dashboardPage().setPassword(password);
        String filePath = getPhotoPath(fileName);
        dashboardPage().setUploadSelfie(filePath);
        }

    @And("user menekan tombol daftar.")
    public void step04(){
        dashboardPage().clickDaftarButton();
    }

    @Then("user berhasil registrasi dan akan melihat pesan {string}.")
    public void step05(String message){
        Assert.assertEquals(dashboardPage().getregistMessage(), message);
    }
}
