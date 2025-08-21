// package com.juaracoding.aplikasihadir.definitions.authentication;

// import com.juaracoding.aplikasihadir.page.LoginPage;
// import com.juaracoding.aplikasihadir.utils.DriverManager;
// import io.cucumber.java.en.*;
// import org.testng.Assert;
// import io.cucumber.java.Before;

// public class NegativeLoginTest {

//     private LoginPage loginPage;
    
//     @Before
//     public void setup() {
//         this.loginPage = new LoginPage(DriverManager.getDriver());
//     }

//     @Given("user masuk ke halaman login")
//     public void step01() {
//         DriverManager.getDriver().get("https://magang.dikahadir.com/absen/login");
//     }

//     @When("user memasukkan username {string}")
//     public void step02(String email) {
//         if (!email.isEmpty()) loginPage.enterEmail(email);
//     }

//     @When("user memasukkan password {string}")
//     public void step03(String password) {
//         if (!password.isEmpty()) loginPage.enterPassword(password);
//     }

//     @When("user menekan tombol masuk")
//     public void step04() {
//         loginPage.clickSubmit();
//     }

//     @Then("user akan melihat pesan kesalahan {string}")
//     public void step05(String message) {
//         Assert.assertEquals(loginPage.getErrorMessage().trim(), message.trim());

//         System.out.println("Expected: " + message);
//         System.out.println("Actual: " + loginPage.getErrorMessage());

//     }
// }