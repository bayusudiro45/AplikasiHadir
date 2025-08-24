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
  #   Then pengguna akan di bawa ke halaman dashboard dengan url "https://magang.dikahadir.com/apps/absent" untuk memeriksa hasil test.
  # Scenario: Navigation to Register Page in Aplikasi Hadir
  #   Given user berada pada halaman login.
  #   When user menekan teks 'disini' pada halaman login.
  #   Then user akan dibawa ke halaman registrasi dengan url "https://magang.dikahadir.com/absen/register". 
  # Scenario: Positive Register In Aplikasi Hadir
  #   Given user berada pada halaman register.
  #   When user memasukkan NIK yang terdaftar pada sistem secara random.
  #   And user memasukkan data valid nama lengkap "Izzah Luthfiah", email, password "Haiqwerty123", file foto "test-photo.jpg".
  #   And user menekan tombol daftar.
  #   Then user berhasil registrasi dan akan melihat pesan "berhasil register, silahkan menunggu di approve oleh admin".
  # Scenario Outline: Register using Invalid Data in Aplikasi Hadir
  #   Given user berada pada halaman register untuk menguji invalid data.
  #   When user memasukkan data NIK "<NIK>", nama lengkap "Izzah Luthfiah", email "<email>", password "Haiqwerty123", file foto "test-photo.jpg".
  #   And setelah mengisi dengan data invalid, user menekan tombol daftar.
  #   Then user gagal registrasi dan akan melihat pesan "<pesan>".
  #   Examples:
  #     | NIK                 | email               | pesan                                                  |
  #     | D5768907            | ${random_email}     | NIK Anda tidak ditemukan                               |
  #     | ${random_valid_NIK} | hadirsqa1@gmail.com | Email sudah terdaftar                                  |
  #     | ${random_valid_NIK} | efrf@gmail.com      | Akun sudah terdaftar di sistem dan belum terverifikasi |
  # Scenario Outline: Register using Empty Data in Aplikasi Hadir
  #   Given user berada pada halaman register untuk menguji empty data.
  #   When user memasukkan data NIK "<NIK>", nama lengkap "<fullname>", email "<email>", password "<password>", file foto "<filename>" pada tiap field.
  #   And setelah mengisi dengan data empty, user menekan tombol daftar.
  #   Then user gagal registrasi dan akan melihat pesan validasi "<validationMessage>".
  #   Examples:
  #     | NIK      | fullname        | email           | password     | filename       | validationMessage           |
  #     |          | Izzah Luthfiah  | efrf@gmail.com | Haiqwerty123 | test-photo.jpg | Please fill out this field. |
  #     | D7240029 |                 | efrf@gmail.com | Haiqwerty123 | test-photo.jpg | Please fill out this field. |
  #     | D7240029 | Azhano Bayu     |                 | Haiqwerty123 | test-photo.jpg | Please fill out this field. |
  #     | D7240029 | Wildernes Dakhi | efrf@gmail.com |              | test-photo.jpg | Please fill out this field. |
  #     | D7240029 | Jeni            | efrf@gmail.com | Haiqwerty123 |                | Please select a file.       |
  # Scenario: Navigation to Lupa password Page in Aplikasi Hadir
  #   Given user berada pada halaman login untuk uji link menuju halaman lupa password.
  #   When user menekan teks 'Lupa password' pada halaman login.
  #   Then user akan dibawa ke halaman lupa password dengan url "https://magang.dikahadir.com/absen/reset-password-request". 

  Scenario Outline: Positive Reset lupa password in Aplikasi Hadir
    Given user berada pada halaman lupa password.
    When user memasukkan email "hadirsqa1@gmail.com" yang terdaftar pada sistem.
    And user menekan tombol submit.
    Then user melihat pesan validasi "Link reset password terkirim, silahkan cek inbox email" dan diarahkan ke halaman url "https://magang.dikahadir.com/absen/reset-password?email=hadirsqa1%40gmail.com&message=success".

  #  Scenario Outline: Negative Reset lupa password in Aplikasi Hadir
  #   Given user sudah berada pada halaman lupa password.
  #   When user memasukkan email "hadirsqa1@gmail.com" pada field email.
  #   And user menekan tombol submit setelah memasukkan email.
  #   Then user melihat pesan validasi "User not found.".

