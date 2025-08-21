Feature: Authentication Feature

  # Scenario Outline: Negative Sign In Aplikasi Hadir
  #   Given pengguna masuk ke halaman login.
  #   When pengguna memasukkan username "<email>".
  #   And pengguna memasukkan password "<password>".
  #   And pengguna menekan tombol masuk.
  #   Then pengguna akan melihat pesan kesalahan "<message>".

  #   Examples:
  #     | email               | password       | message                   |
  #     | haloizzah@gmail.com | SQA@Hadir12345 | Akun tidak ditemukan      |
  #     | hadirsqa1@gmail.com | Hehehe123      | Email atau password salah |
  #     | hadirsqa1@gmail.com |                | Email atau password salah |
  #     |                     | SQA@Hadir12345 | Akun tidak ditemukan      |
  #     |                     |                | Akun tidak ditemukan      |

  # Scenario: Postive Sign In Aplikasi Hadir
  #   Given saat menguji test positive, pengguna masuk ke halaman login.
  #   When pengguna melakukan login dengan username "hadirsqa1@gmail.com" dan password "SQA@Hadir12345" yang valid.
  #   Then pengguna akan di bawa ke halaman inventory dengan url "https://magang.dikahadir.com/apps/absent" untuk memeriksa hasil test.

  # Scenario: Positive Register In Aplikasi Hadir
  #   Given user berada pada halaman register.
  #   When user memasukkan NIK yang terdaftar pada sistem secara random.
  #   And user memasukkan data valid nama lengkap "Izzah Luthfiah", email, password "Haiqwerty123", file foto "test-foto.webp".
  #   And user menekan tombol daftar.
  #   Then user berhasil registrasi dan akan melihat pesan "berhasil register, silahkan menunggu di approve oleh admin".

  Scenario Outline: Register using Invalid Data in Aplikasi Hadir
    Given user berada pada halaman register untuk menguji invalid data.
    When user memasukkan data NIK "<NIK>", nama lengkap "Izzah Luthfiah", email "<email>", password "Haiqwerty123", file foto "test-foto.webp".
    And setelah mengisi dengan data invalid, user menekan tombol daftar.
    Then user gagal registrasi dan akan melihat pesan "<pesan>".

    Examples:
      | NIK           | email               | pesan                                                  |
      | D5768907      | ${random_email}     | NIK Anda tidak ditemukan                               |
      | ${random_NIK} | hadirsqa1@gmail.com | Email sudah terdaftar                                  |
      | ${random_NIK} | efrf@gmail.com      | Akun sudah terdaftar di sistem dan belum terverifikasi |
