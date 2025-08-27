Feature: Cuti Feature

 Scenario: Halaman cuti Aplikasi Hadir
   Given saat pengguna ada di halaman dashboard.
   When pengguna menekan tab cuti.
   Then user akan di bawa ke halaman cuti dengan url "https://magang.dikahadir.com/apps/absent/leave-client" untuk memeriksa hasil test.
#
#  Scenario: Display Info Cuti
#    Given user saat berada di halaman dashborad.
#    When lalu user menakan tab cuti.
#    And lalu user click button Ajukan Cuti.
#    Then user click Info Cuti, untuk melihat total cuti.
#
#  Scenario: Ajukan cuti dengan form kosong
#    Given pengguna saat ini membuka halaman dashboard.
#    When selanjutnya pengguna memilih tab cuti.
#    And pengguna clik button Ajukan cuti.
#    Then pengguna click button Ajukan,dan pengguna melihat message error.

#   Scenario: User berhasil mengajukan cuti dengan form diisi lengkap
#     Given pengguna ada berada halaman dashboard.
#     When pegguna click tab cuti.
#     And lalu pengguna click button Ajukan cuti.
#     And pengguna memilih tipe cuti 'Pernikahan anak'.
#     And pengguna memilih tanggal cuti pada tahun "2022" bulan "April" tanggal "22" dan "23".
#     And pengguna mengisi Catatan "Izin Cuti".
#     And pengguna click tombol Ajukan.
#     Then menampilkan notifikasi bahwa pengajuan cuti berhasil.

#  Scenario: Pengguna gagal mengajukan cuti karena