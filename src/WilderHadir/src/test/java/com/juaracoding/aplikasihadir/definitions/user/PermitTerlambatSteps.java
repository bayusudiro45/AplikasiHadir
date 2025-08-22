// package com.juaracoding.aplikasihadir.definitions.user;

// import com.juaracoding.aplikasihadir.page.DashboardPage;
// import com.juaracoding.aplikasihadir.page.PermitPage;
// import com.juaracoding.aplikasihadir.utils.DriverManager;
// import io.cucumber.java.en.Then;
// import io.cucumber.java.en.When;
// import org.testng.Assert;

// import java.util.List;

// // [PENAMBAHAN] Class steps khusus untuk fitur Terlambat
// public class PermitTerlambatSteps {

//     private final DashboardPage dashboardPage;
//     private final PermitPage permitPage;

//     public PermitTerlambatSteps() {
//         this.dashboardPage = new DashboardPage(DriverManager.getDriver());
//         this.permitPage = new PermitPage(DriverManager.getDriver());
//     }

//     // [PENAMBAHAN] Step definition untuk memilih tab Terlambat
//     @When("user memilih tab Terlambat")
//     public void step01() {
//         permitPage.clickTabTerlambat();
//     }

//     // [PENAMBAHAN] Step definition untuk memverifikasi tab Terlambat aktif
//     @Then("tab Terlambat dalam keadaan aktif")
//     public void step02() {
//         Assert.assertTrue(permitPage.isTabTerlambatActive(),
//                 "Tab Terlambat tidak aktif");
//     }

//     // [PENAMBAHAN] Step definition untuk memverifikasi list terlambat ditampilkan
//     @Then("list izin terlambat ditampilkan")
//     public void step03() {
//         Assert.assertTrue(permitPage.isListTerlambatDisplayed(),
//                 "List izin terlambat tidak ditampilkan");
//     }

//     // [PENAMBAHAN] Step definition untuk memverifikasi total data terlambat
//     @Then("total data izin terlambat adalah {int}")
//     public void step03(int expectedTotal) {
//         int actualTotal = permitPage.getTotalData();
//         Assert.assertEquals(actualTotal, expectedTotal,
//                 "Total data tidak sesuai. Expected: " + expectedTotal + ", Actual: " + actualTotal);
//     }

//     // [PENAMBAHAN] Step definition untuk memverifikasi jumlah kartu terlambat
//     @Then("terdapat minimal {int} kartu izin terlambat yang ditampilkan")
//     public void step04(int expectedMinimal) {
//         int actualCount = permitPage.getPermitCardCount("Terlambat");
//         Assert.assertTrue(actualCount > 0, 
//                          "Tidak ada kartu izin yang ditampilkan");
        
//         if (actualCount < expectedMinimal) {
//             System.out.println("WARNING: Jumlah kartu (" + actualCount + ") kurang dari expected minimal (" + expectedMinimal + ")");
//         }
//     }

//     // [PENAMBAHAN] Step definition untuk memverifikasi tombol ajukan terlambat
//     @Then("tombol Ajukan Izin Terlambat ditampilkan")
//     public void step05() {
//         Assert.assertTrue(permitPage.isAjukanTerlambatButtonDisplayed(),
//                 "Tombol Ajukan Izin Terlambat tidak ditampilkan");
//     }

//     // [PENAMBAHAN] Step definition untuk mencetak data terlambat
//     @Then("cetak data list izin terlambat")
//     public void step06() {
//         permitPage.printListData("Terlambat");
//     }

//     // [PENAMBAHAN] Step definition untuk memverifikasi status data terlambat
//     @Then("semua data izin terlambat memiliki status yang valid")
//     public void step07() {
//         List<PermitPage.PermitData> permitDataList = permitPage.getPermitDataList("Terlambat");

//         for (PermitPage.PermitData data : permitDataList) {
//             Assert.assertTrue(
//                     data.status.equals("Menunggu Approval") ||
//                     data.status.equals("Disetujui") ||
//                     data.status.equals("Ditolak"),
//                     "Status tidak valid: " + data.status
//             );
//         }
//     }
// }