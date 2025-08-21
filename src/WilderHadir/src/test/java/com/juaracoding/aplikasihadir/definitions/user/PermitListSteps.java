// package com.juaracoding.aplikasihadir.definitions.user;

// import com.juaracoding.aplikasihadir.page.PermitPage;
// import com.juaracoding.aplikasihadir.utils.DriverManager;
// import io.cucumber.java.en.Then;
// import org.testng.Assert;

// import java.util.List;

// public class PermitListSteps {
//     private final PermitPage permitPage;

//     public PermitListSteps() {
//         this.permitPage = new PermitPage(DriverManager.getDriver());
//     }

//     @Then("list izin pulang cepat ditampilkan")
//     public void step01() {
//         Assert.assertTrue(permitPage.isListDisplayed(),
//                 "List izin pulang cepat tidak ditampilkan");
//     }

//     @Then("total data izin pulang cepat adalah {int}")
//     public void step02(int expectedTotal) {
//         int actualTotal = permitPage.getTotalData();
//         Assert.assertEquals(actualTotal, expectedTotal,
//                 "Total data tidak sesuai. Expected: " + expectedTotal + ", Actual: " + actualTotal);
//     }

//     @Then("terdapat {int} kartu izin pulang cepat yang ditampilkan")
//     public void step03(int expectedCount) {
//         int actualCount = permitPage.getPermitCardCount();
//         Assert.assertTrue(actualCount >= expectedCount,
//                 "Jumlah kartu tidak sesuai. Expected minimal: " + expectedCount + ", Actual: " + actualCount);
//     }

//     @Then("tombol Ajukan Pulang Cepat ditampilkan")
//     public void step04() {
//         Assert.assertTrue(permitPage.isAjukanButtonDisplayed(),
//                 "Tombol Ajukan Pulang Cepat tidak ditampilkan");
//     }

//     @Then("cetak data list izin pulang cepat")
//     public void step05() {
//         permitPage.printListData();
//     }

//     @Then("semua data izin memiliki status yang valid")
//     public void step06() {
//         List<PermitPage.PermitData> permitDataList = permitPage.getPermitDataList();

//         for (PermitPage.PermitData data : permitDataList) {
//             Assert.assertTrue(
//                     data.status.equals("Menunggu Approval") ||
//                     data.status.equals("Disetujui") ||
//                     data.status.equals("Ditolak"),
//                     "Status tidak valid: " + data.status
//             );
//         }
//     }

//     @Then("data izin ke-{int} memiliki catatan {string}")
//     public void data_izin_ke_memiliki_catatan(int index, String expectedCatatan) {
//         List<PermitPage.PermitData> permitDataList = permitPage.getPermitDataList();

//         Assert.assertTrue(index <= permitDataList.size(),
//                 "Index melebihi jumlah data yang ada");

//         String actualCatatan = permitDataList.get(index - 1).catatan;
//         Assert.assertEquals(actualCatatan, expectedCatatan,
//                 "Catatan tidak sesuai. Expected: " + expectedCatatan + ", Actual: " + actualCatatan);
//     }
// }
