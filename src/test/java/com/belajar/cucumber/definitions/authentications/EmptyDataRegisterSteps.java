package com.belajar.cucumber.definitions.authentications;
import org.testng.Assert;

import com.belajar.cucumber.definitions.providers.AuthProviders;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

/**
 * LLorem ipsumm
 */
public class EmptyDataRegisterSteps extends AuthProviders{
    /**
     * 
     */
    private String emptyField;

    @Given("user berada pada halaman register untuk menguji empty data.")
    public void step01(){
        preConRegister();
        Hook.driver = this;
    }

    @When("user memasukkan data NIK {string}, nama lengkap {string}, email {string}, password {string}, file foto {string} pada tiap field.")
    public void step02(String NIK, String fullname, String email, String password, String filename){
        registerPage().setNIK(getRandomValidNIK(NIK));
        registerPage().setFullname(fullname);
        registerPage().setEmailRegister(getRandomEmail(email));
        registerPage().setPasswordRegister(password);
        if (!filename.isEmpty()) {
           String filePath = getPhotoPath(filename);
            registerPage().setUploadSelfie(filePath); 
        }
        

        if (NIK.isEmpty()) {
            this.emptyField = "nik";
        } else if (fullname.isEmpty()) {
            this.emptyField = "nama"; 
        } else if (email.isEmpty()) {
            this.emptyField = "email";
        } else if (password.isEmpty()) {
            this.emptyField = "password";
        } else if (filename.isEmpty()) {
            this.emptyField = "file";
        }
    }

    @And("setelah mengisi dengan data empty, user menekan tombol daftar.")
    public void step03(){
        registerPage().clickDaftarButton();
    } 
    
    @Then("user gagal registrasi dan akan melihat pesan validasi {string}.")
    public void step04(String expectedMessage){
        String actualMessage = registerPage().getValidationMessage(emptyField);
        Assert.assertEquals(expectedMessage, actualMessage);
    }
    
}
