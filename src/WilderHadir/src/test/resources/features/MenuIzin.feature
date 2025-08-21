# Feature: Menu Izin - Validasi dan Navigasi

#   Scenario: Melihat list izin pulang cepat
#     Given user telah login dengan username "hadirsqa1@gmail.com" dan password "SQA@Hadir12345"
#     And user berada di halaman izin
#     When user klik tab Pulang Cepat
#     Then list izin pulang cepat ditampilkan
#     And total data izin pulang cepat adalah 46
#     And terdapat 20 kartu izin pulang cepat yang ditampilkan
#     And tombol Ajukan Pulang Cepat ditampilkan
#     And semua data izin memiliki status yang valid
#     And cetak data list izin pulang cepat

#   Scenario: Verifikasi data izin spesifik
#     Given user telah login dengan username "hadirsqa1@gmail.com" dan password "SQA@Hadir12345"
#     And user berada di halaman izin
#     When user klik tab Pulang Cepat
#     Then data izin ke-1 memiliki catatan "mau pulang aja"
#     And data izin ke-2 memiliki catatan "sakit perut"

  # Background:
  #   Given User sudah login ke aplikasi HADIR
  #   And User berada di halaman dashboard "/apps/absent"

  # @TC-001
  # Scenario: Menampilkan daftar izin terlambat
  #   When User mengklik menu "Izin"
  #   And User memilih tab "Terlambat"
  #   Then Sistem menampilkan halaman izin dengan URL yang mengandung "permit=late"
  #   And Sistem menampilkan daftar izin dengan kategori "Terlambat" saja
  #   And Setiap data menampilkan kolom: Nama, Jenis Izin, Status, Alasan, Tanggal Dibuat
  #   And Status izin sesuai dengan data di database
  #   And Jumlah data yang ditampilkan sesuai dengan jumlah data izin terlambat di database

  # @TC-002
  # Scenario: Menampilkan daftar izin pulang cepat
  #   When User mengklik menu "Izin"
  #   And User memilih tab "Pulang Cepat"
  #   Then Sistem menampilkan halaman izin dengan URL yang mengandung "permit=early"
  #   And Sistem menampilkan daftar izin dengan kategori "Pulang Cepat" saja
  #   And Setiap data menampilkan kolom: Nama, Jenis Izin, Status, Alasan, Tanggal Dibuat
  #   And Status izin sesuai dengan data di database
  #   And Jumlah data yang ditampilkan sesuai dengan jumlah data izin pulang cepat di database

  # @TC-003
  # Scenario: Navigasi dari tab Terlambat ke tab Pulang Cepat
  #   Given User sudah login dan berada di halaman Menu Izin
  #   And User berada di tab "Terlambat"
  #   When User klik tab "Pulang Cepat"
  #   Then Sistem menampilkan daftar izin kategori "Pulang Cepat"
  #   And Tabel menampilkan data sesuai FSD
  #   And Tab "Pulang Cepat" dalam keadaan aktif
  #   And Tab "Terlambat" tidak aktif

  # @TC-004
  # Scenario: Navigasi dari tab Pulang Cepat ke tab Terlambat
  #   Given User sudah login dan berada di halaman Menu Izin
  #   And User berada di tab "Pulang Cepat"
  #   When User klik tab "Terlambat"
  #   Then Sistem menampilkan daftar izin kategori "Terlambat"
  #   And Tabel menampilkan data sesuai FSD
  #   And Tab "Terlambat" dalam keadaan aktif
  #   And Tab "Pulang Cepat" tidak aktif
