Feature: Overtime Feature

#  Scenario: Halaman lembur Aplikasi Hadir
#    Given user berada pada halaman dashboard.
#    When user menekan tab lembur.
#    Then user akan di bawa ke halaman lembur dengan url "https://magang.dikahadir.com/apps/absent/overtime-client" untuk memeriksa hasil test.

  Scenario: Tombol kembali pada halaman Lembur
    Given pengguna sudah berada di halaman dashboard.
    When pengguna memilih menu lembur.
    Then pengguna menakan tombol kembali.
#
#  Scenario: Tombol reset pada halaman Lembur
#    Given user ada di dashboard aplikasi.
#    When user membuka tab lembur.
#    And user click button Ajukan Lembur.
#    Then user menekan tombol reset.