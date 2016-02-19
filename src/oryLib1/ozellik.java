/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oryLib1;

import dbcLib1.vtbaglatisi;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author mehmet
 */
public class ozellik {

    private int OdaNo;
    vtbaglatisi baglanti=new vtbaglatisi();

    public int getOdaNo() {
        return OdaNo;
    }
     public ResultSet GetOzellikElemanListeAra(int odaNo) throws SQLException{
        String sql = "SELECT * FROM `ozellikler` WHERE `odaNo` = "+odaNo ;
        ResultSet sonuc=baglanti.sqlSorgu(sql);
        sonuc.next();
        return sonuc;
    }
    
    public ResultSet GetOzellikElemanListe(int ID) throws SQLException{
        String sql = "SELECT * FROM `ozellikler` WHERE `ozellikNo` = "+ID ;
        ResultSet sonuc=baglanti.sqlSorgu(sql);
        sonuc.next();
        return sonuc;
    }
    public ResultSet GetOzellikElemanListe() throws SQLException{
        String sql = "SELECT * FROM ozellikler WHERE odaNo = " + OdaNo;
        ResultSet data = baglanti.sqlSorgu(sql);
        return data;
    }
    public void OzellikEkle(String ozellikadi, int maliyet) throws SQLException{
        String sqlekle = "INSERT INTO `otelrezervasyonsistemi`.`ozellikler` (`ozellikNo`, `ozellikAdi`, `odaNo`, `otelNo`, `maliyet`) VALUES (NULL, '"+ozellikadi+"', '"+oda.SecilenOda+"', '"+otel.SecilenOtel+"', '"+maliyet+"')";
        baglanti.sqlislem(sqlekle);
    }
    public void OzellikDuzenle(String ozellikadi, int maliyet, int ozellikno) throws SQLException{
        String sqlduzenle = "UPDATE `otelrezervasyonsistemi`.`ozellikler` SET `ozellikAdi` = '"+ozellikadi+"', `maliyet` = '"+maliyet+"' WHERE `ozellikler`.`ozellikNo` = "+ozellikno;
        baglanti.sqlislem(sqlduzenle);
    }
    public void OzellikSil(int ozellikno) throws SQLException{
        String sqlsil = "DELETE FROM `otelrezervasyonsistemi`.`ozellikler` WHERE `ozellikler`.`ozellikNo` = "+ozellikno;
        baglanti.sqlislem(sqlsil);
    }

    public ozellik() {
    }

    public ozellik(int odano) {
        this.OdaNo = odano;
    }

}
