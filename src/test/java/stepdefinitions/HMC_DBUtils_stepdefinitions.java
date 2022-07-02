package stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import utilities.DBUtils;

import java.sql.SQLException;

public class HMC_DBUtils_stepdefinitions {
    @Given("kullanici DB UTils ile HMC veri tabanina baglanir")
    public void kullanici_db_u_tils_ile_hmc_veri_tabanina_baglanir() {
        DBUtils.getConnection();
    }

    @Given("kullanici DB UTils ile {string} tablosundaki {string} verilerini alir")
    public void kullanici_db_u_tils_ile_tablosundaki_verilerini_alir(String table, String field) {
        String query = "SELECT "+field+" FROM "+ table;
        DBUtils.executeQuery(query);
    }

    @Given("kullanici DB UTils ile {string} sutunundaki verileri okur")
    public void kullanici_db_u_tils_ile_sutunundaki_verileri_okur(String filed) throws SQLException {
        DBUtils.getResultset().first();
        System.out.println(DBUtils.getResultset().getString(filed));
    }

    @And("DBUtil ile tum {string} degerlerini sira numarasi ile yazdirir")
    public void dbutilIleTumDegerleriniSiraNumarasiIleYazdirir(String field) throws SQLException {
        // 1. derste while loop ile next() kullanarak liste yazdirmistik
        // simdi de for loop ile liste yazdiralim
        DBUtils.getResultset().last();
        int sonSatirNo= DBUtils.getResultset().getRow();

        DBUtils.getResultset().first();

        for (int i = 1; i <= sonSatirNo; i++) {
            System.out.println(i+". kayit: "+DBUtils.getResultset().getString(field));
            DBUtils.getResultset().next();
        }

    }

    @Then("DBUtill ile {int}. {string} in {int} oldugunu test eder")
    public void dbutillIleInOldugunuTestEder(int istenenSiraNo, String field, int expectedDeger) throws SQLException {

        DBUtils.getResultset().absolute(istenenSiraNo);
        double actualDeger= DBUtils.getResultset().getDouble(field);
        System.out.println("expectedDeger: "+expectedDeger);
        System.out.println("actualDeger: "+ actualDeger);
        Assert.assertTrue(actualDeger==expectedDeger);

    }

    @Then("tHOTEL tablosunda IDHotel degeri {int} olan kaydin Email bilgisini {string} yapar")
    public void thotelTablosundaIDHotelDegeriOlanKaydinEmailBilgisiniYapar(int idHotel, String yeniEmail) {
        String updateQuery= "update tHOTEL set Email='"+yeniEmail+"' where IDHotel="+idHotel+";";
        DBUtils.executeQuery(updateQuery);

    }
}
