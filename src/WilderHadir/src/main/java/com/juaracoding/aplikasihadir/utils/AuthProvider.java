package com.juaracoding.aplikasihadir.utils;

import com.juaracoding.aplikasihadir.page.DashboardPage;
import com.juaracoding.aplikasihadir.page.LoginPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AuthProvider {

    private final WebDriver driver;
    private final LoginPage loginPage;
    private final DashboardPage dashboardPage;

    private static final String LOGIN_URL = "https://magang.dikahadir.com/absen/login";
    private static final String DASHBOARD_URL = "https://magang.dikahadir.com/apps/absent";

    public AuthProvider() {
        this.driver = DriverManager.getDriver();
        this.loginPage = new LoginPage(driver);
        this.dashboardPage = new DashboardPage(driver);
    }

    public void goToLogin() {
        driver.get(LOGIN_URL);
        loginPage.waitReady();
    }

    public void login(String email, String password) {
        loginPage.enterEmail(email);
        loginPage.enterPassword(password);
        loginPage.clickSubmit();

        // Tunggu dashboard siap
        dashboardPage.waitUntilLoaded();

        // Validasi URL dashboard
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.urlToBe(DASHBOARD_URL));
    }

    public void ensureLoggedIn(String email, String password) {
        String currentUrl = driver.getCurrentUrl();
        if (!currentUrl.equals(DASHBOARD_URL) || !dashboardPage.isAt()) {
            goToLogin();
            login(email, password);
        }
    }
    
    public void goToDashboard() {
        driver.get(DASHBOARD_URL);
        dashboardPage.waitUntilLoaded();
    }
}