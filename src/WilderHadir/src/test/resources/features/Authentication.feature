# Feature: Authentication
# @NegativeLogin
#   Scenario Outline: Negative Sign In Aplikasi Hadir
#     Given user masuk ke halaman login
#     When user memasukkan username "<email>"
#     And user memasukkan password "<password>"
#     And user menekan tombol masuk
#     Then user akan melihat pesan kesalahan "<message>"

#     Examples:
#       | email               | password         | message                |
#       | wilder@gmail.com    | SQA@Hadir12345   | Email atau password salah |
#       | hadirsqa1@gmail.com | Nyoba123         | Email atau password salah |
#       | hadirsqa1@gmail.com |                  | Email atau password salah |
#       |                     | SQA@Hadir12345   | Akun tidak ditemukan   |
#       |                     |                  | Akun tidak ditemukan   |
#   @PositiveLogin
#   Scenario Outline: Positive Sign in Aplikasi Hadir
#     Given user masuk ke dalam halaman login
#     When user mengisi username "<email>"
#     And user mengisi password "<password>"
#     And user mengklik tombol masuk
#     Then user berhasil login dan masuk ke halaman dashboard dengan url "https://magang.dikahadir.com/apps/absent"

#     Examples:
#       | email               | password         |
#       | hadirsqa1@gmail.com | SQA@Hadir12345   |
