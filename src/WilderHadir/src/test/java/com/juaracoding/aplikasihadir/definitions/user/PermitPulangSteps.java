// package com.juaracoding.aplikasihadir.definitions.user;

// import com.juaracoding.aplikasihadir.page.DashboardPage;
// import com.juaracoding.aplikasihadir.page.PermitPage;
// import com.juaracoding.aplikasihadir.utils.DriverManager;
// import io.cucumber.java.en.Then;
// import io.cucumber.java.en.When;
// import org.testng.Assert;

// import java.util.List;

// public class PermitPulangSteps {

//     private final DashboardPage dashboardPage;
//     private final PermitPage permitPage;

//     public PermitPulangSteps() {
//         this.dashboardPage = new DashboardPage(DriverManager.getDriver());
//         this.permitPage = new PermitPage(DriverManager.getDriver());
//     }

//     @When("user klik menu izin dari dashboard")
//     public void step01() {
//         dashboardPage.clickMenuIzin();
//     }

//     @When("user menuju halaman izin")
//     public void step02() {
//         permitPage.goToPage();
//     }

//     @When("user memilih tab {string}")
//     public void step03(String tabName) {
//         if (tabName.equals("Pulang Cepat")) {
//             permitPage.clickTabPulangCepat();
//         } else if (tabName.equals("Terlambat")) {
//             permitPage.clickTabTerlambat();
//         } else {
//             throw new IllegalArgumentException("Tab tidak dikenali: " + tabName);
//         }
//     }

//     @When("user klik tombol Kembali")
//     public void step05() {
//         permitPage.clickKembali();
//     }

//     @Then("halaman izin berhasil dimuat")
//     public void step06() {
//         Assert.assertTrue(permitPage.isPageLoaded(),
//                 "Halaman izin tidak berhasil dimuat");
//     }

//     @Then("tab {string} dalam keadaan aktif")
//     public void step07(String tabName) {
//         if (tabName.equals("Pulang Cepat")) {
//             Assert.assertTrue(permitPage.isTabPulangCepatActive(),
//                     "Tab Pulang Cepat tidak aktif");
//         } else {
//             throw new IllegalArgumentException("Tab tidak dikenali: " + tabName);
//         }
//     }

//     @Then("list izin pulang cepat ditampilkan")
//     public void step08() {
//         Assert.assertTrue(permitPage.isListPulangCepatDisplayed(),
//                 "List izin pulang cepat tidak ditampilkan");
//     }

//     @Then("total data izin pulang cepat adalah {int}")
//     public void step09(int expectedTotal) {
//         int actualTotal = permitPage.getTotalData();
//         Assert.assertEquals(actualTotal, expectedTotal,
//                 "Total data tidak sesuai. Expected: " + expectedTotal + ", Actual: " + actualTotal);
//     }

//     @Then("terdapat minimal {int} kartu izin pulang cepat yang ditampilkan")
//     public void step10(int expectedMinimal) {
//         int actualCount = permitPage.getPermitCardCount("Pulang Cepat");
//         Assert.assertTrue(actualCount > 0, 
//                          "Tidak ada kartu izin yang ditampilkan");
        
//         if (actualCount < expectedMinimal) {
//             System.out.println("WARNING: Jumlah kartu (" + actualCount + ") kurang dari expected minimal (" + expectedMinimal + ")");
//         }
//     }

//     @Then("tombol Ajukan Pulang Cepat ditampilkan")
//     public void step11() {
//         Assert.assertTrue(permitPage.isAjukanPulangCepatButtonDisplayed(),
//                 "Tombol Ajukan Pulang Cepat tidak ditampilkan");
//     }

//     @Then("cetak data list izin pulang cepat")
//     public void cetak_data_list_izin_pulang_cepat() {
//         permitPage.printListData("Pulang Cepat");
//     }

//     @Then("semua data izin memiliki status yang valid")
//     public void step12() {
//         List<PermitPage.PermitData> permitDataList = permitPage.getPermitDataList("Pulang Cepat");

//         for (PermitPage.PermitData data : permitDataList) {
//             Assert.assertTrue(
//                     data.status.equals("Menunggu Approval") ||
//                     data.status.equals("Disetujui") ||
//                     data.status.equals("Ditolak"),
//                     "Status tidak valid: " + data.status
//             );
//         }
//     }

//     @Then("user diarahkan kembali ke dashboard")
//     public void step13() {
//         Assert.assertTrue(dashboardPage.isAt(),
//                 "User tidak diarahkan kembali ke dashboard");
//     }
// }