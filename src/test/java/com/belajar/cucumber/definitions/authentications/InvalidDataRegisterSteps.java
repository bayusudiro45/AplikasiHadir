package com.belajar.cucumber.definitions.authentications;

import org.testng.Assert;

import com.belajar.cucumber.definitions.providers.AuthProviders;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class InvalidDataRegisterSteps extends AuthProviders{

    @Given("user berada pada halaman register untuk menguji invalid data.")
    public void step01(){
        preTest();
        preConRegister();
        Hook.driver = this;
    }

    @When("user memasukkan data NIK {string}, nama lengkap {string}, email {string}, password {string}, file foto {string}.")
    public void step02(String NIK, String fullname, String email, String password, String filename){
        dashboardPage().setNIK(getRandomValidNIK(NIK));
        dashboardPage().setFullname(filename);
        dashboardPage().setEmail(getRandomEmail(email));
        dashboardPage().setPassword(password);
        String filePath = getPhotoPath(filename);
        dashboardPage().setUploadSelfie(filePath);
    }

    @And("setelah mengisi dengan data invalid, user menekan tombol daftar.")
    public void step03(){
        dashboardPage().clickDaftarButton();
    }

    @Then("user gagal registrasi dan akan melihat pesan {string}.")
    public void step04(String message){
        Assert.assertEquals(dashboardPage().getregistMessage(), message);
    }
}
