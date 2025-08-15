Feature: Authentication Feature

  Scenario Outline: Negative Sign In eCommerce
    Given pengguna masuk ke halaman login.
    When pengguna memasukkan username "<email>".
    And pengguna memasukkan password "<password>".
    And pengguna menekan tombol masuk.
    Then pengguna akan melihat pesan kesalahan "<message>".

    Examples:
      | email               | password       | message                   |
      | haloizzah@gmail.com | SQA@Hadir12345 | Akun tidak ditemukan      |
      | hadirsqa1@gmail.com | Hehehe123      | Email atau password salah |
      | hadirsqa1@gmail.com |                | Email atau password salah |
      |                     | SQA@Hadir12345 | Akun tidak ditemukan      |
      |                     |                | Akun tidak ditemukan      |
