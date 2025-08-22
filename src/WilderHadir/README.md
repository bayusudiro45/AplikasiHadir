# Cara test Perscenario, Only CMD terminal
NOTE : Jangan lupa @Anotasi di beberapa test misal Runner & Gherkin

- mvn test -Dcucumber.filter.tags="@PositiveLogin"
- mvn test -DsuiteXmlFile=testng-PositiveLogin.xml
- mvn test -DsuiteXmlFile=testng-NegativeLogin.xml
----------------------------------------------------------
# For Suite TestNg
- mvn clean test -DsuiteXmlFile=src/test/resources/izin.xml
-------------------------------------------------------------------------
# Link Alternativ
- Halaman dashboard : https://magang.dikahadir.com/apps/absent
- halaman ketika Menu Izin di klik : https://magang.dikahadir.com/apps/absent/permit
- silahkan baca isi halaman ini : https://magang.dikahadir.com/apps/absent/permit?permit=late
-------------------------------------------------------------------------------------------------
