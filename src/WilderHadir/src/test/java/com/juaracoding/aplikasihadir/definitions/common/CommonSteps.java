package com.juaracoding.aplikasihadir.definitions.common;

import com.juaracoding.aplikasihadir.page.DashboardPage;
import com.juaracoding.aplikasihadir.page.PermitPage;
import com.juaracoding.aplikasihadir.page.SickPage;
import com.juaracoding.aplikasihadir.utils.AuthProvider;
import com.juaracoding.aplikasihadir.utils.DriverManager;
import io.cucumber.java.en.Given;

public class CommonSteps {

    private final AuthProvider authProvider;
    private final DashboardPage dashboardPage;
    private final PermitPage permitPage;
    private final SickPage sickPage;// [PENAMBAHAN] Tambahkan SickPage

    public CommonSteps() {
        this.authProvider = new AuthProvider();
        this.dashboardPage = new DashboardPage(DriverManager.getDriver());
        this.permitPage = new PermitPage(DriverManager.getDriver());
        this.sickPage = new SickPage(DriverManager.getDriver()); // [PENAMBAHAN] Inisialisasi SickPage
    }

    @Given("user telah login dengan username {string} dan password {string}")
    public void Step01(String email, String password) {
        authProvider.ensureLoggedIn(email, password);
    }
    
    @Given("user berada di dashboard")
    public void Step02() {
        authProvider.goToDashboard();
        dashboardPage.waitUntilLoaded();
    }
    
    // [PENAMBAHAN] Step definition untuk navigasi ke halaman izin
    @Given("user berada di halaman izin")
    public void Step03() {
        permitPage.goToPage();
    }

    // [PENAMBAHAN] Step definition untuk navigasi ke halaman sakit
    @Given("user berada di halaman sakit")
    public void Step04() {
        sickPage.goToPage();
    }
}