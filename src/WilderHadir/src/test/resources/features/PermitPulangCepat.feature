# Feature: Manajemen Izin Pulang Cepat

#   Background:
#     Given user telah login dengan username "hadirsqa1@gmail.com" dan password "SQA@Hadir12345"

#   Scenario: Navigasi ke halaman izin dari dashboard
#     When user klik menu izin dari dashboard
#     Then halaman izin berhasil dimuat

#   Scenario: Akses tab Pulang Cepat
#     Given user berada di halaman izin
#     When user memilih tab "Pulang Cepat"
#     Then tab "Pulang Cepat" dalam keadaan aktif
#     And list izin pulang cepat ditampilkan
#     And tombol Ajukan Pulang Cepat ditampilkan

#   Scenario: Melihat list izin pulang cepat
#     Given user berada di halaman izin
#     And user memilih tab "Pulang Cepat"
#     Then total data izin pulang cepat adalah 46
#     And terdapat minimal 20 kartu izin pulang cepat yang ditampilkan
#     And semua data izin memiliki status yang valid
#     And cetak data list izin pulang cepat

#   Scenario: Kembali ke dashboard dari halaman izin
#     Given user berada di halaman izin
#     When user klik tombol Kembali
#     Then user diarahkan kembali ke dashboard