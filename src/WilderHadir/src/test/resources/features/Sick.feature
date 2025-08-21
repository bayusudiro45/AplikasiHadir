# [PENAMBAHAN] File feature untuk fitur Sakit
Feature: Manajemen Izin Sakit

  Background:
  
    Given user telah login dengan username "hadirsqa1@gmail.com" dan password "SQA@Hadir12345"
    @Sick
  Scenario: Menampilkan list request sakit
    Given user berada di dashboard
    When user klik menu Sakit dari dashboard
    Then halaman sakit berhasil dimuat
    And list request sakit ditampilkan
    And tombol Ajukan Sakit ditampilkan
    And cetak data list request sakit
    
    @Sakit
  Scenario: Kembali ke halaman sebelumnya dari halaman sakit
    Given user berada di dashboard
    When pengguna klik menu Sakit dari dashboard
    Then halaman sakit berhasil dimuat
    When user klik tombol Kembali di halaman sakit
    Then user diarahkan kembali ke dashboard