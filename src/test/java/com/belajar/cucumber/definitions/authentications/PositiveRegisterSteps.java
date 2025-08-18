package com.belajar.cucumber.definitions.authentications;

import com.belajar.cucumber.definitions.providers.AuthProviders;

import io.cucumber.java.en.Given;
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
        String NIK = getRandomValidId();
        loginPage().setNIK(NIK);
    }
}
