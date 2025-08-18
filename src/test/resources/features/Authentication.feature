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


  Scenario: Positive Register In Aplikasi Hadir
    Given user berada pada halaman register.
    When user memasukkan NIK yang terdaftar pada sistem secara random.
    # And user memasukkan data valid lainnya
    # Then user berhasil registrasi dan akan melihat pesan "Registrasi berhasil"
