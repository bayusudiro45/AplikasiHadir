// package com.juaracoding.aplikasihadir.definitions.authentication;

// import org.testng.Assert;

// import com.juaracoding.aplikasihadir.page.DashboardPage;
// import com.juaracoding.aplikasihadir.page.LoginPage;
// import com.juaracoding.aplikasihadir.utils.AuthProvider;
// import com.juaracoding.aplikasihadir.utils.DriverManager;
// import io.cucumber.java.en.*;


// public class PositiveLoginTest {

//     private final AuthProvider auth = new AuthProvider();
//     private final DashboardPage dashboardPage = new DashboardPage(DriverManager.getDriver());
//     private final LoginPage loginPage = new LoginPage(DriverManager.getDriver());

//     @Given("user masuk ke dalam halaman login")
//     public void step01() {
//         auth.goToLogin();
//         loginPage.waitReady();
//     }

//     @When("user mengisi username {string}")
//     public void step02(String email) {
//         loginPage.enterEmail(email);
//     }

//     @When("user mengisi password {string}")
//     public void step03(String password) {
//         loginPage.enterPassword(password);
//     }

//     @When("user mengklik tombol masuk")
//     public void step04() {
//         loginPage.clickSubmit();
//     }

//     @Then("user berhasil login dan masuk ke halaman dashboard dengan url {string}")
//     public void step05(String expectedUrl) {
//         dashboardPage.waitUntilLoaded();
//         Assert.assertEquals(expectedUrl, DriverManager.getDriver().getCurrentUrl());
//     }
// }
