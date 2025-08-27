Feature: Correction Feature
  # Scenario: Navigation to halaman koreksi absen in Aplikasi Hadir
  #   Given user berada pada halaman dashboard sebelum ke halaman koreksi absen.
  #   When user menekan icon koreksi absen.
  #   Then user dibawa ke halaman koreksi dengan url "https://magang.dikahadir.com/apps/absent/correction".
  # Scenario Outline: Positive Ajukan Koreksi in Aplikasi Hadir
  #   Given user berada pada halaman koreksi absen untuk ajukan koreksi.
  #   When user menekan tombol ajukan koreksi.
  #   And user menekan tombol jam masuk dan memasukkan data pada jam 8 menit 30 tanggal "26" bulan "August" tahun "2025".
  #   And user menekan tombol jam keluar dan memasukkan data pada jam 17 menit 00 tanggal "26" bulan "August" tahun "2025".
  #   And user memilih tipe Absen "<tipeAbsen>". 
  #   And user menekan tombol ajukan.
  #   Then user berhasil ajukan koreksi setelah isi data sesuai "<tipeAbsen>".
  #   Examples:
  #     | tipeAbsen |
  #     | wfh       |
  #     |           |
  #     | wfo       |

  Scenario Outline: Negative Ajukan Koreksi in Aplikasi Hadir
    Given user sudah berada pada halaman koreksi absen untuk ajukan koreksi.
    When user klik tombol ajukan koreksi.
    And user klik tombol jam masuk dan memasukkan data pada jam "<jamMasuk>" menit "<menitMasuk>" tanggal "<tanggal>" bulan "<bulan>" tahun "<tahun>".
    And user klik tombol jam keluar dan memasukkan data pada jam "<jamKeluar>" menit "<menitKeluar>" tanggal "<tanggal>" bulan "<bulan>" tahun "<tahun>".
    And user klik tombol ajukan.
    Then user gagal ajukan koreksi dan muncul pesan kesalahan "<pesan>".

    Examples:
      | jamMasuk | menitMasuk | jamKeluar | menitKeluar | tanggal | bulan  | tahun | pesan                          |
      |        8 |         30 |           |             |      26 | August |  2025 | Lengkapi data terlebih dahulu! |
      |          |            |        17 |          00 |      26 | August |  2025 | Lengkapi data terlebih dahulu! |
      |          |            |           |             |      26 | August |  2025 | Salah satu harus diisi!        |
      |       17 |         00 |         8 |          30 |      26 | August |  2025 | Isi data data dengan benar!    |
