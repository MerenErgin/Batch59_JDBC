package stepdefinitions;

import io.cucumber.java.en.Given;
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
}
