package com.belajar.cucumber.definitions.lembur;

import com.belajar.cucumber.definitions.providers.AuthProviders;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ButtonResetLemburSteps extends AuthProviders {
    @Given("user ada di dashboard aplikasi.")
    public void step01(){

    }

    @When("user membuka tab lembur.")
    public void step02(){}

    @And("user click button Ajukan Lembur.")
    public void step03(){}

    @Then("user menekan tombol reset.")
    public void step04(){}
}
