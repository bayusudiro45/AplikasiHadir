Feature: Correction Feature

  # Scenario: Navigation to halaman koreksi absen in Aplikasi Hadir
  #   Given user berada pada halaman dashboard sebelum ke halaman koreksi absen.
  #   When user menekan icon koreksi absen.
  #   Then user dibawa ke halaman koreksi dengan url "https://magang.dikahadir.com/apps/absent/correction".

  Scenario: Ajukan Koreksi in Aplikasi Hadir
    Given user berada pada halaman koreksi absen untuk ajukan koreksi.
    When user menekan tombol ajukan koreksi.
    And user menekan icon jam untuk isi data jam masuk.
