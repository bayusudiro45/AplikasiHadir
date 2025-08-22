# # [PENAMBAHAN] Feature file khusus untuk fitur Terlambat
# Feature: Manajemen Izin Terlambat

#   Background:
#     Given user telah login dengan username "hadirsqa1@gmail.com" dan password "SQA@Hadir12345"

#   Scenario: Akses tab Terlambat
#     Given user berada di halaman izin
#     When user memilih tab Terlambat
#     Then tab Terlambat dalam keadaan aktif
#     And list izin terlambat ditampilkan
#     And tombol Ajukan Izin Terlambat ditampilkan

#   Scenario: Melihat list izin terlambat
#     Given user berada di halaman izin
#     And user memilih tab Terlambat
#     Then total data izin terlambat adalah 7
#     And terdapat minimal 1 kartu izin terlambat yang ditampilkan
#     And semua data izin terlambat memiliki status yang valid
#     And cetak data list izin terlambat

#   Scenario: Kembali ke dashboard dari halaman izin (Terlambat)
#     Given user berada di halaman izin
#     And user memilih tab Terlambat
#     When user klik tombol Kembali
#     Then user diarahkan kembali ke dashboard