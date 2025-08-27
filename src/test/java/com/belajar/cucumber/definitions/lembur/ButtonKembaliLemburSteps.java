package com.belajar.cucumber.definitions.lembur;

import com.belajar.cucumber.definitions.authentications.Hook;
import com.belajar.cucumber.definitions.providers.AuthProviders;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ButtonKembaliLemburSteps extends AuthProviders {

    @Given("pengguna sudah berada di halaman dashboard.")
    public void step01(){
        preConditionLogin();
        Hook.driver = this;
    }

    @When("pengguna memilih menu lembur.")
    public void step02(){
        dashboardPage().clickLemburButton();
    }

    @Then("pengguna menakan tombol kembali.")
    public void step03(){
        lemburPage().setButtonKembali();
    }
}
